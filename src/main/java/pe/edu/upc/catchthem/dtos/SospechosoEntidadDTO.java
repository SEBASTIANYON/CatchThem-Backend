package pe.edu.upc.catchthem.dtos;

public class SospechosoEntidadDTO {

    private String namesEntidad;

    private int cantidadSospechosos;

    private Double edadPromedio;



    public String getNamesEntidad() {
        return namesEntidad;
    }

    public void setNamesEntidad(String namesEntidad) {
        this.namesEntidad = namesEntidad;
    }

    public int getCantidadSospechosos() {
        return cantidadSospechosos;
    }

    public void setCantidadSospechosos(int cantidadSospechosos) {
        this.cantidadSospechosos = cantidadSospechosos;
    }

    public Double getEdadPromedio() {
        return edadPromedio;
    }

    public void setEdadPromedio(Double edadPromedio) {
        this.edadPromedio = edadPromedio;
    }
}
