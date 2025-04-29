package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.PagoDTO;

import java.util.List;

public interface PagoService {
   <Pago> PagoDTO createPago(PagoDTO pagoDTO);
   List<PagoDTO> getAllPagos();
   PagoDTO getPagoById(int id);
   boolean deletePagoById(int id);


}
