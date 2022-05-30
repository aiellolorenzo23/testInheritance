package test.common.inheritance.entity.main;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Sandbox", description = "All details about the Sandbox.")
public class Sandbox {
    @Id
    @GeneratedValue
    @Schema(name = "Id")
    @Getter
    @Setter
    private Long id;
    @Schema(name = "name")
    @Getter @Setter
    private String name;
}
