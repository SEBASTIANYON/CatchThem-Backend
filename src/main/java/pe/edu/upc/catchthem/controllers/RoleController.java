package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.RoleDTO;
import pe.edu.upc.catchthem.entities.Role;
import pe.edu.upc.catchthem.entities.Users;
import pe.edu.upc.catchthem.serviceInterfaces.IRoleService;
import pe.edu.upc.catchthem.serviceInterfaces.IUsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService rS;
    @Autowired
    private IUsersService sS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RoleDTO> listar(){
        return rS.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RoleDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA')or hasAuthority('AGENTE')")
    public void registrar(@RequestBody RoleDTO dto){
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto,Role.class);
        rS.insert(r);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Long id){
        rS.eliminar(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RoleDTO> listarId(@PathVariable("id") long id) {
        List<String[]> lista = rS.Buscarporidusuario(id);
        List<RoleDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            RoleDTO dto =  new RoleDTO();
            dto.setId(Long.parseLong(data[0]));
            dto.setRol(data[1]);
            dto.setUser(usuario(id));

            listadto.add(dto);
        }
        return listadto;
    }

    private Users usuario(long id){
        Users user = sS.listarId(id);
        return user;
    }
}
