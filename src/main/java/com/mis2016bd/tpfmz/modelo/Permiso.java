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
 * @author silvina
 */
public class Permiso {
    private int codPermiso;
    private String accion;
    private Perfil perfil;
    private Set modulos = new HashSet(0);
    
    public void addModulo(Modulo m){
        /*falta validar*/
       }
    
    public void bajaModulo(int codigo){
        /*hacer*/
    }
    
    public Modulo getModulo(int codigo){
        /*hacer*/
        Modulo m = new Modulo();
        return m;
    }

    public Permiso() {
    }

    public Permiso(int codPermiso, String accion, Perfil perfil) {
        this.codPermiso = codPermiso;
        this.accion = accion;
        this.perfil = perfil;
    }

        public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    

    public int getCodPermiso() {
        return codPermiso;
    }

    public void setCodPermiso(int codPermiso) {
        this.codPermiso = codPermiso;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    
}
