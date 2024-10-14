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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

 
@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    public Commande() {
    }

    public Commande(int id, Date dateAchat) {
        this.id = id;
        this.dateAchat = dateAchat;
    }
    
    @OneToMany(mappedBy = "commande", fetch = FetchType.EAGER)
    private List<LignesCommandedeProduit> ligneCommandedeProduits;

  
    public int getId() {
        return id;
    }

    public List<LignesCommandedeProduit> getLigneCommandedeProduits() {
        return ligneCommandedeProduits;
    }

    public void setLigneCommandedeProduits(List<LignesCommandedeProduit> ligneCommandedeProduits) {
        this.ligneCommandedeProduits = ligneCommandedeProduits;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }
}
