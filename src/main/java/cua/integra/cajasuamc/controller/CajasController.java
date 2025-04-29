package cua.integra.cajasuamc.controller;

import cua.integra.cajasuamc.dto.CajasDTO;
import cua.integra.cajasuamc.service.CajaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CajasController{

    private final CajaService cajaService;

    public CajasController(CajaService cajaService) {
        this.cajaService = cajaService;
    }

    @PostMapping("/cajas")
    public CajasDTO createCaja(@RequestBody CajasDTO cajasDTO){
        return cajaService.createCaja(cajasDTO);
    }

    @GetMapping("/cajas")
    public List<Object> getAllCajas(){
        return cajaService.getAllCajas();
    }

    @GetMapping("/cajas/{id}")
    public ResponseEntity<CajasDTO> getCajasById(@PathVariable int id) {
        CajasDTO cajasDTO = cajaService.getCajasById(id);
        if (cajasDTO != null) {
            return ResponseEntity.ok(cajasDTO);
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("cajas/{id}")
    public ResponseEntity<CajasDTO> updateCaja(@PathVariable int id, @RequestBody CajasDTO cajasDTO) {
        CajasDTO updateCaja = cajaService.updateCaja(id, cajasDTO);
        if (updateCaja != null) {
            return ResponseEntity.ok(updateCaja);
        }
        return ResponseEntity.notFound().build();
    }

}