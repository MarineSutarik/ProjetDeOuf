/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.Plongee.domain.repo;

import java.util.HashMap;
import java.util.Map;
import miage.Plongee.domains.Adresse;

/**
 *
 * @author Marine
 */
public class AdresseRepoImpl implements AdresseRepo {
    private final Map<Integer, Adresse> adresseById = new HashMap<>();
    private Integer lastIndex = new Integer(0);

     
    @Override
    public Adresse creerAdresse(Adresse a) {
        lastIndex += 1;
        a.setIdAdresse(lastIndex);
        adresseById.put(lastIndex, a);
        return a;   
    }
    
}
