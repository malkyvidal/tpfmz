/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio;

import com.mis2016bd.tpfmz.modelo.Materia;
import java.util.List;

/**
 *
 * @author malky
 */
public interface MateriaServicio {
    public List<Materia> obtenerTodasLasMaterias();

    public Materia encontrarMateriaPorCodigo(int id);

    public Materia obtenerMateriaPorCodigo(int codMateria);
    void nuevaMateria(Materia al);
    void eliminaMateria(Materia materia);
    void updateMateria(Materia al);
      
}
