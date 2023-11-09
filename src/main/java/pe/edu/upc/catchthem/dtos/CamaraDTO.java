package pe.edu.upc.catchthem.dtos;

import pe.edu.upc.catchthem.entities.Entidad;

public class CamaraDTO {
    private int id_camara;
    private String ubicacion;
    private String tipo_camara;
    private String area_vigilada;
    private char estado;
    private Entidad entidad;

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
