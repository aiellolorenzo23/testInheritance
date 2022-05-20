package test.common.inheritance.repository.sons;

import org.springframework.data.jpa.repository.JpaRepository;
import test.common.inheritance.entity.sons.Pen;

public interface PenRepository extends JpaRepository<Pen,Long> {
}
