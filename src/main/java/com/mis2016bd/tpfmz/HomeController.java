/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz;


import com.mis2016bd.tpfmz.servicio.AlumnoServicio;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    
   @Autowired
  private AlumnoServicio servicio;
    
    @RequestMapping("/")
    public String welcome(Model model){
        
       model.addAttribute("alumnos", servicio.obtenerTodosLosAlumnos().size());
        return "welcome";
    }
}
