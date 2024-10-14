/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondestock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LignesCommandedeProduit;
import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LignesCommandeService;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import ma.projet.classes.ProduitCommandePK;

/**
 *
 * @author ACCENT W5000
 */
public class Gestiondestock {
    public static void main(String[] args) {
//       HibernateUtil.getSessionFactory().openSession();
          ProduitService ps = new ProduitService();
          CategorieService cs = new CategorieService();
          CommandeService cms = new CommandeService();
         // Création de quelques catégories
        Categorie c1 = new Categorie(0, "CAT001", "téléphones");
        Categorie c2 = new Categorie(0, "CAT002", "ordinateurs");
        Categorie c3 = new Categorie(0, "CAT003", "tablets");
        // Ajout des catégories dans la base de données
        cs.create(c1);
        cs.create(c2);
        cs.create(c3);
        // Récupération des catégories depuis la base de données pour assigner aux produits
        Categorie categorieTelephone = cs.getById(c1.getId());
        Categorie categorieOrdinateurs = cs.getById(c2.getId());
        Categorie categorieTablets = cs.getById(c3.getId());
        // Création de quelques produits en fonction des catégories
        Produit p1 = new Produit(0, "PROD001", 1500.0, categorieTablets);  // Produit électronique
        Produit p2 = new Produit(0, "PROD002", 500.0, categorieTelephone);      // Produit vêtements
        Produit p3 = new Produit(0, "PROD003", 2000.0, categorieOrdinateurs);     
        // Ajout des catégories dans la base de données
        ps.create(p1);
        ps.create(p2);
        ps.create(p3);  
        
//        // Récupérer et afficher tous les produits
//        System.out.println("\nListe des produits :");
//        List<Produit> produits = ps.getAll();
//        for (Produit produit : produits) {
//            System.out.println("ID: " + produit.getId()  +  ", Référence: " + produit.getRef() + ", Prix: " + produit.getPrix());
//        }
//
//        //Récupérer et afficher le produit avec ID 2
//        System.out.println("\nProduit avec ID 2 :");
//        Produit produitById = ps.getById(2);
//        if (produitById != null) {
//            System.out.println("ID: " + produitById.getId() + ", Référence: " + produitById.getRef() + ", Prix: " + produitById.getPrix());
//        } else {
//            System.out.println("Produit avec ID 2 non trouvé.");
//        }    
//        
//        
//        // Tester la récupération des produits par catégorie
//              // Récupérer une catégorie par son ID pour tester
//        int cateid = 1;  // Remplacez '1' par l'ID de la catégorie que vous voulez tester
//        Categorie categorieTest = cs.getById(cateid);
//
//        if (categorieTest != null) {
//            // Appel à la méthode pour récupérer les produits par catégorie
//            List<Produit> produits = ps.findProduitsByCategorie(cateid);
//
//            // Vérification et affichage des résultats
//            if (produits != null && !produits.isEmpty()) {
//                System.out.println("Produits trouvés dans la catégorie " + categorieTest.getLibelle() + " :");
//                for (Produit produit : produits) {
//                    System.out.println("Référence : " + produit.getRef() + ", Prix : " + produit.getPrix());
//                }
//            } else {
//                System.out.println("Aucun produit trouvé dans cette catégorie.");
//            }
//        } else {
//            System.out.println("Catégorie avec l'ID " + cateid + " n'existe pas.");
//        }
//          
    // Appeler la méthode pour récupérer les produits commandés entre ces dates
         // Création de quelques commandes
        Commande cmd1 = new Commande(0, new Date());
        Commande cmd2 = new Commande(0, new Date());
        Commande cmd3 =  new Commande(0, new Date());
        
        cms.create(cmd1);
        cms.create(cmd2);
        cms.create(cmd3);

//    // Créer un format de date pour les tests
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            // Définir les dates de début et de fin pour le test
//            Date startDate = sdf.parse("2024-10-13");
//            Date endDate = sdf.parse("2024-10-20");
//
//            // Appeler la méthode findProduitsCommandesEntreDates
//            List<Produit> produitsCommandes = ps.findProduitsCommandesEntreDates(startDate, endDate);
//
//            // Tester si des produits ont été commandés entre les dates spécifiées
//            if (produitsCommandes != null && !produitsCommandes.isEmpty()) {
//                System.out.println("Produits commandés entre " + startDate + " et " + endDate + " :");
//                for (Produit produit : produitsCommandes) {
//                    System.out.println("Produit : Référence - " + produit.getRef() + ", Prix - " + produit.getPrix());
//                }
//            } else {
//                System.out.println("Aucun produit commandé entre ces dates.");
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    
//        
//       // Création de lignes de commande
//        LignesCommandeService ls = new LignesCommandeService();
//        
//        ls.create(new LignesCommandedeProduit(new ProduitCommandePK(p1.getId(), cmd1.getId()), p1, cmd1, 10));
//        ls.create(new LignesCommandedeProduit(new ProduitCommandePK(p2.getId(), cmd2.getId()), p2, cmd2, 20));
//        ls.create(new LignesCommandedeProduit(new ProduitCommandePK(p3.getId(), cmd3.getId()), p3, cmd3, 10));
//
//        // Tester la récupération des produits dans une commande donnée
//        List<LignesCommandedeProduit> lignesCommandes = ps.afficherProduitsParCommande(1);
//        
//        if (lignesCommandes != null && !lignesCommandes.isEmpty()) {
//            for (LignesCommandedeProduit ligne : lignesCommandes) {
//                Produit produit = ligne.getProduit();
//                System.out.println("Produit dans commande : Référence - " + produit.getRef() + ", Quantité - " + ligne.getQuantite());
//            }
//        } else {
//            System.out.println("Aucun produit trouvé pour cette commande.");
//        }
//        
            
       // Tester la récupération des produits dont le prix est supérieur à 100 DH
        List<Produit> produits = ps.findProduitsAvecPrixSupérieurÀ(100.0);
        
        if (produits != null && !produits.isEmpty()) {
        {
            for (Produit produit : produits) {
                System.out.println("Produit : Référence - " + produit.getRef() + ", Prix - " + produit.getPrix());
            }
            /*        } else {
                 System.out.println("Aucun produit trouvé avec un prix supérieur à 100 DH.");*/
        }
        }
    }
}

    
            
  


   

 
    

