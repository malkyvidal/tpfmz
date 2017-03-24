/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.modelo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author malky
 */
public class Materia {

    private int codMateria;
    private Carrera carrera;
    private String nombreMateria;
    private Boolean modalidad;
    private Set materiasalumnos = new HashSet(0);
    
    public Materia() {
    }

    public Materia(int codMateria) {
        this.codMateria = codMateria;
    }

    public Materia(int codMateria, Carrera carrera, String nombreMateria, Boolean modalidad) {
        this.codMateria = codMateria;
        this.carrera = carrera;
        this.nombreMateria = nombreMateria;
        this.modalidad = modalidad;
    }

    public int getCodMateria() {
        return this.codMateria;
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }

    public Carrera getCarrera() {
        return this.carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getNombreMateria() {
        return this.nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Boolean getModalidad() {
        return this.modalidad;
    }

    public void setModalidad(Boolean modalidad) {
        this.modalidad = modalidad;
    }
    
    public Set getMateriasalumnos() {
        return this.materiasalumnos;
    }
    
    public void setMateriasalumnos(Set materiasalumnos) {
        this.materiasalumnos = materiasalumnos;
    }
}
