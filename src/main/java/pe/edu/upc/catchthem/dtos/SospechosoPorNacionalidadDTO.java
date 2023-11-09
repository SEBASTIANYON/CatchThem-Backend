package pe.edu.upc.catchthem.dtos;

public class SospechosoPorNacionalidadDTO {

    private String Nacionalidad;
    private int Promedio;

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public int getPromedio() {
        return Promedio;
    }

    public void setPromedio(int promedio) {
        Promedio = promedio;
    }
}
