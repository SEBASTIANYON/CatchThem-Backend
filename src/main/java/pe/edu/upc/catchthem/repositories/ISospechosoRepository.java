package pe.edu.upc.catchthem.repositories;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ISospechosoRepository extends JpaRepository<Sospechoso,Integer> {

    List<Sospechoso> findSospechosoByFecharegistro(LocalDate fecha);

    Sospechoso findSospechosoByIdSospechoso(Integer id);

    @Query("select s from Sospechoso s where s.entidad = :entidad")
    List<Sospechoso> findAllByEntidad(@Param("entidad") Entidad entidad);


    @Query(value = "SELECT P.nombre , count(a.id_antecedente)\n" +
            "FROM sospechoso p inner join antecedente_penal a on p.id_sospechoso = a.id_sospechoso \n" +
            "group by p.nombre" ,nativeQuery = true)
    public List<String[]> AntecedentesporSospechoso();

    @Query("SELECT s.nacionalidad, COUNT(s) FROM Sospechoso s GROUP BY s.nacionalidad")
    public List<String[]> sospechosoPorNacionalidad();
}
