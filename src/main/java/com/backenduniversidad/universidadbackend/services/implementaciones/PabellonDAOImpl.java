package com.backenduniversidad.universidadbackend.services.implementaciones;

import com.backenduniversidad.universidadbackend.modelo.entidades.Pabellon;
import com.backenduniversidad.universidadbackend.repositorios.PabellonRepository;
import com.backenduniversidad.universidadbackend.services.contratos.PabellonDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PabellonDAOImpl extends GenericDAOImpl<Pabellon, PabellonRepository, Integer> implements PabellonDAO {

    public PabellonDAOImpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findByDireccionLocalidad(String localidad) {
        return repository.findByDireccionLocalidad(localidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pabellon> findByNombreIgnoreCase(String nombre) {
        return repository.findByNombreIgnoreCase(nombre);
    }
}
