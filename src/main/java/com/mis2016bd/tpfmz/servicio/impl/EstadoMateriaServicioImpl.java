/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Estadosmateria;
import com.mis2016bd.tpfmz.repositorio.EstadoMateriaRepositorio;
import com.mis2016bd.tpfmz.servicio.EstadoMateriaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franco
 */
@Service
public class EstadoMateriaServicioImpl implements EstadoMateriaServicio {
    
    @Autowired
    private EstadoMateriaRepositorio repo;
    
    @Override
    public List<Estadosmateria> obtenerTodasLosEstadoMateria() {
        return repo.obtenerTodasLosEstados();
    }
    
}
