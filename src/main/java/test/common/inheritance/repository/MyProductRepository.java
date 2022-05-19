package test.common.inheritance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.common.inheritance.entity.MyProduct;

public interface MyProductRepository extends JpaRepository<MyProduct,Long> {
}
