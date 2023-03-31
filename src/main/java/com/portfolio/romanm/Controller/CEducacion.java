package com.portfolio.romanm.Controller;

import com.portfolio.romanm.Dto.DtoEducacion;
import com.portfolio.romanm.Entity.Educacion;
import com.portfolio.romanm.Security.Controller.Mensaje;
import com.portfolio.romanm.Service.SEducacion;
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
@RequestMapping("educacion")
@CrossOrigin
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe la educacion solicitada"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getInstitucionEdu())){
            return new ResponseEntity(new Mensaje("La institucion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEdu.getTituloEdu())){
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
         
        if(StringUtils.isBlank(dtoEdu.getCarreraEdu())){
            return new ResponseEntity(new Mensaje("La carrera es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEdu.getInicioEdu())){
            return new ResponseEntity(new Mensaje("La fecha de inicio es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(sEducacion.existsByCarreraEdu(dtoEdu.getCarreraEdu())){
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(dtoEdu.getInstitucionEdu(), dtoEdu.getTituloEdu(), 
                dtoEdu.getCarreraEdu(), dtoEdu.getInicioEdu(), 
                dtoEdu.getFinEdu(), dtoEdu.getLinkImg());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEdu){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(sEducacion.existsByCarreraEdu(dtoEdu.getCarreraEdu()) && sEducacion.getByCarreraEdu(dtoEdu.getCarreraEdu()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEdu.getInstitucionEdu())){
            return new ResponseEntity(new Mensaje("La institucion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEdu.getTituloEdu())){
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
         
        if(StringUtils.isBlank(dtoEdu.getCarreraEdu())){
            return new ResponseEntity(new Mensaje("La carrera es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEdu.getInicioEdu())){
            return new ResponseEntity(new Mensaje("La fecha de inicio es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setInstitucionEdu(dtoEdu.getInstitucionEdu());
        educacion.setTituloEdu(dtoEdu.getTituloEdu());
        educacion.setCarreraEdu(dtoEdu.getCarreraEdu());
        educacion.setInicioEdu(dtoEdu.getInicioEdu());
        educacion.setFinEdu(dtoEdu.getFinEdu());
        educacion.setLinkImg(dtoEdu.getLinkImg());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        sEducacion.delete(id);
        
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
}
