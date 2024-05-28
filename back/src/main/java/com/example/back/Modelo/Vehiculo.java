package com.example.back.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    private String nombre;
    private String marca;
    private String descripcion;
    private String modelo;
    private String ubicacion;
    private int ano;
    private String condicion;
    private String transmision;
    private String tipo;
    private String combustible;
    private int ultimoDigitoPlaca;
    private int precio;
    private int kilometraje;
    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;
    @ManyToOne
    @JoinColumn(name = "id_administrador")
    private Administrador administradorRegistro;
}
