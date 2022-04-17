package com.backenduniversidad.universidadbackend.services.implementaciones;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;
import com.backenduniversidad.universidadbackend.repositorios.PersonaRepository;
import com.backenduniversidad.universidadbackend.services.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class AlumnoDAOImpl implements AlumnoDAO {

    @Autowired
    @Qualifier("repositorioAlumnos")
    private PersonaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Persona save(Persona persona) {
        return repository.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
