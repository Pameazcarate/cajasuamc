package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.AlumnoDTO;

import java.util.List;

public interface AlumnoService {
    <Alummno> AlumnoDTO createAlumno(AlumnoDTO alumnoDTO);

    List<AlumnoDTO> getAllAlumnos();
    AlumnoDTO getUserByMatricula(int matricula);
    AlumnoDTO updateAlumno(int matricula,AlumnoDTO alumno);
    boolean deleteAlumno(int matricula);
}
