/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.Plongee.component;
import miage.Plongee.domains.Membre;
import miage.Plongee.domain.enumeration.TypeMembre;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import miage.Plongee.services.GestionMembre;
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
        gestionMembre.creerMembre("RIGAL", "Anais", "thuglife@gourgandine.fr", "thug", "life", null, 1, "564654AD54", "France", "Sulpice", TypeMembre.President);
         gestionMembre.creerMembre("TOURNIE", "Vivien", "viv@gourgandine.fr", "viv", "life", null, 1, "564654uAD54", "France", "Toulouse", TypeMembre.Membre);
        Membre m =  gestionMembre.creerMembre("SUTARIK", "Marine", "marine@gourgandine.fr", "mar", "life", null, 1, "564u654AD54", "Slovaquie", "Nowhere", TypeMembre.Secretaire);
        gestionMembre.payerCotisation("pihjp", 30, m);
    }
}
