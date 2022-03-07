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
public class LignePanier {
    int id,produit_id,quantite,utilisateur_id;

    public LignePanier(int id, int produit_id, int utilisateur_id,int quantite) {
        this.id = id;
        this.utilisateur_id=utilisateur_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
    }
     public LignePanier(  int produit_id, int utilisateur_id,int quantite) {
        this.utilisateur_id=utilisateur_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
   

    public LignePanier() {
    }

   
}
