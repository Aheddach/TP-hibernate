/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LignesCommandedeProduit;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ACCENT W5000
 */
public class ProduitService implements IDao<Produit> {


    @Override
    public boolean create(Produit o) {
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
    public Produit getById(int id) {
        Session session = null;
        Produit e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Produit) session.get(Produit.class, id);
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
    public List<Produit> getAll() {
        Session session = null;
        List<Produit>  Produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Produits = session.createQuery("from Produit").list();
            session.getTransaction().commit();
            return Produits;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return Produits;
    }
        // Méthode pour afficher la liste des produits par catégorie
            public List<Produit> findProduitsByCategorie(int cateid){
        Session session=null;
        try{
           session=HibernateUtil.getSessionFactory().openSession();
           return session.createQuery("from Produit where categorie.id = :cateid").setParameter("cateid", cateid)
                    .list();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if (session != null){
                session.close();
            }
        }
    }

    // Méthode pour afficher la liste des produits commandés entre deux dates
    public List<Produit> findProduitsCommandesEntreDates(Date startDate, Date endDate) {
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery(
            "select distinct p from Produit p, Commande c where c.dateAchat between :startDate and :endDate"
        )
        .setParameter("startDate", startDate)
        .setParameter("endDate", endDate)
        .list();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        if (session != null) {
            session.close();
        }
    }
}

    // Méthode pour afficher les produits commandés dans une commande donnée
    public List<LignesCommandedeProduit> afficherProduitsParCommande(int commandeId) {
        Session session =null;
        try {
        session=HibernateUtil.getSessionFactory().openSession();
        Commande commande = (Commande) session.get(Commande.class, commandeId);
        if (commande != null) {
            return commande.getLigneCommandedeProduits();
        }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new ArrayList<>();
    }
    
    // Méthode pour afficher la liste des produits dont le prix est supérieur à 100 DH

    public List<Produit> findProduitsAvecPrixSupérieurÀ(double prix) {
        Session session = null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            return  session.createQuery("FROM Produit p WHERE p.prix > :prixMin").setParameter("prixMin", prix)
                .list();
           
        } catch (HibernateException e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return produits;
    }
}       
    