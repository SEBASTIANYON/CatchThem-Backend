package pe.edu.upc.catchthem.serviceInterfaces;

import pe.edu.upc.catchthem.entities.Role;
import java.util.List;

public interface IRoleService {
    public List<Role> listar();
    public void ingresar(Role role);
    public void eliminar(long id);
}
