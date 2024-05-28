package com.example.back.Repositorio;

import com.example.back.Modelo.Cita;
import com.example.back.Modelo.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepositorio extends JpaRepository<Vendedor, Integer> {
}
