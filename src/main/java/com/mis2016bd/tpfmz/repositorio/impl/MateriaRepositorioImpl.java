/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.Alumno;
import com.mis2016bd.tpfmz.modelo.Materia;
import com.mis2016bd.tpfmz.repositorio.MateriaRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author malky
 */

@Repository
public class MateriaRepositorioImpl implements MateriaRepositorio{

    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Materia> obtenerTodasLasMaterias() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Materia";
        Query query = session.createQuery(hql);
        List<Materia> materias = query.list();
        return  materias;
        
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
    public Materia encontrarMateriaPorCodigo(int id) {
        Session session = getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("from Materia where codMateria="+Integer.toString(id));
        Materia materia = (Materia) query.uniqueResult();
        return materia;
    }

           
}
