package test.common.inheritance.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import test.common.inheritance.entity.main.MyProduct;

public interface MyProductRepository extends JpaRepository<MyProduct,Long> {
}
