package com.example.back.Servicio;

import com.example.back.Modelo.Comprador;
import com.example.back.Repositorio.CompradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompradorServicio {

    @Autowired
    private CompradorRepositorio repository;


    public Comprador save(Comprador Comprador) {
        return repository.save(Comprador);
    }

    public void update(Comprador comprador, int id) {
        Optional<Comprador> optional = repository.findById(id);

        if (optional.isPresent()) {
            Comprador compradorUpdate = optional.get();
            compradorUpdate.setNombre(comprador.getNombre());
            compradorUpdate.setUsuario(comprador.getUsuario());
            compradorUpdate.setContrasena(comprador.getContrasena());
            compradorUpdate.setIdentificacion(comprador.getIdentificacion());
            repository.save(compradorUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }

    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Optional<Comprador> findById(int id) {
        return repository.findById(id);
    }

    public List<Comprador> findAll() {
        return repository.findAll();
    }
}
