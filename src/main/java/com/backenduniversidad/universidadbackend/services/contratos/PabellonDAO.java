package com.backenduniversidad.universidadbackend.services.contratos;

import com.backenduniversidad.universidadbackend.modelo.entidades.Pabellon;

import java.util.Optional;

public interface PabellonDAO extends GenericDAO<Pabellon, Integer>{

    Iterable<Pabellon> findByDireccionLocalidad(String localidad);

    Optional<Pabellon> findByNombreIgnoreCase(String nombre);
}
