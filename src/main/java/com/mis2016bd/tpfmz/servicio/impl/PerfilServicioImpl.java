/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Perfil;
import com.mis2016bd.tpfmz.repositorio.PerfilRepositorio;
import com.mis2016bd.tpfmz.servicio.PerfilServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author silvina
 */
@Service
public class PerfilServicioImpl implements PerfilServicio{

    @Autowired
    PerfilRepositorio repo;
    
    @Override
    public List<Perfil> obtenerTodosLosPerfiles() {
       return repo.obtenerTodosLosPerfiles();
    }
     @Override
    public Perfil obtenerPerfilPorCodigoPerfil(Integer codigo) {
       return repo.obtenerPerfilPorCodigoPerfil(codigo);
}
      @Override
    public void nuevoPerfil(Perfil al) {
        repo.nuevoPerfil(al);
    }

    @Override
    public void eliminaPerfil(Perfil perfil) {
        repo.eliminaPerfil(perfil);
    }

    @Override
    public Perfil encontrarPerfilPorCodigoPerfil(int perfil) {
        return  repo.encontrarPerfilPorCodigoPerfil(perfil);
    }
   @Override
    public void updatePerfil(Perfil al) {
        repo.updatePerfil(al);
    }
   
}
