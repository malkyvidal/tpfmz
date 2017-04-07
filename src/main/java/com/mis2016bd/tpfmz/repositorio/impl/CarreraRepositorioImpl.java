/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.Carrera;
import com.mis2016bd.tpfmz.repositorio.CarreraRepositorio;
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
public class CarreraRepositorioImpl implements CarreraRepositorio{
 private SessionFactory sessionFactory;
 
    @Transactional
    @Override
    public List<Carrera> obtenerTodasLasCarreras() {
            Session session = sessionFactory.getCurrentSession();
            String hql = "FROM Carrera";
            Query query = session.createQuery(hql);
            List<Carrera> carreras = query.list();
            return carreras;
    }

    @Transactional
    @Override
    public Carrera obtenerCarreraPorCodigoCarrera(Integer codigoCarrera) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "From  Carrera where codigoCarrera=:codigoCarrera";
        Query query = session.createQuery(hql);
        query.setInteger("codigoCarrera", codigoCarrera);
        Carrera carrera = (Carrera) query.uniqueResult();
        return carrera;
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
    public Carrera encontrarCarreraPorCodigo(int id) {
        Session session = getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("from Carrera where codigoCarrera="+Integer.toString(id));
        Carrera carrera = (Carrera) query.uniqueResult();
        return carrera;
    }
    
    @Transactional
    @Override
    public void eliminarCarrera(Carrera carrera) {
        Session session = getSessionFactory().getCurrentSession();
        session.delete(carrera);
    }
    
    @Transactional
    @Override
    public void nuevaCarrera(Carrera nueva) {
        Session session = getSessionFactory().getCurrentSession();
         session.saveOrUpdate(nueva);
    }
    
    @Transactional
    @Override
    public void updateCarrera(Carrera al) {
        Session session = getSessionFactory().getCurrentSession();
        String hql = "From  Carrera where codigoCarrera=:codigoCarrera";
        Query query = session.createQuery(hql);
        query.setInteger("codigoCarrera", al.getCodigoCarrera());
        Carrera carrera = (Carrera) query.uniqueResult();
        carrera.setCanNivel(al.getCanNivel());
        carrera.setNombre(al.getNombre());
    }
    
}
