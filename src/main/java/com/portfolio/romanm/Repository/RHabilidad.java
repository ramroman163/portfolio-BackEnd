package com.portfolio.romanm.Repository;

import com.portfolio.romanm.Entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidad extends JpaRepository<Habilidad, Integer>{
    public Optional<Habilidad> findByNombreHab(String nombreHab);
    public boolean existsByNombreHab(String nombreHab);
}
