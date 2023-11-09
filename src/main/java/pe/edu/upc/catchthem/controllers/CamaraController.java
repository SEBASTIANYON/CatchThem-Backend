package pe.edu.upc.catchthem.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.CamaraDTO;
import pe.edu.upc.catchthem.entities.Camara;
import pe.edu.upc.catchthem.serviceInterfaces.ICamaraService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
 @RequestMapping("/camara")
 public class CamaraController {
        @Autowired
        private ICamaraService cS;

        @PostMapping
        @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('POLICIA') or hasRole('AGENTE')")
        public void registrar(@RequestBody CamaraDTO camaraDTO){
            ModelMapper m= new ModelMapper();
            Camara c = m.map(camaraDTO,Camara.class);
            cS.insertar(c);
        }
        @GetMapping
        @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('AGENTE') or hasAuthority('POLICIA')")
        public List<CamaraDTO> listar(){
            return cS.listar().stream().map(x->{
                ModelMapper m = new ModelMapper();
                return m.map(x,CamaraDTO.class);
            }).collect(Collectors.toList());

        }
        @DeleteMapping("/{id}")
        @PreAuthorize("hasAuthority('ADMIN')")
        public void eliminar(@PathVariable("id") Integer id){
            cS.eliminar(id);
        }
}