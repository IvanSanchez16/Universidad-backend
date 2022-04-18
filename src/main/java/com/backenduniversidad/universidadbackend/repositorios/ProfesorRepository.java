package com.backenduniversidad.universidadbackend.repositorios;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository{

    @Query("SELECT distinct p FROM Profesor p JOIN p.carreras c WHERE c.nombre = ?1")
    Iterable<Persona> buscarProfesoresPorCarrera(String carrera);
}
