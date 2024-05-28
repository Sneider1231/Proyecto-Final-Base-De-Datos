package com.example.back.Controlador;

import com.example.back.Modelo.Vehiculo;
import com.example.back.Servicio.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("cita")
public class VehiculoControlador {

    @Autowired
    private VehiculoServicio service;

    @PostMapping("")
    public Vehiculo save(@RequestBody Vehiculo vehiculo){
        return service.save(vehiculo);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Vehiculo vehiculo, @PathVariable int id){
        service.update(vehiculo, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @GetMapping("")
    public List<Vehiculo> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vehiculo> findById(@PathVariable int id){
        return service.findById(id);
    }
}
