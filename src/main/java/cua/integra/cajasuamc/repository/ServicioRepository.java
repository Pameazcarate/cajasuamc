package cua.integra.cajasuamc.repository;

import cua.integra.cajasuamc.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Empleado, Long> {
}
