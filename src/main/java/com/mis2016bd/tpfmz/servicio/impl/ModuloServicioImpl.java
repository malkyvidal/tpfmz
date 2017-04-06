/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Modulo;
import com.mis2016bd.tpfmz.repositorio.ModuloRepositorio;
import com.mis2016bd.tpfmz.servicio.ModuloServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author silvina
 */
@Service
public class ModuloServicioImpl implements ModuloServicio{

    @Autowired
    private ModuloRepositorio repo;
    
    @Override
    public List<Modulo> obtenerTodosLosModulos() {
       return repo.obtenerTodosLosModulos();
    }
    
       @Override
    public void nuevoModulo(Modulo al) {
        repo.nuevoModulo(al);
    }

    @Override
    public void eliminaModulo(Modulo modulo) {
        repo.eliminaModulo(modulo);
    }

    @Override
    public Modulo encontrarModuloPorCodModulo(int codModulo) {
        return  repo.encontrarModuloPorCodModulo(codModulo);
    }
   
}
