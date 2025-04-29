package cua.integra.cajasuamc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Table(name = "servicios")
@Setter
public class Servicios {
    @Id
    private long idServicio;
    @Column(nullable = false)
    private String recuperacion;
    @Column(nullable = false)
    private String constancia;
    @Column(nullable = false)
    private String reposicionCredencial;
    @Column(nullable = false)
    private String multaBiblioteca;
    @Column(nullable = false)
    private String boletoTransporte;
}
