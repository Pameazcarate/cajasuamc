package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.ServicioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioService {
    ServicioDTO updateServicio(long idServicio, ServicioDTO servicioDTO);
    ServicioDTO createServicio(ServicioDTO servicioDTO);
    List<ServicioDTO> getAllServicios();
    ServicioDTO getServicioByIdServicio(long idServicio);
}
