package cua.integra.cajasuamc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

    @Entity
    @Table(name = "pago")
    @Getter
    @Setter
    public class Pago {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false)
        private Date fechaPago;

        @Column(nullable = false)
        private String monto;

        @ManyToOne
        @JoinColumn(name = "alumno_id")
        private Alumno alumno;

        @ManyToOne
        @JoinColumn(name = "caja_id")
        private Caja caja;
<<<<<<< Updated upstream
        }
=======

        @ManyToOne
        @JoinColumn(name = "servicio_id")
        private Servicio servicio;
    }
>>>>>>> Stashed changes
