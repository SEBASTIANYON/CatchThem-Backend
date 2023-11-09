package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.ActaInterrogatorioDTO;
import pe.edu.upc.catchthem.entities.ActasInterrogatorio;
import pe.edu.upc.catchthem.serviceInterfaces.IActaInterrogatorioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actas")
public class ActaInterrogatorioController {

    @Autowired
    //aS <->actaInterrogatorioService
    private IActaInterrogatorioService aS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA')")
    public void ingresar(@RequestBody ActaInterrogatorioDTO actaInterrogatorioDTO){
        ModelMapper m = new ModelMapper();
        ActasInterrogatorio actasInterrogatorio=m.map(actaInterrogatorioDTO, ActasInterrogatorio.class);
        aS.insertar(actasInterrogatorio);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody ActaInterrogatorioDTO actaInterrogatorioDTO){
        ModelMapper m = new ModelMapper();
        ActasInterrogatorio actasInterrogatorio=m.map(actaInterrogatorioDTO, ActasInterrogatorio.class);
        aS.insertar(actasInterrogatorio);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA') or hasAuthority('AGENTE')")
    public List<ActaInterrogatorioDTO> listar(){
        return aS.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ActaInterrogatorioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ActaInterrogatorioDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        ActaInterrogatorioDTO dto = m.map(aS.listarId(id),ActaInterrogatorioDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        aS.eliminar(id);
    }
}