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
import com.mis2016bd.tpfmz.modelo.Modulo;
import com.mis2016bd.tpfmz.modelo.Permiso;


import com.mis2016bd.tpfmz.servicio.ModuloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ModelAttribute;


import com.mis2016bd.tpfmz.servicio.PermisoServicio;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author silvina
 */
@Controller
public class ModuloController {
    
    @Autowired
    private ModuloServicio servicio;
    @Autowired
    private PermisoServicio permisos;
    
    @RequestMapping("/Modulos")
    
    public String todoslosModulos(Model model){
       
        
   
        model.addAttribute("datos",servicio.obtenerTodosLosModulos());
        
        return "modulos";
    }
    
    @RequestMapping(value="/Modulos/nuevo",method = RequestMethod.GET)
    public String nuevoModulo(Model model){
    
       Modulo al = new Modulo();
       
       List<Permiso> pl = permisos.obtenerTodosLosPermisos();
       
        model.addAttribute("datosPermisos",pl);
       model.addAttribute("nuevoModulo", al);
      
        
        return "nuevoModulo";
    }
    
    
    @RequestMapping(value="/Modulos/nuevo",method = RequestMethod.POST)
 
    public String procesaNuevoModulo(@ModelAttribute("nuevoModulo") Modulo nuevo){
        
       
       Permiso permisoAsociado = permisos.obtenerPermisoPorCodigoPermiso(nuevo.getPermiso().getCodPermiso());
       nuevo.setPermiso(permisoAsociado);
       servicio.nuevoModulo(nuevo);
        return "redirect:/Modulos";
    }
    
    
     @RequestMapping(value="/Modulos/eliminar/{id}",method = RequestMethod.GET)
   
    public String eliminarModulo( @PathVariable("id") int id){
    
        
       
        Modulo al  = servicio.encontrarModuloPorCodModulo(id);
        servicio.eliminaModulo(al);
        
       return "redirect:/Modulos";
    
    }
       @RequestMapping(value="/Modulos/update/{id}",method = RequestMethod.GET)
    public String updateModulo(@PathVariable("id") int id, Model model){
    
       Modulo al = servicio.encontrarModuloPorCodModulo(id);
           
       
       List<Permiso> pl = permisos.obtenerTodosLosPermisos();
       
        model.addAttribute("datosPermisos",pl);
       model.addAttribute("updateModulo", al);
      
        
        return "updateModulo";
    }
    
    
    @RequestMapping(value="/Modulos/update/{id}",method = RequestMethod.POST)
 
    public String procesaUpdateModulo(@PathVariable("id") int id, @ModelAttribute("updateModulo") Modulo nuevo){
        nuevo.setCodModulo(id);
       
       Permiso permisoAsociado = permisos.obtenerPermisoPorCodigoPermiso(nuevo.getPermiso().getCodPermiso());
       nuevo.setPermiso(permisoAsociado);
       servicio.updateModulo(nuevo);
        return "redirect:/Modulos";
    }
    
    
}
