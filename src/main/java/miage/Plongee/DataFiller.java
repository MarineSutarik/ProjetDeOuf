/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.Plongee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import services.GestionMembre;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Pour remplir la BD
 * @author marin
 */
@Component
public class DataFiller implements CommandLineRunner{
     @Autowired
     GestionMembre gestionMembre;
     
     @Override
    @Transactional
    public void run(String... strings) throws Exception {
    }
}
