/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.camping.models;

import java.sql.Date;

/**
 *
 * @author nmedia
 */
public class Hebergeur extends Utilisateur {

    public Hebergeur() {
    }

    public Hebergeur(int num_tel, String nom, String prenom, String adresse, String login, String mdp, String role, String date_naissance) {
        super(num_tel, nom, prenom, adresse, login, mdp, role, date_naissance);
    }

    

    

    

    @Override
    public String toString() {
        return "Hebergeur{" + '}';
    }

    

    

    
    
}
