package cua.integra.cajasuamc.repository;

import cua.integra.cajasuamc.entity.Caja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajaRepository extends JpaRepository<Caja, String> {
    Caja save(Caja caja);
    Caja findById(int id);
}
