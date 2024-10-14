/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h1;

import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import static org.hibernate.criterion.Restrictions.le;

/**
 *
 * @author ACCENT W5000
 */
public class H1 {
    public static void main(String[] args) {
//        HibernateUtil.getSessionFactory().openSession();
        
          ProduitService ps = new ProduitService();
//        // Créer cinq produits
//        ps.create(new Produit( "Porche", "RefA", new Date(), 1200000000.0, "Produit A"));
//        ps.create(new Produit( "McLaren", "RefB", new Date(), 800000000.0, "Produit B"));
//        ps.create(new Produit( "Pagani", "RefC", new Date(), 150000000.0, "Produit C"));
//        ps.create(new Produit( "Bentely", "RefD", new Date(), 90000000000.0, "Produit D"));
//        ps.create(new Produit( "AstonMartin", "RefE", new Date(), 20000000000.0, "Produit E"));
//        
//        // Afficher la liste des produits
//        List<Produit> produits = ps.findAll();
//        for (Produit p : produits) {
//            System.out.println("ID: " + p.getId() + ", Marque: " + p.getMarque() + ", Prix: " + p.getPrix());
//        }
//        
//        // Afficher les informations du produit dont id = 2
//        Produit produit2 = ps.findById(2);
//        if (produit2 != null) {
//            System.out.println("Informations du produit avec id=2 :");
//            System.out.println("Marque: " + produit2.getMarque() + ", Prix: " + produit2.getPrix());
//        } else {
//            System.out.println("Produit avec ID 2 non trouvé.");
//        }
//        // Supprimer le produit dont id = 3
//          ps.delete(ps.findById(3));
//          System.out.println("Produit avec id=3 est supprimé.");
//        // Modifier les informations du produit dont id = 1
//            Produit produit1 = ps.findById(1);
//            if (produit1 != null) {
//                produit1.setMarque("Mercedes");
//                produit1.setPrix(130000000.0);
//                ps.update(produit1);
//                System.out.println("Produit avec id=1 est modifié.");
//            } else {
//                System.out.println("Produit avec id=1 est non trouvé.");
//            }
//          // Afficher la liste des produits dont le prix est supérieur à 100 DH
//                System.out.println("les produits dont le prix est supérieur à 130000000 DH :");
//                for (Produit p : produits) {
//                    if (p.getPrix() > 130000000.0) {
//                        System.out.println("ID: " + p.getId() + ", Marque: " + p.getMarque() + ", Prix: " + p.getPrix());
//                    }
//        //  Afficher la liste des produits commandés entre deux dates
                List<Produit> produits = ps.findAll();

                Scanner scanner = new Scanner(System.in);
                System.out.println("Entrez la date de début (jj/MM/yyyy) : ");
                String dateDebutStr = scanner.nextLine();
                System.out.println("Entrez la date de fin (jj/MM/yyyy) : ");
                String dateFinStr = scanner.nextLine();

        
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date dateDebut = dateFormat.parse(dateDebutStr);
                    Date dateFin = dateFormat.parse(dateFinStr);

                    System.out.println("Produits commandés entre " + dateDebutStr + " et " + dateFinStr + " :");
                    for (Produit p : produits) {
                        if (!p.getDateAchat().before(dateDebut) && !p.getDateAchat().after(dateFin)) {
                            System.out.println("ID: " + p.getId() + ", Marque: " + p.getMarque() + ", Prix: " + p.getPrix());
                        }
                    }
                } catch (ParseException e) {
                    System.out.println("Erreur de format de date.");
                } finally {
                    scanner.close();
                }
                }           
    }

    

