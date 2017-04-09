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
    
     @RequestMapping(value="/Perfiles/eliminar/{id}",method = RequestMethod.GET)
    public String borrarPerfil(@PathVariable("id") int id, Model model){
       
       Perfil al = servicio.encontrarPerfilPorCodigoPerfil(id);
      List<Permiso> pl = servPermisos.obtenerTodosLosPermisosPorPerfil(id);
       
       int size = pl.size();
       
       model.addAttribute("cantPermisos",size);
       model.addAttribute("detallePermisos",pl);
       model.addAttribute("borrarPerfil", al);
       model.addAttribute("codPerf", id);
      
        return "borrarPerfil";
    }
    @RequestMapping(value="/Perfiles/borrar/{id}",method = RequestMethod.GET)

    public String procesaBorrarPerfil(@PathVariable("id") int id){
           
       Perfil al  = servicio.encontrarPerfilPorCodigoPerfil(id);
       int codPerf = al.getCodPerfil();
       
       List<Permiso> lista = servPermisos.obtenerTodosLosPermisosPorPerfil(codPerf);
        
       ListIterator<Permiso> it = lista.listIterator();
       while(it.hasNext()) {
         Permiso next = it.next();
         int codPerm = next.getCodPermiso();
         
         List<Modulo> listMod = servModulos.obtenerTodosLosModulosPorPermiso(codPerm);
         ListIterator<Modulo> itMod = listMod.listIterator();
         while(itMod.hasNext()) {
             Modulo nextMod = itMod.next();
             servModulos.eliminaModulo(nextMod);
         }
         servPermisos.eliminaPermiso(next);
       }
        servicio.eliminaPerfil(al);
                       
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
    
}
