/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ACCENT W5000
 */
@Entity
public class LignesCommandedeProduit {
    @EmbeddedId
    private ProduitCommandePK pk;
    
    @ManyToOne
    @JoinColumn(name = "produit",insertable = false, updatable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "commande",insertable = false, updatable = false)
    private Commande commande;
    
    private int quantite;

    public LignesCommandedeProduit() {
    }

    public LignesCommandedeProduit(ProduitCommandePK pk, Produit produit, Commande commande, int quantite) {
        this.pk = pk;
        this.produit = produit;
        this.commande = commande;
        this.quantite = quantite;
    }

    public ProduitCommandePK getPk() {
        return pk;
    }

    public void setPk(ProduitCommandePK pk) {
        this.pk = pk;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
