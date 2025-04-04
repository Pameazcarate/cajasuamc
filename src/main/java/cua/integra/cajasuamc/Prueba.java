package cua.integra.cajasuamc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Prueba {
    @GetMapping("/v1")
    public String v1() {
        return "Pruebas desde rama development para practica 6.";
    }
}