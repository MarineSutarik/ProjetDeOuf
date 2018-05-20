/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.Plongee.domain.repo;

import java.util.Date;
import miage.Plongee.domains.Adresse;
import miage.Plongee.domains.Membre;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marine
 */
public interface MembreRepoCustom {
    
    public String getNombreCotisationsPrevues();
    
    public String getNombreCotisationsRegles();

}