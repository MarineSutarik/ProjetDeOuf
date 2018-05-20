/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.Plongee.domains;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author allan
 */
@Entity
@Table(name = "Paiement")
public class Paiement implements Serializable {
    @Id
    @GeneratedValue
    private Integer idPaiement ;
    private String refBancaire;
    @Column (nullable = false)
    private float montant;
    @ManyToOne
    private Membre membre;

    public Paiement() {
    }

    public Paiement( String refBancaire, float montant, Membre membre) {
        
        this.refBancaire = refBancaire;
        this.montant = montant;
        this.membre = membre;
    }

    public Integer getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(Integer idPaiement) {
        this.idPaiement = idPaiement;
    }

    public String getRefBancaire() {
        return refBancaire;
    }

    public void setRefBancaire(String refBancaire) {
        this.refBancaire = refBancaire;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }
         
}
