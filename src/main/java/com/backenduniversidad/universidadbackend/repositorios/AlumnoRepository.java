package com.backenduniversidad.universidadbackend.repositorios;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository{

    @Query("SELECT a FROM Alumno a WHERE a.carrera.nombre = ?1")
    Iterable<Persona> buscarAlumnosPorCarrera(String carrera);
}
