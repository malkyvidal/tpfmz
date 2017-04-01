/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.dtos;



/**
 *
 * @author malky
 */
public class AlumnoDto {
      
      private String telefono;
      private String email;
      private String idPlan;
      private Boolean egresado;
      private String contrasenia;

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public AlumnoDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(String idPlan) {
        this.idPlan = idPlan;
    }

    public Boolean getEgresado() {
        return egresado;
    }

    public void setEgresado(Boolean egresado) {
        this.egresado = egresado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
      
}
