/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.modelo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author malky
 */
public class Alumno extends Usuario{
    
      private Plan plan;
      private String telefono;
      private String email;
      private Set materiasalumnoses = new HashSet(0);

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    char  egresado;
     

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getEgresado() {
        return egresado;
    }

    public void setEgresado(char egresado) {
        this.egresado = egresado;
    }
    
    public Set getMateriasalumnoses() {
        return this.materiasalumnoses;
    }
    
    public void setMateriasalumnoses(Set materiasalumnoses) {
        this.materiasalumnoses = materiasalumnoses;
    }
}
