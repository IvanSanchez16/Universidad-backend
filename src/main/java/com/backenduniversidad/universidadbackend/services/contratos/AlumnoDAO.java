package com.backenduniversidad.universidadbackend.services.contratos;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;

import java.util.Optional;

public interface AlumnoDAO {
    Optional<Persona> findById(Integer id);
    Persona save(Persona persona);
    Iterable<Persona> findAll();
    void deleteById(Integer id);
}
