/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Employe;
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
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe o) {
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
    public Employe getById(int id) {
        Session session = null;
        Employe e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Employe) session.get(Employe.class, id);
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
    public List<Employe> getAll() {
        Session session = null;
        List<Employe>  Employes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Employes = session.createQuery("from Employe").list();
            session.getTransaction().commit();
            return Employes;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return Employes;
    }
    public List<Tache> getTachesRealiseesParEmploye(Employe employe) {
    Session session = null;
    List<Tache> taches = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        taches = session.createQuery("SELECT et.tache FROM EmployeTache et WHERE et.employe = :employe")
                        .setParameter("employe", employe)
                        .list();
        session.getTransaction().commit();
    } catch (HibernateException e) {
        session.getTransaction().rollback();
    } finally {
        session.close();
    }
    return taches;
    }
    
    public List<Projet> getProjetsGerésParEmploye(Employe employe) {
    Session session = null;
    List<Projet> projets = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        projets = session.createQuery("FROM Projet p WHERE p.chefDeProjet = :employe")
                         .setParameter("employe", employe)
                         .list();
        session.getTransaction().commit();
    } catch (HibernateException e) {
        session.getTransaction().rollback();
    } finally {
        session.close();
    }
    return projets;
    }
    
}
