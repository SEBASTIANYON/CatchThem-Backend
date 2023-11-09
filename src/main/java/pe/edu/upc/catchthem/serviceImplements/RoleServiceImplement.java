package pe.edu.upc.catchthem.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.Role;
import pe.edu.upc.catchthem.repositories.RoleRepository;
import pe.edu.upc.catchthem.serviceInterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService{
    @Autowired
    //rR<->roleRepository
    private RoleRepository rR;

    @Override
    public List<Role> listar() {
        return rR.findAll();
    }

    @Override
    public void eliminar(long id) {
        rR.deleteById(id);
    }
}
