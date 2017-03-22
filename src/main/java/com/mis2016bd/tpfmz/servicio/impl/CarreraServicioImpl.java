/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Carrera;
import com.mis2016bd.tpfmz.repositorio.CarreraRepositorio;
import com.mis2016bd.tpfmz.servicio.CarreraServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author malky
 */
@Service
public class CarreraServicioImpl implements CarreraServicio{

    @Autowired
    CarreraRepositorio repo;
    
    @Override
    public List<Carrera> obtenerTodasLasCarreras() {
        return repo.obtenerTodasLasCarreras();
    }

    @Override
    public Carrera obtenerCarreraPorCodigoCarrera(Integer codigoCarrera) {
       return repo.obtenerCarreraPorCodigoCarrera(codigoCarrera);
    }
    
}
