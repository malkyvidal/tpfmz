/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.modelo;

/**
 *
 * @author silvina
 */
public class Modulo {
    private int codModulo;
    private String descripcion;
    private Permiso permiso;

    public Modulo() {
    }

    public Modulo(int codModulo, String descripcion, Permiso permiso) {
        this.codModulo = codModulo;
        this.descripcion = descripcion;
        this.permiso = permiso;
    }

    public int getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(int codModulo) {
        this.codModulo = codModulo;
    }

        public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
 
    
}