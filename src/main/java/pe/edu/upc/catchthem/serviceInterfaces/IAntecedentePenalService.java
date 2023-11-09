package pe.edu.upc.catchthem.serviceInterfaces;

import pe.edu.upc.catchthem.entities.AntecedentePenal;

import java.util.List;

public interface IAntecedentePenalService {

    public void insertar(AntecedentePenal antecedentePenal);
    public List<AntecedentePenal> listar();
    public void eliminar(int idAntecedente);

    List<String[]> antecedentesPorDelito();

}