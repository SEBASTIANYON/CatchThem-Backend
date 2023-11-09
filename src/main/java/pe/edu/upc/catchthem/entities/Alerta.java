package pe.edu.upc.catchthem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "Alerta")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_alerta;
    @Column(name = "fecha",nullable = false)
    private LocalDate fecha;
    @Column(name = "tipo",length = 20,nullable = false)
    private String tipo;
    @Column(name = "descripcion",length = 20,nullable = false)
    private String descripcion;
    @Column(name = "ubicacion",length = 20,nullable = false)
    private String ubicacion;
    @Column(name = "gravedad",length = 20,nullable = false)
    private String gravedad;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Users usuario;

    public Alerta() {
    }

    public Alerta(int id_alerta, LocalDate fecha, String tipo, String descripcion, String ubicacion, String gravedad, Users usuario) {
        this.id_alerta = id_alerta;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.gravedad = gravedad;
        this.usuario = usuario;
    }

    public int getId_alerta() {
        return id_alerta;
    }

    public void setId_alerta(int id_alerta) {
        this.id_alerta = id_alerta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
