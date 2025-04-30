package cua.integra.cajasuamc.service.impl;

import cua.integra.cajasuamc.dto.PagoDTO;
import cua.integra.cajasuamc.entity.Alumno;
import cua.integra.cajasuamc.entity.Caja;
import cua.integra.cajasuamc.entity.Pago;
import cua.integra.cajasuamc.repository.AlumnoRepository;
import cua.integra.cajasuamc.repository.PagoRepository;
import cua.integra.cajasuamc.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl {

    private final PagoRepository pagoRepository;
    private final AlumnoRepository alumnoRepository;
    private final CajaRepository cajaRepository;

    @Autowired
    public PagoServiceImpl(PagoRepository pagoRepository, AlumnoRepository alumnoRepository, CajaRepository cajaRepository) {
        this.pagoRepository = pagoRepository;
        this.alumnoRepository = alumnoRepository;
        this.cajaRepository = cajaRepository;
    }

    @Override
    public PagoDTO createPago(PagoDTO pagoDTO){
        Pago pago = toEntity(pagoDTO);
        pago.setFechaPago(new Date());

        Alumno alumno = alumnoRepository.findById(String.valueOf(pagoDTO.getAlumnoId())).orElse(null);
        Caja caja = cajaRepository.findById(pagoDTO.getCajaId()).orElse(null);

        if (alumno != null && caja != null){
            pago.setAlumno(alumno);
            pago.setCaja(caja);
            Pago savedPago = pagoRepository.save(pago);
            return toDTO(savedPago);
        }

        return null;

    }

    @Override
    public List<PagoDTO> getAllPagos(){
        List<Pago> pagos = pagoRepository.findAll();
        return pagos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PagoDTO getPagoById(long id){
        return pagoRepository.findById((long) id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public boolean deletePagoById(int id){
        try{
            pagoRepository.deleteById((long)id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private PagoDTO toDTO(Pago pago){
        PagoDTO dto = new PagoDTO();
        dto.setId(pago.getId());
        dto.setFechaPago(pago.getFechaPago());
        dto.setMonto(pago.getMonto());
        dto.setAlumnoId(pago.getAlumno().getId());
        dto.getCajaId(pago.getCaja().getId());
        return dto;
    }

    private Pago toEntity(PagoDTO dto) {
        Pago pago = new Pago();
        pago.setId(dto.getId());
        pago.setFechaPago(dto.getFechaPago());
        pago.setMonto(dto.getMonto());
        return pago;
    }



}
