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
import java.util.Set;
import java.util.HashSet;

public class Perfil {
 
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private int codPerfil;

    private String descripcion;

    private boolean estado;
    
    private Set<Permiso> permisos = new HashSet(0);
    private Set<Usuario> usuarios = new HashSet(0);
    
   
    public void updateUsuario(int legajo){
        /*ver deberia devolver usuario y luego actualizarlo*/
    }
     public void addPermiso(Permiso p){
        this.permisos.add(p);
    }
    public void bajaPermiso(Permiso p){
        this.permisos.remove(p);
    }
    public void updatePermiso(int cod){
        /*ver deberia devolver usuario y luego actualizarlo*/
    }

    public Perfil() {
    }

    public Perfil(int codPerfil, String descripcion, boolean estado) {
        this.codPerfil = codPerfil;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    

    public int getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(int codPerfil) {
        this.codPerfil = codPerfil;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }
   
    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }
     public Set<Usuario> getUsuarios() {
        return usuarios;
    }
     public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
