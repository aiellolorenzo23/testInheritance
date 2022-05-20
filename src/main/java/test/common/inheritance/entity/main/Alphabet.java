package test.common.inheritance.entity.main;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Alphabet", description = "All details about the Alphabet.")
public class Alphabet {
    @Id
    @GeneratedValue
    @Schema(name = "AlphabetId")
    @Getter
    @Setter
    private Long AlphabetId;
    @Schema(name = "letter")
    @Getter @Setter
    private String letter;
}
