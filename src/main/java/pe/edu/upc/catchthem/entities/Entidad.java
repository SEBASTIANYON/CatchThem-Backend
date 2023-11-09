package pe.edu.upc.catchthem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Entidad")
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntidad;
    @Column(name = "nombre",length = 30,nullable = false)
    private String nombre;
    @Column(name = "direccion",length = 30,nullable = false)
    private String direccion;
    @Column(name = "telefono",length = 9,nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    @JsonIgnore
    private TipoEntidad tipoEntidad;

    public Entidad() {
    }

    public Entidad(int idEntidad, String nombre, String direccion, String telefono, TipoEntidad tipoEntidad) {
        this.idEntidad = idEntidad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoEntidad = tipoEntidad;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoEntidad getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(TipoEntidad tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }
}
