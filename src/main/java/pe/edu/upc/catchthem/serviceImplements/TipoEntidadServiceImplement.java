package pe.edu.upc.catchthem.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.TipoEntidad;
import pe.edu.upc.catchthem.entities.Users;
import pe.edu.upc.catchthem.repositories.ITipoEntidadRepository;
import pe.edu.upc.catchthem.serviceInterfaces.ITipoEntidadService;

import java.util.List;

@Service
public class TipoEntidadServiceImplement implements ITipoEntidadService {
    @Autowired
    private ITipoEntidadRepository iTipoEntidadRepository;

    @Override
    public void insert(TipoEntidad tipo) {
        iTipoEntidadRepository.save(tipo);
    }

    @Override
    public void delete(int id) {
        iTipoEntidadRepository.deleteById(id);
    }

    @Override
    public List<TipoEntidad> list() {
        return iTipoEntidadRepository.findAll();
    }



    @Override
    public TipoEntidad listarId(int id){
        return iTipoEntidadRepository.findById(id).orElse(null);
    }


}
