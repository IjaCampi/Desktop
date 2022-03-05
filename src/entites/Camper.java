/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;

/**
 *
 * @author nmedia
 */
public class Camper extends Utilisateur {

    public Camper() {
    }

    public Camper(int id_user, int num_tel, int id_groupe, String nom, String prenom, String adresse, String login, String mdp, String role, String date_naissance) {
        super(id_user, num_tel, id_groupe, nom, prenom, adresse, login, mdp, role, date_naissance);
    }

   

    
    @Override
    public String toString() {
        return "Camper{" + '}';
    }

    

    
    
}
