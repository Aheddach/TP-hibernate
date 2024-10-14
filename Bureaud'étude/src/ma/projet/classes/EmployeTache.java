/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ACCENT W5000
 */
@Entity
public class EmployeTache {
    
    @EmbeddedId
    private EmployeTachePK pk;
    
    @ManyToOne
    @JoinColumn(name = "employe",insertable = false, updatable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "tache",insertable = false, updatable = false)
    private Tache tache;
    
    private Date dateDebutReelle;
    private Date dateFinReelle;

    public EmployeTache() {
    }

    public EmployeTache(Employe employe, Tache tache, Date dateDebutReelle, Date dateFinReelle) {
        this.employe = employe;
        this.tache = tache;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
    }



    public EmployeTache(Date dateDebutReelle, Date dateFinReelle) {
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
    }

    public EmployeTache(EmployeTachePK pk, Employe employe, Tache tache, Date dateDebutReelle, Date dateFinReelle) {
        this.pk = pk;
        this.employe = employe;
        this.tache = tache;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }
    
    
    
}
