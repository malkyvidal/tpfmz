/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio;


import com.mis2016bd.tpfmz.modelo.Mensaje;
import java.util.List;

/**
 *
 * @author franco
 */

public interface MensajeServicio {
     public List<Mensaje> obtenerTodasLosMensajes();

    public Mensaje encontrarMensajePorId(int id);

    public void eliminarMensaje(Mensaje aa);

    public void nuevoMensaje(Mensaje mensaje);

    public List<Mensaje> obtenerTodosLosMensajesUsuario(int id);
}
