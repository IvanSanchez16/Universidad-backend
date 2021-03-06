package com.backenduniversidad.universidadbackend.services.implementaciones;

import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;
import com.backenduniversidad.universidadbackend.repositorios.AlumnoRepository;
import com.backenduniversidad.universidadbackend.repositorios.PersonaRepository;
import com.backenduniversidad.universidadbackend.services.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarAlumnosPorCarrera(String carrera) {
        return ((AlumnoRepository)repository).buscarAlumnosPorCarrera(carrera);
    }
}
