package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.ActasporPoliciaDTO;
import pe.edu.upc.catchthem.dtos.AlertaDTO;
import pe.edu.upc.catchthem.dtos.AlertaPromedioMensualEntidadDTO;
import pe.edu.upc.catchthem.dtos.AlertaporUbicacionDTO;
import pe.edu.upc.catchthem.entities.Alerta;
import pe.edu.upc.catchthem.serviceInterfaces.IAlertaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private IAlertaService alertaService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA') or hasAuthority('AGENTE')")
    public void ingresar(@RequestBody AlertaDTO alertaDTO){
        ModelMapper m=new ModelMapper();
        Alerta alerta=m.map(alertaDTO,Alerta.class);
        alertaService.ingresar(alerta);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody AlertaDTO alertaDTO){
        ModelMapper m=new ModelMapper();
        Alerta alerta=m.map(alertaDTO,Alerta.class);
        alertaService.ingresar(alerta);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA') or hasAuthority('AGENTE')")
    public List<AlertaDTO> listar(){
        return alertaService.listar().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,AlertaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        alertaService.eliminar(id);
    }

    @GetMapping("/{id}")
    public AlertaDTO  listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        AlertaDTO dto=m.map(alertaService.listarId(id),AlertaDTO.class);
        return dto;
    }

    @GetMapping("/Alertasporubicacion")
    public List<AlertaporUbicacionDTO> CantidadAlertasPorUbicacion(){
        List<String[]> lista = alertaService.CantidadAlertasPorUbicacion();
        List<AlertaporUbicacionDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            AlertaporUbicacionDTO dto =  new AlertaporUbicacionDTO();
            dto.setUbicacion(data[0]);
            dto.setCantidad(Integer.parseInt(data[1]));
            listadto.add(dto);
        }
        return listadto;
    }
    @GetMapping("/PromedioAlertarPorEntidad")
    public List<AlertaPromedioMensualEntidadDTO> cantidadActasPorPolicia(){
        List<String[]> lista = alertaService.PromedioMensualEntidad();
        List<AlertaPromedioMensualEntidadDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            AlertaPromedioMensualEntidadDTO dto =  new AlertaPromedioMensualEntidadDTO();
            dto.setNameENTIDAD(data[0]);
            dto.setPromedio(Integer.parseInt(data[1]));
            listadto.add(dto);
        }
        return listadto;
    }
}
