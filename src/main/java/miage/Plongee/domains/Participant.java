/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.Plongee.domains;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author allan
 */
@Entity
@Document
class Participant implements Serializable {
    @Id
    private Integer idMembre;
    private String nom;
    private String prenom; 

    public Integer getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Integer idMembre) {
        this.idMembre = idMembre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Participant(Integer idMembre, String nom, String prenom) {
        this.idMembre = idMembre;
        this.nom = nom;
        this.prenom = prenom;
    }

    protected Participant() {
    }
    
    
}
