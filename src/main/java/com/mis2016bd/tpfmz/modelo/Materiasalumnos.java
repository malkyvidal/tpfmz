package com.mis2016bd.tpfmz.modelo;


/**
 * 
 */
public class Materiasalumnos{


     private Short id;
     private Alumno alumno;
     private Materia materia;
     private String estadoMateria;

    public Materiasalumnos() {
    }

    public Materiasalumnos(Alumno alumno, Materia materia, String estadoMateria) {
       this.alumno = alumno;
       this.materia = materia;
       this.estadoMateria = estadoMateria;
    }
   
    public Short getId() {
        return this.id;
    }
    
    public void setId(Short id) {
        this.id = id;
    }
    public Alumno getAlumno() {
        return this.alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Materia getMateria() {
        return this.materia;
    }
    
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public String getEstadoMateria() {
        return this.estadoMateria;
    }
    
    public void setEstadoMateria(String estadoMateria) {
        this.estadoMateria = estadoMateria;
    }




}


