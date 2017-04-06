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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.mis2016bd.tpfmz.modelo.Perfil;

import com.mis2016bd.tpfmz.servicio.PerfilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PerfilController {
    
    @Autowired
    private PerfilServicio servicio;
   
    
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
    
    
     @RequestMapping(value="/Perfiles/eliminar/{id}",method = RequestMethod.GET)
   
    public String eliminarPerfil( @PathVariable("id") int id){      
       
        Perfil al  = servicio.encontrarPerfilPorCodigoPerfil(id);
        servicio.eliminaPerfil(al);
        
       return "redirect:/Perfiles";
    
    }
    
}
