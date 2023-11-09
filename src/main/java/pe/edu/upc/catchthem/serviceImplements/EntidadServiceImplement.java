package pe.edu.upc.catchthem.serviceImplements;

import org.apache.tomcat.util.net.NioEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.repositories.IEntidadRepository;
import pe.edu.upc.catchthem.serviceInterfaces.IEntidadService;

import java.util.List;

@Service
public class EntidadServiceImplement implements IEntidadService {
    @Autowired
    private IEntidadRepository iEntidadRepository;
    @Override
    public void insert(Entidad entidad) {
        iEntidadRepository.save(entidad);
    }

    @Override
    public void delete(int id) {
        iEntidadRepository.deleteById(id);
    }

    @Override
    public List<Entidad> list() {
        return iEntidadRepository.findAll();
    }

    @Override
    public List<String[]> SospechososPorEntidad() {
        return iEntidadRepository.SospechososPorEntidad();
    }

    @Override
    public List<String[]> ListarNacimientoSospechososPorEntidad() {
        return iEntidadRepository.ListarNacimientoSospechososPorEntidad();
    }

    @Override
    public List<String[]> cantidadCamarasporEntidad() {
        return iEntidadRepository.cantidadCamarasporEntidad();
    }

    @Override
    public Entidad listarId(int id) {
        return iEntidadRepository.findById(id).orElse(null);
    }
}
