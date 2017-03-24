package com.mis2016bd.tpfmz.modelo;


import java.util.Date;

/**
 * @author franco
 */
public class Estadosmateria{


     private Short id;
     private Materiasalumnos materiasalumnos;
     private String estado;
     private Date fecha;

    public Estadosmateria() {
    }

    public Estadosmateria(Materiasalumnos materiasalumnos, String estado, Date fecha) {
       this.materiasalumnos = materiasalumnos;
       this.estado = estado;
       this.fecha = fecha;
    }
   
    public Short getId() {
        return this.id;
    }
    
    public void setId(Short id) {
        this.id = id;
    }
    public Materiasalumnos getMateriasalumnos() {
        return this.materiasalumnos;
    }
    
    public void setMateriasalumnos(Materiasalumnos materiasalumnos) {
        this.materiasalumnos = materiasalumnos;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


