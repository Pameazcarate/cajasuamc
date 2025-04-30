package cua.integra.cajasuamc.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="servicio")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class ServicioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;
    @Column(nullable = false)
    private String nombreServicio;
    @Column(nullable = false)
    private int costo;

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
