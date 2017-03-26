/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio;

import com.mis2016bd.tpfmz.modelo.Alumno;
import com.mis2016bd.tpfmz.modelo.Materia;
import java.util.List;

/**
 *
 * @author malky
 */
public interface MateriaRepositorio {
    public List<Materia> obtenerTodasLasMaterias();
}
