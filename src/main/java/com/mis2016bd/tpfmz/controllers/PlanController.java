/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.controllers;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.mis2016bd.tpfmz.modelo.Alumno;
import com.mis2016bd.tpfmz.modelo.Plan;


import com.mis2016bd.tpfmz.servicio.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ModelAttribute;


import com.mis2016bd.tpfmz.servicio.PlanServicio;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author franco
 */

@Controller
public class PlanController {
    
    @Autowired
    private PlanServicio planes;
    
    @RequestMapping("/Planes")
    public String todosLosPlanes(Model model){
           
        model.addAttribute("planes",planes.obtenerTodosLosPlanes());
        
        return "planes";
    }
    
    @RequestMapping(value = { "/Planes/nuevo"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
	Plan al = new Plan();
       
        model.addAttribute("nuevoPlan", al);
      
        
        return "nuevoPlan";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
    
    @RequestMapping(value="/Planes/nuevo",method = RequestMethod.POST)
 
    public String procesarNuevoPlan(@ModelAttribute("nuevoPlan") Plan nuevo){
               
        planes.nuevoPlan(nuevo);
        return "redirect:/Planes";
    }
       
    @RequestMapping(value="/Planes/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarPlan( @PathVariable("id") String id){
    
        Plan plan  = planes.encontrarPlanPorIdentificador(id);
        planes.eliminaPlan(plan);
        
       return "redirect:/Planes";
    
    }
}
