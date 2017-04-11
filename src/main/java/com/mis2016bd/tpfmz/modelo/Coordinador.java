/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.modelo;

/**
 *
 * @author malky
 */
import java.util.Date;
public class Coordinador extends Usuario{
    
   String nroResolucion;
   String especialidad;
   String plan;
    Date fechaAlta;
    Date fechaBaja;

    public String getNroResolucion() {
        return nroResolucion;
    }

    public void setNroResolucion(String nroResolucion) {
        this.nroResolucion = nroResolucion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
   
}
