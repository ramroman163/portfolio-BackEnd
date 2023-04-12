package com.portfolio.romanm.Controller;

import com.portfolio.romanm.Dto.DtoHabilidad;
import com.portfolio.romanm.Entity.Habilidad;
import com.portfolio.romanm.Security.Controller.Mensaje;
import com.portfolio.romanm.Service.SHabilidad;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("habilidad")
@CrossOrigin(origins = "https://yoprogramo-angular.web.app/")
public class CHabilidad {
    @Autowired
    SHabilidad sHabilidad;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list(){
        List<Habilidad> list = sHabilidad.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id){
        if(!sHabilidad.existsById(id))
            return new ResponseEntity(new Mensaje("No existe la habilidad"), HttpStatus.NOT_FOUND);
        Habilidad habilidad = sHabilidad.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
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
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHabilidad dtoHabilidad){
        if(!sHabilidad.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(sHabilidad.existsByNombreHab(dtoHabilidad.getNombreHab()) && sHabilidad.getByNombreHab(dtoHabilidad.getNombreHab()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoHabilidad.getNombreHab())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Habilidad habilidad = sHabilidad.getOne(id).get();
        habilidad.setNombreHab(dtoHabilidad.getNombreHab());
        habilidad.setPorcentajeHab(dtoHabilidad.getPorcentajeHab());
        
        sHabilidad.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHabilidad.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        sHabilidad.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
}
