package pe.edu.upc.catchthem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Sospechoso")
public class Sospechoso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSospechoso;
    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;
    @Column(name = "alias", length = 20, nullable = true)
    private String alias;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate nacimiento;
    @Column(name = "genero", length = 10, nullable = false)
    private String genero;
    @Column(name = "nacionalidad", length = 20, nullable = false)
    private String nacionalidad;
    @Column(name = "descripcion", length = 60, nullable = false)
    private String descripcion;
    @Column(name = "historial", length = 50, nullable = false)
    private String historial;
    @Column(name = "estado", length = 15, nullable = false)
    private String estado;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fecharegistro;

    @Column(name = "imagen", length = 255, nullable = true)
    private String imagen;
    @ManyToOne
    @JoinColumn(name = "id_entidad")
    @JsonIgnore
    private Entidad entidad;

    public Sospechoso() {

    }

    public Sospechoso(int idSospechoso, String nombre, String alias, LocalDate nacimiento, String genero, String nacionalidad, String descripcion, String historial, String estado, LocalDate fecharegistro, String imagen, Entidad entidad) {
        this.idSospechoso = idSospechoso;
        this.nombre = nombre;
        this.alias = alias;
        this.nacimiento = nacimiento;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.descripcion = descripcion;
        this.historial = historial;
        this.estado = estado;
        this.fecharegistro = fecharegistro;
        this.imagen = imagen;
        this.entidad = entidad;
    }

    public int getIdSospechoso() {
        return idSospechoso;
    }

    public void setIdSospechoso(int idSospechoso) {
        this.idSospechoso = idSospechoso;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(LocalDate fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}
