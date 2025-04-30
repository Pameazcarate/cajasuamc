package cua.integra.cajasuamc.service.impl;

import cua.integra.cajasuamc.dto.ServicioDTO;
import cua.integra.cajasuamc.entities.Servicio;
import cua.integra.cajasuamc.repository.ServicioRepository;
import cua.integra.cajasuamc.service.ServicioService;

import java.util.List;
import java.util.stream.Collectors;

public class ServicioServiceImpl implements ServicioService {
    private final ServicioRepository servicioRepository;

    public ServicioServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public ServicioDTO createServicio(ServicioDTO servicioDTO) {
        Servicio servicio = new Servicio();

        servicio.setIdServicio(servicioDTO.getIdServicio());
        servicio.setNombreServicio(servicioDTO.getNombreServicio());
        servicio.setCosto(String.valueOf(servicioDTO.getCosto()));

        Servicio savedServicios = servicioRepository.save(servicio);

        servicioDTO.setIdServicio((int) savedServicios.getIdServicio());
        return servicioDTO;
    }

    @Override
    public List<ServicioDTO> getAllServicios() {
        List<Servicio> servicios = servicioRepository.findAll();
        return servicios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ServicioDTO getServicioByIdServicio(long idServicio) {
        Servicio servicio = servicioRepository.findByIdServicio(idServicio);
        if (servicio != null) {
            return convertToDTO(servicio);
        }
        return null;
    }

    @Override
    public ServicioDTO updateServicio(long idServicio, ServicioDTO servicioDTO){
        Servicio servicio1 = servicioRepository.findByIdServicio(idServicio);
        if (servicio1 != null) {
            servicio1.setIdServicio(servicioDTO.getIdServicio());
            servicio1.setNombreServicio(servicioDTO.getNombreServicio());
            servicio1.setCosto(String.valueOf(servicioDTO.getCosto()));

            Servicio updatedServicio = servicioRepository.save(servicio1);
            return convertToDTO(updatedServicio);
        }
        return null;
    }

    private ServicioDTO convertToDTO(Servicio servicio) {
        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setIdServicio(servicioDTO.getIdServicio());
        servicioDTO.setNombreServicio(servicioDTO.getNombreServicio());
        servicioDTO.setCosto(Integer.parseInt(String.valueOf(servicioDTO.getCosto())));
        return servicioDTO;
    }
}
