package cua.integra.cajasuamc.repository;

import cua.integra.cajasuamc.entity.Caja;
import cua.integra.cajasuamc.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    Pago findById(long id);

}
