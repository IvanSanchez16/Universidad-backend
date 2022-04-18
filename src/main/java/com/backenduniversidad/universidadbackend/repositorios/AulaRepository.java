package com.backenduniversidad.universidadbackend.repositorios;

import com.backenduniversidad.universidadbackend.modelo.entidades.Aula;
import com.backenduniversidad.universidadbackend.modelo.entidades.enumeradores.Pizarron;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AulaRepository extends CrudRepository<Aula, Integer> {

    Iterable<Aula> findByPizarron(Pizarron pizarron);

    Iterable<Aula> findByPabellonNombre(String nombre);

    Optional<Aula> findByNumeroaula(Integer numeroAula);
}
