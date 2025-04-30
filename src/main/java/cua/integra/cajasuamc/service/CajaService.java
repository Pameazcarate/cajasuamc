package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.CajasDTO;

import java.util.List;

public interface CajaService {
    CajasDTO createCaja(CajasDTO cajasDTO);

    List<Object> getAllCajas();

    CajasDTO getCajasById(long id);

    CajasDTO updateCaja(long id, CajasDTO cajasDTO);
}
