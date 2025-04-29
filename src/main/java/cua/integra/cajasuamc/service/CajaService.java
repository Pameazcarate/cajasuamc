package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.CajasDTO;

import java.util.List;

public interface CajaService {
    CajasDTO createCaja(CajasDTO cajasDTO);

    List<Object> getAllCajas();

    CajasDTO getCajasById(int id);

    CajasDTO updateCaja(int id, CajasDTO cajasDTO);
}
