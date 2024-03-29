package com.portfolio.romanm.Service;

import com.portfolio.romanm.Entity.Educacion;
import com.portfolio.romanm.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    @Autowired
    REducacion rEducacion;
    
    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    
    public Optional<Educacion> getByCarreraEdu(String carreraEdu){
        return rEducacion.findByCarreraEdu(carreraEdu);
    }
    
    public void save(Educacion experiencia){
        rEducacion.save(experiencia);
    }
    
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsByCarreraEdu(String carreraEdu){
        return rEducacion.existsByCarreraEdu(carreraEdu);
    }
}
