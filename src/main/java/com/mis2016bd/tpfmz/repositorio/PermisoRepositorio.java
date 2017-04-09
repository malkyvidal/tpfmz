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
import com.mis2016bd.tpfmz.modelo.Permiso;
import java.util.List;

public interface PermisoRepositorio {
   List<Permiso> obtenerTodosLosPermisos();
   public Permiso obtenerPermisoPorCodigoPermiso(Integer codigo);
    void nuevoPermiso(Permiso al);
    void eliminaPermiso(Permiso permiso);
    Permiso encontrarPermisoPorCodPermiso(int codPermiso);
     void updatePermiso(Permiso al);
     List<Permiso> obtenerTodosLosPermisosPorPerfil(int codPerfil);
}
