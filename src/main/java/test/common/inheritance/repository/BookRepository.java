package test.common.inheritance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.common.inheritance.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
