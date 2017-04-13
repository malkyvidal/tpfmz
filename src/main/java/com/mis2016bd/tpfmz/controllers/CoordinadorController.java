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
import com.mis2016bd.tpfmz.modelo.Coordinador;
import com.mis2016bd.tpfmz.modelo.Perfil;


import com.mis2016bd.tpfmz.servicio.CoordinadorServicio;
import com.mis2016bd.tpfmz.servicio.PerfilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ModelAttribute;


import com.mis2016bd.tpfmz.servicio.PlanServicio;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author silvina
 */
@Controller
public class CoordinadorController {
    
    @Autowired
    private CoordinadorServicio servicio;
    @Autowired
    private PerfilServicio perfil;
        
    @RequestMapping("/Coordinadores")
    
    public String todoslosCoordinadores(Model model){
       
        model.addAttribute("datos",servicio.obtenerTodosLosCoordinadores());
        
        return "coordinadores";
        
    }
     @InitBinder
    private void dateBinder(WebDataBinder binder) {
            
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");        
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,editor);  
    }
    
    @RequestMapping(value="/Coordinadores/nuevo",method = RequestMethod.GET)
    public String nuevoCoordinador(Model model){
    
       Coordinador al = new Coordinador();
       List<Perfil> perfiles = perfil.obtenerTodosLosPerfiles();
       
       
       model.addAttribute("datosPerfiles",perfiles);
       model.addAttribute("nuevoCoordinador", al);
             
       return "nuevoCoordinador";
    }
    
    
    @RequestMapping(value="/Coordinadores/nuevo",method = RequestMethod.POST)
 
    public String procesaNuevoCoordinador(@ModelAttribute("nuevoCordinador") Coordinador nuevo){        
       servicio.nuevoCoordinador(nuevo);
       return "redirect:/Coordinadores";
    }
    
    
    @RequestMapping(value="/Coordinadores/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarCoordinador( @PathVariable("id") int id){
    
        Coordinador al  = servicio.encontrarCoordinadorPorLegajo(id);
        servicio.eliminaCoordinador(al);
        
       return "redirect:/Coordinadores";
    
    }
    
    @RequestMapping(value="/Coordinadores/update/{id}",method = RequestMethod.GET)
    public String updateCoordinador(@PathVariable("id") int id, Model model){
    
       Coordinador al = servicio.encontrarCoordinadorPorLegajo(id);
        List<Perfil> perfiles = perfil.obtenerTodosLosPerfiles();
   
       model.addAttribute("datosPerfiles",perfiles);
       model.addAttribute("updateCoordinador", al);
             
       return "updateCoordinador";
    }
    
    
    @RequestMapping(value="/Coordinadores/update/{id}",method = RequestMethod.POST)
 
    public String procesaUpdateCoordinador(@PathVariable("id") int id, @ModelAttribute("updateCoordinador") Coordinador nuevo){
        nuevo.setLegajo(id);
        servicio.updateCoordinador(nuevo);
        return "redirect:/Coordinadores";
    }
    
}
