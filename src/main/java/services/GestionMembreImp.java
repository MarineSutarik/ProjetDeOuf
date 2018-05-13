package services;

import domain.Adresse;
import domain.Enseignant;
import domain.Membre;
import domain.repo.AdresseRepo;
import domain.repo.PaiementRepo;
import exception.ExceptionMembreInexistant;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import domain.Paiement;
import domain.President;
import domain.enumeration.TypeMembre;
import domain.repo.EnseignantRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import domain.Secretaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import domain.repo.MembreRepoCustom;
import domain.repo.MembreRepo;


/**
 *
 * @author Marine
 */
@Service
public class GestionMembreImp implements GestionMembre{

  
    
    @Autowired
    private MembreRepo membres;
    
    @Autowired
    private AdresseRepo adresse;

    @Autowired
    private PaiementRepo paiement;
    
    @Autowired
    private EnseignantRepo enseignant;
    
    @Override
    public Membre creerMembre( String nom, String prenom, String adresseMail, String login, String password, Date dateDebutCertificat, Integer niveauExpertise, String numLicence,  String pays, String ville,TypeMembre type) {
        Adresse a = new Adresse( pays, ville);
        a = adresse.creerAdresse(a);
         Membre m = null;
        switch (type){
            case Membre :
                 m = new Membre(nom, prenom, adresseMail, login,password, null, null,  niveauExpertise, numLicence, a);
                 break;
            case Secretaire :
                 m = new Secretaire(nom, prenom, adresseMail, login,password, null, null,  niveauExpertise, numLicence, a);
                 break;
            case President :
                m = new President(nom, prenom, adresseMail, login,password, null, null,  niveauExpertise, numLicence, a);
                 break;
            case Enseignant :
                 m = new Enseignant(nom, prenom, adresseMail, login,password, null, null,  niveauExpertise, numLicence, a);
                 break;
                 
        }
        m  = membres.save(m);
        
        return m;
    }

    @Override
    public Membre seconnecter(String login, String password) throws ExceptionMembreInexistant {
        
        Membre m =  membres.findByLogin(login);
        if (!m.getPassword().equals(password.trim()))
            throw new ExceptionMembreInexistant();
        
        return m;
   
    }

    @Override
    public void payerCotisation(String IBAN, float somme, Membre membre) {
        Paiement p = new Paiement(IBAN,somme, membre);
        paiement.save(p);
        Membre m = membres.findByIdMembre(membre.getIdMembre());
        m.setaPaye(new Date());
        membres.save(m);
    }

    @Override
    public List<Membre> consulterCotisation() {
        ArrayList<Membre> r = new   ArrayList<Membre> ();
        for( Membre m : membres.findAll()){
            r.add(m);
        }
        return r;
    }

    @Override
    public Map<String, String> consulterStatistiques() {
    HashMap<String,String> h = new HashMap<String,String>();
    
   //nombre de membre
    String k = "nombre de membre";
    String v = membres.count()+" membres";
    h.put(k, v);
    
    //nombre d'enseignant
     k = "nombre d'enseignant";
     v = enseignant.count()+" enseignants";
    h.put(k, v);
    
    
    //nombre de cotisation prévue
     k = "nombre d'enseignant";
     v =membres.getNombreCotisationsPrevues()+" cotisations";
    h.put(k, v);
    
    
    //nombre de cotisation réglées 
     k = "nombre d'enseignant";
     v =membres.getNombreCotisationsRegles()+" cotisations";
    h.put(k, v);
    
    return h;
    }

    @Override
    public void donnerCertificat(Integer idMembre) {
        Membre m = membres.findByIdMembre(idMembre);
        m.setDateDebutCertificat(new Date());
        membres.save(m);
    }
    
}