package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.PagoDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PagoService {

   PagoDTO createPago(PagoDTO pagoDTO);

   List<PagoDTO> getAllPagos();
   PagoDTO getPagoById(Long id);
   boolean deletePagoById(Long id);


}
