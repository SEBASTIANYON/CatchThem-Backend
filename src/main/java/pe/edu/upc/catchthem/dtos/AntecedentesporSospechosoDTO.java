package pe.edu.upc.catchthem.dtos;

public class AntecedentesporSospechosoDTO {

    private String nameSospechoso;

    private int cantidadAntecedentes;

    public String getNameSospechoso() {
        return nameSospechoso;
    }

    public void setNameSospechoso(String nameSospechoso) {
        this.nameSospechoso = nameSospechoso;
    }

    public int getCantidadAntecedentes() {
        return cantidadAntecedentes;
    }

    public void setCantidadAntecedentes(int cantidadAntecedentes) {
        this.cantidadAntecedentes = cantidadAntecedentes;
    }
}
