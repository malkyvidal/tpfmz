/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.AdminAlumnado;
import com.mis2016bd.tpfmz.repositorio.AdminAlumnoRepositorio;
import com.mis2016bd.tpfmz.servicio.AdminAlumnoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franco
 */
@Service
public class AdminAlumnoServicioImpl implements AdminAlumnoServicio {
    @Autowired
    private AdminAlumnoRepositorio repo;

    @Override
    public List<AdminAlumnado> obtenerTodosLosAdminAlumno() {
        return repo.obtenerTodosLosAdminAlumno();
    }

    @Override
    public AdminAlumnado encontrarAdministradorPorLegajo(int id) {
        return repo.encontrarAdministradorPorLegajo(id);
    }

    @Override
    public void eliminarAdministrador(AdminAlumnado aa) {
        repo.eliminarAdministrador(aa);
    }

    @Override
    public void nuevoAdminAlumno(AdminAlumnado nuevo) {
        repo.nuevoAdminAlumno(nuevo);
    }

    @Override
    public void updateAdminAlumno(AdminAlumnado nuevo) {
        repo.updateAdminAlumno(nuevo);
    }
    
    

    
}
