package pe.edu.upc.catchthem.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.Camara;
import pe.edu.upc.catchthem.serviceInterfaces.ICamaraService;
import pe.edu.upc.catchthem.repositories.ICamaraRepository;

import java.util.List;

@Service
public class CamaraServiceImplement implements ICamaraService {

    @Autowired
    private ICamaraRepository cR;

    @Override
    public void insertar(Camara camara) {
        cR.save(camara);
    }

    @Override
    public List<Camara> listar() {
        return cR.findAll();
    }

    @Override
    public void eliminar(int id_camara) {
        cR.deleteById(id_camara);
    }
}
