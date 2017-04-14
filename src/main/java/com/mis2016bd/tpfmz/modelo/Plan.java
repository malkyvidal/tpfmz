package com.mis2016bd.tpfmz.modelo;
// Generated 22/03/2017 19:10:31 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author franco
 */

public class Plan {


     private Integer identificador;
     private String nombre;
     private String nroResolucion;
     private String descripcion;
     private Date fechaIni;
     private Date fechaFin;
     private Set alumnos = new HashSet(0);
     private Set<Coordinador> coordinadores = new HashSet(0);

    public Set<Coordinador> getCoordinadores() {
        return coordinadores;
    }

    public void setCoordinadores(Set<Coordinador> coordinadores) {
        this.coordinadores = coordinadores;
    }

         
    public Set getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set alumnos) {
        this.alumnos = alumnos;
    }
    
    public Plan() {
    }

	
    public Plan(Integer identificador) {
        this.identificador = identificador;
    }
    public Plan(Integer identificador, String nombre, String nroResolucion, String descripcion, Date fechaIni, Date fechaFin, Set<Coordinador> coordinadores) {
       this.identificador = identificador;
       this.nombre = nombre;
       this.nroResolucion = nroResolucion;
       this.descripcion = descripcion;
       this.fechaIni = fechaIni;
       this.fechaFin = fechaFin;
       this.coordinadores = coordinadores;
    }
   
    public Integer getIdentificador() {
        return this.identificador;
    }
    
    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroResolucion() {
        return this.nroResolucion;
    }
    
    public void setNroResolucion(String nroResolucion) {
        this.nroResolucion = nroResolucion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaIni() {
        return this.fechaIni;
    }
    
    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

  


}


