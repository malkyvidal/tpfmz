/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.controllers;

import com.mis2016bd.tpfmz.modelo.AdminAlumnado;
import com.mis2016bd.tpfmz.modelo.Alumno;
import com.mis2016bd.tpfmz.modelo.Mensaje;
import com.mis2016bd.tpfmz.modelo.Usuario;
import com.mis2016bd.tpfmz.servicio.AlumnoServicio;
import com.mis2016bd.tpfmz.servicio.MensajeServicio;
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
public class MensajesController {
    
    @Autowired
    private MensajeServicio servicio;
    @Autowired
    private AlumnoServicio servicio1;
    
    @RequestMapping("/Mensajes")
    public String todoslosAlumnos(Model model){
       
        model.addAttribute("datos",servicio.obtenerTodasLosMensajes());
        
        return "mensajes";
    }
    
    @RequestMapping(value="/Mensajes/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarMensaje( @PathVariable("id") int id){
    
        Mensaje aa = servicio.encontrarMensajePorId(id);
        servicio.eliminarMensaje(aa);
        
       return "redirect:/Mensajes";
    
    }
    
    @InitBinder
    private void dateBinder(WebDataBinder binder) {
            
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");        
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,editor);  
    }
    
    @RequestMapping(value="/Mensajes/nuevo",method = RequestMethod.GET)
    public String nuevoAdminAlumno(Model model){
       
       Mensaje mensaje = new Mensaje();
              
       List<Alumno> destinatario = servicio1.obtenerTodosLosAlumnos();
              
       model.addAttribute("nuevoMensaje", mensaje);
       model.addAttribute("destinatario",destinatario);
        
       return "nuevoMensaje";
    }
    
    
    @RequestMapping(value="/Mensajes/nuevo",method = RequestMethod.POST)
    public String procesarNuevoAdminAlumno(@ModelAttribute("nuevoMensaje") Mensaje mensaje){
        
       servicio.nuevoMensaje(mensaje);
       return "redirect:/Mensajes";
    }
}
