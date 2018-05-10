/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.repo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import domain.Adresse;
import domain.Membre;
import java.util.Calendar;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marine
 */
@Repository
public class MembreRepoCustomImpl implements MembreRepoCustom {
    
    @PersistenceContext
    private EntityManager entityManager;

    //PAS SÛR DE CA ??? MAIS JE SAIS PAS COMMENT FAIRE SINON..
    @Autowired
    private MembreRepo membres;
    
    @Override
    public String getNombreCotisationsPrevues() {
        
        String query = "Select count(idMembre) from Membre where year(dateDebutCertificat) = "+Calendar.getInstance().get(Calendar.YEAR);
        String r = "";
        r = this.entityManager
                .createQuery(query)
                .getFirstResult()+"";
        return r;
    }

    @Override
    public String getNombreCotisationsRegles() {
        String query = "Select count(idMembre) from Membre where year(dateDebutCertificat) <> "+Calendar.getInstance().get(Calendar.YEAR);
        String r = "";
        r = this.entityManager
                .createQuery(query)
                .getFirstResult()+"";
        return r;  
    }
    
    @Override
    public Membre updateMembre(Integer idMembre, Membre m) {
        Membre membreActuel = this.membres.findByIdMembre(idMembre);
        
        membreActuel.setAdresse(m.getAdresse());
        membreActuel.setAdresseMail(m.getAdresseMail());
        membreActuel.setDateDebutCertificat(m.getDateDebutCertificat());
        membreActuel.setLogin(m.getLogin());
        membreActuel.setNiveauExpertise(m.getNiveauExpertise());
        membreActuel.setNom(m.getNom());
        membreActuel.setNumLicence(m.getNumLicence());
        membreActuel.setPassword(m.getPassword());
        membreActuel.setPrenom(m.getPrenom());
        membreActuel.setaPaye(m.getAPaye());
        
        return this.membres.save(m);
    }
    
    @Override
    public void deleteMembre(Integer idMembre){
        membres.delete(membres.findByIdMembre(idMembre));
    }  
}