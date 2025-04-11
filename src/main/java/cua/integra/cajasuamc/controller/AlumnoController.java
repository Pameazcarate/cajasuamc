package cua.integra.cajasuamc.controller;

import cua.integra.cajasuamc.dto.AlumnoDTO;
import cua.integra.cajasuamc.service.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @PostMapping
    public ResponseEntity<AlumnoDTO> createAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        AlumnoDTO createdAlumno = alumnoService.createAlumno(alumnoDTO);
        return new ResponseEntity<>(createdAlumno, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> getAllAlumnos() {
        List<AlumnoDTO> alumnos = alumnoService.getAllAlumnos();
        if (alumnos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<AlumnoDTO> getAlumnoByMatricula(@PathVariable int matricula) {
        AlumnoDTO alumno = alumnoService.getUserByMatricula(matricula);
        if (alumno != null) {
            return new ResponseEntity<>(alumno, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<AlumnoDTO> updateAlumno(@PathVariable int matricula, @RequestBody AlumnoDTO alumnoDTO) {
        AlumnoDTO updatedAlumno = alumnoService.updateAlumno(matricula, alumnoDTO);
        if (updatedAlumno != null) {
            return new ResponseEntity<>(updatedAlumno, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable int matricula) {
        boolean deleted = alumnoService.deleteAlumno(matricula);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
