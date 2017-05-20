/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.controllers;

import com.mis2016bd.tpfmz.modelo.Carrera;
import com.mis2016bd.tpfmz.servicio.CarreraServicio;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author franco
 */
@Controller
public class CarreraController {
    @Autowired
    private CarreraServicio servicio;
    
    private final org.apache.log4j.Logger logger = LogManager.getLogger(RestController.class.getName());
    
    @RequestMapping("/Carreras")
    public String todoslosAlumnos(Model model){
      
        model.addAttribute("datos",servicio.obtenerTodasLasCarreras());
        
        return "carreras";
    }
    
    @RequestMapping(value="/Carreras/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarCarrera( @PathVariable("id") int id){
    
        Carrera carrera  = servicio.encontrarCarreraPorCodigo(id);
        servicio.eliminaCarrera(carrera);
        return "redirect:/Carreras";
    
    }
    
    
    @RequestMapping(value="/Carreras/nuevo",method = RequestMethod.GET)
    public String nuevoAlumno(Model model){
    
       Carrera carrera = new Carrera();
              
       model.addAttribute("nuevaCarrera", carrera);
      
       return "nuevaCarrera";
    }
    
    
    @RequestMapping(value="/Carreras/nuevo",method = RequestMethod.POST)
 
    public String procesaNuevaCarrera(@ModelAttribute("nuevaCarrera") Carrera nueva){
        
            
       servicio.nuevaCarrera(nueva);
       return "redirect:/Carreras";
    }
    
    
    @RequestMapping(value="/Carreras/update/{id}",method = RequestMethod.GET)
    public String updateCarrera(@PathVariable("id") int id, Model model){
    
       Carrera carrera = servicio.encontrarCarreraPorCodigo(id);
      
       model.addAttribute("updateCarrera", carrera);
      
        
        return "updateCarrera";
    }
    
    @RequestMapping(value="/Carreras/update/{id}",method = RequestMethod.POST)
    public String procesaUpdateCarrera(@PathVariable("id") int id, @ModelAttribute("updateCarrera") Carrera nuevo){
        nuevo.setCodigoCarrera(id);
        servicio.updateCarrera(nuevo);
        return "redirect:/Carreras";
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
