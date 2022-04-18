package com.backenduniversidad.universidadbackend.services.contratos;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{

    Iterable<Persona> buscarAlumnosPorCarrera(String carrera);

    //TODO Cerrar la seccion 4 - practica
}
