package com.backenduniversidad.universidadbackend.repositorios;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
}
