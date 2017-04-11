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
import com.mis2016bd.tpfmz.modelo.Coordinador;
import java.util.List;

public interface CoordinadorRepositorio {
   List<Coordinador> obtenerTodosLosCoordinadores();
   void nuevoCoordinador(Coordinador al);
   void eliminaCoordinador(Coordinador coordinador);
   Coordinador encontrarCoordinadorPorLegajo(int legajo);
   void updateCoordinador(Coordinador al);
   
}
