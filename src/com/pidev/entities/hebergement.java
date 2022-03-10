/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.entities;

/**
 *
 * @author asus
 */
public class hebergement {
    private int id_hebergement;
    private int id_user;
    private String nom;
    private String ville;
    private int capacite;
    private String categorie;

    public hebergement(String nom) {
        this.nom = nom;
    }

    public hebergement(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }
    private Boolean disponibilite;
    private int prix;

    @Override
    public String toString() {
        return "hebergement{" + "id_user=" + id_user + ", nom=" + nom + ", ville=" + ville + ", capacite=" + capacite + ", categorie=" + categorie + ", disponibilite=" + disponibilite + ", prix=" + prix + '}';
    }

    

    public hebergement(int id_user, String nom, String ville, int capacite, String categorie, Boolean disponibilite, int prix) {
        this.id_user = id_user;
        this.nom = nom;
        this.ville = ville;
        this.capacite = capacite;
        this.categorie = categorie;
        this.disponibilite = disponibilite;
        this.prix = prix;
    }
    
}
