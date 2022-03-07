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
public class Produit {
     int id,qteStock;
    String nom,marque,description,photo,categorie;
   
     
     float prix_ut;

    public Produit() {
    }

    public Produit(int id, int qteStock, String nom, String marque, String description, String photo, String categorie, float prix_ut) {
        this.id = id;
        this.qteStock = qteStock;
        this.nom = nom;
        this.marque = marque;
        this.description = description;
        this.photo = photo;
        this.categorie = categorie;
        this.prix_ut = prix_ut;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", qteStock=" + qteStock + ", nom=" + nom + ", marque=" + marque + ", description=" + description + ", photo=" + photo + ", categorie=" + categorie + ", prix_ut=" + prix_ut + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getPrix_ut() {
        return prix_ut;
    }

    public void setPrix_ut(float prix_ut) {
        this.prix_ut = prix_ut;
    }
    
       
}
