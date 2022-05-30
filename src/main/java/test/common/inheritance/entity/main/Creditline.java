package test.common.inheritance.entity.main;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Creditline", description = "All details about the Creditline.")
public class Creditline {
    @Id
    @GeneratedValue
    @Schema(name = "Id")
    @Getter @Setter
    private Long id;
    @Schema(name = "rtceCreditlineId")
    @Getter @Setter
    private String rtceCreditlineId;
    @Schema(name = "trades")
    @Getter @Setter
    @ManyToMany(mappedBy = "creditlines")
    private Set<Trade> trades = new HashSet<>();
    @Schema(name = "sandbox")
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "SANDBOX_ID", referencedColumnName = "ID", nullable = false)
    private Sandbox sandbox;
}
