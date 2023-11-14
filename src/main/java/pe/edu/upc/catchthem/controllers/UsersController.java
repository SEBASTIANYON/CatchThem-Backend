package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.*;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Users;
import pe.edu.upc.catchthem.serviceInterfaces.IUsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService uS;

    @PostMapping
    public void registrar(@RequestBody UsersDTO dto){
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto,Users.class);
        uS.insert(u);
    }
    @GetMapping
    public List<UsersDTO> listar(){
        return uS.listar().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        uS.eliminar(id);
    }

    @PostMapping("/insertarrol")
    public void insertarRol(@RequestParam("authority") String authority,@RequestParam("user_id") Long user_id){
        uS.insRol(authority,user_id);
    }

    @GetMapping("/cantidadActasPorPolicia")
    public List<ActasporPoliciaDTO> cantidadActasPorPolicia(){
        List<String[]> lista = uS.ActasporPolicia();
        List<ActasporPoliciaDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            ActasporPoliciaDTO dto =  new ActasporPoliciaDTO();
            dto.setNamePolicia(data[0]);
            dto.setCantidadActas(Integer.parseInt(data[1]));
            listadto.add(dto);
        }
        return listadto;
    }

    @GetMapping("/usuariosPorEntidad")
    public List<ListarUsuariosDTO> UsuariosPorEntidad(@RequestBody Entidad entidad){
        List<String[]> lista = uS.findAllByEntidad(entidad.getNombre());
        List<ListarUsuariosDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            ListarUsuariosDTO dto =  new ListarUsuariosDTO();
            dto.setNombre(data[0]);
            dto.setCorreo(data[1]);
            dto.setTelefono(data[2]);
            listadto.add(dto);
        }
        return listadto;
    }

    @GetMapping("/BusquedaporCorreo")
    public UsersDTO buscarporcorreo(@RequestParam("email") String email){
        ModelMapper m = new ModelMapper();
        UsersDTO s = m.map(uS.findUsersByCorreo(email),UsersDTO.class);
        return s;
    }
}
