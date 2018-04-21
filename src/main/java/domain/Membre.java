/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author marine
 */
@Entity
public class Membre implements Serializable {

    @Id
    @GeneratedValue
    private Integer idMembre;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String login;
    private String password;
    private Date dateDebutCertificat;
    private boolean aPaye;
    private boolean estApte;
    private Integer niveauExpertise;
    private String numLicence;
    private Adresse adresse ;
    protected Membre(){}
    
    public Membre(Integer idMembre, String nom, String prenom, String adresseMail, String login, String password, Date dateDebutCertificat, boolean aPaye, boolean estApte, Integer niveauExpertise, String numLicence, Adresse adresse) {
        this.idMembre = idMembre;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.login = login;
        this.password = password;
        this.dateDebutCertificat = dateDebutCertificat;
        this.aPaye = aPaye;
        this.estApte = estApte;
        this.niveauExpertise = niveauExpertise;
        this.numLicence = numLicence;
        this.adresse = adresse;
    }

    public Integer getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Integer idMembre) {
        this.idMembre = idMembre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateDebutCertificat() {
        return dateDebutCertificat;
    }

    public void setDateDebutCertificat(Date dateDebutCertificat) {
        this.dateDebutCertificat = dateDebutCertificat;
    }

    public boolean isaPaye() {
        return aPaye;
    }

    public void setaPaye(boolean aPaye) {
        this.aPaye = aPaye;
    }

    public boolean isEstApte() {
        return estApte;
    }

    public void setEstApte(boolean estApte) {
        this.estApte = estApte;
    }

    public Integer getNiveauExpertise() {
        return niveauExpertise;
    }

    public void setNiveauExpertise(Integer niveauExpertise) {
        this.niveauExpertise = niveauExpertise;
    }

    public String getNumLicence() {
        return numLicence;
    }

    public void setNumLicence(String numLicence) {
        this.numLicence = numLicence;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    
    
}
