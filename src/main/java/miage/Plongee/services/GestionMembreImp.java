package miage.Plongee.services;

import miage.Plongee.domains.Adresse;
import miage.Plongee.domains.Enseignant;
import miage.Plongee.domains.Membre;
import miage.Plongee.domain.repo.AdresseRepo;
import miage.Plongee.domain.repo.PaiementRepo;
import miage.Plongee.exception.ExceptionMembreInexistant;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import miage.Plongee.domains.Paiement;
import miage.Plongee.domains.President;
import miage.Plongee.domain.enumeration.TypeMembre;
import miage.Plongee.domain.repo.EnseignantRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import miage.Plongee.domains.Secretaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import miage.Plongee.domain.repo.MembreRepoCustom;
import miage.Plongee.domain.repo.MembreRepo;


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