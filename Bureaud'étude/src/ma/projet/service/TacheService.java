/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.Date;
import java.util.List;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ACCENT W5000
 */
public class TacheService implements IDao<Tache> {


    @Override
    public boolean create(Tache o) {
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
    public Tache getById(int id) {
        Session session = null;
        Tache e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Tache) session.get(Tache.class, id);
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
    public List<Tache> getAll() {
        Session session = null;
        List<Tache>  Taches = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Taches = session.createQuery("from Tache").list();
            session.getTransaction().commit();
            return Taches;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return Taches;
    }
    
    public List<Tache> getTachesAvecPrixSup1000() {
    Session session = null;
    List<Tache> taches = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        taches = session.getNamedQuery("Tache.findByPrixSup").list();
        session.getTransaction().commit();
    } catch (HibernateException e) {
        session.getTransaction().rollback();
    } finally {
        session.close();
    }
    return taches;
    }
    
    public List<Tache> getTachesRealiseesEntreDates(Date dateDebut, Date dateFin) {
    Session session = null;
    List<Tache> taches = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        taches = session.createQuery("FROM Tache t WHERE t.dateDebut >= :dateDebut AND t.dateFin <= :dateFin")
                        .setParameter("dateDebut", dateDebut)
                        .setParameter("dateFin", dateFin)
                        .list();
        session.getTransaction().commit();
    } catch (HibernateException e) {
        session.getTransaction().rollback();
    } finally {
        session.close();
    }
    return taches;
    }


    
}
