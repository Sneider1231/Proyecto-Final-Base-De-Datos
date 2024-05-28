package com.example.back.Repositorio;

import com.example.back.Modelo.Administrador;
import com.example.back.Modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, Integer> {
}
