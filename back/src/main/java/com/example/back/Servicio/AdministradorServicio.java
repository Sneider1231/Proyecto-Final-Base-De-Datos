package com.example.back.Servicio;

import com.example.back.Modelo.Administrador;
import com.example.back.Repositorio.AdministradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicio {

    @Autowired
    private AdministradorRepositorio repository;


    public Administrador save(Administrador Administrador) {
        return repository.save(Administrador);
    }

    public void update(Administrador administrador, int id) {
        Optional<Administrador> optional = repository.findById(id);

        if (optional.isPresent()) {
            Administrador administradorUpdate = optional.get();
            administradorUpdate.setUsuario(administrador.getUsuario());
            administradorUpdate.setContrasena(administrador.getContrasena());
            repository.save(administradorUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }

    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Optional<Administrador> findById(int id) {
        return repository.findById(id);
    }

    public List<Administrador> findAll() {
        return repository.findAll();
    }
}
