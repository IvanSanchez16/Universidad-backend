package com.backenduniversidad.universidadbackend.repositorios;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

    @Query("SELECT p FROM Persona p WHERE p.nombre = ?1 and p.apellido = ?2")
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);

    @Query("SELECT p FROM Persona p WHERE p.dni = ?1")
    Optional<Persona> buscarPorDNI(String dni);

    @Query("SELECT p FROM Persona p WHERE p.apellido LIKE %?1%")
    Iterable<Persona> buscarPersonasPorApellido(String apellido);
}
