package pe.edu.upc.catchthem.serviceInterfaces;

import pe.edu.upc.catchthem.entities.Entidad;

import java.util.List;

public interface IEntidadService {
    public void insert(Entidad entidad);
    public void delete(int id);
    public List<Entidad> list();

    public Entidad listarId(int id);

    public List<String[]> SospechososPorEntidad();

    public List<String[]> ListarNacimientoSospechososPorEntidad();
    public List<String[]> cantidadCamarasporEntidad();

}
