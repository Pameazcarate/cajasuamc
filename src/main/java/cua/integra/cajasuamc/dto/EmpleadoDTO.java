package cua.integra.cajasuamc.dto;

import lombok.Data;

@Data
public class EmpleadoDTO {
    private long numeroEmpleado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
}
