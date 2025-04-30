package cua.integra.cajasuamc.service;

import cua.integra.cajasuamc.dto.ServicioDTO;

import java.util.List;

public interface ServicioService {
    ServicioDTO updateServicio(long idServicio, ServicioDTO servicioDTO);
    ServicioDTO createServicio(ServicioDTO servicioDTO);
    List<ServicioDTO> getAllServicios();
    ServicioDTO getServicioByIdServicio(long idServicio);
}
