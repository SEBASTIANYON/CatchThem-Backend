package pe.edu.upc.catchthem.serviceInterfaces;

import pe.edu.upc.catchthem.entities.Alerta;

import java.util.List;

public interface IAlertaService {

    public void ingresar(Alerta alerta);
    public List<Alerta> listar();
    public void eliminar(int idAlerta);
    public List<String[]> CantidadAlertasPorUbicacion();
    public List<String[]> PromedioMensualEntidad();

    public Alerta listarId(int idAlerta);
}
