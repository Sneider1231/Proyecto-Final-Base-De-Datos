package com.example.back.Controlador;

import com.example.back.Modelo.Administrador;
import com.example.back.Servicio.AdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("cita")
public class AdministradorControlador {

    @Autowired
    private AdministradorServicio service;

    @PostMapping("")
    public Administrador save(@RequestBody Administrador administrador){
        return service.save(administrador);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Administrador administrador, @PathVariable int id){
        service.update(administrador, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @GetMapping("")
    public List<Administrador> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Administrador> findById(@PathVariable int id){
        return service.findById(id);
    }
}
