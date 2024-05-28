package com.example.back.Servicio;

import com.example.back.Modelo.Vehiculo;
import com.example.back.Repositorio.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServicio {

    @Autowired
    private VehiculoRepositorio repository;


    public Vehiculo save(Vehiculo Vehiculo) {
        return repository.save(Vehiculo);
    }

    public void update(Vehiculo vehiculo, int id) {
        Optional<Vehiculo> optional = repository.findById(id);

        if (optional.isPresent()) {
            Vehiculo vehiculoUpdate = optional.get();
            vehiculoUpdate.setNombre(vehiculo.getNombre());
            vehiculoUpdate.setMarca(vehiculo.getMarca());
            vehiculoUpdate.setDescripcion(vehiculo.getDescripcion());
            vehiculoUpdate.setModelo(vehiculo.getModelo());
            vehiculoUpdate.setUbicacion(vehiculo.getUbicacion());
            vehiculoUpdate.setAno(vehiculo.getAno());
            vehiculoUpdate.setCondicion(vehiculo.getCondicion());
            vehiculoUpdate.setTransmision(vehiculo.getTransmision());
            vehiculoUpdate.setTipo(vehiculo.getTipo());
            vehiculoUpdate.setCombustible(vehiculo.getCombustible());
            vehiculoUpdate.setUltimoDigitoPlaca(vehiculo.getUltimoDigitoPlaca());
            vehiculoUpdate.setPrecio(vehiculo.getPrecio());
            vehiculoUpdate.setKilometraje(vehiculo.getKilometraje());
            vehiculoUpdate.setVendedor(vehiculo.getVendedor());
            vehiculoUpdate.setAdministradorRegistro(vehiculo.getAdministradorRegistro());
            repository.save(vehiculoUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }

    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Optional<Vehiculo> findById(int id) {
        return repository.findById(id);
    }

    public List<Vehiculo> findAll() {
        return repository.findAll();
    }
}
