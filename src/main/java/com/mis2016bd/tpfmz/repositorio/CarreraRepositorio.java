/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio;

import com.mis2016bd.tpfmz.modelo.Carrera;
import java.util.List;

/**
 *
 * @author malky
 */
public interface CarreraRepositorio {
    public List<Carrera> obtenerTodasLasCarreras();
    public Carrera obtenerCarreraPorCodigoCarrera(Integer codigoCarrera);

    public Carrera encontrarCarreraPorCodigo(int id);

    public void eliminarCarrera(Carrera carrera);

    public void nuevaCarrera(Carrera nueva);

    public void updateCarrera(Carrera nuevo);
    
}
