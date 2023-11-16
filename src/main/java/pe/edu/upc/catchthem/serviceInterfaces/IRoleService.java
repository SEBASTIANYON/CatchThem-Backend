package pe.edu.upc.catchthem.serviceInterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.catchthem.entities.Role;
import pe.edu.upc.catchthem.entities.Users;

import java.util.List;

public interface IRoleService {
    public List<Role> listar();

    public void insert(Role role);
    public void eliminar(long id);

    public List<String[]> Buscarporidusuario(@Param("idusuario") long idusuario);
}
