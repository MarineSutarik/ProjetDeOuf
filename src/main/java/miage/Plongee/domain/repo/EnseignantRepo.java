/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.Plongee.domain.repo;

import miage.Plongee.domains.Enseignant;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marine
 */
public interface EnseignantRepo extends CrudRepository<Enseignant, Integer>{
    
}
