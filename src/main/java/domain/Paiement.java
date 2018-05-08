/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author allan
 */
@Entity
public class Paiement {
    @Id
    @GeneratedValue
    private Integer idPaiement ;
    private String refBancaire;
    @Column (nullable = false)
    private float montant;
    private Integer idMembre;

    public Paiement() {
    }

    public Paiement( String refBancaire, float montant, Integer idMembre) {
        
        this.refBancaire = refBancaire;
        this.montant = montant;
        this.idMembre = idMembre;
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

    public Integer getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Integer idMembre) {
        this.idMembre = idMembre;
    }
         
}
