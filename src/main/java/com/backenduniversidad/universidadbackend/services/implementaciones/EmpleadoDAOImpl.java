package com.backenduniversidad.universidadbackend.services.implementaciones;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;
import com.backenduniversidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import com.backenduniversidad.universidadbackend.repositorios.EmpleadoRepository;
import com.backenduniversidad.universidadbackend.repositorios.PersonaRepository;
import com.backenduniversidad.universidadbackend.services.contratos.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {

    public EmpleadoDAOImpl(@Qualifier("repositorioEmpleados") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarEmpleadosPorTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return ((EmpleadoRepository)repository).buscarEmpleadosPorTipoEmpleado(tipoEmpleado);
    }
}
