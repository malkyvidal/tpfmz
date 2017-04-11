/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.controllers;

import com.mis2016bd.tpfmz.modelo.Alumno;
import com.mis2016bd.tpfmz.modelo.Materia;
import com.mis2016bd.tpfmz.modelo.Materiasalumnos;
import com.mis2016bd.tpfmz.servicio.AlumnoServicio;
import com.mis2016bd.tpfmz.servicio.MateriaAlumnoServicio;
import com.mis2016bd.tpfmz.servicio.MateriaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author franco
 */

@Controller
public class MateriaAlumnoController {
    @Autowired
    private MateriaAlumnoServicio servicio;
    @Autowired
    private MateriaServicio materia;
    @Autowired
    private AlumnoServicio alumno;
    
    
    @RequestMapping("/MateriaAlumno")
    public String todasLasMateriasAlumnos(Model model){
           
        model.addAttribute("datos",servicio.obtenerTodasLasMaterias());
        
        return "materiaalumno";
    }
    
    @RequestMapping(value="/MateriaAlumno/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarAlumno( @PathVariable("id") int id){
    
        Materiasalumnos al  = servicio.encontrarMateriaAlumnoPorCodigo(id);
        servicio.eliminaMateriaAlumno(al);
        
       return "redirect:/MateriaAlumno";
    
    }
    @RequestMapping(value="/MateriaAlumno/nuevo",method = RequestMethod.GET)
    public String nuevoAlumno(Model model){
       
       Materiasalumnos al = new Materiasalumnos();
       List<Materia> materias = materia.obtenerTodasLasMaterias();
       List<Alumno> alumnos = alumno.obtenerTodosLosAlumnos();
       
       model.addAttribute("datosMaterias",materias);
       model.addAttribute("datosAlumnos",alumnos);
       model.addAttribute("nuevaMateriaAlumno", al);
      
        
       return "nuevaMateriaAlumno";
    }
    
    
    @RequestMapping(value="/MateriaAlumno/nuevo",method = RequestMethod.POST)
 
    public String procesaNuevoAlumno(@ModelAttribute("nuevaMateriaAlumno") Materiasalumnos nuevo){
      
       Materia materiaAsociada = materia.obtenerMateriaPorCodigo(nuevo.getMateria().getCodMateria());
       Alumno alumnoasociado = alumno.encontrarAlumnoPorLegajo(nuevo.getAlumno().getLegajo());
       nuevo.setAlumno(alumnoasociado);
       nuevo.setMateria(materiaAsociada);
       
       servicio.nuevaMateriaAlumno(nuevo);
       return "redirect:/MateriaAlumno";
    }
    
}
