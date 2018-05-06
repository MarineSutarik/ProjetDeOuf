/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.util.Date;
import domain.Membre;
import exception.ExceptionMembreInexistant;
import java.util.List;
import java.util.Map;

/**
 *
 * @author squatteur
 */
public interface GestionMembre {

    /**
     * Correspond au DSS s'inscrire
     * @param idMembre
     * @param nom
     * @param prenom
     * @param adresseMail
     * @param login
     * @param password
     * @param dateDebutCertificat
     * @param asPaye
     * @param estApte
     * @param niveauExpertise
     * @param numLicence
     * @param pays
     * @param ville
     * @return 
     */
    public Membre creerMembre (Integer idMembre, String nom, String prenom, String adresseMail, String login, String password, Date dateDebutCertificat, boolean asPaye, boolean estApte, Integer niveauExpertise, String numLicence, String pays, String ville);
    
    /**
     * Permet à un utilisateur de se connecter
     * @param login
     * @param password
     * @return 
     */
    public Membre seconnecter(String login, String password) throws ExceptionMembreInexistant ;
    
    public void payerCotisation(String IBAN, float somme, Integer idMembre);
    
    /**
     *
     * @return
     */
    public Map<Membre, String> consulterCotisation ();
    
    /**
     *
     * @return
     */
    public Map <String, String> consulterStatistiques();
    
}
