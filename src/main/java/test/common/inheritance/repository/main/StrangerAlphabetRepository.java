package test.common.inheritance.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import test.common.inheritance.entity.main.StrangerAlphabet;

public interface StrangerAlphabetRepository extends JpaRepository<StrangerAlphabet,Long> {
}
