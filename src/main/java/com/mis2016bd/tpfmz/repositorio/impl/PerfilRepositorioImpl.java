/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.Perfil;
import com.mis2016bd.tpfmz.repositorio.PerfilRepositorio;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Session.LockRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.springframework.transaction.annotation.Isolation;

/**
 *
 * @author silvina
 */
@Repository
public class PerfilRepositorioImpl implements PerfilRepositorio{
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public List<Perfil> obtenerTodosLosPerfiles() {
      Session session = getSessionFactory().getCurrentSession();
       String hql = "FROM Perfil";
       Query query = session.createQuery(hql);
       List<Perfil> lista = query.list();
       return lista;
    }
    @Transactional
    @Override
    public Perfil obtenerPerfilPorCodigoPerfil(Integer codPerfil) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "From  Perfil where codPerfil=:codPerfil";
        Query query = session.createQuery(hql);
        query.setInteger("codPerfil", codPerfil);
        Perfil perfil = (Perfil) query.uniqueResult();
        return perfil;
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
    public void nuevoPerfil(Perfil al) {
         Session session = getSessionFactory().getCurrentSession();
         session.saveOrUpdate(al);
         
    }

    @Transactional
    @Override
    public void eliminaPerfil(Perfil perfil) {
        Session session = getSessionFactory().getCurrentSession();
        session.delete(perfil);
    }

    @Transactional
    @Override
    public Perfil encontrarPerfilPorCodigoPerfil(int codPerfil) {
        Session session = getSessionFactory().getCurrentSession();
        
        Query query = session.createQuery("from Perfil where codPerfil="+Integer.toString(codPerfil));
        Perfil perfil = (Perfil) query.uniqueResult();
        return perfil;
    }
    
  @Transactional
    @Override
    public void updatePerfil(Perfil al) {
       Session session = getSessionFactory().getCurrentSession();
        int g = al.getCodPerfil();
       Perfil perfil = (Perfil) session.get(Perfil.class, g, new LockOptions(LockMode.OPTIMISTIC));
//        
 perfil.setVersion(perfil.getVersion()-1);
 perfil.setCodPerfil(al.getCodPerfil());
 perfil.setDescripcion(al.getDescripcion());
for (int i = 0; i < 1000000; i++) {
          System.out.println(i);
       }
perfil.setEstado(al.getEstado());
       //  session.saveOrUpdate(al);
       
    }

    
}
