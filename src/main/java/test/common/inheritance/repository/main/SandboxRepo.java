package test.common.inheritance.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import test.common.inheritance.entity.main.Sandbox;

public interface SandboxRepo extends JpaRepository<Sandbox,Long> {
}
