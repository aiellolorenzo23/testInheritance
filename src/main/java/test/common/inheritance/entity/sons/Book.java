package test.common.inheritance.entity.sons;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.common.inheritance.entity.main.MyProduct;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Book", description = "All details about the Book.")
public class Book extends MyProduct {
    @Schema(name = "author")
    @Getter
    @Setter
    private String author;
}
