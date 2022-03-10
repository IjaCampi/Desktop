/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.entities;

/**
 *
 * @author nmedia
 */
public class Groupe {
    private int id_groupe,nbr_personnes;
    private String nom,description;
    public Groupe(){
        
    }

    public Groupe(int id_groupe, int nbr_personnes, String nom, String description) {
        this.id_groupe = id_groupe;
        this.nbr_personnes = nbr_personnes;
        this.nom = nom;
        this.description = description;
    }

    public int getId_groupe() {
        return id_groupe;
    }

    public int getNbr_personnes() {
        return nbr_personnes;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId_groupe(int id_groupe) {
        this.id_groupe = id_groupe;
    }

    public void setNbr_personnes(int nbr_personnes) {
        this.nbr_personnes = nbr_personnes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Groupe{" + "id_groupe=" + id_groupe + ", nbr_personnes=" + nbr_personnes + ", nom=" + nom + ", description=" + description + '}';
    }
    
    
}

    