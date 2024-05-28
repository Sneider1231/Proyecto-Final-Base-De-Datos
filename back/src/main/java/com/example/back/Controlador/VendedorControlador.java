package com.example.back.Controlador;

import com.example.back.Modelo.Vendedor;
import com.example.back.Servicio.VendedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("cita")
public class VendedorControlador {

    @Autowired
    private VendedorServicio service;

    @PostMapping("")
    public Vendedor save(@RequestBody Vendedor vendedor){
        return service.save(vendedor);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Vendedor vendedor, @PathVariable int id){
        service.update(vendedor, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @GetMapping("")
    public List<Vendedor> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vendedor> findById(@PathVariable int id){
        return service.findById(id);
    }
}
