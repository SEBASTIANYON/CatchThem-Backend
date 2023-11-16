package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "select r.id, r.rol, r.user_id from roles r where r.user_id = :idusuario", nativeQuery = true)
    public List<String[]> Buscarporidusuario(@Param("idusuario") long idusuario);
}
