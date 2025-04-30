package cua.integra.cajasuamc.repository;

import cua.integra.cajasuamc.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    Alumno findByMatricula(int matricula);
}