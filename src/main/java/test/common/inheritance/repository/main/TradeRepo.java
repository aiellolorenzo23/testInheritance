package test.common.inheritance.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import test.common.inheritance.entity.main.Sandbox;
import test.common.inheritance.entity.main.Trade;

import java.util.List;

public interface TradeRepo extends JpaRepository<Trade,Long> {
   List<Trade> findAllBySandbox(Sandbox sandbox);
}
