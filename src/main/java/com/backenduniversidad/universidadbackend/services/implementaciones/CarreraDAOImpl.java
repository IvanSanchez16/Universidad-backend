package com.backenduniversidad.universidadbackend.services.implementaciones;

import com.backenduniversidad.universidadbackend.modelo.entidades.Carrera;
import com.backenduniversidad.universidadbackend.repositorios.CarreraRepository;
import com.backenduniversidad.universidadbackend.services.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraDAOImpl extends GenericDAOImpl<Carrera, CarreraRepository, Integer> implements CarreraDAO {

    @Autowired
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido) {
        return repository.buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);
    }
}
