package com.backenduniversidad.universidadbackend.services.implementaciones;

import com.backenduniversidad.universidadbackend.modelo.entidades.Aula;
import com.backenduniversidad.universidadbackend.modelo.entidades.enumeradores.Pizarron;
import com.backenduniversidad.universidadbackend.repositorios.AulaRepository;
import com.backenduniversidad.universidadbackend.services.contratos.AulaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class AulaDAOImpl extends GenericDAOImpl<Aula, AulaRepository, Integer> implements AulaDAO {

    public AulaDAOImpl(AulaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findByPizarron(Pizarron pizarron) {
        return repository.findByPizarron(pizarron);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findByPabellonNombre(String nombre) {
        return repository.findByPabellonNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Aula> findByNumeroAula(Integer numeroAula) {
        return repository.findByNumeroAula(numeroAula);
    }
}
