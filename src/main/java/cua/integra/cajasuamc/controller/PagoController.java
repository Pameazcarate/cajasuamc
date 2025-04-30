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

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

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

<<<<<<< Updated upstream
    @GetMapping("/{id}")
=======
    @GetMapping("/pagos/{id}")
>>>>>>> Stashed changes
    public ResponseEntity<PagoDTO> getPagoById(@PathVariable long id) {
        PagoDTO pago = pagoService.getPagoById(id);
        if (pago != null) {
            return new ResponseEntity<>(pago, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

<<<<<<< Updated upstream
    @DeleteMapping("/{id}")
=======
    @DeleteMapping("/pagos/{id}")
>>>>>>> Stashed changes
    public ResponseEntity<Void> deletePago(@PathVariable long id) {
        boolean deleted = pagoService.deletePagoById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
