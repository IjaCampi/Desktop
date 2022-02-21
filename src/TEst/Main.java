/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEst;

import Utils.DBconnection;
import com.edu.entities.Groupe;
import com.edu.entities.Utilisateur;
import java.sql.SQLException;
import services.Groupe_service;
import services.User_service;



/**
 *
 * @author nmedia
 */
public class Main {
    public static void main(String[] args)  {
        DBconnection m = DBconnection.getInstance();        
        User_service ps = new User_service();
        Groupe_service g=new Groupe_service();

        
        Utilisateur p= new Utilisateur (2 ,25478556,2, "Houssem", "jBELI","rue tunis","houssemjbeli","houssem1234","camper", "21/10/1989");

        //ps.ajouterUser(p);
        ps.rechercheParNom("Houssem");
        //ps.supprimeruser(p);
        ///Groupe g1=new Groupe(1,"webdev","c'est un group d'unfo");
        //g.ajoutergroupe(g1);
        //g.affichergroupe();
       // g.supprimergroupe(g1);
        
            
        
        
    }
   
}
    

