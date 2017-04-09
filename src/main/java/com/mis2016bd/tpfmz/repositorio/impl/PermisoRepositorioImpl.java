/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.Permiso;
import com.mis2016bd.tpfmz.repositorio.PermisoRepositorio;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author silvina
 */
@Repository
public class PermisoRepositorioImpl implements PermisoRepositorio{
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public List<Permiso> obtenerTodosLosPermisos() {
        Session session = getSessionFactory().getCurrentSession();
         String hql = "FROM Permiso";
       Query query = session.createQuery(hql);
       List<Permiso> lista = query.list();
       return lista;
    }
    @Transactional
    @Override
    public Permiso obtenerPermisoPorCodigoPermiso(Integer codPermiso) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "From  Permiso where codPermiso=:codPermiso";
        Query query = session.createQuery(hql);
        query.setInteger("codPermiso", codPermiso);
        Permiso permiso = (Permiso) query.uniqueResult();
        return permiso;
}
    
    @Transactional
    @Override
    public List<Permiso> obtenerTodosLosPermisosPorPerfil(int codPerfil) {
        Session session = getSessionFactory().getCurrentSession();
        String hql = "FROM Permiso WHERE codPerfil=" +Integer.toString(codPerfil);
       Query query = session.createQuery(hql);
       List<Permiso> permisos = query.list();
       return permisos;
    }
    
     @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
        @Transactional
    @Override
    public void nuevoPermiso(Permiso al) {
         Session session = getSessionFactory().getCurrentSession();
         session.saveOrUpdate(al);
         
    }

    @Transactional
    @Override
    public void eliminaPermiso(Permiso permiso) {
   
        Session session = getSessionFactory().getCurrentSession();
        session.delete(permiso);
    }

    @Transactional
    @Override
    public Permiso encontrarPermisoPorCodPermiso(int codPermiso) {
        Session session = getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("from Permiso where codPermiso="+Integer.toString(codPermiso));
        Permiso permiso = (Permiso) query.uniqueResult();
        return permiso;
    }
    
     @Transactional
    @Override
    public void updatePermiso(Permiso al) {
         Session session = getSessionFactory().getCurrentSession();
         session.saveOrUpdate(al);
    }


}