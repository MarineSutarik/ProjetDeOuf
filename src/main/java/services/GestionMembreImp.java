package services;

import domain.Membre;
import domain.repo.MembreRepo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Marine
 */
@Service
public class GestionMembreImp implements GestionMembre{

    @Autowired
    private MembreRepo membre;

    @Override
    public modele.Membre creerMembre(Integer idMembre, String nom, String prenom, String adresseMail, String login, Date dateDebutCertificat, boolean asPaye, boolean estApte, Integer niveauExpertise, String numLicence, Integer idAdresse, String pays, String ville) {
    //TODO creer adresse, puis créer memnbre
        return null;
    
    }
     
    
    
}
