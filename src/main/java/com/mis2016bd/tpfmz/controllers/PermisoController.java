/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.mis2016bd.tpfmz.modelo.Permiso;
import com.mis2016bd.tpfmz.modelo.Perfil;
import com.mis2016bd.tpfmz.modelo.Modulo;
import com.mis2016bd.tpfmz.servicio.ModuloServicio;

import com.mis2016bd.tpfmz.servicio.PermisoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ModelAttribute;


import com.mis2016bd.tpfmz.servicio.PerfilServicio;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author silvina
 */
@Controller
public class PermisoController {
        
    @Autowired
    private PermisoServicio servicio;
    @Autowired
    private PerfilServicio perfiles;
     @Autowired
    private ModuloServicio servModulos;
    
    @RequestMapping("/Permisos")
    
    public String todoslosPermisos(Model model){
       
        
   
        model.addAttribute("datos",servicio.obtenerTodosLosPermisos());
        
        return "permisos";
    }
    
    @RequestMapping(value="/Permisos/nuevo",method = RequestMethod.GET)
    public String nuevoPermiso(Model model){
    
       Permiso al = new Permiso();
       
       List<Perfil> pl = perfiles.obtenerTodosLosPerfiles();
       
        model.addAttribute("datosPerfiles",pl);
       model.addAttribute("nuevoPermiso", al);
      
        
        return "nuevoPermiso";
    }
    
    
    @RequestMapping(value="/Permisos/nuevo",method = RequestMethod.POST)
 
    public String procesaNuevoPermiso(@ModelAttribute("nuevoPermiso") Permiso nuevo){
        
       
       Perfil perfilAsociado = perfiles.obtenerPerfilPorCodigoPerfil(nuevo.getPerfil().getCodPerfil());
       nuevo.setPerfil(perfilAsociado);
       servicio.nuevoPermiso(nuevo);
        return "redirect:/Permisos";
    }
    
    
    @RequestMapping(value="/Permisos/eliminar/{id}",method = RequestMethod.GET)
    public String borrarPermiso(@PathVariable("id") int id, Model model){
       
       Permiso al = servicio.encontrarPermisoPorCodPermiso(id);
       List<Modulo> pl = servModulos.obtenerTodosLosModulosPorPermiso(id);
       int size = pl.size();
       
       model.addAttribute("cantModulos",size);
       model.addAttribute("detalleModulos",pl);
       model.addAttribute("borrarPermiso", al);
       model.addAttribute("codPermi", id);
      
        return "borrarPermiso";
    }
    
        
     @RequestMapping(value="/Permisos/borrar/{id}",method = RequestMethod.GET)

    public String procesaBorrarPermiso(@PathVariable("id") int id){
           
       Permiso al  = servicio.encontrarPermisoPorCodPermiso(id);
       int codPerm = al.getCodPermiso();
       
       List<Modulo> lista = servModulos.obtenerTodosLosModulosPorPermiso(codPerm);
        
       ListIterator<Modulo> it = lista.listIterator();
       while(it.hasNext()) {
         Modulo next = it.next();
         servModulos.eliminaModulo(next);
       }
        servicio.eliminaPermiso(al);
                       
      return "redirect:/Permisos";
    
    }
        
    @RequestMapping(value="/Permisos/update/{id}",method = RequestMethod.GET)
    public String updatePermiso(@PathVariable("id") int id, Model model){
    
       Permiso al = servicio.encontrarPermisoPorCodPermiso(id);
                  
       List<Perfil> pl = perfiles.obtenerTodosLosPerfiles();
       
        model.addAttribute("datosPerfiles",pl);
       model.addAttribute("updatePermiso", al);
      
        
        return "updatePermiso";
    }
    
    
    @RequestMapping(value="/Permisos/update/{id}",method = RequestMethod.POST)
 
    public String procesaUpdatePermiso(@PathVariable("id") int id, @ModelAttribute("updatePermiso") Permiso nuevo){
        nuevo.setCodPermiso(id);
       
       Perfil perfilAsociado = perfiles.obtenerPerfilPorCodigoPerfil(nuevo.getPerfil().getCodPerfil());
       nuevo.setPerfil(perfilAsociado);
       servicio.updatePermiso(nuevo);
        return "redirect:/Permisos";
    }
    
 
}
