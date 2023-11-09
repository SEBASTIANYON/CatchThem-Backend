package pe.edu.upc.catchthem.dtos;

import javax.persistence.Column;

public class TipoEntidadDTO {
    private int idTipo;
    private String sector;

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
