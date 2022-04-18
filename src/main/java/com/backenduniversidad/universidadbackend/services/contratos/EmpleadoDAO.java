package com.backenduniversidad.universidadbackend.services.contratos;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;
import com.backenduniversidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;

public interface EmpleadoDAO extends PersonaDAO{

    Iterable<Persona> buscarEmpleadosPorTipoEmpleado(TipoEmpleado tipoEmpleado);
}
