package com.backenduniversidad.universidadbackend.modelo.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pabellones")
public class Pabellon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "metros_cuadrados")
    private Double mts2;
    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
            @AttributeOverride(name = "dpto", column = @Column(name = "departamento"))
    })
    private Direccion direccion;
    @Column(name = "created_at")
    private LocalDateTime fechaAlta;
    @Column(name = "updated_at")
    private LocalDateTime fechaModificacion;

    @OneToMany(
        mappedBy = "pabellon",
        fetch = FetchType.LAZY
    )
    private Set<Aula> aulas;

    public Pabellon() {
    }

    public Pabellon(Integer id, Double mts2, String nombre, Direccion direccion, LocalDateTime fechaAlta, LocalDateTime fechaModificacion) {
        this.id = id;
        this.mts2 = mts2;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMts2() {
        return mts2;
    }

    public void setMts2(Double mts2) {
        this.mts2 = mts2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Set<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Set<Aula> aulas) {
        this.aulas = aulas;
    }

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDeActualizar(){
        this.fechaModificacion = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Pabellon{" +
                "id=" + id +
                ", mts2=" + mts2 +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return id.equals(pabellon.id) && nombre.equals(pabellon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
