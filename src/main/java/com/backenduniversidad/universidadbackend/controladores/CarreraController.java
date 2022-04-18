package com.backenduniversidad.universidadbackend.controladores;

import com.backenduniversidad.universidadbackend.exceptions.BadRequestException;
import com.backenduniversidad.universidadbackend.modelo.entidades.Carrera;
import com.backenduniversidad.universidadbackend.services.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    private final CarreraDAO carreraDAO;

    @Autowired
    public CarreraController(CarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }

    @GetMapping
    public List<Carrera> obtenerTodos() {
        List<Carrera> carreras = (List<Carrera>) carreraDAO.findAll();
        // En el curso se usa esta practica pero prefiero regresar el arreglo vacio
        // if (carreras.isEmpty()){
        //     throw new BadRequestException("No existen carreras");
        // }
        return carreras;
    }

    @GetMapping("/{id}")
    public Carrera obtenerPorId(@PathVariable(value = "id") Integer id){ //Solo es necesario agregar el value si no se llaman igual
        Optional<Carrera> carrera = carreraDAO.findById(id);
        if (carrera.isEmpty()){
            return null;
        }
        return carrera.get();
    }

    @PostMapping
    public Carrera altaCarrera(@RequestBody Carrera carrera){
        if (carrera.getCantidadAnios() < 0){
            throw new BadRequestException("La cantidad de años no puede ser negativa");
        }
        if (carrera.getCantidadMaterias() < 0){
            throw new BadRequestException("La cantidad de materias no puede ser negativa");
        }
        return carreraDAO.save(carrera);
    }

    @PutMapping("/{id}")
    public Carrera actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Carrera carreraUpdate;
        Optional<Carrera> oCarreraUpdate = carreraDAO.findById(id);

        if (oCarreraUpdate.isEmpty()){
            throw new BadRequestException("No se encontró la carrera");
        }

        carreraUpdate = oCarreraUpdate.get();
        if (carrera.getCantidadMaterias() != null){
            carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        }
        if (carrera.getCantidadAnios() != null){
            carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        }
        return carreraDAO.save(carreraUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        carreraDAO.deleteById(id);
    }

}
