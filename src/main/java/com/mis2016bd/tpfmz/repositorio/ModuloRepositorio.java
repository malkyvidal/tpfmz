/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio;

/**
 *
 * @author silvina
 */
import com.mis2016bd.tpfmz.modelo.Modulo;
import java.util.List;

public interface ModuloRepositorio {
     List<Modulo> obtenerTodosLosModulos();
     void nuevoModulo(Modulo al);
     void eliminaModulo(Modulo modulo);
     Modulo encontrarModuloPorCodModulo(int codModulo);
}


