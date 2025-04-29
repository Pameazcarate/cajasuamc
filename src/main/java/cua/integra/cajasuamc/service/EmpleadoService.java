package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.EmpleadoDTO;

import java.util.List;

public interface EmpleadoService {
    EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO);
    List<EmpleadoDTO> getAllEmpleados();
    List<EmpleadoDTO> getAllAlumnos();
    EmpleadoDTO getEmpleadoBynumeroEmpleado(long numeroEmpleado);
    EmpleadoDTO updateEmpleado(long numeroEmpleado, EmpleadoDTO empleadoDTO);
}
