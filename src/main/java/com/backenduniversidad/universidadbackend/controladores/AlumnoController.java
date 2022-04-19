package com.backenduniversidad.universidadbackend.controladores;

import com.backenduniversidad.universidadbackend.exceptions.BadRequestException;
import com.backenduniversidad.universidadbackend.modelo.entidades.Alumno;
import com.backenduniversidad.universidadbackend.modelo.entidades.Carrera;
import com.backenduniversidad.universidadbackend.modelo.entidades.Persona;
import com.backenduniversidad.universidadbackend.services.contratos.CarreraDAO;
import com.backenduniversidad.universidadbackend.services.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final PersonaDAO alumnoDAO;
    private final CarreraDAO carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDAO, CarreraDAO carreraDAO) {
        this.alumnoDAO = alumnoDAO;
        this.carreraDAO = carreraDAO;
    }

    @GetMapping
    public List<Persona> obtenerTodos(){
        return (List<Persona>) alumnoDAO.findAll();
    }

    @GetMapping("/{id}")
    public Persona obtenerAlumnoPorId(@PathVariable Integer id){
        Optional<Persona> oAlumno = alumnoDAO.findById(id);
        if (oAlumno.isEmpty()){
            throw new BadRequestException("El alumno no existe");
        }
        return oAlumno.get();
    }

    @PostMapping
    public Persona altaAlumno(@RequestBody Persona alumno){
        return alumnoDAO.save(alumno);
    }

    @PutMapping("/{id}")
    public Persona actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Optional<Persona> oAlumno = alumnoDAO.findById(id);
        if (oAlumno.isEmpty()){
            throw new BadRequestException("No se encontro el alumno");
        }
        Persona alumnoUpdate = oAlumno.get();

        if (alumno.getNombre() != null){
            alumnoUpdate.setNombre(alumno.getNombre());
        }
        if (alumno.getApellido() != null){
            alumnoUpdate.setApellido(alumno.getApellido());
        }
        if (alumno.getDireccion() != null){
            alumnoUpdate.setDireccion(alumno.getDireccion());
        }
        return alumnoDAO.save(alumnoUpdate);
    }

    @DeleteMapping("/{id}")
    public void borrarAlumno(@PathVariable Integer id){
        alumnoDAO.deleteById(id);
    }

    @PutMapping("/{idAlumno}/{idCarrera}")
    public Persona asignarCarrera(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = alumnoDAO.findById(idAlumno);
        if (oAlumno.isEmpty()){
            throw new BadRequestException(String.format("El alumno %d no existe", idAlumno));
        }
        Persona alumno = oAlumno.get();

        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if (oCarrera.isEmpty()){
            throw new BadRequestException(String.format("La carrera %d no existe", idCarrera));
        }
        Carrera carrera = oCarrera.get();

        ((Alumno)alumno).setCarrera(carrera);

        return alumnoDAO.save(alumno);
    }
}
