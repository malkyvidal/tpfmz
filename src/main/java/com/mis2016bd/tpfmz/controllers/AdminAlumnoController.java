/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.controllers;

import com.mis2016bd.tpfmz.modelo.AdminAlumnado;
import com.mis2016bd.tpfmz.modelo.Perfil;
import com.mis2016bd.tpfmz.servicio.AdminAlumnoServicio;
import com.mis2016bd.tpfmz.servicio.PerfilServicio;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author franco
 */
@Controller
public class AdminAlumnoController {
   @Autowired
   private AdminAlumnoServicio servicio;
   @Autowired
   private PerfilServicio perfil;
   
    @InitBinder
    private void dateBinder(WebDataBinder binder) {
            
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");        
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,editor);  
    }
    
    @RequestMapping("/AdminAlumno")
    public String todoslosAlumnos(Model model){
       
        model.addAttribute("datos",servicio.obtenerTodosLosAdminAlumno());
        
        return "adminalumno";
    }
    
    @RequestMapping(value="/AdminAlumno/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarAlumno( @PathVariable("id") int id){
    
        AdminAlumnado aa = servicio.encontrarAdministradorPorLegajo(id);
        servicio.eliminarAdministrador(aa);
        
       return "redirect:/AdminAlumno";
    
    }
    
     @RequestMapping(value="/AdminAlumno/nuevo",method = RequestMethod.GET)
    public String nuevoAdminAlumno(Model model){
    
       AdminAlumnado aa = new AdminAlumnado();
       
       List<Perfil> perfiles = perfil.obtenerTodosLosPerfiles();
              
       model.addAttribute("nuevoAdminAlumno", aa);
       model.addAttribute("datosPerfiles",perfiles);
        
       return "nuevoAdminAlumno";
    }
    
    
    @RequestMapping(value="/AdminAlumno/nuevo",method = RequestMethod.POST)
    public String procesarNuevoAdminAlumno(@ModelAttribute("nuevoAdminAlumno") AdminAlumnado nuevo){
        
       servicio.nuevoAdminAlumno(nuevo);
       return "redirect:/AdminAlumno";
    }
    
     @RequestMapping(value="/AdminAlumno/update/{id}",method = RequestMethod.GET)
    public String updateAlumno(@PathVariable("id") int id, Model model){
    
       AdminAlumnado aa = servicio.encontrarAdministradorPorLegajo(id);
           
       
       List<Perfil> perfiles = perfil.obtenerTodosLosPerfiles();
       
       model.addAttribute("datosPerfiles",perfiles);
       model.addAttribute("updateAdminAlumno", aa);
      
        
        return "updateAdminAlumno";
    }
    
    
    @RequestMapping(value="/AdminAlumno/update/{id}",method = RequestMethod.POST)
 
    public String procesaUpdateAlumno(@PathVariable("id") int id, @ModelAttribute("updateAdminAlumno") AdminAlumnado nuevo){
       
       nuevo.setLegajo(id);
              
       servicio.updateAdminAlumno(nuevo);
       
       return "redirect:/AdminAlumno";
    }
    
}
