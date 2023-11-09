package pe.edu.upc.catchthem.dtos;

import pe.edu.upc.catchthem.entities.Sospechoso;

import java.time.LocalDate;

public class AntecedentePenalDTO {

    private int id_antecedente;
    private String delito;
    private LocalDate fecha_comision;
    private LocalDate fecha_condena;
    private String sentencia;
    private String ubicacion;
    private String estado;
    private Sospechoso sospechoso;

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

    public Sospechoso getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Sospechoso sospechoso) {
        this.sospechoso = sospechoso;
    }
}
