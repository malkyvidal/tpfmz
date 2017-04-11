/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Coordinador;
import com.mis2016bd.tpfmz.repositorio.CoordinadorRepositorio;
import com.mis2016bd.tpfmz.servicio.CoordinadorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author silvina
 */
@Service
public class CoordinadorServicioImpl implements CoordinadorServicio{

    @Autowired
    CoordinadorRepositorio repo;
    
    @Override
    public List<Coordinador> obtenerTodosLosCoordinadores() {
       return repo.obtenerTodosLosCoordinadores();
    }

    @Override
    public void nuevoCoordinador(Coordinador al) {
        repo.nuevoCoordinador(al);
    }

    @Override
    public void eliminaCoordinador(Coordinador coordinador) {
        repo.eliminaCoordinador(coordinador);
    }

    @Override
    public Coordinador encontrarCoordinadorPorLegajo(int legajo) {
        return  repo.encontrarCoordinadorPorLegajo(legajo);
    }
    @Override
    public void updateCoordinador(Coordinador al) {
        repo.updateCoordinador(al);
    }
   
    
}
