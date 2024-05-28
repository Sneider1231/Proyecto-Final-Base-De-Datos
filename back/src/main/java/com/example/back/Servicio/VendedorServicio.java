package com.example.back.Servicio;

import com.example.back.Modelo.Vendedor;
import com.example.back.Repositorio.VendedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServicio {

    @Autowired
    private VendedorRepositorio repository;


    public Vendedor save(Vendedor Vendedor) {
        return repository.save(Vendedor);
    }

    public void update(Vendedor vendedor, int id) {
        Optional<Vendedor> optional = repository.findById(id);

        if (optional.isPresent()) {
            Vendedor vendedorUpdate = optional.get();
            vendedorUpdate.setNombre(vendedor.getNombre());
            vendedorUpdate.setUsuario(vendedor.getUsuario());
            vendedorUpdate.setContrasena(vendedor.getContrasena());
            vendedorUpdate.setTelefono(vendedor.getTelefono());
            vendedorUpdate.setIdentificacion(vendedor.getIdentificacion());
            repository.save(vendedorUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }

    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Optional<Vendedor> findById(int id) {
        return repository.findById(id);
    }

    public List<Vendedor> findAll() {
        return repository.findAll();
    }
}
