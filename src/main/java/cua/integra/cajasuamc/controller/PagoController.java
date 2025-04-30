package cua.integra.cajasuamc.controller;

import cua.integra.cajasuamc.dto.PagoDTO;
import cua.integra.cajasuamc.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    @PostMapping("/pagos")
    public ResponseEntity<PagoDTO> createPago(@RequestBody PagoDTO pagoDTO) {
        PagoDTO createdPago = pagoService.createPago(pagoDTO);
        return new ResponseEntity<>(createdPago, HttpStatus.CREATED);
    }

    @GetMapping("/pagos")
    public ResponseEntity<List<PagoDTO>> getAllPagos() {
        List<PagoDTO> pagos = pagoService.getAllPagos();
        if (pagos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> getPagoById(@PathVariable int id) {
        PagoDTO pago = pagoService.getPagoById(id);
        if (pago != null) {
            return new ResponseEntity<>(pago, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable int id) {
        boolean deleted = pagoService.deletePagoById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<List<PagoDTO>> getPagosByAlumno(@PathVariable Long alumnoId) {
        List<PagoDTO> pagos = pagoService.getPagosByAlumnoId(alumnoId);
        return pagos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(pagos);
    }

    @GetMapping("/rango-fechas")
    public ResponseEntity<List<PagoDTO>> getPagosPorRangoFechas(@RequestParam Date inicio, @RequestParam Date fin) {
        List<PagoDTO> pagos = pagoService.getPagosByFechaPagoBetween(inicio, fin);
        return pagos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(pagos);
    }

}
