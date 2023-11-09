package pe.edu.upc.catchthem.serviceInterfaces;

import pe.edu.upc.catchthem.entities.Camara;

import java.util.List;

public interface ICamaraService {
    public void insertar(Camara camara);
    public List<Camara> listar();
    public void eliminar(int id_camara);
}
