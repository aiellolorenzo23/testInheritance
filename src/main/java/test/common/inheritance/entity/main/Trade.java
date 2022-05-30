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
@Schema(name="Trade", description = "All details about the Trade.")
public class Trade {
    @Id
    @GeneratedValue
    @Schema(name = "Id")
    @Getter
    @Setter
    private Long id;
    @Schema(name = "extId")
    @Getter @Setter
    private String extId;
    @Schema(name = "creditlines")
    @Getter @Setter
    @ManyToMany()
    @JoinTable(name = "TRADE_CREDITLINE", joinColumns = {
            @JoinColumn(name = "TRADE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "TRADE_CL_FK_TRADE_ID")) }, inverseJoinColumns = {
            @JoinColumn(name = "CREDITLINE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "TRADE_CL_FK_CREDITLINE_ID")) })
    private Set<Creditline> creditlines = new HashSet<>();
    @Schema(name = "sandbox")
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "SANDBOX_ID", referencedColumnName = "ID", nullable = false)
    private Sandbox sandbox;

}
