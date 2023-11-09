package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.RoleDTO;
import pe.edu.upc.catchthem.entities.Role;
import pe.edu.upc.catchthem.serviceInterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService rS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RoleDTO> listar(){
        return rS.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Long id){
        rS.eliminar(id);
    }
}
