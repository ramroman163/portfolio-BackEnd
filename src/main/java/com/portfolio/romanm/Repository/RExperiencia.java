package com.portfolio.romanm.Repository;

import com.portfolio.romanm.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByLugarExp(String LugarExp);
    public boolean existsByLugarExp(String lugarExp);
}
