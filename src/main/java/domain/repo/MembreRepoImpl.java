/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.repo;

import java.util.Date;
import modele.Adresse;
import modele.Membre;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marine
 */
@Service
public class MembreRepoImpl implements MembreRepo {

    @Override
    public Membre creerMembre(Integer idMembre, String nom, String prenom, String adresseMail, String login, Date dateDebutCertificat, boolean asPaye, boolean estApte, Integer niveauExpertise, String numLicence, Adresse padresse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
