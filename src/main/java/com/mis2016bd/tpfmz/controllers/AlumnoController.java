/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.mis2016bd.tpfmz.modelo.Alumno;
import com.mis2016bd.tpfmz.modelo.Perfil;
import com.mis2016bd.tpfmz.modelo.Plan;
import com.mis2016bd.tpfmz.modelo.Materiasalumnos;
import com.mis2016bd.tpfmz.modelo.Mensaje;
import java.util.List;
import java.util.ListIterator;


import com.mis2016bd.tpfmz.servicio.AlumnoServicio;
import com.mis2016bd.tpfmz.servicio.PerfilServicio;
import com.mis2016bd.tpfmz.servicio.MateriaAlumnoServicio;
import com.mis2016bd.tpfmz.servicio.MensajeServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ModelAttribute;


import com.mis2016bd.tpfmz.servicio.PlanServicio;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author malky
 */
@Controller
public class AlumnoController {
    
    @Autowired
    private AlumnoServicio servicio;
    @Autowired
    private PlanServicio planes;
    @Autowired
    private PerfilServicio perfil;
    @Autowired
    private MensajeServicio mensaje;
    @Autowired
    private MateriaAlumnoServicio matAlum;
    
    @RequestMapping("/Alumnos")
    
    public String todoslosAlumnos(Model model){
       
        
   
        model.addAttribute("datos",servicio.obtenerTodosLosAlumnos());
        
        return "alumnos";
    }
    
    @RequestMapping(value="/Alumnos/nuevo",method = RequestMethod.GET)
    public String nuevoAlumno(Model model){
    
       Alumno al = new Alumno();
       
       List<Plan> pl = planes.obtenerTodosLosPlanes();
       List<Perfil> perfiles = perfil.obtenerTodosLosPerfiles();
       
       model.addAttribute("datosPlanes",pl);
       model.addAttribute("nuevoAlumno", al);
        model.addAttribute("datosPerfiles",perfiles);
        
       return "nuevoAlumno";
    }
    
    
    @RequestMapping(value="/Alumnos/nuevo",method = RequestMethod.POST)
 
    public String procesaNuevoAlumno(@ModelAttribute("nuevoAlumno") Alumno nuevo){
        
       
       Plan planAsociado = planes.obtenerPlanPorCodigoPlan(nuevo.getPlan().getIdentificador());
       nuevo.setPlan(planAsociado);
       servicio.nuevoAlumno(nuevo);
       return "redirect:/Alumnos";
    }
    
   @RequestMapping(value="/Alumnos/eliminar/{id}",method = RequestMethod.GET)
    public String borrarAlumno(@PathVariable("id") int id, Model model){
       
       Alumno al = servicio.encontrarAlumnoPorLegajo(id);
           
      List<Materiasalumnos> pl = matAlum.obtenerTodasLasMateriasAlumnosPorLegajo(id); 
       int size = pl.size();
       
       model.addAttribute("cantMatAlum",size);
       model.addAttribute("detalleMateriasAlumnos",pl);
       model.addAttribute("borrarAlumno", al);
       model.addAttribute("legajo", id);
      
        return "borrarAlumno";
    }
    
        
    @RequestMapping(value="/Alumnos/borrar/{id}",method = RequestMethod.GET)
    public String procesaBorrarAlumno(@PathVariable("id") int id){
    
        Alumno alum  = servicio.encontrarAlumnoPorLegajo(id);
        
        int legajo = alum.getLegajo();
         
        List<Materiasalumnos>  lista = matAlum.obtenerTodasLasMateriasAlumnosPorLegajo(legajo);
        ListIterator<Materiasalumnos> it = lista.listIterator();
        while(it.hasNext()) {
            Materiasalumnos next = it.next();
            matAlum.eliminaMateriaAlumno(next);
        }
        
        List<Mensaje>  lista1 = mensaje.obtenerTodosLosMensajesUsuario(id);
        ListIterator<Mensaje> it1 = lista1.listIterator();
        while(it1.hasNext()) {
            Mensaje next = it1.next();
            mensaje.eliminarMensaje(next);
        }
        
        servicio.eliminaAlumno(alum);
        
       return "redirect:/Alumnos";
    
    }
    
    @RequestMapping(value="/Alumnos/update/{id}",method = RequestMethod.GET)
    public String updateAlumno(@PathVariable("id") int id, Model model){
    
       Alumno al = servicio.encontrarAlumnoPorLegajo(id);
           
       
       List<Plan> pl = planes.obtenerTodosLosPlanes();
        List<Perfil> perfiles = perfil.obtenerTodosLosPerfiles();
       
        model.addAttribute("datosPlanes",pl);
         model.addAttribute("datosPerfiles",perfiles);
       model.addAttribute("updateAlumno", al);
      
        
        return "updateAlumno";
    }
    
    
    @RequestMapping(value="/Alumnos/update/{id}",method = RequestMethod.POST)
 
    public String procesaUpdateAlumno(@PathVariable("id") int id, @ModelAttribute("updateAlumno") Alumno nuevo){
        nuevo.setLegajo(id);
       
       Plan planAsociado = planes.obtenerPlanPorCodigoPlan(nuevo.getPlan().getIdentificador());
       nuevo.setPlan(planAsociado);
       servicio.updateAlumno(nuevo);
        return "redirect:/Alumnos";
    }
    
}
