/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Membre;
import domain.enumeration.TypeMembre;
import exception.ExceptionMembreInexistant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.GestionMembre;

/**
 *
 * @author Marine
 */
@RestController
@RequestMapping("/miage/plongee")
public class ControllerRest {
    
    @Autowired
    private GestionMembre gestionMembre;
    
    @GetMapping("/statistiques")
    public Map<String,String> getStatistiques(){
      return gestionMembre.consulterStatistiques();
    }
    
     @GetMapping("/cotisation")
    public List<Membre> getCotisation(){
      return gestionMembre.consulterCotisation();
    }
    
    @PostMapping("/certificat/{idMembre}")
    public void donnerCertificat(Integer idMembre){
       gestionMembre.donnerCertificat(idMembre);
    }
    
    @PostMapping("/cotisation")
    public void payerCotisation (@RequestParam(value="IBAN") String IBAN, 
            @RequestParam(value="somme") float somme,
            @RequestParam(value="membre") Membre membre){
        gestionMembre.payerCotisation(IBAN, somme, membre);
    }
    
    @GetMapping("/connexion")
    public Membre seconnecter (@RequestParam(value="login")String login,
            @RequestParam(value="password") String password ) throws ExceptionMembreInexistant{
        return gestionMembre.seconnecter(login,  password);
    }
    
    @GetMapping("/creation")   
     public Membre creerMembre (@RequestParam(value="idMembre") Integer idMembre,
             @RequestParam(value="nom") String nom,
             @RequestParam(value="prenom") String prenom,
             @RequestParam(value="adresseMail") String adresseMail,
             @RequestParam(value="login") String login,
             @RequestParam(value="password") String password,
             @RequestParam(value="dateDebutCertificat") Date dateDebutCertificat,
             @RequestParam(value="niveauExpertise") Integer niveauExpertise,
             @RequestParam(value="numLicence") String numLicence,
             @RequestParam(value="pays") String pays,
             @RequestParam(value="ville") String ville,
             @RequestParam(value="type") TypeMembre type){
         return gestionMembre.creerMembre(idMembre, nom, prenom, adresseMail, login, password, dateDebutCertificat, niveauExpertise, numLicence, pays, ville, type);
     }    
    
    
    
    
    
    
}
