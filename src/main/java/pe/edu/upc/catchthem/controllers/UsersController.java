package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.*;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;
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
    @Autowired
    private PasswordEncoder bcrypt;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody UsersDTO dto){
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto,Users.class);
        u.setPassword(bcrypt.encode(u.getPassword()));
        uS.insert(u);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsersDTO> listar(){
        return uS.listar().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        uS.eliminar(id);
    }

    @PostMapping("/insertarrol")
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public UsersDTO buscarporcorreo(@RequestParam("email") String email){
        ModelMapper m = new ModelMapper();
        UsersDTO s = m.map(uS.findUsersByCorreo(email),UsersDTO.class);
        return s;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UsersDTO listarId(@PathVariable("id") long id) {
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(uS.listarId(id),UsersDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA')or hasAuthority('AGENTE')")
    public void modificar(@RequestBody UsersDTO usuariodto){
        System.out.println(usuariodto);
        ModelMapper m= new ModelMapper();
        Users actualUser = uS.listarId(usuariodto.getId());
        Users ap = m.map(usuariodto, Users.class);
        ap.setRoles(actualUser.getRoles());
        uS.insert(ap);
    }

}
