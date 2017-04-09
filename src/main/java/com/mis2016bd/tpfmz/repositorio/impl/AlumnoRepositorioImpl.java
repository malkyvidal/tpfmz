/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.Alumno;
import com.mis2016bd.tpfmz.modelo.Carrera;
import com.mis2016bd.tpfmz.modelo.Materia;
import com.mis2016bd.tpfmz.modelo.Plan;
import com.mis2016bd.tpfmz.repositorio.AlumnoRepositorio;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
public class AlumnoRepositorioImpl implements AlumnoRepositorio{
    private SessionFactory sessionFactory;
    
     @Transactional
    @Override
    public List<Alumno> obtenerTodosLosAlumnos() {
       Session session = getSessionFactory().getCurrentSession();
       String hql = "FROM Alumno";
       Query query = session.createQuery(hql);
       List<Alumno> lista = query.list();
      
     
        
       return lista;
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
    public void nuevoAlumno(Alumno al) {
         Session session = getSessionFactory().getCurrentSession();
         session.saveOrUpdate(al);
         
    }

    @Transactional
    @Override
    public void eliminaAlumno(Alumno alumno) {
        Session session = getSessionFactory().getCurrentSession();
        session.delete(alumno);
    }

    @Transactional
    @Override
    public Alumno encontrarAlumnoPorLegajo(int legajo) {
        Session session = getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("from Alumno where legajo="+Integer.toString(legajo));
        Alumno alumno = (Alumno) query.uniqueResult();
        return alumno;
    }

    
     @Transactional
    @Override
    public void updateAlumno(Alumno al) {
         Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from Alumno where legajo="+Integer.toString(al.getLegajo()));
        Alumno alumno = (Alumno) query.uniqueResult();
        alumno.setCodPerfil(al.getCodPerfil());
        alumno.setContrasenia(al.getContrasenia());
        alumno.setEgresado(al.getEgresado());
        alumno.setEmail(al.getEmail());
        alumno.setPlan(al.getPlan());
        alumno.setTelefono(al.getTelefono());
    }

   
    
}
