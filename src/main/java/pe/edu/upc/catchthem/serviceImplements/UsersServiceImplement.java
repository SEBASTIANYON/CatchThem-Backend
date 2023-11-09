package pe.edu.upc.catchthem.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Users;
import pe.edu.upc.catchthem.repositories.UserRepository;
import pe.edu.upc.catchthem.serviceInterfaces.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {

    @Autowired
    private UserRepository userRepository;
    @Override

    public void eliminar(Long id){
        userRepository.deleteById(id);
    }
    public void insert(Users users){
        userRepository.save(users);
    }
    public List<Users> listar() {
        return userRepository.findAll();
    }

    @Override
    public List<String[]> ActasporPolicia() {
        return userRepository.ActasporPolicia();
    }

    @Override
    public void insRol(String authority, Long user_id) {
        userRepository.insRol(authority,user_id);
    }

    @Override
    public List<String[]> findAllByEntidad(String entidad) {
        return userRepository.findAllByEntidad(entidad);
    }

    @Override
    public Users findUsersByCorreo(String email) {
        return userRepository.findUsersByCorreo(email);
    }

    @Override
    public Users listarId(Long id){
        return userRepository.findById(id).orElse(null);
    }


}