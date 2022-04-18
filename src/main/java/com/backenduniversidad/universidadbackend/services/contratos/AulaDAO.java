package com.backenduniversidad.universidadbackend.services.contratos;

import com.backenduniversidad.universidadbackend.modelo.entidades.Aula;
import com.backenduniversidad.universidadbackend.modelo.entidades.enumeradores.Pizarron;

import java.util.Optional;

public interface AulaDAO extends GenericDAO<Aula, Integer>{

    Iterable<Aula> findByPizarron(Pizarron pizarron);

    Iterable<Aula> findByPabellonNombre(String nombre);

    Optional<Aula> findByNumeroAula(Integer numeroAula);
}
