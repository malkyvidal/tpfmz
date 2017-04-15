/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Materiasalumnos;
import com.mis2016bd.tpfmz.repositorio.MateriaAlumnoRepositorio;
import com.mis2016bd.tpfmz.servicio.MateriaAlumnoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franco
 */
@Service
public class MateriasalumnosServicioImpl implements MateriaAlumnoServicio{
    
    @Autowired
    private MateriaAlumnoRepositorio repo;
    
    @Override
    public List<Materiasalumnos> obtenerTodasLasMaterias() {
        return repo.obtenerTodasLasMaterias();
    }
    
     @Override
    public List<Materiasalumnos> obtenerTodasLasMateriasAlumnosPorLegajo(int legajo){
        return repo.obtenerTodasLasMateriasAlumnosPorLegajo(legajo);
    }

    @Override
    public Materiasalumnos encontrarMateriaAlumnoPorCodigo(int id) {
        return repo.encontrarMateriaAlumnoPorCodigo(id);
    }

    @Override
    public void eliminaMateriaAlumno(Materiasalumnos al) {
        repo.eliminaMateriaAlumno(al);
    }

    @Override
    public void nuevaMateriaAlumno(Materiasalumnos nuevo) {
        repo.nuevaMateriaAlumno(nuevo);
    }


    @Override
    public void updateMateriaAlumno(Materiasalumnos nuevo) {
        repo.updateMateriaAlumno(nuevo);
    }
    
}
