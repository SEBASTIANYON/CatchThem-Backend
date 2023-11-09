package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.Alerta;

import java.util.List;

@Repository
public interface IAlertaRepository extends JpaRepository<Alerta,Integer> {

  //Buscar por ubicacion
    @Query(value = "SELECT a.ubicacion, COUNT(a) FROM Alerta a GROUP BY a.ubicacion")
    public List<String[]> CantidadAlertasPorUbicacion();

     @Query(value = "SELECT e.nombre, COUNT(EXTRACT(MONTH FROM a.fecha)) " +
            "FROM Alerta a " +
            "INNER JOIN Users u ON u.id = a.id_usuario " +
            "INNER JOIN Entidad e ON u.id_entidad = e.idEntidad " +
            "GROUP BY e.nombre", nativeQuery = true)
    public List<String[]> PromedioMensualEntidad();
}
