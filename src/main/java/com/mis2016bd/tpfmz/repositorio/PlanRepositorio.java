/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio;

import com.mis2016bd.tpfmz.modelo.Plan;
import java.util.List;

/**
 *
 * @author franco
 */
public interface PlanRepositorio {
    public List<Plan> obtenerTodosLosPlanes();
    public Plan obtenerPlanPorCodigoPlan(String identificador);
    Plan encontrarPlanPorIdentificador(String id);
    void eliminarPlan(Plan plan);
    void nuevoPlan(Plan pl);
}
