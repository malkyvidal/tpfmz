/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio.impl;

import com.mis2016bd.tpfmz.modelo.Plan;
import com.mis2016bd.tpfmz.repositorio.PlanRepositorio;
import com.mis2016bd.tpfmz.servicio.PlanServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author franco
 */
public class PlanServicioImpl implements PlanServicio{
    @Autowired
    PlanRepositorio repo;
    
    @Override
    public List<Plan> obtenerTodosLosPlanes() {
        return repo.obtenerTodosLosPlanes();
    }

    @Override
    public Plan obtenerPlanPorCodigoPlan(String identificador) {
        return repo.obtenerPlanPorCodigoPlan(identificador);
    }
    
}
