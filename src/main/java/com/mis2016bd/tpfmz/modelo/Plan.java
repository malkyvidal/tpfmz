package com.mis2016bd.tpfmz.modelo;
// Generated 22/03/2017 19:10:31 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * @author franco
 */

public class Plan {


     private String identificador;
     private String nombre;
     private Short nroResolucion;
     private String descripcion;
     private Date fechaIni;
     private Date fechaFin;

    public Plan() {
    }

	
    public Plan(String identificador) {
        this.identificador = identificador;
    }
    public Plan(String identificador, String nombre, Short nroResolucion, String descripcion, Date fechaIni, Date fechaFin) {
       this.identificador = identificador;
       this.nombre = nombre;
       this.nroResolucion = nroResolucion;
       this.descripcion = descripcion;
       this.fechaIni = fechaIni;
       this.fechaFin = fechaFin;
    }
   
    public String getIdentificador() {
        return this.identificador;
    }
    
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getNroResolucion() {
        return this.nroResolucion;
    }
    
    public void setNroResolucion(Short nroResolucion) {
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


