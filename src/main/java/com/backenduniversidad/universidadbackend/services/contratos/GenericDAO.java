package com.backenduniversidad.universidadbackend.services.contratos;

import java.util.Optional;

public interface GenericDAO<T, L> {

    Optional<T> findById(L id);

    T save(T entidad);

    Iterable<T> findAll();

    void deleteById(L id);
}
