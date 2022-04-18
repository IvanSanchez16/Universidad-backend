package com.backenduniversidad.universidadbackend.repositorios;

import com.backenduniversidad.universidadbackend.modelo.entidades.Pabellon;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {

    Iterable<Pabellon> findByDireccionLocalidad(String localidad);

    Optional<Pabellon> findByNombreIgnoreCase(String nombre);
}
