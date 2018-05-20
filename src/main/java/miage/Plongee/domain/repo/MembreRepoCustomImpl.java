/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.Plongee.domain.repo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import miage.Plongee.domains.Adresse;
import miage.Plongee.domains.Membre;
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
}