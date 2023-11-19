package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.TipoEntidadDTO;
import pe.edu.upc.catchthem.entities.TipoEntidad;
import pe.edu.upc.catchthem.serviceInterfaces.ITipoEntidadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipoentidad")
public class TipoEntidadController {
    @Autowired
    private ITipoEntidadService iTipoEntidadService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody TipoEntidadDTO tipoEntidad){
        ModelMapper m = new ModelMapper();
        TipoEntidad t = m.map(tipoEntidad,TipoEntidad.class);
        iTipoEntidadService.insert(t);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody TipoEntidadDTO tipoEntidad){
        ModelMapper m= new ModelMapper();
        TipoEntidad t = m.map(tipoEntidad, TipoEntidad.class);
        iTipoEntidadService.insert(t);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void  delete(@PathVariable("id") Integer id){
        iTipoEntidadService.delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<TipoEntidadDTO> listar(){
        return iTipoEntidadService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,TipoEntidadDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public TipoEntidadDTO buscarporid(@PathVariable("id")  Integer id){
        ModelMapper m = new ModelMapper();
        TipoEntidadDTO s = m.map(iTipoEntidadService.listarId(id),TipoEntidadDTO.class);
        return s;
    }
}
