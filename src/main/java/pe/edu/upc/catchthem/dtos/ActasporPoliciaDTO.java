package pe.edu.upc.catchthem.dtos;

public class ActasporPoliciaDTO {

    private String namePolicia;

    private int CantidadActas;

    public String getNamePolicia() {
        return namePolicia;
    }

    public void setNamePolicia(String namePolicia) {
        this.namePolicia = namePolicia;
    }

    public int getCantidadActas() {
        return CantidadActas;
    }

    public void setCantidadActas(int cantidadActas) {
        CantidadActas = cantidadActas;
    }
}
