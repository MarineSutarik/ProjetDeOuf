package services;

import domain.Adresse;
import domain.Membre;
import domain.repo.AdresseRepo;
import domain.repo.MembreRepo;
import java.util.Date;
import java.util.Map;
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
    public Membre creerMembre(Integer idMembre, String nom, String prenom, String adresseMail, String login, String password, Date dateDebutCertificat, boolean asPaye, boolean estApte, Integer niveauExpertise, String numLicence,  String pays, String ville) {
        Adresse a = new Adresse( pays, ville);
        a = adresse.creerAdresse(a);
        Membre m = new Membre(nom, prenom, adresseMail, login,password, dateDebutCertificat, asPaye, estApte, niveauExpertise, numLicence, a);
        m  = membre.creerMembre(m);
        
        return m;
    }

    @Override
    public Membre seconnecter(String login, String password) {
    Membre m = membre.getByLogin(String login);
    }

    @Override
    public void payerCotisation(String IBAN, float somme, Integer idMembre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Membre, String> consulterCotisation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> consulterStatistiques() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    
    
}
