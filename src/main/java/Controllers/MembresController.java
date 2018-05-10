/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import domain.*;
import domain.repo.MembreRepo;
import exception.ExceptionMembreInexistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vivie
 */
@RestController
@RequestMapping("/api/membres")
public class MembresController {
    
    @Autowired
    private MembreRepo MembresRepo;
    
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
}
