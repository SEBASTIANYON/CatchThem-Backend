package pe.edu.upc.catchthem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Camara")
public class Camara {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_camara;
    @Column(name = "ubicacion",length = 30,nullable = false)
    private String ubicacion;
    @Column(name = "tipo_camara",length = 30,nullable = false)
    private String tipo_camara;
    @Column(name = "area_vigilada",length = 40,nullable = false)
    private String area_vigilada;
    @Column(name = "estado",length = 10,nullable = false)
    private char estado;

    @ManyToOne
    @JoinColumn(name = "id_entidad")
    @JsonIgnore
    private Entidad entidad;

    public Camara() {
    }

    public Camara(int id_camara, String ubicacion, String tipo_camara, String area_vigilada, char estado, Entidad entidad) {
        this.id_camara = id_camara;
        this.ubicacion = ubicacion;
        this.tipo_camara = tipo_camara;
        this.area_vigilada = area_vigilada;
        this.estado = estado;
        this.entidad = entidad;
    }

    public int getId_camara() {
        return id_camara;
    }

    public void setId_camara(int id_camara) {
        this.id_camara = id_camara;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo_camara() {
        return tipo_camara;
    }

    public void setTipo_camara(String tipo_camara) {
        this.tipo_camara = tipo_camara;
    }

    public String getArea_vigilada() {
        return area_vigilada;
    }

    public void setArea_vigilada(String area_vigilada) {
        this.area_vigilada = area_vigilada;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}
