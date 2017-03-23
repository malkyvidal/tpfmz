/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz;


import com.mis2016bd.tpfmz.servicio.AlumnoServicio;
import com.mis2016bd.tpfmz.servicio.ModuloServicio;
import com.mis2016bd.tpfmz.servicio.PermisoServicio;
import com.mis2016bd.tpfmz.servicio.PerfilServicio;
import com.mis2016bd.tpfmz.servicio.CarreraServicio;
import com.mis2016bd.tpfmz.servicio.MateriaServicio;
import com.mis2016bd.tpfmz.servicio.PlanServicio;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    
  //@Autowired
  //private AlumnoServicio servicio;
  @Autowired
  private PlanServicio servicio1;
  //  @Autowired
  //private ModuloServicio servicio;
    // @Autowired
  //private PerfilServicio servicio;
   //@Autowired
  //private PermisoServicio servicio;

//    @Autowired
//    private CarreraServicio servicio;
//  
    //@Autowired
    //private MateriaServicio servicio;
  
    @RequestMapping("/")
    public String welcome(Model model){
      
    //model.addAttribute("alumnos", servicio.obtenerTodosLosAlumnos().size());
    model.addAttribute("plan",servicio1.obtenerTodosLosPlanes().size());
      return "welcome";
        
     // model.addAttribute("modulos", servicio.obtenerTodosLosModulos().size());
     // return "welcome";
    // model.addAttribute("permisos", servicio.obtenerTodosLosPermisos().size());
    //  return "welcome";
      //model.addAttribute("perfiles", servicio.obtenerTodosLosPerfiles().size());
     // return "welcome";
      //model.addAttribute("perfiles", servicio.obtenerPerfilPorCodigoPerfil(1).getDescripcion());
      //return "welcome";
    }
}
