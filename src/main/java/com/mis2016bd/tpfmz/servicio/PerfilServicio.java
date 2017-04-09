/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio;

import com.mis2016bd.tpfmz.modelo.Perfil;
import java.util.List;

/**
 *
 * @author silvina
 */
public interface PerfilServicio {
        List<Perfil> obtenerTodosLosPerfiles();
         public Perfil obtenerPerfilPorCodigoPerfil(Integer codigo);
          void nuevoPerfil(Perfil al);
   void eliminaPerfil(Perfil perfil);
   Perfil encontrarPerfilPorCodigoPerfil(int codPerfil);
   void updatePerfil(Perfil al);
}
