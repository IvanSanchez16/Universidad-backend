package com.backenduniversidad.universidadbackend.services.implementaciones;

import com.backenduniversidad.universidadbackend.modelo.entidades.Carrera;
import com.backenduniversidad.universidadbackend.repositorios.CarreraRepository;
import com.backenduniversidad.universidadbackend.services.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class CarreraDAOImpl implements CarreraDAO {

    @Autowired
    private CarreraRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Carrera> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Carrera save(Carrera carrera) {
        return repository.save(carrera);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
