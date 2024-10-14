/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ACCENT W5000
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Tache.findByPrixSup", 
                query = "FROM Tache t WHERE t.prix > 1000")
})
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private Double prix;

    public Tache() {
    }

    public Tache(int id, String nom, Date dateDebut, Date dateFin, Double prix) {
        this.id = id;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
    }
    
    @ManyToOne
    @JoinColumn(name = "projet")
    private Projet projet;
    
    @OneToMany(mappedBy = "tache", fetch = FetchType.EAGER)
    private List<EmployeTache> EmployeTaches;

    public Tache(int id, String nom, Date dateDebut, Date dateFin, Double prix, Projet projet) {
        this.id = id;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.projet = projet;
    }

    public Tache(int id, String nom, Date dateDebut, Date dateFin, Double prix, Projet projet, List<EmployeTache> EmployeTaches) {
        this.id = id;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.projet = projet;
        this.EmployeTaches = EmployeTaches;
    }
    



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<EmployeTache> getEmployeTaches() {
        return EmployeTaches;
    }

    public void setEmployeTaches(List<EmployeTache> EmployeTaches) {
        this.EmployeTaches = EmployeTaches;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
    
    
}
