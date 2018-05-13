/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import domain.*; 
import org.springframework.web.bind.annotation.RequestParam;
import domain.repo.MembreRepo;
import services.GestionMembre;
import exception.ExceptionMembreInexistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import domain.Membre;
import domain.enumeration.TypeMembre;
import exception.ExceptionMembreInexistant;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Vivien Marine 
 */
@RestController
@RequestMapping("/api/membres")
public class MembresController {
    
    @Autowired
    private MembreRepo MembresRepo;
    
       
    @Autowired
    private GestionMembre gestionMembre;
    
    @PostMapping
    public Membre create(@RequestBody Membre m){
        return this.MembresRepo.save(m);
    }
    
    @GetMapping("/{idMembre}")
    public Membre find(@PathVariable("idMembre") Integer id) throws ExceptionMembreInexistant {
        return this.MembresRepo.findByIdMembre(id);
    }
    
    @GetMapping("/{idMembre}")
    public Membre update(@PathVariable("idMembre") Integer id, @RequestBody Membre m) throws ExceptionMembreInexistant {
        return this.MembresRepo.updateMembre(id, m);
        
    }
                
    @DeleteMapping("/{idMembre}")
    public void delete(@PathVariable("idMembre") Integer id) throws ExceptionMembreInexistant {
        this.MembresRepo.deleteMembre(id);
    }
    
      
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
     public Membre creerMembre (
             @RequestBody String nom,
             @RequestBody String prenom,
             @RequestBody String adresseMail,
            @RequestBody String login,
             @RequestBody String password,
             @RequestBody Date dateDebutCertificat,
             @RequestBody Integer niveauExpertise,
             @RequestBody String numLicence,
             @RequestBody String pays,
            @RequestBody String ville,
             @RequestBody TypeMembre type){
         return gestionMembre.creerMembre( nom, prenom, adresseMail, login, password, dateDebutCertificat, niveauExpertise, numLicence, pays, ville, type);
     }
     
       @GetMapping("/test")   
     public Integer test ( ){
         return 1;
     }    
}
