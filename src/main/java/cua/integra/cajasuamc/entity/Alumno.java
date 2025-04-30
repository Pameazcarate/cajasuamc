package cua.integra.cajasuamc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="alumno")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private long matricula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "alumno")
    @ToString.Exclude
    private List<Pago> pagos;
}
