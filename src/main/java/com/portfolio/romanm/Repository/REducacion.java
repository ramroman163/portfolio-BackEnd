package com.portfolio.romanm.Repository;

import com.portfolio.romanm.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByCarreraEdu(String carreraEdu);
    public boolean existsByCarreraEdu(String carreraEdu);
}
