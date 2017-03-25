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
    String telefono;
    String email;

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    char  egresado;
    private Set<Materia> materias = new HashSet<Materia>(0);
  

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
    
    public Set<Materia> getMaterias() {
	return this.materias;
	}

    public void setMaterias(Set<Materia> materias) {
	this.materias = materias;
    }
}
