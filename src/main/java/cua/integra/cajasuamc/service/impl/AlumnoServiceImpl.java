package cua.integra.cajasuamc.service.impl;

import cua.integra.cajasuamc.dto.AlumnoDTO;
import cua.integra.cajasuamc.entity.Alumno;
import cua.integra.cajasuamc.repository.AlumnoRepository;
import cua.integra.cajasuamc.service.AlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = toEntity(alumnoDTO);
        Alumno savedAlumno = alumnoRepository.save(alumno);
        return toDTO(savedAlumno);
    }

    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlumnoDTO getUserByMatricula(int matricula) {
        Alumno alumno = alumnoRepository.findByMatricula(matricula);
        return alumno != null ? toDTO(alumno) : null;
    }

    @Override
    public AlumnoDTO updateAlumno(int matricula, AlumnoDTO alumnoDTO) {
        Alumno alumno = alumnoRepository.findByMatricula(matricula);
        if (alumno != null) {
            alumno.setNombre(alumnoDTO.getNombre());
            alumno.setApellidos(alumnoDTO.getApellidos());
            alumno.setTelefono(alumnoDTO.getTelefono());
            Alumno updatedAlumno = alumnoRepository.save(alumno);
            return toDTO(updatedAlumno);
        }
        return null;
    }

    @Override
    public boolean deleteAlumno(int matricula) {
        try {
            alumnoRepository.deleteByMatricula(matricula);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private AlumnoDTO toDTO(Alumno alumno) {
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setId(alumno.getId());
        alumnoDTO.setMatricula(alumno.getMatricula());
        alumnoDTO.setNombre(alumno.getNombre());
        alumnoDTO.setApellidos(alumno.getApellidos());
        alumnoDTO.setTelefono(alumno.getTelefono());
        return alumnoDTO;
    }

    private Alumno toEntity(AlumnoDTO alumnoDTO) {
        Alumno alumno = new Alumno();
        alumno.setId(alumnoDTO.getId());
        alumno.setMatricula(alumnoDTO.getMatricula());
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellidos(alumnoDTO.getApellidos());
        alumno.setTelefono(alumnoDTO.getTelefono());
        return alumno;
    }
}