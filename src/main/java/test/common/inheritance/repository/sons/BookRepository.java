package test.common.inheritance.repository.sons;

import org.springframework.data.jpa.repository.JpaRepository;
import test.common.inheritance.entity.sons.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
