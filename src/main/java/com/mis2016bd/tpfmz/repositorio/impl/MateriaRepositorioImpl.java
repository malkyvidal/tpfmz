/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis2016bd.tpfmz.repositorio.impl;

import com.mis2016bd.tpfmz.modelo.Materia;
import com.mis2016bd.tpfmz.repositorio.MateriaRepositorio;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Session.LockRequest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author malky
 */
@Repository
public class MateriaRepositorioImpl implements MateriaRepositorio {

    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Materia> obtenerTodasLasMaterias() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Materia";
        Query query = session.createQuery(hql);
        List<Materia> lista = query.list();
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
    public Materia encontrarMateriaPorCodigo(int id) {
        Session session = getSessionFactory().getCurrentSession();

        Query query = session.createQuery("from Materia where codMateria=" + Integer.toString(id));
        Materia materia = (Materia) query.uniqueResult();
        return materia;
    }

    @Transactional
    @Override
    public Materia obtenerMateriaPorCodigo(int codMateria) {
        Session session = getSessionFactory().getCurrentSession();

        Query query = session.createQuery("from Materia where codMateria=" + Integer.toString(codMateria));
        Materia materia = (Materia) query.uniqueResult();
        return materia;
    }

    @Transactional
    @Override
    public void nuevaMateria(Materia al) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(al);

    }

    @Transactional
    @Override
    public void eliminaMateria(Materia materia) {
        Session session = getSessionFactory().getCurrentSession();
        session.delete(materia);
    }

    @Transactional
    @Override
    public void updateMateria(Materia al) {

        Session session = getSessionFactory().getCurrentSession();

//        Query query = session.createQuery("from Materia where codMateria="+Integer.toString(al.getCodMateria()));
//        Materia materia = (Materia) query.uniqueResult();
        int g = al.getCodMateria();
        Materia materia = (Materia) session.get(Materia.class, g, new LockOptions(LockMode.OPTIMISTIC));
//        
        //session.evict(materia);
       materia.setVersion(materia.getVersion()-1);
                
        materia.setCodMateria(al.getCodMateria());
        materia.setCarrera(al.getCarrera());
       
        materia.setNombreMateria(al.getNombreMateria());
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
        }
        materia.setModalidad(al.getModalidad());
        

    }

}
