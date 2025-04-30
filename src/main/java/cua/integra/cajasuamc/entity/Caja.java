package cua.integra.cajasuamc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="caja")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Caja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String numero_ventanilla;
    @OneToMany(mappedBy = "caja")
    @ToString.Exclude
    private List<Pago> pagos;
}
