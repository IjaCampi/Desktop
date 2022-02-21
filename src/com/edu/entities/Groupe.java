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
    private int id_group;
    private String nom,description;
    public Groupe(){
}

    public Groupe(int id_group, String nom, String description) {
        this.id_group = id_group;
        this.nom = nom;
        this.description = description;
    }

    public int getId_group() {
        return id_group;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Groupe{" + "id_group=" + id_group + ", nom=" + nom + ", description=" + description + '}';
    }

}