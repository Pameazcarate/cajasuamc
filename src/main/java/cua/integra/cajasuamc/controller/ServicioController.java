package cua.integra.cajasuamc.controller;

import cua.integra.cajasuamc.dto.ServicioDTO;
import cua.integra.cajasuamc.service.ServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class ServicioController {
    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @PostMapping("/servicios")
    public ResponseEntity<ServicioDTO> createServicio(@RequestBody ServicioDTO servicioDTO) {
        ServicioDTO createdServicio = servicioService.createServicio(servicioDTO);
        return new ResponseEntity<>(createdServicio, HttpStatus.CREATED);
    }

    @GetMapping("/servicios")
    public ResponseEntity<List<ServicioDTO>> getAll() {
        List<ServicioDTO> servicios = servicioService.getAllServicios();
        if (servicios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    @GetMapping("/servicios/{idServicio}")
    public ResponseEntity<ServicioDTO> findServicioByIdServicio(@PathVariable long idServicio) {
        ServicioDTO servicio = servicioService.getServicioByIdServicio(idServicio);
        if (servicio != null) {
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/servicios/{idServicio}")
    public ResponseEntity<ServicioDTO> updateServicio(@PathVariable long idServicio, @RequestBody ServicioDTO servicioDTO) {
        ServicioDTO updatedServicio = servicioService.updateServicio(idServicio, servicioDTO);
        if (updatedServicio != null) {
            return new ResponseEntity<>(updatedServicio, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
