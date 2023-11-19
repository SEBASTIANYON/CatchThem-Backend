package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.*;

import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.serviceInterfaces.IEntidadService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/entidad")
public class EntidadController {
    @Autowired
    private IEntidadService iEntidadService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody EntidadDTO entidadDTO){
        ModelMapper m= new ModelMapper();
        Entidad entidad = m.map(entidadDTO, Entidad.class);
        iEntidadService.insert(entidad);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody EntidadDTO entidadDTO){
        ModelMapper m= new ModelMapper();
        Entidad entidad = m.map(entidadDTO, Entidad.class);
        iEntidadService.insert(entidad);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        iEntidadService.delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<EntidadDTO> listar(){
        return iEntidadService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,EntidadDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntidadDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        EntidadDTO dto = m.map(iEntidadService.listarId(id),EntidadDTO.class);
        return dto;
    }

    @GetMapping("/cantidadsospechosos")
    public List<cantidadsospechososDTO> cantidaddesospechososporentidad(){
        List<String[]> lista = iEntidadService.SospechososPorEntidad();
        List<cantidadsospechososDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            cantidadsospechososDTO dto =  new cantidadsospechososDTO();
            dto.setNamesEntidad(data[0]);
            dto.setCantidadSospechosos(Integer.parseInt(data[1]));

            listadto.add(dto);
        }
        return listadto;
    }

    @GetMapping("/edadpromedio")
    public List<SospechosoEntidadDTO> edadpromedioporentidad(){

        List<String[]> lista = iEntidadService.ListarNacimientoSospechososPorEntidad();

        List<SospechosoEntidadDTO>listadto =new ArrayList<>();
        int edad = 0;

        for(String[] data:lista){
            SospechosoEntidadDTO dto =  new SospechosoEntidadDTO();
            dto.setNamesEntidad(data[0]);
            //dto.setCantidadSospechosos(Integer.parseInt(data[1]));
            dto.setEdadPromedio(Double.parseDouble(data[1]));
            dto.setCantidadSospechosos(Integer.parseInt(data[2]));

            listadto.add(dto);
        }
        return listadto;
    }

    @GetMapping("/cantidadcamaras")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<EntidadCamarasDTO> cantidadcamaras(){
        List<String[]> lista = iEntidadService.cantidadCamarasporEntidad();
        List<EntidadCamarasDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            EntidadCamarasDTO dto =  new EntidadCamarasDTO();
            dto.setNombreEntidad(data[0]);
            dto.setSector(data[1]);
            dto.setCantidadCamaras(Integer.parseInt(data[2]));

            listadto.add(dto);
        }
        return listadto;
    }



    /*
    public int promedioedad(List<String[]> list){

        //List<String[]> lista = iEntidadService.SospechososPorEntidad();
        int edad=0;
        int edadprom=0;
        for(String[] data:list){

            LocalDate date = LocalDate.now();
            LocalDate nacimiento = LocalDate.parse(data[1]);
            edad = edad +  (date.getYear() - nacimiento.getYear());
            edadprom = edad/ list.size();

        }

        return edadprom;

    }
    */


}
