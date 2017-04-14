/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.mis2016bd.tpfmz.modelo.Plan;
import com.mis2016bd.tpfmz.modelo.Coordinador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.mis2016bd.tpfmz.servicio.PlanServicio;
import com.mis2016bd.tpfmz.servicio.CoordinadorServicio;

import java.text.SimpleDateFormat;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author franco
 */

@Controller
public class PlanController {
    
    @Autowired
    private PlanServicio planes;
     @Autowired
    private CoordinadorServicio servCoord;
    
    @RequestMapping("/Planes")
    public String todosLosPlanes(Model model){
           
        model.addAttribute("planes",planes.obtenerTodosLosPlanes());
        
        return "planes";
    }
    
     @InitBinder
    private void dateBinder(WebDataBinder binder) {
            
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");        
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,editor);  
    }
    
    @RequestMapping(value = { "/Planes/nuevo"}, method = RequestMethod.GET)
    public String nuevoPlan(ModelMap model) {
	Plan al = new Plan();
       
        model.addAttribute("nuevoPlan", al);

        return "nuevoPlan";
    }
         
    @RequestMapping(value="/Planes/nuevo",method = RequestMethod.POST)
 
    public String procesarNuevoPlan(@ModelAttribute("nuevoPlan") Plan nuevo){
        
        planes.nuevoPlan(nuevo);
        return "redirect:/Planes";
    }
       
    @RequestMapping(value="/Planes/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarPlan( @PathVariable("id") int id){
    
        Plan plan  = planes.encontrarPlanPorIdentificador(id);
        
        int codPlan = plan.getIdentificador();
         
         List<Coordinador>  listCoord = servCoord.obtenerTodosLosCoordinadoresPorPlan(codPlan);
         ListIterator<Coordinador> itCoord = listCoord.listIterator();
         while(itCoord.hasNext()) {
             Coordinador nextCoord = itCoord.next();
             servCoord.eliminaCoordinador(nextCoord);
         }
        planes.eliminaPlan(plan);
        
       return "redirect:/Planes";
    
    }
    
    @RequestMapping(value="/Planes/update/{id}",method = RequestMethod.GET)
    public String updatePlan(@PathVariable("id") int id, Model model){
                
       Plan plan = planes.encontrarPlanPorIdentificador(id);
      
       model.addAttribute("updatePlan", plan);
      
        
        return "updatePlan";
    }
    
    
    @RequestMapping(value="/Planes/update/{id}",method = RequestMethod.POST)
 
    public String procesarUpdatePlan(@PathVariable("id") int id, @ModelAttribute("updatePlan") Plan nuevo){
       nuevo.setIdentificador(id);
             
       planes.updatePlan(nuevo);
       
       return "redirect:/Planes";
    }
}
