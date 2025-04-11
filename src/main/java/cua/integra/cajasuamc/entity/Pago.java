package cua.integra.cajasuamc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Pago")
@Getter
@Setter
public class Pago {
    @Id
    private long id;
    @Column(nullable = false, unique = true)
    private Date fechaPago;
    @Column(nullable = false)
    private String monto;
}
