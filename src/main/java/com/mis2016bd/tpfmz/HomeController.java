/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz;


import com.mis2016bd.tpfmz.modelo.Alumno;
import com.mis2016bd.tpfmz.modelo.Plan;
import com.mis2016bd.tpfmz.servicio.AlumnoServicio;
import com.mis2016bd.tpfmz.servicio.ModuloServicio;
import com.mis2016bd.tpfmz.servicio.PermisoServicio;
import com.mis2016bd.tpfmz.servicio.PerfilServicio;
import com.mis2016bd.tpfmz.servicio.CarreraServicio;
import com.mis2016bd.tpfmz.servicio.MateriaAlumnoServicio;
import com.mis2016bd.tpfmz.servicio.MateriaServicio;
import com.mis2016bd.tpfmz.servicio.MensajeServicio;
import com.mis2016bd.tpfmz.servicio.PlanServicio;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    
  @Autowired
  private PlanServicio servicio1, servicio3;
  @Autowired 
  private MateriaAlumnoServicio servicio2;
  
    @RequestMapping("/")
    public String welcome(Model model){
                 
       Plan pl = servicio1.obtenerPlanPorCodigoPlan("plan1");
              
              model.addAttribute("planes",servicio3.obtenerTodosLosPlanes().size());
             return "welcome";
    }
}
