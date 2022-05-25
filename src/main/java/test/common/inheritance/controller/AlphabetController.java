package test.common.inheritance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.common.inheritance.entity.main.Alphabet;
import test.common.inheritance.entity.main.StrangerAlphabet;
import test.common.inheritance.repository.main.AlphabetRepository;
import test.common.inheritance.repository.main.StrangerAlphabetRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/inheritance")
@CrossOrigin
@Tag(name="AlphabetController", description="Operations for AlphabetController")
@Slf4j
public class AlphabetController {
    @Autowired
    AlphabetRepository alphabetRepository;
    @Autowired
    StrangerAlphabetRepository strangerAlphabetRepository;

    @Operation(description = "insertAlphabet")
    @PostMapping("/insertAlphabet")
    @ResponseBody
    public ResponseEntity<?> insertAlphabet() {
        String letters[] = {"A","B","C","D","E","F","G","H","I","L","M","N","O","P","Q","R","S","T","U","V","Z"};
        List<Alphabet> alfabeto = new ArrayList<>();
        for(int i=0;i<letters.length;i++){
            Alphabet alphabet = new Alphabet();
            alphabet.setLetter(letters[i]);
            alfabeto.add(alphabetRepository.save(alphabet));
        }

        return ResponseEntity.ok().body(alfabeto);
    }

    @Operation(description = "insertStrangerAlphabet")
    @PostMapping("/insertStrangerAlphabet")
    @ResponseBody
    public ResponseEntity<?> insertStrangerAlphabet() {
        String letters[] = {"J","K","W","X","Y"};
        List<StrangerAlphabet> alfabetoStraniero = new ArrayList<>();
        for(int i=0;i<letters.length;i++){
            StrangerAlphabet alphabet = new StrangerAlphabet();
            alphabet.setNewLetter(letters[i]);
            alfabetoStraniero.add(strangerAlphabetRepository.save(alphabet));
        }
        return ResponseEntity.ok().body(alfabetoStraniero);
    }

    @Operation(description = "getAlphabet")
    @GetMapping("/getAlphabet")
    @ResponseBody
    public ResponseEntity<?> getAlphabet() {
        List<Alphabet> alphabetList = alphabetRepository.findAllWithoutSons();
        if(alphabetList!=null && !alphabetList.isEmpty())
            return ResponseEntity.ok().body(alphabetList);
        return ResponseEntity.notFound().build();
    }

    @Operation(description = "getStrangerAlphabet")
    @GetMapping("/getStrangerAlphabet")
    @ResponseBody
    public ResponseEntity<?> getStrangerAlphabet() {
        List<StrangerAlphabet> alphabetList = strangerAlphabetRepository.findAll();
        if(alphabetList!=null && !alphabetList.isEmpty())
            return ResponseEntity.ok().body(alphabetList);
        return ResponseEntity.notFound().build();
    }
}
