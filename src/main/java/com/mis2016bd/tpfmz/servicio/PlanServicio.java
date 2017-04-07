/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.servicio;

import com.mis2016bd.tpfmz.modelo.Plan;
import java.util.List;

/**
 *
 * @author franco
 */
public interface PlanServicio {
    public List<Plan> obtenerTodosLosPlanes();
    public Plan obtenerPlanPorCodigoPlan(String identificador);
    Plan encontrarPlanPorIdentificador(String legajo);
    void eliminaPlan(Plan plan);
    public void nuevoPlan(Plan pl);
}
