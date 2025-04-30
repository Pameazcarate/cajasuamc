package cua.integra.cajasuamc.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="caja")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CajasDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String numero_ventanilla;
}
