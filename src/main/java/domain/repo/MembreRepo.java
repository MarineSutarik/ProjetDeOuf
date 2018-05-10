/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.repo;

import domain.Membre;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marine
 */
public interface MembreRepo extends CrudRepository<Membre, Integer>, MembreRepoCustom{
    
    /**
     *
     * @param login
     * @return
     */
    public Membre findByLogin(String login);
    
    public Membre findByIdMembre( Integer idMembre);

}
