package test.common.inheritance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.common.inheritance.entity.main.Creditline;
import test.common.inheritance.entity.main.Sandbox;
import test.common.inheritance.entity.main.Trade;
import test.common.inheritance.repository.main.CreditlineRepo;
import test.common.inheritance.repository.main.SandboxRepo;
import test.common.inheritance.repository.main.TradeRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inheritance")
@CrossOrigin
@Tag(name="SandboxController", description="Operations for SandboxController")
@Slf4j
public class SandboxController {
    @Autowired
    SandboxRepo sandboxRepo;
    @Autowired
    TradeRepo tradeRepo;
    @Autowired
    CreditlineRepo creditlineRepo;

    public static int copiaN = 0;

    @Operation(description = "createSandbox")
    @PostMapping("/createSandbox")
    @ResponseBody
    public ResponseEntity<?> createSandbox() {
        Sandbox sandbox = new Sandbox();
        sandbox.setName("Lo chiamavano Sandbox");
        return ResponseEntity.ok().body(sandboxRepo.save(sandbox));
    }

    @Operation(description = "createCreditline")
    @PostMapping("/createCreditline")
    @ResponseBody
    public ResponseEntity<?> createCreditline(@RequestBody AddRemoveWsaCreditlineRequest request) {
        List<String> cList = request.getRtceCreditlineIds();
        Sandbox sandbox = sandboxRepo.findById(request.getSandboxId()).isPresent() ?  sandboxRepo.findById(request.getSandboxId()).get() : null;
        log.info(sandbox != null ? "Sandbox: presente" : "Sandbox: non presente");
        if (sandbox != null) {
            for(String id: cList) {
                Creditline cl = new Creditline();
                cl.setSandbox(sandbox);
                cl.setRtceCreditlineId(id);
                creditlineRepo.save(cl);
            }
        }

        return ResponseEntity.ok().body(getAllCreditlines(request.getSandboxId()));
    }

    @Operation(description = "getAllCreditlines")
    @GetMapping("/getAllCreditlines")
    @ResponseBody
    public List<Creditline> getAllCreditlines(Long sandboxId) {
        Sandbox sandbox = sandboxRepo.findById(sandboxId).get();
        if(sandbox!=null)
            return creditlineRepo.findAllBySandbox(sandbox);
        else
            return new ArrayList<Creditline>();
    }

    @NoArgsConstructor
    public static class AddRemoveWsaCreditlineRequest {
        @Getter @Setter
        Long sandboxId;
        @Getter @Setter
        List<String> rtceCreditlineIds;
    }

    @Operation(description = "createTrade")
    @PostMapping("/createTrade")
    @ResponseBody
    public ResponseEntity<?> createTrade(@RequestBody AddWsaTradeRequest request){
        Sandbox sandbox = sandboxRepo.findById(request.getSandboxId()).get();
        Creditline creditline = null;
        if(request.getRtceCreditlineId() != null) {
            creditline = creditlineRepo.findByRtceCreditlineIdAndSandbox(request.getRtceCreditlineId(), sandbox).isPresent() ? creditlineRepo.findByRtceCreditlineIdAndSandbox(request.getRtceCreditlineId(), sandbox).get() : null;
        }
        for(String extId: request.getExtIds()) {
            Trade trade = null;
            trade = new Trade();
            trade.setSandbox(sandbox);
            if(creditline != null) {
                Set<Creditline> creditlines = trade.getCreditlines();
                creditlines.add(creditline);
                trade.setCreditlines(creditlines);
                trade.setExtId(extId);
                tradeRepo.save(trade);
            }
        }
        return ResponseEntity.ok().body(getAllTrades(request.getSandboxId()));
    }

    @Operation(description = "getAllTrades")
    @GetMapping("/getAllTrades")
    @ResponseBody
    public List<Trade> getAllTrades(Long sandboxId) {
        Sandbox sandbox = sandboxRepo.findById(sandboxId).get();
        if(sandbox!=null)
            return tradeRepo.findAllBySandbox(sandbox);
        else
            return new ArrayList<Trade>();
    }

    @NoArgsConstructor
    public static class AddWsaTradeRequest {
        @Getter @Setter
        Long sandboxId;
        @Getter @Setter
        String rtceCreditlineId;
        @Getter @Setter
        List<String> extIds;
    }


    @Operation(description = "cloneSandbox")
    @PostMapping("/cloneSandbox")
    @ResponseBody
    public ResponseEntity<?> cloneSandbox(@RequestBody CloneSandboxRequest request) {
        Sandbox sandbox = sandboxRepo.findById(request.sandboxId).get();
        Sandbox newSandbox = new Sandbox();
        copiaN++;
        newSandbox.setName(sandbox.getName()+" - Copia"+copiaN);
        newSandbox = sandboxRepo.save(newSandbox);


        List<Creditline> creditlineList = creditlineRepo.findAllBySandbox(sandbox);
        List<String> rtceCreditlineIds = creditlineList.stream().map(creditline -> creditline.getRtceCreditlineId()).collect(Collectors.toList());
        AddRemoveWsaCreditlineRequest addRemoveWsaCreditlineRequest = new AddRemoveWsaCreditlineRequest();
        addRemoveWsaCreditlineRequest.setSandboxId(newSandbox.getId());
        addRemoveWsaCreditlineRequest.setRtceCreditlineIds(rtceCreditlineIds);
        createCreditline(addRemoveWsaCreditlineRequest);

        List<Trade> tradeList = tradeRepo.findAllBySandbox(sandbox);
        List<String> extIds = tradeList.stream().map(trade -> trade.getExtId()).collect(Collectors.toList());
        AddWsaTradeRequest addWsaTradeRequest = new AddWsaTradeRequest();
        addWsaTradeRequest.setSandboxId(newSandbox.getId());
        addWsaTradeRequest.setExtIds(extIds);
        addWsaTradeRequest.setRtceCreditlineId("uno");
        createTrade(addWsaTradeRequest);

        return ResponseEntity.ok().body(newSandbox);
    }

    @NoArgsConstructor
    public static class CloneSandboxRequest {
        @Getter @Setter
        Long sandboxId;
    }

}
