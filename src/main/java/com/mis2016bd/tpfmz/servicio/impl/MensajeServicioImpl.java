/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Mensaje;
import com.mis2016bd.tpfmz.repositorio.MensajesRepositorio;
import com.mis2016bd.tpfmz.servicio.MensajeServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franco
 */
@Service
public class MensajeServicioImpl implements MensajeServicio{
    
    @Autowired 
    private MensajesRepositorio repo;
    
    @Override
    public List<Mensaje> obtenerTodasLosMensajes() {
        return repo.obtenerTodasLosMensajes();
    }

    @Override
    public Mensaje encontrarMensajePorId(int id) {
       return repo.encontrarMensajePorId(id);
    }

    @Override
    public void eliminarMensaje(Mensaje aa) {
        repo.eliminarMensaje(aa);
    }

    @Override
    public void nuevoMensaje(Mensaje mensaje) {
        repo.nuevoMensaje(mensaje);
    }

    @Override
    public List<Mensaje> obtenerTodosLosMensajesUsuario(int id) {
        return repo.obtenerTodosLosMensajesUsuario(id);
    }
    
}
