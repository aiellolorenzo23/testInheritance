package test.common.inheritance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.common.inheritance.entity.sons.Book;
import test.common.inheritance.entity.main.MyProduct;
import test.common.inheritance.entity.sons.Pen;
import test.common.inheritance.repository.sons.BookRepository;
import test.common.inheritance.repository.main.MyProductRepository;
import test.common.inheritance.repository.sons.PenRepository;

import java.util.List;

@RestController
@RequestMapping("/api/inheritance")
@CrossOrigin
@Tag(name="ProductsController", description="Operations for ProductsController")
@Slf4j
public class ProductsController {

    @Autowired
    MyProductRepository myProductRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PenRepository penRepository;

    @Operation(description = "insertProduct")
    @PostMapping("/insertProduct")
    @ResponseBody
    public ResponseEntity<?> insertProduct() {
        MyProduct product = new MyProduct();
        product.setName("Cazza di sicurezzo");
        return ResponseEntity.ok().body(myProductRepository.save(product));
    }

    @Operation(description = "insertBook")
    @PostMapping("/insertBook")
    @ResponseBody
    public ResponseEntity<?> insertBook() {
        Book book = new Book();
        book.setName("Libro di sicurezzo");
        book.setAuthor("Synergo");
        return ResponseEntity.ok().body(bookRepository.save(book));
    }

    @Operation(description = "insertPen")
    @PostMapping("/insertPen")
    @ResponseBody
    public ResponseEntity<?> insertPen() {
        Pen pen = new Pen();
        pen.setName("Penna di sicurezzo");
        pen.setColor("Gialla");
        return ResponseEntity.ok().body(penRepository.save(pen));
    }


    @Operation(description = "getAllProducts")
    @GetMapping("/getAllProducts")
    @ResponseBody
    public ResponseEntity<?> getAllProducts() {
        List<MyProduct> products = myProductRepository.findAll();
        if(products!=null && !products.isEmpty())
            return ResponseEntity.ok().body(products);
        return ResponseEntity.notFound().build();
    }

    @Operation(description = "getAllBooks")
    @GetMapping("/getAllBooks")
    @ResponseBody
    public ResponseEntity<?> getAllBooks() {
        List<Book> products = bookRepository.findAll();
        if(products!=null && !products.isEmpty())
            return ResponseEntity.ok().body(products);
        return ResponseEntity.notFound().build();
    }

    @Operation(description = "getAllPens")
    @GetMapping("/getAllPens")
    @ResponseBody
    public ResponseEntity<?> getAllPens() {
        List<Pen> products = penRepository.findAll();
        if(products!=null && !products.isEmpty())
            return ResponseEntity.ok().body(products);
        return ResponseEntity.notFound().build();
    }



}
