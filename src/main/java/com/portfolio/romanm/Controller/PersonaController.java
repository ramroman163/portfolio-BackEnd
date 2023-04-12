package com.portfolio.romanm.Controller;

import com.portfolio.romanm.Dto.DtoPersona;
import com.portfolio.romanm.Entity.Persona;
import com.portfolio.romanm.Security.Controller.Mensaje;
import com.portfolio.romanm.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://yoprogramo-angular.web.app/")
public class PersonaController {
    @Autowired
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe la habilidad"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    /*
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtoHabilidad){
        if(StringUtils.isBlank(dtoHabilidad.getNombreHab())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(sHabilidad.existsByNombreHab(dtoHabilidad.getNombreHab())){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Habilidad habilidad = new Habilidad(dtoHabilidad.getNombreHab(), dtoHabilidad.getPorcentajeHab());
        sHabilidad.save(habilidad);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(personaService.existsByNombre(dtoPersona.getNombre()) && personaService.getByNombre(dtoPersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPersona.getApellido())){
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPersona.getProfesion())){
            return new ResponseEntity(new Mensaje("La profesion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPersona.getUbicacion())){
            return new ResponseEntity(new Mensaje("La ubicacion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPersona.getAcercaDeMi())){
            return new ResponseEntity(new Mensaje("El acerca de mi es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setProfesion(dtoPersona.getProfesion());
        persona.setUbicacion(dtoPersona.getUbicacion());
        persona.setLinkImgPerfil(dtoPersona.getLinkImgPerfil());
        persona.setLinkImgBanner(dtoPersona.getLinkImgBanner());
        persona.setAcercaDeMi(dtoPersona.getAcercaDeMi());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHabilidad.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        sHabilidad.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }*/
}
