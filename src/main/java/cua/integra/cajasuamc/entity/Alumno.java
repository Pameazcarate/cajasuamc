package cua.integra.cajasuamc.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "alumnos")
@Setter
public class Alumno {
    @Id
    private long id;
    @Column(nullable = false, unique = true)
    private String matricula;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false, name = "telefono_contacto")
    private String telefonoContacto;
    @Column(nullable = false)
    private String password;
=======

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
    private int id;

    @Column(nullable = false, unique = true)
    private int matricula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "pago")
    @ToString.Exclude
    private List<Pago> pagos;
}
