package test.common.inheritance.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.common.inheritance.entity.main.Alphabet;

import java.util.List;

public interface AlphabetRepository extends JpaRepository<Alphabet,Long> {
    @Query(value = "SELECT *, 0 AS clazz_ FROM alphabet", nativeQuery = true) //mettere 0 AS clazz_ per fare query nativa che prende solo il padre
    List<Alphabet> findAllWithoutSons();
}
