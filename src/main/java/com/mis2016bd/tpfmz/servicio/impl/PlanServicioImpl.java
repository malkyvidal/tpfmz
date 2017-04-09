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
import org.springframework.stereotype.Service;

/**
 *
 * @author franco
 */
@Service
public class PlanServicioImpl implements PlanServicio{
    @Autowired
    PlanRepositorio repo;
    
    @Override
    public List<Plan> obtenerTodosLosPlanes() {
        return repo.obtenerTodosLosPlanes();
    }

    @Override
    public Plan obtenerPlanPorCodigoPlan(int identificador) {
        return repo.obtenerPlanPorCodigoPlan(identificador);
    }

    @Override
    public Plan encontrarPlanPorIdentificador(int id) {
        return repo.encontrarPlanPorIdentificador(id);
    }

    @Override
    public void eliminaPlan(Plan plan) {
        repo.eliminarPlan(plan);
    }

    @Override
    public void nuevoPlan(Plan pl) {
        repo.nuevoPlan(pl);
    }

    @Override
    public void updatePlan(Plan nuevo) {
        repo.updatePlan(nuevo);
    }
    
}
