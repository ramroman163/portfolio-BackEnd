package com.portfolio.romanm.Service;

import com.portfolio.romanm.Entity.Experiencia;
import com.portfolio.romanm.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByLugarExp(String lugarExp){
        return rExperiencia.findByLugarExp(lugarExp);
    }
    
    public void save(Experiencia experiencia){
        rExperiencia.save(experiencia);
    }
    
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    
    public boolean existsByLugarExp(String lugarExp){
        return rExperiencia.existsByLugarExp(lugarExp);
    }
}
