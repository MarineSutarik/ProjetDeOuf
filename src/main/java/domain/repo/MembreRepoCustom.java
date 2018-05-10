/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.repo;

import java.util.Date;
import domain.Adresse;
import domain.Membre;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marine
 */
public interface MembreRepoCustom {
    
    public String getNombreCotisationsPrevues();
    
    public String getNombreCotisationsRegles();

    public Membre updateMembre(Integer idMembre, Membre m);
    
    public void deleteMembre(Integer idMembre);
}
