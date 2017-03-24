/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.Materiasalumnos;
import com.mis2016bd.tpfmz.repositorio.MateriasAlumnoRepositorio;
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
public class MateriasAlumnoRepositorioImpl implements MateriasAlumnoRepositorio{
    
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public List<Materiasalumnos> obtenerTodasLasMateriasAlumno() {
      Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Materiasalumnos";
        Query query = session.createQuery(hql);
        List<Materiasalumnos> materias = query.list();
        return  materias;
        
    }
    
     @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
