/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.Plongee.services;


import java.util.Date;
import miage.Plongee.domains.Membre;
import miage.Plongee.domain.enumeration.TypeMembre;
import miage.Plongee.exception.ExceptionMembreInexistant;
import java.util.List;
import java.util.Map;

/**
 *
 * @author squatteur
 */
public interface GestionMembre {

    /**
     * Correspond au DSS s'inscrire
     * @param nom
     * @param prenom
     * @param adresseMail
     * @param login
     * @param password
     * @param dateDebutCertificat
     * @param niveauExpertise
     * @param numLicence
     * @param type
     * @param pays
     * @param ville
     * @return 
     */
    public Membre creerMembre ( String nom, String prenom, String adresseMail, String login, String password, Date dateDebutCertificat,  Integer niveauExpertise, String numLicence, String pays, String ville, TypeMembre type);
    
    public Membre updateMembre(Integer idMembre, Membre m);
    public void deleteMembre(Integer idMembre);
    
    /**
     * Permet à un utilisateur de se connecter
     * @param login
     * @param password
     * @return 
     * @throws miage.Plongee.exception.ExceptionMembreInexistant 
     */
    public Membre seconnecter(String login, String password) throws ExceptionMembreInexistant ;
    
    public void payerCotisation(String IBAN, float somme,  Membre membre);
    public void donnerCertificat(Integer idMembre);
    /**
     *
     * @return
     */
    public List<Membre>  consulterCotisation ();
    
    /**
     *
     * @return
     */
    public Map <String, String> consulterStatistiques();
    
    
}
