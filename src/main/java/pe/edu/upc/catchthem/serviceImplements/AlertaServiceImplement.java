package pe.edu.upc.catchthem.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.Alerta;
import pe.edu.upc.catchthem.repositories.IAlertaRepository;
import pe.edu.upc.catchthem.serviceInterfaces.IAlertaService;

import java.util.List;

@Service
public class AlertaServiceImplement implements IAlertaService {

    @Autowired
    //aR<-> alertaRepository
    IAlertaRepository aR;
    @Override
    public void ingresar(Alerta alerta) {
        aR.save(alerta);
    }

    @Override
    public List<Alerta> listar() {
        return aR.findAll();
    }

    @Override
    public void eliminar(int idAlerta) {
        aR.deleteById(idAlerta);
    }

    @Override
    public List<String[]> CantidadAlertasPorUbicacion() {
        return aR.CantidadAlertasPorUbicacion();
    }

    @Override
    public List<String[]> PromedioMensualEntidad() {
        return aR.PromedioMensualEntidad();
    }

    @Override
    public Alerta listarId(int idAlerta) {
        return aR.findById(idAlerta).orElse(null);
    }
}
