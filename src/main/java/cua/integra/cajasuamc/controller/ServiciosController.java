package cua.integra.cajasuamc.controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Table(name = "servicios")
@Setter
public class ServiciosController {

    @Id
    private long idServicio;
    @Column(nullable = false, unique = true)
    private String nombreServicio;
    @Column(nullable = false)
    private String costo;
    @Column(nullable = false)

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public Long getIdServicio() {
        return idServicio;
    }
}
