/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.Estadosmateria;
import com.mis2016bd.tpfmz.modelo.Materia;
import com.mis2016bd.tpfmz.repositorio.EstadoMateriaRepositorio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author franco
 */

@Repository
public class EstadoMateriaRepositorioImpl implements EstadoMateriaRepositorio {

     private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Estadosmateria> obtenerTodasLosEstados() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Estadosmateria";
        Query query = session.createQuery(hql);
        List<Estadosmateria> estados = query.list();
        return  estados; 
    }
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
