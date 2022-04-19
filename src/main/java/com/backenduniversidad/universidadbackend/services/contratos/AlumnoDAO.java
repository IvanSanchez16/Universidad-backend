package com.backenduniversidad.universidadbackend.services.contratos;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{

    Iterable<Persona> buscarAlumnosPorCarrera(String carrera);

    //TODO Seccion 7 - Hacer controladores de los demas recursos - 80
}
