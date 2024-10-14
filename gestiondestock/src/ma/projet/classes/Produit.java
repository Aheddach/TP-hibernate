/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ACCENT W5000
 */
@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "reference")
    private String ref;
    private Double prix;


    public Produit() {
    }

    public Produit(int id, String ref, Double prix) {
        this.id = id;
        this.ref = ref;
        this.prix = prix;
    }
    @ManyToOne
    @JoinColumn(name = "categorie")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit", fetch = FetchType.EAGER)
    private List<LignesCommandedeProduit> ligneCommandedeProduits;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<LignesCommandedeProduit> getLigneCommandedeProduits() {
        return ligneCommandedeProduits;
    }

    public void setLigneCommandedeProduits(List<LignesCommandedeProduit> ligneCommandedeProduits) {
        this.ligneCommandedeProduits = ligneCommandedeProduits;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Produit(int id, String ref, Double prix, Categorie categorie) {
        this.id = id;
        this.ref = ref;
        this.prix = prix;
        this.categorie = categorie;
    }

    
    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
  
}
