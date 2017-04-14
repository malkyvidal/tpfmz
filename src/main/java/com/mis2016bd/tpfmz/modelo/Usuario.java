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
public class Usuario {
    int legajo;

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    
    String contrasenia;
    private Perfil perfil;


    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil p) {
        this.perfil = p;
    }
    
}
