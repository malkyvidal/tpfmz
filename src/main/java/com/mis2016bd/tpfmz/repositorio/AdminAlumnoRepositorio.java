/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio;

import com.mis2016bd.tpfmz.modelo.AdminAlumnado;
import java.util.List;

/**
 *
 * @author franco
 */
public interface AdminAlumnoRepositorio {

    public List<AdminAlumnado> obtenerTodosLosAdminAlumno();

    public AdminAlumnado encontrarAdministradorPorLegajo(int id);

    public void eliminarAdministrador(AdminAlumnado aa);

    public void nuevoAdminAlumno(AdminAlumnado nuevo);

    public void updateAdminAlumno(AdminAlumnado nuevo);
    
}
