package pe.edu.upc.catchthem.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.ActasInterrogatorio;
import pe.edu.upc.catchthem.repositories.IActaInterrogatorioRepository;
import pe.edu.upc.catchthem.repositories.IAntecedentePenalRepository;
import pe.edu.upc.catchthem.serviceInterfaces.IActaInterrogatorioService;

import java.util.List;

@Service
public class ActaInterrogatorioServiceImplement implements IActaInterrogatorioService {

    @Autowired
    //aR<->actaInterrogatorioRepository
    private IActaInterrogatorioRepository aR;

    @Override
    public void insertar(ActasInterrogatorio actasInterrogatorio) {
        aR.save(actasInterrogatorio);
    }

    @Override
    public List<ActasInterrogatorio> listar() {
        return aR.findAll();
    }

    @Override
    public void eliminar(int idActa) {
        aR.deleteById(idActa);
    }

    @Override
    public ActasInterrogatorio listarId(int idActa) {
        return aR.findById(idActa).orElse(null);
    }
}
