package com.mis2016bd.tpfmz.modelo;


import java.util.HashSet;
import java.util.Set;

/**
 * @author franco
 */
public class Materiasalumnos{


     private Short id;
     private Alumno alumno;
     private Materia materia;
     private Short modalidad;
     private Set estadosmaterias = new HashSet(0);

    public Materiasalumnos() {
    }

    public Materiasalumnos(Alumno alumno, Materia materia, Short modalidad, Set estadosmaterias) {
       this.alumno = alumno;
       this.materia = materia;
       this.modalidad = modalidad;
       this.estadosmaterias = estadosmaterias;
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
    public Short getModalidad() {
        return this.modalidad;
    }
    
    public void setModalidad(Short modalidad) {
        this.modalidad = modalidad;
    }
    public Set getEstadosmaterias() {
        return this.estadosmaterias;
    }
    
    public void setEstadosmaterias(Set estadosmaterias) {
        this.estadosmaterias = estadosmaterias;
    }
}


