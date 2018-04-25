/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.repo;

import java.util.Date;
import modele.Adresse;
import modele.Membre;

/**
 *
 * @author Marine
 */
public interface MembreRepo {
    Membre creerMembre(Integer idMembre, String nom, String prenom, String adresseMail, String login, Date dateDebutCertificat, boolean asPaye, boolean estApte, Integer niveauExpertise, String numLicence, Adresse padresse);
}
