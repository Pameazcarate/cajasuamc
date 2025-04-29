package cua.integra.cajasuamc.controller;

import cua.integra.cajasuamc.dto.EmpleadoDTO;
import cua.integra.cajasuamc.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService alumnoService) {
        this.empleadoService = alumnoService;
    }

    @PostMapping("/empleados")
    public ResponseEntity<EmpleadoDTO> createEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        EmpleadoDTO createdAlumno = empleadoService.createEmpleado(empleadoDTO);
        return new ResponseEntity<>(createdAlumno, HttpStatus.CREATED);
    }

    @GetMapping("/empleados")
    public ResponseEntity<List<EmpleadoDTO>> getAll() {
        List<EmpleadoDTO> empleados = empleadoService.getAllEmpleados();
        if (empleados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping("/empleados/{numeroEmpleado}")
    public ResponseEntity<EmpleadoDTO> findEmpleadoBynumeroEmpleado(@PathVariable long numeroEmpleado) {
        EmpleadoDTO empleado = empleadoService.getEmpleadoBynumeroEmpleado(numeroEmpleado);
        if (empleado != null) {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/empleados/{numeroEmpleado}")
    public ResponseEntity<EmpleadoDTO> updateEmpleado(@PathVariable long numeroEmpleado, @RequestBody EmpleadoDTO empleadoDTO) {
        EmpleadoDTO updatedEmpleado = empleadoService.updateEmpleado(numeroEmpleado, empleadoDTO);
        if (updatedEmpleado != null) {
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
