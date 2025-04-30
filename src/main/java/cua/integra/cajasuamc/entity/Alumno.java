package cua.integra.cajasuamc.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;

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
}
