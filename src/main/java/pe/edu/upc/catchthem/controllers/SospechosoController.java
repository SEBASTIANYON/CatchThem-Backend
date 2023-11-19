package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.*;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;
import pe.edu.upc.catchthem.serviceInterfaces.ISospechosoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sospechoso")
public class SospechosoController {

    @Autowired
    private ISospechosoService iSospechosoService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA')or hasAuthority('AGENTE')")
    public void registrar(@RequestBody SospechosoDTO sospechosoDTO){
        ModelMapper m= new ModelMapper();
        Sospechoso ap = m.map(sospechosoDTO, Sospechoso.class);
        iSospechosoService.insert(ap);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA')or hasAuthority('AGENTE')")
    public void modificar(@RequestBody SospechosoDTO sospechosoDTO){
        ModelMapper m= new ModelMapper();
        Sospechoso ap = m.map(sospechosoDTO, Sospechoso.class);
        iSospechosoService.insert(ap);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void  delete(@PathVariable("id") Integer id){
        iSospechosoService.delete(id);
    }

    @GetMapping("/{id}")
    public SospechosoDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        SospechosoDTO dto = m.map(iSospechosoService.listarId(id),SospechosoDTO.class);
        return dto;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA')or hasAuthority('AGENTE')")
    public List<SospechosoDTO> listar(){
        return iSospechosoService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,SospechosoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/buscarfecha")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA') or hasAuthority('AGENTE')")
    public List<SospechosoDTO> buscarfecha(@RequestParam String fecha){
        LocalDate localDate = LocalDate.parse(fecha);
        return iSospechosoService.findSospechosoByFecharegistro(localDate).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,SospechosoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/id")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA') or hasAuthority('AGENTE')")
    public SospechosoDTO buscarporid(@RequestParam("id") Integer id){
        ModelMapper m = new ModelMapper();
        SospechosoDTO s = m.map(iSospechosoService.findSospechosoByIdSospechoso(id),SospechosoDTO.class);
        return s;
    }

    @PostMapping("/buscarEntidad")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<SospechosoDTO> buscarporentidad(@RequestBody Entidad entidad){
        return iSospechosoService.findAllByEntidad(entidad).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,SospechosoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/cantidadantecedentesporsospechoso")
    public List<AntecedentesporSospechosoDTO> cantidadantecedentesporsospechoso(){
        List<String[]> lista = iSospechosoService.AntecedentesporSospechoso();
        List<AntecedentesporSospechosoDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            AntecedentesporSospechosoDTO dto =  new AntecedentesporSospechosoDTO();
            dto.setNameSospechoso(data[0]);
            dto.setCantidadAntecedentes(Integer.parseInt(data[1]));
            listadto.add(dto);
        }
        return listadto;
    }

    @GetMapping("/cantidadsospechososnacionalidad")
    public List<SospechosoPorNacionalidadDTO> sospechosoPorNacionalidad(){
        List<String[]> lista = iSospechosoService.sospechososPorNacionalidad();
        List<SospechosoPorNacionalidadDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            SospechosoPorNacionalidadDTO dto =  new SospechosoPorNacionalidadDTO();
            dto.setNacionalidad(data[0]);
            dto.setPromedio(Integer.parseInt(data[1]));
            listadto.add(dto);
        }
        return listadto;
    }

}
