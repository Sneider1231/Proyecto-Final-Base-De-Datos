package com.example.back.Controlador;

import com.example.back.Modelo.Comprador;
import com.example.back.Servicio.CompradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("cita")
public class CompradorControlador {

    @Autowired
    private CompradorServicio service;

    @PostMapping("")
    public Comprador save(@RequestBody Comprador comprador){
        return service.save(comprador);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Comprador comprador, @PathVariable int id){
        service.update(comprador, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @GetMapping("")
    public List<Comprador> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Comprador> findById(@PathVariable int id){
        return service.findById(id);
    }
}
