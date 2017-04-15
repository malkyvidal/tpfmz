/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.controllers;

import java.util.List;
import java.util.ListIterator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.mis2016bd.tpfmz.modelo.Materia;
import com.mis2016bd.tpfmz.modelo.Carrera;
import com.mis2016bd.tpfmz.modelo.Materiasalumnos;



import com.mis2016bd.tpfmz.servicio.MateriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ModelAttribute;


import com.mis2016bd.tpfmz.servicio.CarreraServicio;
import com.mis2016bd.tpfmz.servicio.MateriaAlumnoServicio;

import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author silvina
 */
@Controller
public class MateriaController {
    
    @Autowired
    private MateriaServicio servicio;
    @Autowired
    private CarreraServicio carreras;
    @Autowired
    private MateriaAlumnoServicio matAlum;
    
    @RequestMapping("/Materias")
    
    public String todaslasMaterias(Model model){       
   
        model.addAttribute("datos",servicio.obtenerTodasLasMaterias());
        
        return "materias";
    }
    
    @RequestMapping(value="/Materias/nueva",method = RequestMethod.GET)
    public String nuevaMateria(Model model){
    
       Materia al = new Materia();
       
       List<Carrera> pl = carreras.obtenerTodasLasCarreras();
       
       model.addAttribute("datosCarrera",pl);
       model.addAttribute("nuevaMateria", al);
      
        
       return "nuevaMateria";
    }
    
    
    @RequestMapping(value="/Materias/nueva",method = RequestMethod.POST)
 
    public String procesaNuevaMateria(@ModelAttribute("nuevaMateria") Materia nueva){
        
       
       Carrera carreraAsociada = carreras.obtenerCarreraPorCodigoCarrera(nueva.getCarrera().getCodigoCarrera());
       nueva.setCarrera(carreraAsociada);
       servicio.nuevaMateria(nueva);
       return "redirect:/Materias";
    }
    
    
    @RequestMapping(value="/Materias/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarMateria( @PathVariable("id") int id){
    
       Materia al  = servicio.encontrarMateriaPorCodigo(id);
       servicio.eliminaMateria(al);
        
       return "redirect:/Materias";
    
    }
    
    @RequestMapping(value="/Materias/update/{id}",method = RequestMethod.GET)
    public String updateMateria(@PathVariable("id") int id, Model model){
    
       Materia al = servicio.encontrarMateriaPorCodigo(id);
           
       
       List<Carrera> pl = carreras.obtenerTodasLasCarreras();
       
        model.addAttribute("datosCarrera",pl);
       model.addAttribute("updateMateria", al);
      
       
        
        return "updateMateria";
    }
    
    
    @RequestMapping(value="/Materias/update/{id}",method = RequestMethod.POST)
 
    public String procesaUpdateMateria(@PathVariable("id") int id, @ModelAttribute("updateMateria") Materia nueva){
       nueva.setCodMateria(id);
       
       Carrera carreraAsociada = carreras.obtenerCarreraPorCodigoCarrera(nueva.getCarrera().getCodigoCarrera());
       nueva.setCarrera(carreraAsociada);
       servicio.updateMateria(nueva);
        return "redirect:/Materias";
    }
    
}
