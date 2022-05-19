package test.common.inheritance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.common.inheritance.entity.Pen;

public interface PenRepository extends JpaRepository<Pen,Long> {
}
