/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.Materiasalumnos;
import com.mis2016bd.tpfmz.repositorio.MateriaAlumnoRepositorio;
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
public class MateriaAlumnoRepositorioImpl implements MateriaAlumnoRepositorio{
    
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Materiasalumnos> obtenerTodasLasMaterias() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Materiasalumnos";
        Query query = session.createQuery(hql);
        List<Materiasalumnos> materias = query.list();
        return  materias;
    }
    
    @Transactional
    @Override
    public List<Materiasalumnos> obtenerTodasLasMateriasAlumnosPorLegajo(int legajo) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Materiasalumnos where legajo="+Integer.toString(legajo);
        Query query = session.createQuery(hql);
        List<Materiasalumnos> materias = query.list();
        return  materias;
    }
  
    @Transactional
    @Override
    public List<Materiasalumnos> obtenerTodasLasMateriasAlumnosPorCodMateria(int codMateria) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Materiasalumnos where codigoMateria="+Integer.toString(codMateria);
        Query query = session.createQuery(hql);
        List<Materiasalumnos> matAlumn = query.list();
        return  matAlumn;
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
    public Materiasalumnos encontrarMateriaAlumnoPorCodigo(int id) {
        Session session = getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("from Materiasalumnos where id="+Integer.toString(id));
        Materiasalumnos al = (Materiasalumnos) query.uniqueResult();
        return al;
    }
    
    @Transactional
    @Override
    public void eliminaMateriaAlumno(Materiasalumnos al) {
        Session session = getSessionFactory().getCurrentSession();
        session.delete(al);
    }
    
    @Transactional
    @Override
    public void nuevaMateriaAlumno(Materiasalumnos nuevo) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(nuevo);
    }
   
    @Transactional
    @Override 
    public void updateMateriaAlumno(Materiasalumnos nuevo) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(nuevo);
    }
}
