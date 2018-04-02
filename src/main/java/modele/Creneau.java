/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author allan
 */
@Entity
class Creneau {
    private Date dateDebut;
    @Column (nullable = false)
    private Integer duree;

    public Creneau(Date dateDebut, Integer duree) {
        this.dateDebut = dateDebut;
        this.duree = duree;
    }

    protected Creneau() {
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }
    
    
}
