/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.LignesCommandedeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ACCENT W5000
 */
public class LignesCommandeService implements IDao<LignesCommandedeProduit>{
    
    @Override
    public boolean create(LignesCommandedeProduit o) {
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
    public LignesCommandedeProduit getById(int id) {
        Session session = null;
        LignesCommandedeProduit e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (LignesCommandedeProduit) session.get(LignesCommandedeProduit.class, id);
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
    public List<LignesCommandedeProduit> getAll() {
        Session session = null;
        List<LignesCommandedeProduit>  LignesCommandedeProduits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            LignesCommandedeProduits = session.createQuery("from LignesCommandedeProduit").list();
            session.getTransaction().commit();
            return LignesCommandedeProduits;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return LignesCommandedeProduits;
    }
    
    
}
