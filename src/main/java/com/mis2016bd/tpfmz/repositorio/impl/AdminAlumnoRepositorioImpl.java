/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.AdminAlumnado;
import com.mis2016bd.tpfmz.modelo.Usuario;
import com.mis2016bd.tpfmz.repositorio.AdminAlumnoRepositorio;
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
public class AdminAlumnoRepositorioImpl implements AdminAlumnoRepositorio{
    
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public List<AdminAlumnado> obtenerTodosLosAdminAlumno() {
       Session session = getSessionFactory().getCurrentSession();
       String hql = "FROM AdminAlumnado";
       Query query = session.createQuery(hql);
       List<AdminAlumnado> lista = query.list();
       
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
    public AdminAlumnado encontrarAdministradorPorLegajo(int id) {
        Session session = getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("from AdminAlumnado where legajo="+Integer.toString(id));
        AdminAlumnado aa = (AdminAlumnado) query.uniqueResult();
        return aa;
    }

    @Transactional
    @Override
    public void eliminarAdministrador(AdminAlumnado aa) {
        Session session = getSessionFactory().getCurrentSession();
        session.delete(aa);
    }

    @Transactional
    @Override
    public void nuevoAdminAlumno(AdminAlumnado nuevo) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(nuevo);
    }

    @Transactional
    @Override
    public void updateAdminAlumno(AdminAlumnado nuevo) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(nuevo);
    }
        
}
