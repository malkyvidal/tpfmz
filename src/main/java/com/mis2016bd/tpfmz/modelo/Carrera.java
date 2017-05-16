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
public class Carrera {
    
    
     private Integer codigoCarrera;
     private String nombre;
     private Boolean canNivel;
     private int version;
     private Set materias = new HashSet(0);

    public Carrera() {
    }

	
    public Carrera(String nombre) {
        this.nombre = nombre;
    }
    public Carrera(String nombre, Boolean canNivel,int version, Set materias) {
       this.nombre = nombre;
       this.canNivel = canNivel;
       this.materias = materias;
       this.version = version;
    }
   
    public Integer getCodigoCarrera() {
        return this.codigoCarrera;
    }
    
    public void setCodigoCarrera(Integer codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Boolean getCanNivel() {
        return this.canNivel;
    }
    
    public void setCanNivel(Boolean canNivel) {
        this.canNivel = canNivel;
    }
    
    public Set getMaterias() {
        return this.materias;
    }
    
    public void setMaterias(Set materias) {
        this.materias = materias;
    }
    
    public int getVersion() {
        return this.version;
    }
    
    public void setVersion(int version) {
        this.version = version;
    }
}
