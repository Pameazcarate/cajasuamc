package cua.integra.cajasuamc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "servicios")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idServicio;
    @Column(nullable = false)
    private String nombreServicio;
    @Column(nullable = false)
    private int costo;

    @OneToMany(mappedBy = "servicio")
    @ToString.Exclude
    private List<Pago> pagos;


    public Servicio orElse(Object o) {
        return null;
    }
}
