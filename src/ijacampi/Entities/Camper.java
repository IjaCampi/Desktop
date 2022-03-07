/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.Entities;

/**
 *
 * @author brahim
 */
public class Camper {
   private  int id;
   private String nom;
   private String role;

    public Camper(int id, String nom, String role) {
        this.id = id;
        this.nom = nom;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

   
    public Camper(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
   

    public Camper() {
    }

    public Camper(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Camper{" + "id=" + id + ", nom=" + nom + '}';
    }
    
}
