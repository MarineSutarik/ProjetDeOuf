/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
    private Integer refBancaire;
    @Column (nullable = false)
    private float montant;
    private Integer idMembre;

    public Paiement() {
    }

    public Paiement(Integer idPaiement, Integer refBancaire, float montant, Integer idMembre) {
        this.idPaiement = idPaiement;
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

    public Integer getRefBancaire() {
        return refBancaire;
    }

    public void setRefBancaire(Integer refBancaire) {
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
