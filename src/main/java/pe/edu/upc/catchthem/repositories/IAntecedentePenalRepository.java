package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.AntecedentePenal;

import java.util.List;

@Repository
public interface IAntecedentePenalRepository extends JpaRepository<AntecedentePenal,Integer> {

    List<AntecedentePenal> findAntecedentePenalBySospechoso(Integer id_sospechoso);

    @Query(value = "select delito as Delito, count(delito) as cantidad_delitos\n" +
            "from antecedente_penal\n" +
            "group by delito", nativeQuery = true)
    List<String[]> antecedentesPorDelito();
}