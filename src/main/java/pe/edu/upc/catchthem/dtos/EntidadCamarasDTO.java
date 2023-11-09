package pe.edu.upc.catchthem.dtos;

public class EntidadCamarasDTO {
private String nombreEntidad;
private String sector;
private int cantidadCamaras;

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getCantidadCamaras() {
        return cantidadCamaras;
    }

    public void setCantidadCamaras(int cantidadCamaras) {
        this.cantidadCamaras = cantidadCamaras;
    }
}
