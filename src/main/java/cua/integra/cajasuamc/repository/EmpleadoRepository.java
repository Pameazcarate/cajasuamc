package cua.integra.cajasuamc.repository;

import cua.integra.cajasuamc.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Empleado findBynumeroEmpleado(long numeroEmpleado);
}
