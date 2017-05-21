/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio;

/**
 *
 * @author malky
 */
import com.mis2016bd.tpfmz.modelo.Alumno;
import java.util.List;

public interface AlumnoRepositorio {
   List<Alumno> obtenerTodosLosAlumnos();
   void nuevoAlumno(Alumno al);
   void eliminaAlumno(Alumno alumno);
   Alumno encontrarAlumnoPorLegajo(int legajo);
   void updateAlumno (Alumno al);
   
}
