/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;


import com.mis2016bd.tpfmz.modelo.Modulo;
import com.mis2016bd.tpfmz.repositorio.ModuloRepositorio;
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
public class ModuloRepositorioImpl implements ModuloRepositorio{
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public List<Modulo> obtenerTodosLosModulos() {
        Session session = getSessionFactory().getCurrentSession();
         String hql = "FROM Modulo";
       Query query = session.createQuery(hql);
       List<Modulo> modulos = query.list();
       return modulos;
    }
    @Transactional
    @Override
    public List<Modulo> obtenerTodosLosModulosPorPermiso(int codPermiso) {
        Session session = getSessionFactory().getCurrentSession();
        String hql = "FROM Modulo WHERE codPermiso=" +Integer.toString(codPermiso);
       Query query = session.createQuery(hql);
       List<Modulo> modulos = query.list();
       return modulos;
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
    public void nuevoModulo(Modulo al) {
         Session session = getSessionFactory().getCurrentSession();
         session.saveOrUpdate(al);
         
    }

    @Transactional
    @Override
    public void eliminaModulo(Modulo modulo) {
        Session session = getSessionFactory().getCurrentSession();
        session.delete(modulo);
    }

    @Transactional
    @Override
    public Modulo encontrarModuloPorCodModulo(int codModulo) {
        Session session = getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("from Modulo where codModulo="+Integer.toString(codModulo));
        Modulo modulo = (Modulo) query.uniqueResult();
        return modulo;
    }
    
     @Transactional
    @Override
    public void updateModulo(Modulo al) {
         Session session = getSessionFactory().getCurrentSession();
         session.saveOrUpdate(al);
    }


}