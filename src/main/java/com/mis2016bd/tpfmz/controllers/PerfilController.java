/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author silvina
 */
package com.mis2016bd.tpfmz.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.mis2016bd.tpfmz.modelo.Perfil;
import com.mis2016bd.tpfmz.modelo.Permiso;
import com.mis2016bd.tpfmz.modelo.Modulo;

import com.mis2016bd.tpfmz.servicio.PermisoServicio;
import com.mis2016bd.tpfmz.servicio.ModuloServicio;
import com.mis2016bd.tpfmz.servicio.PerfilServicio;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PerfilController {
    
    @Autowired
    private PerfilServicio servicio;
    @Autowired
    private PermisoServicio servPermisos;
   @Autowired
    private ModuloServicio servModulos; 
   
   
    
    @RequestMapping("/Perfiles")
    
    public String todoslosPerfiles(Model model){
       
        
   
        model.addAttribute("datos",servicio.obtenerTodosLosPerfiles());
        
        return "perfiles";
    }
    
    @RequestMapping(value="/Perfiles/nuevo",method = RequestMethod.GET)
    public String nuevoPerfil(Model model){
    
       Perfil al = new Perfil();
       
      model.addAttribute("nuevoPerfil", al);
      
        
        return "nuevoPerfil";
    }
    
    
    @RequestMapping(value="/Perfiles/nuevo",method = RequestMethod.POST)
 
    public String procesaNuevoPerfil(@ModelAttribute("nuevoPerfil") Perfil nuevo){
               
        servicio.nuevoPerfil(nuevo);
        return "redirect:/Perfiles";
    }
    
     
  
      @RequestMapping(value="/Perfiles/update/{id}",method = RequestMethod.GET)
    public String updatePerfil(@PathVariable("id") int id, Model model){
    
       Perfil al = servicio.encontrarPerfilPorCodigoPerfil(id);
           
       model.addAttribute("updatePerfil", al);
             
        return "updatePerfil";
    }
    
    
    @RequestMapping(value="/Perfiles/update/{id}",method = RequestMethod.POST)
 
    public String procesaUpdatePerfil(@PathVariable("id") int id, @ModelAttribute("updatePerfil") Perfil nuevo){
        nuevo.setCodPerfil(id);
       
        servicio.updatePerfil(nuevo);
        return "redirect:/Perfiles";
    }
    
        @ExceptionHandler(Exception.class)
   public ModelAndView handleError(HttpServletRequest req, HibernateOptimisticLockingFailureException exception) {
        ModelAndView mav = new ModelAndView();
        
       mav.addObject("exception", exception);
       mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
       mav.setViewName("error");
        return mav;
}
}
