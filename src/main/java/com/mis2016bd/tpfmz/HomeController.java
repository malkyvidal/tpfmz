/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz;


import com.mis2016bd.tpfmz.servicio.AlumnoServicio;
import com.mis2016bd.tpfmz.servicio.CarreraServicio;
import com.mis2016bd.tpfmz.servicio.MateriaServicio;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    
//   @Autowired
//  private AlumnoServicio servicio;
//    
//    @Autowired
//    private CarreraServicio servicio;
//  
    @Autowired
    private MateriaServicio servicio;
    
    @RequestMapping("/")
    public String welcome(Model model){
//        
      model.addAttribute("alumnos", servicio.obtenerTodasLasMaterias().size());
        return "welcome";
    }
}
