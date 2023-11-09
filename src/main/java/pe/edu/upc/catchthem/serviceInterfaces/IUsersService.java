package pe.edu.upc.catchthem.serviceInterfaces;

import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Users;

import java.util.List;

public interface IUsersService {
    public void insert(Users users);
    public void eliminar(Long id);
    public List<Users> listar();

    public List<String[]> ActasporPolicia();

    public void insRol(String authority, Long user_id);

    public List<String[]> findAllByEntidad(String entidad);

    Users findUsersByCorreo(String email);

    public Users listarId(Long id);



}