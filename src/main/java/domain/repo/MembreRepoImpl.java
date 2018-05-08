/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.repo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import domain.Adresse;
import domain.Membre;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marine
 */
@Repository
public class MembreRepoImpl implements MembreRepo {
    private final Map<Integer, Membre> membreById = new HashMap<>();
    private Integer lastIndex = new Integer(0);

    @Override
    public Membre creerMembre(Membre m) {
        m.setIdMembre(lastIndex+1);
        lastIndex = m.getIdMembre();
        membreById.put(lastIndex, m);
        return m;
    }

  

  
    
}
