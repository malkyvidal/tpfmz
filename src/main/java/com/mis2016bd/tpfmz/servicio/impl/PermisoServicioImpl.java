/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Permiso;
import com.mis2016bd.tpfmz.repositorio.PermisoRepositorio;
import com.mis2016bd.tpfmz.servicio.PermisoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author silvina
 */
@Service
public class PermisoServicioImpl implements PermisoServicio{

    @Autowired
    PermisoRepositorio repo;
    
    @Override
    public List<Permiso> obtenerTodosLosPermisos() {
       return repo.obtenerTodosLosPermisos();
    }
     @Override
    public Permiso obtenerPermisoPorCodigoPermiso(Integer codigo) {
       return repo.obtenerPermisoPorCodigoPermiso(codigo);
}
       @Override
    public void nuevoPermiso(Permiso al) {
        repo.nuevoPermiso(al);
    }

    @Override
    public void eliminaPermiso(Permiso permiso) {
        repo.eliminaPermiso(permiso);
    }

    @Override
    public Permiso encontrarPermisoPorCodPermiso(int codPermiso) {
        return  repo.encontrarPermisoPorCodPermiso(codPermiso);
    }
   
}
