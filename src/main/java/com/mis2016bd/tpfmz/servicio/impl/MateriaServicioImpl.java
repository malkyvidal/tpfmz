/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Materia;
import com.mis2016bd.tpfmz.servicio.MateriaServicio;
import com.mis2016bd.tpfmz.repositorio.MateriaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author malky
 */
@Service
public class MateriaServicioImpl implements MateriaServicio{

    @Autowired 
    private MateriaRepositorio repo;
    
    @Override
    public List<Materia> obtenerTodasLasMaterias() {
        return repo.obtenerTodasLasMaterias();
    }

    @Override
    public Materia encontrarMateriaPorCodigo(int id) {
        return repo.encontrarMateriaPorCodigo(id);
    }

    @Override
    public Materia obtenerMateriaPorCodigo(int codMateria) {
       return repo.obtenerMateriaPorCodigo(codMateria);
    }
    
}
