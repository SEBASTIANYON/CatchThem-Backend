package pe.edu.upc.catchthem.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;
import pe.edu.upc.catchthem.repositories.ISospechosoRepository;
import pe.edu.upc.catchthem.serviceInterfaces.ISospechosoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SospechosoServiceImplement implements ISospechosoService {
    @Autowired
    private ISospechosoRepository iSospechosoRepository;
    @Override
    public void insert(Sospechoso sospechoso) {
        iSospechosoRepository.save(sospechoso);
    }
    @Override
    public void delete(int idSospechoso) {
        iSospechosoRepository.deleteById(idSospechoso);
    }

    @Override
    public Sospechoso listarId(int idSospechoso) {
        return iSospechosoRepository.findById(idSospechoso).orElse(null);
    }

    @Override
    public List<Sospechoso> list() {
        return iSospechosoRepository.findAll();
    }



    @Override
    public List<Sospechoso> findSospechosoByFecharegistro(LocalDate fecha){
        return iSospechosoRepository.findSospechosoByFecharegistro(fecha);
    }

    @Override
    public Sospechoso findSospechosoByIdSospechoso(Integer id){
        return iSospechosoRepository.findSospechosoByIdSospechoso(id);
    }

    @Override
    public List<Sospechoso> findAllByEntidad(Entidad entidad){
        return iSospechosoRepository.findAllByEntidad(entidad);
    }

    @Override
    public List<String[]> AntecedentesporSospechoso() {
        return iSospechosoRepository.AntecedentesporSospechoso();
    }

    @Override
    public List<String[]> sospechososPorNacionalidad() {
        return iSospechosoRepository.sospechosoPorNacionalidad();
    }
}
