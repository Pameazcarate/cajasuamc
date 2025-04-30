package cua.integra.cajasuamc.service.impl;

import cua.integra.cajasuamc.dto.PagoDTO;
import cua.integra.cajasuamc.entity.Alumno;
import cua.integra.cajasuamc.entity.Caja;
import cua.integra.cajasuamc.entity.Pago;
import cua.integra.cajasuamc.repository.AlumnoRepository;
import cua.integra.cajasuamc.repository.CajaRepository;
import cua.integra.cajasuamc.repository.PagoRepository;
import cua.integra.cajasuamc.service.PagoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final AlumnoRepository alumnoRepository;
    private final CajaRepository cajaRepository;

    public PagoServiceImpl(PagoRepository pagoRepository, AlumnoRepository alumnoRepository, CajaRepository cajaRepository) {
        this.pagoRepository = pagoRepository;
        this.alumnoRepository = alumnoRepository;
        this.cajaRepository = cajaRepository;
    }

    @Override
    public PagoDTO createPago(PagoDTO pagoDTO) {
        Pago pago = new Pago();
        pago.setFechaPago(new Date());
        pago.setMonto(pagoDTO.getMonto().toString());

        Alumno alumno = alumnoRepository.findById(pagoDTO.getAlumnoId()).orElse(null);
        Caja caja = cajaRepository.findById(pagoDTO.getCajaId()).orElse(null);

        if (alumno != null && caja != null) {
            pago.setAlumno(alumno);
            pago.setCaja(caja);
            Pago savedPago = pagoRepository.save(pago);
            return convertToDTO(savedPago);
        }

        return null;
    }

    @Override
    public List<PagoDTO> getAllPagos() {
        List<Pago> pagos = pagoRepository.findAll();
        return pagos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PagoDTO getPagoById(Long id) {
        return pagoRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public boolean deletePagoById(Long id) {
        try {
            pagoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private PagoDTO convertToDTO(Pago pago) {
        PagoDTO dto = new PagoDTO();
        dto.setId(pago.getId());
        dto.setFechaPago(pago.getFechaPago());

        if (pago.getMonto() != null) {
            dto.setMonto(new BigDecimal(pago.getMonto()));
        }

        if (pago.getAlumno() != null) {
            dto.setAlumnoId(pago.getAlumno().getId());
        }

        if (pago.getCaja() != null) {
            dto.setCajaId(pago.getCaja().getId());
        }

        return dto;
    }

}
