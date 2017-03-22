/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio;

import com.mis2016bd.tpfmz.modelo.Carrera;
import java.util.List;

/**
 *
 * @author malky
 */
public interface CarreraServicio {
    public List<Carrera> obtenerTodasLasCarreras();
    public Carrera obtenerCarreraPorCodigoCarrera(Integer codigoCarrera);
}
