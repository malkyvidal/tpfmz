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
import com.mis2016bd.tpfmz.modelo.Perfil;
import java.util.List;

public interface PerfilRepositorio {
   List<Perfil> obtenerTodosLosPerfiles();
   public Perfil obtenerPerfilPorCodigoPerfil(Integer codigo);
   void nuevoPerfil(Perfil al);
   void eliminaPerfil(Perfil perfil);
   Perfil encontrarPerfilPorCodigoPerfil(int codPerfil);
}
