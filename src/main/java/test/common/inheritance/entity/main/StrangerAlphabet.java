package test.common.inheritance.entity.main;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="StrangerAlphabet", description = "All details about the StrangerAlphabet.")
public class StrangerAlphabet extends Alphabet{
    @Schema(name = "newLetters")
    @Getter
    @Setter
    private String newLetter;
}
