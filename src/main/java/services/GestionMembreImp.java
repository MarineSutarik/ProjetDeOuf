package services;

import domain.Adresse;
import domain.Membre;
import domain.repo.AdresseRepo;
import domain.repo.MembreRepo;
import domain.repo.MembreRepoCRUD;
import domain.repo.PaiementRepo;
import exception.ExceptionMembreInexistant;
import java.util.Date;
import java.util.Map;
import domain.Paiement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private MembreRepoCRUD membreCRUD;
    
    @Autowired
    private AdresseRepo adresse;

    @Autowired
    private PaiementRepo paiement;
    
    @Override
    public Membre creerMembre(Integer idMembre, String nom, String prenom, String adresseMail, String login, String password, Date dateDebutCertificat, boolean asPaye, boolean estApte, Integer niveauExpertise, String numLicence,  String pays, String ville) {
        Adresse a = new Adresse( pays, ville);
        a = adresse.creerAdresse(a);
        Membre m = new Membre(nom, prenom, adresseMail, login,password, null, null,  niveauExpertise, numLicence, a);
        m  = membreCRUD.save(m);
        
        return m;
    }

    @Override
    public Membre seconnecter(String login, String password) throws ExceptionMembreInexistant {
        
        Membre m =  membreCRUD.findByLogin(login);
        if (!m.getPassword().equals(password.trim()))
            throw new ExceptionMembreInexistant();
        
        return m;
   
    }

    @Override
    public void payerCotisation(String IBAN, float somme, Integer idMembre) {
        Paiement p = new Paiement(IBAN,somme, idMembre);
        paiement.save(p);
        Membre m = membreCRUD.findByIdMembre(idMembre);
        m.setaPaye(new Date());
        membreCRUD.save(m);
    }

    @Override
    public List<Membre> consulterCotisation() {
        ArrayList<Membre> r = new   ArrayList<Membre> ();
        for( Membre m : membreCRUD.findAll()){
            r.add(m);
        }
        return r;
    }

    @Override
    public Map<String, String> consulterStatistiques() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void donnerCertificat(Integer idMembre) {
        Membre m = membreCRUD.findByIdMembre(idMembre);
        m.setDateDebutCertificat(new Date());
        membreCRUD.save(m);
    }
     
    
    
}
