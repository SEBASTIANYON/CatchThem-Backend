package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.catchthem.entities.Users;
import pe.edu.upc.catchthem.entities.Entidad;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    public Users findByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);

    @Query(value = "select u.nombre, count(i) from users u inner join actas_interrogatorio i \n" +
            "on i.id_usuario = u.id group by u.nombre" , nativeQuery = true)
    public List<String[]> ActasporPolicia();

    @Query("SELECT u.nombre, u.correo, u.telefono FROM Users u INNER JOIN u.entidad e WHERE e.nombre = :entidad")
    public List<String[]> findAllByEntidad(@Param("entidad") String entidad);

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    Users findUsersByCorreo(String email);
}