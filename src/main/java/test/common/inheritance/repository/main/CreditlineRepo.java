package test.common.inheritance.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import test.common.inheritance.entity.main.Creditline;
import test.common.inheritance.entity.main.Sandbox;

import java.util.List;
import java.util.Optional;

public interface CreditlineRepo  extends JpaRepository<Creditline,Long> {
    List<Creditline> findAllBySandbox(Sandbox sandbox);
    Optional<Creditline> findByRtceCreditlineIdAndSandbox(String rtceCreditlineId, Sandbox sandbox);
}
