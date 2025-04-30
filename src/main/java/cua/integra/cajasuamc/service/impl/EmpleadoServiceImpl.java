package cua.integra.cajasuamc.service.impl;

import cua.integra.cajasuamc.dto.EmpleadoDTO;
import cua.integra.cajasuamc.entities.Empleado;
import cua.integra.cajasuamc.repository.EmpleadoRepository;
import cua.integra.cajasuamc.service.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado();

        empleado.setNumeroEmpleado(empleadoDTO.getNumeroEmpleado());
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setApellidos(empleadoDTO.getApellidos());
        empleado.setTelefono(String.valueOf(empleadoDTO.getTelefono()));

        Empleado savedEmpleado = empleadoRepository.save(empleado);

        empleadoDTO.setNumeroEmpleado(savedEmpleado.getNumeroEmpleado());
        return empleadoDTO;
    }

    @Override
    public List<EmpleadoDTO> getAllEmpleados() {
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO getEmpleadoBynumeroEmpleado(long numeroEmpleado) {
        Empleado empleado = empleadoRepository.findBynumeroEmpleado(numeroEmpleado);
        if (empleado != null) {
            return convertToDTO(empleado);
        }
        return null;
    }

    @Override
    public EmpleadoDTO updateEmpleado(long numeroEmpleado, EmpleadoDTO empleadoDTO){
        Empleado empleado1 = empleadoRepository.findBynumeroEmpleado(numeroEmpleado);
        if (empleado1 != null) {
            empleado1.setNombre(empleadoDTO.getNombre());
            empleado1.setApellidos(empleadoDTO.getApellidos());
            empleado1.setTelefono(String.valueOf(empleadoDTO.getTelefono()));

            Empleado updatedEmpleado = empleadoRepository.save(empleado1);
            return convertToDTO(updatedEmpleado);
        }
        return null;
    }

    private EmpleadoDTO convertToDTO(Empleado empleado) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setNumeroEmpleado(empleado.getNumeroEmpleado());
        empleadoDTO.setNombre(empleado.getNombre());
        empleadoDTO.setApellidos(empleado.getApellidos());
        return empleadoDTO;
    }
}
