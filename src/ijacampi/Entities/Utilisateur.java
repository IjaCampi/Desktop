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
public class Utilisateur {
   private  int id,num_tel;
   private String nom,prenom,adresse,login,mdp,role;
    private String date_naissance;

    public Utilisateur(int id, String nom, String role) {
        this.id = id;
        this.nom = nom;
        this.role = role;
    }

    public Utilisateur(int id, int num_tel, String nom, String prenom, String adresse, String login, String mdp, String role, String date_naissance) {
        this.id = id;
        this.num_tel = num_tel;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.login = login;
        this.mdp = mdp;
        this.role = role;
        this.date_naissance = date_naissance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

   
    public Utilisateur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
   

    public Utilisateur() {
    }

    public Utilisateur(int id) {
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
