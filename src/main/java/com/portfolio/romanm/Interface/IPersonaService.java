package com.portfolio.romanm.Interface;

import com.portfolio.romanm.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer una lista de persona
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un usuario por id
    public void deletePersona(long id);
    
    //Buscar persona por id
    public Persona findPersona(long id);
}
