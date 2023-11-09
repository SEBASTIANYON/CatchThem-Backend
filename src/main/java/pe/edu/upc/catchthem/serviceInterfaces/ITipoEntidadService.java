package pe.edu.upc.catchthem.serviceInterfaces;

import pe.edu.upc.catchthem.entities.TipoEntidad;

import java.util.List;

public interface ITipoEntidadService {
    void insert(TipoEntidad tipo);

    void delete(int id);

    List<TipoEntidad> list();

}
