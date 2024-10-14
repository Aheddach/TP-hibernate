/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureaud.étude;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
//import java.util.Date;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTachePK;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author ACCENT W5000
 */
public class BureaudÉtude {

    public static void main(String[] args) {
          // HibernateUtil.getSessionFactory().openSession();
        
        // Création des services
        EmployeService employeService = new EmployeService();
        ProjetService projetService = new ProjetService();
        TacheService tacheService = new TacheService();
        
        // Création de quelques employés
        Employe emp1 = new Employe(0, "Ahmed", "Bennani", "068888");
        Employe emp2 = new Employe(0, "Ayoub", "ElMadi", "068877");
        Employe emp3 = new Employe(0, "Amine", "Ouadi", "068866");

        // Ajout des employés dans la base de données
        employeService.create(emp1);
        employeService.create(emp2);
        employeService.create(emp3);

        // Utilisation de LocalDate pour spécifier une date
        LocalDate localDateDebut = LocalDate.of(2023, 1, 1); // 1er janvier 2023
        LocalDate localDateFin = LocalDate.of(2023, 12, 31); // 31 décembre 2023

        // Conversion LocalDate en Date
    //    Date dateDebut = Date.from(localDateDebut.atStartOfDay(ZoneId.systemDefault()).toInstant());
     //   Date dateFin = Date.from(localDateFin.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Création de projets
//        Projet projet1 = new Projet(0, "Gestion de stock", dateDebut, dateFin, emp1);
//        Projet projet2 = new Projet(0, "Application Java", dateDebut, dateFin, emp2);
//
//        // Ajout des projets dans la base de données
//        projetService.create(projet1);
//        projetService.create(projet2);
//
//        // Création de tâches
//        Tache tache1 = new Tache(0, "Analyse", dateDebut, dateFin, 1500.0, projet1);
//        Tache tache2 = new Tache(0, "Développement", dateDebut, dateFin, 900.0, projet1);
//        Tache tache3 = new Tache(0, "Testing", dateDebut, dateFin, 1100.0, projet2);
//
//        // Ajout des tâches dans la base de données
//        tacheService.create(tache1);
//        tacheService.create(tache2);
//        tacheService.create(tache3);
//        
//        // Conversion LocalDate en Date
//        Date dateDebutReelle = Date.from(localDateDebut.atStartOfDay(ZoneId.systemDefault()).toInstant());
//        Date dateFinReelle = Date.from(localDateFin.atStartOfDay(ZoneId.systemDefault()).toInstant());

//        // Attribution des tâches aux employés
//        EmployeTacheService employeTacheService = new EmployeTacheService();
//        employeTacheService.create(new EmployeTache(new EmployeTachePK(emp1.getId(),tache1.getId()),emp1,tache1, dateDebutReelle, dateFinReelle));
//        employeTacheService.create(new EmployeTache(new EmployeTachePK(emp2.getId(),tache2.getId()),emp2,tache2, dateDebutReelle, dateFinReelle));
//        employeTacheService.create(new EmployeTache(new EmployeTachePK(emp3.getId(),tache3.getId()),emp3,tache3, dateDebutReelle, dateFinReelle));
//

        
 /*       // 1. Afficher les tâches réalisées par un employé (ex : emp1)
      // Récupérer un employé (par exemple, avec l'ID 1)
      Employe emp = employeService.getById(1); // Assurez-vous que cet employé existe dans la base de données
    
    if (emp1 != null) {
        // Afficher les tâches réalisées par cet employé
        System.out.println("Tâches réalisées par " + emp.getNom() + ":");
        List<Tache> tachesEmp = employeService.getTachesRealiseesParEmploye(emp);
        
        if (tachesEmp != null && !tachesEmp.isEmpty()) {
            for (Tache t : tachesEmp) {
                System.out.println("Tâche: " + t.getNom() + " | Date début : " + t.getDateDebut() + " | Date fin : " + t.getDateFin());
            }
        } else {
            System.out.println("Aucune tâche réalisée par " + emp.getNom());
        }
    } else {
        System.out.println("Employé non trouvé !");
    } */


 /*        Employe emp = employeService.getById(2); // Assurez-vous que cet employé existe dans la base de données
        // 2. Afficher les projets gérés par un employé (ex : emp1)
        if (emp != null) {
                // Afficher les projets gérés par cet employé
                System.out.println("Projets gérés par " + emp.getNom() + ":");
                List<Projet> projetsEmp = employeService.getProjetsGerésParEmploye(emp);

                if (projetsEmp != null && !projetsEmp.isEmpty()) {
                    for (Projet p : projetsEmp) {
                        System.out.println("Projet: " + p.getNom() + " | Date début : " + p.getDateDebut() + " | Date fin : " + p.getDateFin());
                    }
                } else {
                    System.out.println(emp1.getNom() + " ne gère aucun projet.");
                }
            } else {
                System.out.println("Employé non trouvé !");
            }
  */      

  /*      // 3. Afficher les tâches planifiées pour un projet (ex : projet1)
            Projet projet = projetService.getById(1); // Assurez-vous que ce projet existe dans la base de données

                if (projet != null) {
                    // Afficher les tâches planifiées pour ce projet
                    System.out.println("Tâches planifiées pour le projet: " + projet.getNom());
                    List<Tache> tachesProjet = projetService.getTachesPlanifieesPourProjet(projet);

                    if (tachesProjet != null && !tachesProjet.isEmpty()) {
                        for (Tache t : tachesProjet) {
                            System.out.println("Tâche: " + t.getNom() + " | Date début : " + t.getDateDebut() + " | Date fin : " + t.getDateFin());
                        }
                    } else {
                        System.out.println("Aucune tâche planifiée pour le projet " + projet.getNom());
                    }
                } else {
                    System.out.println("Projet non trouvé !");
                }
      */      
      /*   Projet projet = projetService.getById(1); // Assurez-vous que ce projet existe dans la base de données      
        // 4. Afficher les tâches réalisées dans un projet (ex : projet1)
        if (projet != null) {
                // Afficher les tâches réalisées dans ce projet
                System.out.println("Tâches réalisées pour le projet: " + projet.getNom());
                List<Object[]> tachesRealisees = projetService.getTachesRealiseesDansProjet(projet);

                if (tachesRealisees != null && !tachesRealisees.isEmpty()) {
                    System.out.println("Liste des tâches :");
                    System.out.println("Num | Nom | Date Début Réelle | Date Fin Réelle");
                    for (Object[] row : tachesRealisees) {
                        Integer id = (Integer) row[0];
                        String nom = (String) row[1];
                        System.out.println(id + " | " + nom + " | " + dateDebutReelle + " | " + dateFinReelle);
                    }
                } else {
                    System.out.println("Aucune tâche réalisée pour le projet " + projet.getNom());
                }
            } else {
                System.out.println("Projet non trouvé !");
            }*/

            

/*        // 5. Afficher les tâches dont le prix est supérieur à 1000 DH
        System.out.println("Tâches avec un prix supérieur à 1000 DH:");
        List<Tache> tachesPrixSup = tacheService.getTachesAvecPrixSup1000();
        for (Tache t : tachesPrixSup) {
            System.out.println(t.getNom() + " - Prix: " + t.getPrix());
       }
*/
            
        // 6. Afficher les tâches réalisées entre deux dates (exemple avec dates fictives)

        // Créer des dates pour le test
        LocalDate local1DateDebut = LocalDate.of(2023, 01, 01);
        LocalDate local2DateFin = LocalDate.of(2023, 12, 31);

        // Conversion de LocalDate en java.sql.Date
        java.sql.Date dateDebut = Date.valueOf(local1DateDebut);
        java.sql.Date dateFin = Date.valueOf(local2DateFin);
        // Tester la méthode getTachesRealiseesEntreDates
        List<Tache> taches = tacheService.getTachesRealiseesEntreDates(dateDebut, dateFin);

        // Afficher les résultats
        System.out.println("Tâches réalisées entre " + dateDebut + " et " + dateFin + ":");
        for (Tache t : taches) {
            System.out.println(t.getNom() + " (Date Début: " + t.getDateDebut() + ", Date Fin: " + t.getDateFin() + ")");
        }
    
    
    }
}
    
    

