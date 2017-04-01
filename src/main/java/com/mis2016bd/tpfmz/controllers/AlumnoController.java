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
import com.mis2016bd.tpfmz.modelo.Alumno;


import com.mis2016bd.tpfmz.servicio.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.mis2016bd.tpfmz.dtos.AlumnoDto;
/**
 *
 * @author malky
 */
@Controller
public class AlumnoController {
    
    @Autowired
    private AlumnoServicio servicio;
    
    @RequestMapping("/Alumnos")
    
    public String todoslosAlumnos(Model model){
       
        
   
        model.addAttribute("datos",servicio.obtenerTodosLosAlumnos());
        return "alumnos";
    }
    
    @RequestMapping(value="/Alumnos/nuevo",method = RequestMethod.GET)
    public String nuevoAlumno(Model model){
    
       AlumnoDto al = new AlumnoDto();
       model.addAttribute("nuevoAlumno", al);
       
        
        return "nuevoAlumno";
    }
    
    
    @RequestMapping(value="/Alumnos/nuevo",method = RequestMethod.POST)
 
    public String procesaNuevoAlumno(@ModelAttribute("nuevoAlumno") AlumnoDto nuevo){
        
       
        return "redirect:/Alumnos";
    }
    
}
