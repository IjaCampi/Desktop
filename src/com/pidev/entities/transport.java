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
public class transport {
    private int id_transport;
    private int id_user;
    private String type;
    private String matricule;
    private String marcule;
    
    private int nbr_place;

    public transport(int id_user, String type, String matricule, String marcule, int nbr_place) {
        this.id_user = id_user;
        this.type = type;
        this.matricule = matricule;
        this.marcule = marcule;
        this.nbr_place = nbr_place;
    }

    @Override
    public String toString() {
        return "transport{" + "id_user=" + id_user + ", type=" + type + ", matricule=" + matricule + ", marcule=" + marcule + ", nbr_place=" + nbr_place + '}';
    }
    
}
