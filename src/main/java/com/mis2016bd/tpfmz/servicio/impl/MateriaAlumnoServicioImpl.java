/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Materiasalumnos;
import com.mis2016bd.tpfmz.repositorio.MateriasAlumnoRepositorio;
import com.mis2016bd.tpfmz.servicio.MateriaAlumnoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franco
 */
@Service
public class MateriaAlumnoServicioImpl implements MateriaAlumnoServicio{
    
    @Autowired
    private MateriasAlumnoRepositorio repo;
     
    @Override
    public List<Materiasalumnos> obtenerTodasLasMateriasAlumno() {
        return repo.obtenerTodasLasMateriasAlumno();
    }
    
}
