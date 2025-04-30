package cua.integra.cajasuamc.service.impl;

import cua.integra.cajasuamc.dto.CajasDTO;
import cua.integra.cajasuamc.entity.Caja;
import cua.integra.cajasuamc.repository.CajaRepository;
import cua.integra.cajasuamc.service.CajaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CajaServiceImpl implements CajaService {

    private final CajaRepository cajaRepository;

    public CajaServiceImpl(CajaRepository cajaRepository) {
        this.cajaRepository = cajaRepository;
    }

    @Override
    public CajasDTO createCaja(CajasDTO cajasDTO) {
        Caja caja = new Caja();

        caja.setId(cajasDTO.getId());
        caja.setNumero_ventanilla(cajasDTO.getNumero_ventanilla());

        Caja savedCaja = cajaRepository.save(caja);

        cajasDTO.setId(savedCaja.getId());
        return cajasDTO;
    }

    @Override
    public List<Object> getAllCajas() {
        List<Caja> cajas = cajaRepository.findAll();
        return cajas.stream().map(this::convertToDTO).collect(Collectors.toList()).reversed();
    }

    private Object convertToDTO(Caja caja) {
        CajasDTO cajasDTO = new CajasDTO();
        cajasDTO.setId(caja.getId());
        cajasDTO.setNumero_ventanilla(caja.getNumero_ventanilla());

        return cajasDTO;
    }

    @Override
    public CajasDTO getCajasById(long id) {
        Caja caja = cajaRepository.findById(id);
        if (caja != null) {
            return (CajasDTO) convertToDTO(caja);
        }
        return null;
    }

    @Override
    public CajasDTO updateCaja(long id, CajasDTO cajasDTO) {
        Caja cajaE = cajaRepository.findById(id);
        if (cajaE != null) {
            cajaE.setId(cajasDTO.getId());
            cajaE.setNumero_ventanilla(cajasDTO.getNumero_ventanilla());

            Caja updatedCaja = cajaRepository.save(cajaE);
            return (CajasDTO) convertToDTO(updatedCaja);
        }
        return null;
    }
}
