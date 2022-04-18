package com.backenduniversidad.universidadbackend.services.contratos;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;

public interface ProfesorDAO extends PersonaDAO{

    Iterable<Persona> buscarProfesoresPorCarrera(String carrera);
}
