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

    @PostMapping("/caja")
    public CajasDTO createCaja(@RequestBody CajasDTO cajasDTO){
        return cajaService.createCaja(cajasDTO);
    }

    @GetMapping("/caja")
    public List<Object> getAllCajas(){
        return cajaService.getAllCajas();
    }

    @GetMapping("/caja/{id}")
    public ResponseEntity<CajasDTO> getCajasById(@PathVariable long id) {
        CajasDTO cajasDTO = cajaService.getCajasById(id);
        if (cajasDTO != null) {
            return ResponseEntity.ok(cajasDTO);
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("caja/{id}")
    public ResponseEntity<CajasDTO> updateCaja(@PathVariable long id, @RequestBody CajasDTO cajasDTO) {
        CajasDTO updateCaja = cajaService.updateCaja(id, cajasDTO);
        if (updateCaja != null) {
            return ResponseEntity.ok(updateCaja);
        }
        return ResponseEntity.notFound().build();
    }

}