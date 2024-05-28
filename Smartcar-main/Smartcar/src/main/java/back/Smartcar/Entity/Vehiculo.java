package back.Smartcar.Entity;

import jakarta.persistence.*;
import java.io.File;
import java.math.BigDecimal;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "marca", length = 100, nullable = false)
    private String marca;

    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;

    @Column(name = "modelo", length = 100, nullable = false)
    private String modelo;

    @Column(name = "ubicacion", length = 100)
    private String ubicacion;

    @Column(name = "anio", precision = 10, scale = 1, nullable = false)
    private Integer anio;

    @Column(name = "condicion", length = 100)
    private String condicion;

    @Column(name = "transmision", length = 100)
    private String transmision;

    @Column(name = "tipo", length = 100, nullable = false)
    private String tipo;

    @Column(name = "combustible", length = 100)
    private String combustible;

    @Column(name = "ultimo_digito", precision = 1, scale = 1)
    private Integer ultimoDigito;

    @Column(name = "precio",precision = 10, scale = 1, nullable = false)
    private BigDecimal precio;

    @Column(name = "kilometraje", precision = 10, scale = 1)
    private BigDecimal kilometraje;

    @Column(name = "imagen")
    private String imagen;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "administrador_registro_id")
    private Administrador administradorRegistroID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Integer getUltimoDigito() {
        return ultimoDigito;
    }

    public void setUltimoDigito(Integer ultimoDigito) {
        this.ultimoDigito = ultimoDigito;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(BigDecimal kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Administrador getAdministradorRegistroID() {
        return administradorRegistroID;
    }

    public void setAdministradorRegistroID(Administrador administradorRegistroID) {
        this.administradorRegistroID = administradorRegistroID;
    }
}
