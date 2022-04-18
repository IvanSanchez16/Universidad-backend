package com.backenduniversidad.universidadbackend.services.contratos;

import com.backenduniversidad.universidadbackend.modelo.entidades.Carrera;

public interface CarreraDAO extends GenericDAO<Carrera, Integer>{

    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}
