package cua.integra.cajasuamc.service.impl;

import cua.integra.cajasuamc.dto.AlumnoDTO;
import cua.integra.cajasuamc.entity.Alumno;
import cua.integra.cajasuamc.repository.AlumnoRepository;
import cua.integra.cajasuamc.service.AlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public <Alummno> AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = new Alumno();

        alumno.setId(alumnoDTO.getId());
        alumno.setMatricula(alumnoDTO.getMatricula());
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellidos(alumnoDTO.getApellidos());
        alumno.setTelefono(alumnoDTO.getTelefono());

        Alumno savedAlumno = (Alumno) alumnoRepository.save(alumno);
        alumnoDTO.setMatricula(savedAlumno.getMatricula);
        return alumnoDTO;
    }

    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        return List.of();
    }


    @Override
    public AlumnoDTO getUserByMatricula(int matricula) {
        return null;
    }

    @Override
    public AlumnoDTO updateAlumno(int matricula, AlumnoDTO alumno) {
        return null;
    }

    @Override
    public boolean deleteAlumno(int matricula) {
        return false;
    }
}
