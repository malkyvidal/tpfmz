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
    private int modalidad;

    
    private int version;
    private Set<Materiasalumnos> materiasalumnoses = new HashSet(0);
    
     public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    public Materia() {
    }

    public Materia(int codMateria) {
        this.codMateria = codMateria;
    }

    public Materia(int codMateria, Carrera carrera, String nombreMateria, int modalidad) {
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

    public int getModalidad() {
        return this.modalidad;
    }

    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }
    
    public Set getMateriasalumnoses() {
        return this.materiasalumnoses;
    }
    
    public void setMateriasalumnoses(Set materiasalumnoses) {
        this.materiasalumnoses = materiasalumnoses;
 }
    
}