/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.Plan;
import com.mis2016bd.tpfmz.repositorio.PlanRepositorio;
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
public class PlanRepositorioImpl implements PlanRepositorio{
    
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public List<Plan> obtenerTodosLosPlanes() {
        Session session = sessionFactory.getCurrentSession();
            String hql = "FROM Plan";
            Query query = session.createQuery(hql);
            List<Plan> planes = query.list();
            return planes;
    }
    
    @Transactional
    @Override
    public Plan obtenerPlanPorCodigoPlan(int identificador) {
         Session session = sessionFactory.getCurrentSession();
         
         Query query = session.createQuery("FROM Plan where identificador="+Integer.toString(identificador));
         Plan plan = (Plan)query.uniqueResult();
        
         return plan;
        
       
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
    public Plan encontrarPlanPorIdentificador(int id) {
        Session session = getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("FROM Plan where identificador="+Integer.toString(id));
        Plan plan = (Plan)query.uniqueResult();
        
        return plan;
    }
    
    @Transactional
    @Override
    public void eliminarPlan(Plan plan) {
       Session session = getSessionFactory().getCurrentSession();
       session.delete(plan); 
    }
    
    @Transactional
    @Override
    public void nuevoPlan(Plan pl) {
        Session session = getSessionFactory().getCurrentSession();
        session.save(pl);
    }

    @Transactional
    @Override
    public void updatePlan(Plan nuevo) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(nuevo);
    }
    
}
