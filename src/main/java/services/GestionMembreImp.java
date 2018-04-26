package services;

import domain.Adresse;
import domain.Membre;
import domain.repo.AdresseRepo;
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
    
    @Autowired
    private AdresseRepo adresse;

    @Override
    public Membre creerMembre(Integer idMembre, String nom, String prenom, String adresseMail, String login, String password, Date dateDebutCertificat, boolean asPaye, boolean estApte, Integer niveauExpertise, String numLicence, Integer idAdresse, String pays, String ville) {
        Adresse a = new Adresse( pays, ville);
        a = adresse.creerAdresse(a);
        Membre m = new Membre(nom, prenom, adresseMail, login,password, dateDebutCertificat, asPaye, estApte, niveauExpertise, numLicence, a);
        m  = membre.creerMembre(m);
        
        return m;
    }
     
    
    
}
