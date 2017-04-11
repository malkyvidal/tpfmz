/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;


import com.mis2016bd.tpfmz.modelo.Coordinador;
import com.mis2016bd.tpfmz.repositorio.CoordinadorRepositorio;
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
public class CoordinadorRepositorioImpl implements CoordinadorRepositorio{
    private SessionFactory sessionFactory;
    
     @Transactional
    @Override
    public List<Coordinador> obtenerTodosLosCoordinadores() {
       Session session = getSessionFactory().getCurrentSession();
       String hql = "FROM Coordinador";
       Query query = session.createQuery(hql);
       List<Coordinador> lista = query.list();
             
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
    public void nuevoCoordinador(Coordinador al) {
         Session session = getSessionFactory().getCurrentSession();
         session.saveOrUpdate(al);
         
    }

    @Transactional
    @Override
    public void eliminaCoordinador(Coordinador coordinador) {
        Session session = getSessionFactory().getCurrentSession();
        session.delete(coordinador);
    }

    @Transactional
    @Override
    public Coordinador encontrarCoordinadorPorLegajo(int legajo) {
        Session session = getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("from Coordinador where legajo="+Integer.toString(legajo));
        Coordinador coordinador = (Coordinador) query.uniqueResult();
        return coordinador;
    }

    
     @Transactional
    @Override
    public void updateCoordinador(Coordinador al) {
         Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from Coordinador where legajo="+Integer.toString(al.getLegajo()));
        Coordinador coordinador = (Coordinador) query.uniqueResult();
        coordinador.setCodPerfil(al.getCodPerfil());
        coordinador.setContrasenia(al.getContrasenia());
        coordinador.setNroResolucion(al.getNroResolucion());
        coordinador.setEspecialidad(al.getEspecialidad());
        coordinador.setPlan(al.getPlan());
        coordinador.setFechaAlta(al.getFechaAlta());
        coordinador.setFechaBaja(al.getFechaBaja());
     }

   
    
}
