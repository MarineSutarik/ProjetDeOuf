/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.repo;

import domain.Enseignant;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marine
 */
public interface EnseignantRepo extends CrudRepository<Enseignant, Integer>{
    
}
