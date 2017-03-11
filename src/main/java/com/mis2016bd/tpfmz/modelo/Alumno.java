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
public class Alumno extends Usuario{
    
    String telefono;
    String email;
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
    
    
}
