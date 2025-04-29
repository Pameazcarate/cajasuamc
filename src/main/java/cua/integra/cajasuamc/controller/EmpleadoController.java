package cua.integra.cajasuamc.controller;
import cua.integra.cajasuamc.dto.EmpleadoDTO;
import cua.integra.cajasuamc.service.impl.EmpleadoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class EmpleadoController {
    private EmpleadoServiceImpl empleadoService;

    public EmpleadoController(EmpleadoServiceImpl empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/clientes")
    public EmpleadoDTO save(@RequestBody EmpleadoDTO empleadoDTO){
        return empleadoService.save(empleadoDTO);
    }

    @GetMapping("/clientes")
    public List<EmpleadoDTO> findAll(){
        return empleadoService.findAll();
    }
}
