/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author allan
 */
@Entity
public class Cours implements Serializable {
    @Id
    private String nomCours ;
    
    private Integer niveauCible ;
    @Id
    private Creneau creneau;
    @Id
    private Integer enseignant;
    private Participant[] participants ;

    public Cours(String nomCours, Integer niveauCible, Creneau creneau, Integer enseignant, Participant[] participants) {
        this.nomCours = nomCours;
        this.niveauCible = niveauCible;
        this.creneau = creneau;
        this.enseignant = enseignant;
        this.participants = participants;
    }

    protected Cours() {
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public Integer getNiveauCible() {
        return niveauCible;
    }

    public void setNiveauCible(Integer niveauCible) {
        this.niveauCible = niveauCible;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    public Integer getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Integer enseignant) {
        this.enseignant = enseignant;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void setParticipants(Participant[] participants) {
        this.participants = participants;
    }
    
      
     
}
