package pe.edu.upc.catchthem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="AntecedentePenal")
public class AntecedentePenal{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_antecedente;
    @Column(name = "delito",length = 40,nullable = false)
    private String delito;
    @Column(name = "fecha_comision", nullable = false)
    private LocalDate fecha_comision;
    @Column(name = "fecha_condena",nullable = false)
    private LocalDate fecha_condena;
    @Column(name = "sentencia",length = 40,nullable = false)
    private String sentencia;
    @Column(name = "ubicacion",length = 40,nullable = false)
    private String ubicacion;
    @Column(name = "estado",length = 40,nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_sospechoso")
    @JsonIgnore
    private Sospechoso sospechoso;

    public AntecedentePenal(int id_antecedente, String delito, LocalDate fecha_comision, LocalDate fecha_condena, String sentencia, String ubicacion, String estado, Sospechoso sospechoso) {
        this.id_antecedente = id_antecedente;
        this.delito = delito;
        this.fecha_comision = fecha_comision;
        this.fecha_condena = fecha_condena;
        this.sentencia = sentencia;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.sospechoso = sospechoso;
    }

    public AntecedentePenal() {
    }

    public Sospechoso getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Sospechoso sospechoso) {
        this.sospechoso = sospechoso;
    }

    public int getId_antecedente() {
        return id_antecedente;
    }

    public void setId_antecedente(int id_antecedente) {
        this.id_antecedente = id_antecedente;
    }

    public String getDelito() {
        return delito;
    }

    public void setDelito(String delito) {
        this.delito = delito;
    }

    public LocalDate getFecha_comision() {
        return fecha_comision;
    }

    public void setFecha_comision(LocalDate fecha_comision) {
        this.fecha_comision = fecha_comision;
    }

    public LocalDate getFecha_condena() {
        return fecha_condena;
    }

    public void setFecha_condena(LocalDate fecha_condena) {
        this.fecha_condena = fecha_condena;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
