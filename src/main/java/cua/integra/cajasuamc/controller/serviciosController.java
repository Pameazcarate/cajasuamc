package cua.integra.cajasuamc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicios")
public class serviciosController {
    
    public ConductorController(IConductorService conductorService){
        this.conductorService = conductorService;
    }

    @GetMapping("/test")
    public String test(){
        return "Hola mundo";
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Conductor setUser(@RequestBody Conductor conductor){
        return conductorService.createConductor(conductor);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Conductor> getAllUsers() {
        return conductorService.getAll();
    }

    @GetMapping("/conductor/{id}")
    public Conductor getUserById(@PathVariable String id) {
        return conductorService.getConductorById(id);
    }

    @DeleteMapping("/conductor/{id}")
    public void deleteUser(@PathVariable String id) {
        conductorService.deleteConductor(id);
    }

    @PutMapping("/conductor/{id}")
    public Conductor updateUser(@PathVariable String id, @RequestBody Conductor conductor) {
        return conductorService.updateConductor(id, conductor);
    }

    @PatchMapping("/conductor/{id}")
    public Conductor patchUser(@PathVariable String id, @RequestBody Conductor conductor) {
        return conductorService.patchConductor(id, conductor);
    }
}
