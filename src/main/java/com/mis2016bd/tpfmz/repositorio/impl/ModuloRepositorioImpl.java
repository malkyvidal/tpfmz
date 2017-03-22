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
    
     @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}