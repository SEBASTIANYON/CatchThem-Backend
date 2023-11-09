package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.AntecedentePenal;
import pe.edu.upc.catchthem.entities.Camara;

import java.util.List;
@Repository
public interface ICamaraRepository extends JpaRepository<Camara,Integer> {

}
