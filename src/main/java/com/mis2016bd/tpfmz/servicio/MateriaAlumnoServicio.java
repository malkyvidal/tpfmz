/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio;

import com.mis2016bd.tpfmz.modelo.Materiasalumnos;
import java.util.List;

/**
 *
 * @author franco
 */
public interface MateriaAlumnoServicio {
    List<Materiasalumnos> obtenerTodasLasMaterias();

    public Materiasalumnos encontrarMateriaAlumnoPorCodigo(int id);

    public void eliminaMateriaAlumno(Materiasalumnos al);

    public void nuevaMateriaAlumno(Materiasalumnos nuevo);
     public List<Materiasalumnos> obtenerTodasLasMateriasAlumnosPorCodMateria(int codMateria);

    public void updateMateriaAlumno(Materiasalumnos nuevo);
}
