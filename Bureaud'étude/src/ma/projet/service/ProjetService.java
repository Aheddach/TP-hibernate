/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ACCENT W5000
 */
public class ProjetService implements IDao<Projet> {


    @Override
    public boolean create(Projet o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public Projet getById(int id) {
        Session session = null;
        Projet e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Projet) session.get(Projet.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;
    }

    @Override
    public List<Projet> getAll() {
        Session session = null;
        List<Projet>  Projets = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Projets = session.createQuery("from Projet").list();
            session.getTransaction().commit();
            return Projets;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return Projets;
    }
    
    public List<Tache> getTachesPlanifieesPourProjet(Projet projet) {
    Session session = null;
    List<Tache> taches = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        taches = session.createQuery("FROM Tache t WHERE t.projet = :projet")
                        .setParameter("projet", projet)
                        .list();
        session.getTransaction().commit();
    } catch (HibernateException e) {
        session.getTransaction().rollback();
    } finally {
        session.close();
    }
    return taches;
    }
    
    public List<Object[]> getTachesRealiseesDansProjet(Projet projet) {
    Session session = null;
    List<Object[]> result = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        result = session.createQuery("SELECT t.id, t.nom, et.dateDebutReelle, et.dateFinReelle " +
                                     "FROM EmployeTache et JOIN et.tache t WHERE t.projet = :projet")
                        .setParameter("projet", projet)
                        .list();
        session.getTransaction().commit();
    } catch (HibernateException e) {
        session.getTransaction().rollback();
    } finally {
        session.close();
    }
    return result;
    }
}
