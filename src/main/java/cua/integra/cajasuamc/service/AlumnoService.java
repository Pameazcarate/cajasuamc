package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.AlumnoDTO;

import java.util.List;

public interface AlumnoService {
    AlumnoDTO createAlumno(AlumnoDTO alumno);

    List<AlumnoDTO> getAllAlumnos();
    AlumnoDTO getUserByMatricula(AlumnoDTO alumno);
}
