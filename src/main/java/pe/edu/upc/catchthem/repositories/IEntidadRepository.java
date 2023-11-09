package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.Entidad;

import java.util.List;

@Repository
public interface IEntidadRepository extends JpaRepository<Entidad,Integer> {
    void deleteByIdEntidad(Integer id);

    @Query(value = "select e.nombre, count(s.id_sospechoso) from entidad e join sospechoso s on e.id_entidad = s.id_entidad group by e.nombre" ,nativeQuery = true)
    public List<String[]> SospechososPorEntidad();

    @Query(value = "SELECT e.nombre, \n" +
            "       AVG(EXTRACT(YEAR FROM age(CURRENT_DATE, s.fecha_nacimiento))) AS edad_promedio,\n" +
            "\t   COUNT(*) AS cantidad_sospechosos\n" +
            "FROM entidad e\n" +
            "JOIN sospechoso s ON e.id_entidad = s.id_entidad\n" +
            "GROUP BY e.nombre;" ,nativeQuery = true)
    public List<String[]> ListarNacimientoSospechososPorEntidad();

    @Query(value = "select e.nombre, te.sector, count(c.id_camara)  from entidad e " +
            " join camara c on e.id_entidad = c.id_entidad" +
            " join tipo_entidad te on e.Id_tipo = te.Id_tipo" +
            " group by e.nombre, te.sector" ,nativeQuery = true)
    public List<String[]> cantidadCamarasporEntidad();
}
