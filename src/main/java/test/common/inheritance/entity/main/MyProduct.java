package test.common.inheritance.entity.main;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="MyProduct", description = "All details about the MyProduct.")
public class MyProduct {
    @Id
    @GeneratedValue
    @Schema(name = "Id")
    @Getter @Setter
    private Long productId;
    @Schema(name = "name")
    @Getter @Setter
    private String name;
}