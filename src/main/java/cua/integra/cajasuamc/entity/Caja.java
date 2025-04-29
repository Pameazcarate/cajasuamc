package cua.integra.cajasuamc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cajas")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Caja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String numero_ventanilla;
}
