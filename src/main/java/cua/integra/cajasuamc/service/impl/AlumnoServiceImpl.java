package cua.integra.cajasuamc.service.impl;

import cua.integra.cajasuamc.dto.AlumnoDTO;
import cua.integra.cajasuamc.entity.Alumno;
import cua.integra.cajasuamc.repository.AlumnoRepository;
import cua.integra.cajasuamc.service.AlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }


    @Override
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = new Alumno();

        alumno.setMatricula(alumnoDTO.getMatricula());
        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setApellidos(alumnoDTO.getApellidos());
        alumno.setTelefono(alumnoDTO.getTelefono());

        Alumno savedAlumno = alumnoRepository.save(alumno);

        alumnoDTO.setId(savedAlumno.getId());
        return alumnoDTO;
    }

    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlumnoDTO getAlumnoByMatricula(int matricula){
        Alumno alumno = alumnoRepository.findByMatricula(matricula);
        if (alumno != null) {
            return convertToDTO(alumno);
        }
        return null;
    }

    @Override
    public AlumnoDTO updateAlumno(int matricula, AlumnoDTO alumnoDTO){
        Alumno alumnnoE = alumnoRepository.findByMatricula(matricula);
        if (alumnnoE != null) {
            alumnnoE.setNombre(alumnoDTO.getNombre());
            alumnnoE.setApellidos(alumnoDTO.getApellidos());
            alumnnoE.setTelefono(alumnoDTO.getTelefono());

            Alumno updatedAlumno = alumnoRepository.save(alumnnoE);
            return convertToDTO(updatedAlumno);
        }
        return null;
    }

    private AlumnoDTO convertToDTO(Alumno alumno) {
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setMatricula(alumno.getMatricula());
        alumnoDTO.setNombre(alumno.getNombre());
        alumnoDTO.setApellidos(alumno.getApellidos());
        alumnoDTO.setTelefono(alumno.getTelefono());
        return alumnoDTO;
    }

}