package com.backenduniversidad.universidadbackend.repositorios;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;
import com.backenduniversidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioEmpleados")
public interface EmpleadoRepository extends PersonaRepository{

    @Query("SELECT e FROM Empleado e WHERE e.tipoEmpleado = ?1")
    Iterable<Persona> buscarEmpleadosPorTipoEmpleado(TipoEmpleado tipoEmpleado);
}
