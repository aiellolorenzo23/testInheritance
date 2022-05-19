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
@Schema(name="Pen", description = "All details about the Pen.")
public class Pen extends MyProduct {
    @Schema(name = "color")
    @Getter
    @Setter
    private String color;
}
