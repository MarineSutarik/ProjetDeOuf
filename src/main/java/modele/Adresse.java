/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author allan
 */
public class Adresse {
     
    @Id
    @GeneratedValue
    private Integer idAdresse;
    private String pays;
    private String ville;

    protected Adresse() {
    }

    public Adresse(Integer idAdresse, String pays, String ville) {
        this.idAdresse = idAdresse;
        this.pays = pays;
        this.ville = ville;
    }

    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
}
