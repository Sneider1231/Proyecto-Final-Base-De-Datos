package com.example.back.Servicio;

import com.example.back.Modelo.Cita;
import com.example.back.Repositorio.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServicio {

    @Autowired
    private CitaRepositorio repository;


    public Cita save(Cita Cita) {
        return repository.save(Cita);
    }

    public void update(Cita cita, int id) {
        Optional<Cita> optional = repository.findById(id);

        if (optional.isPresent()) {
            Cita citaUpdate = optional.get();
            citaUpdate.setFechaHora(cita.getFechaHora());
            citaUpdate.setUbicacion(cita.getUbicacion());
            citaUpdate.setVehiculo(cita.getVehiculo());
            citaUpdate.setComprador(cita.getComprador());
            repository.save(citaUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }

    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Optional<Cita> findById(int id) {
        return repository.findById(id);
    }

    public List<Cita> findAll() {
        return repository.findAll();
    }
}
