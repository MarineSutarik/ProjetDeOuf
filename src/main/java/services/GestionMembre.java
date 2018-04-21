/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.util.Date;

/**
 *
 * @author squatteur
 */
public interface GestionMembre {

    /**
     *
     * @param idMembre
     * @param nom
     * @param prenom
     * @param adresseMail
     * @param login
     * @param dateDebutCertificat
     * @param asPaye
     * @param estApte
     * @param niveauExpertise
     * @param numLicence
     * @param idAdresse
     * @param pays
     * @param ville
     */
    public void creerMembre (Integer idMembre, String nom, String prenom, String adresseMail, String login, Date dateDebutCertificat, boolean asPaye, boolean estApte, Integer niveauExpertise, String numLicence,Integer idAdresse, String pays, String ville);
}
