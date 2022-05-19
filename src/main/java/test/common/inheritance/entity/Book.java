package test.common.inheritance.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
