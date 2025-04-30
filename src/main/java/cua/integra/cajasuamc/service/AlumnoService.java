package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.AlumnoDTO;
import cua.integra.cajasuamc.dto.CajasDTO;

import java.util.List;

public interface AlumnoService {

    AlumnoDTO createAlumno(AlumnoDTO alumno);

    List<AlumnoDTO> getAllAlumnos();

    AlumnoDTO getAlumnoByMatricula(int matricula);

    AlumnoDTO updateAlumno(int matricula, AlumnoDTO alumnoDTO);
}
