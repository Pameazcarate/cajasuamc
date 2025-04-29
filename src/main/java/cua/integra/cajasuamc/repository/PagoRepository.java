package cua.integra.cajasuamc.repository;

import cua.integra.cajasuamc.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    List<Pago> findByAlumnoId(Long alumnoId);
    List<Pago> findByCajaId(Long cajaId);
    List<Pago> findByFechaPago(Date fechaPago);
    List<Pago> findByFechaPagoBetween(Date inicio, Date fin);
    List<Pago> findByMonto(BigDecimal monto);
    List<Pago> findByServicioId(Long servicioId);

}
