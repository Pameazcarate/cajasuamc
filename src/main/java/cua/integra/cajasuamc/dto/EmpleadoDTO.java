package cua.integra.cajasuamc.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="empleados")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class EmpleadoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroEmpleado;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellidos;
    @Column(nullable = false)
    private int telefono;

    public long getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(long numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
