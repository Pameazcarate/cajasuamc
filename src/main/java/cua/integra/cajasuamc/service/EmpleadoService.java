package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.EmpleadoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmpleadoService {
    EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO);
    List<EmpleadoDTO> getAllEmpleados();
    EmpleadoDTO getEmpleadoBynumeroEmpleado(long numeroEmpleado);
    EmpleadoDTO updateEmpleado(long numeroEmpleado, EmpleadoDTO empleadoDTO);
}

