/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import ijacampi.Entities.Utilisateur;
import ijacampi.Entities.Commande;
import ijacampi.Entities.Equipement;
import ijacampi.Entities.Evenement;
import ijacampi.Entities.LigneCommande;

import ijacampi.Services.CommandeService;
import ijacampi.Services.EquipementService;
import ijacampi.Services.LigneCommandeService;
import ijacampi.utils.DBConnexion;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author brahim
 */
public class Ijacampi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnexion.getInstance();
        //Equipement(int quantite, int client_id, int evenement_id,
        // String nom, String marque, String etat, String description, String photo)
        /*
        Equipement e1=new Equipement(
            1,1,1,
            "x","x","x","x","1"
        
        );
        EquipementService es =new EquipementService();
        es.Ajouter(e1);
       System.out.println(es.afficher());
        System.out.println(e1.toString());
        e1.setDescription("xd");
       es.modifier(e1);
        System.out.println(e1.toString());
        System.out.println(es.afficher()); 
        es.supprimer(e1);
      
        System.out.println(es.afficher());
        e1.setDescription("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        es.modifier(e1);
        *
         Produit produit=new Produit(1,1,"1","1","1","1","1",1.3f);
        ProduitService ps=new ProduitService();
         //ps.Ajouter(produit);
         Panier panier =new Panier();
         LignePanier lp=new LignePanier(1,1,2);
         LignePanierService lps=new LignePanierService();
        
        panier.ajouterLigne(lp);
        lps.Ajouter(lp);
        panier.afficherLigne();
         */
        Evenement ev = new Evenement(1, "weekend");
        Utilisateur camper = new Utilisateur(1, "omar", "client");
        Equipement e = new Equipement(ev, camper, "1", "2", "3", "4", "5");
        //public Equipement(Evenement evenement, Camper camper, float prix, String nom, String marque, String description, String photo, String categorie)
        Equipement e1 = new Equipement(camper, 10f, "lambda", "delta", "lambda_delta", "src", "alpha");
        Equipement e2 = new Equipement(camper, 5f, "lambda", "delta", "lambda_delta", "src", "alpha");
        // EquipementService es=new EquipementService();
        ///   Date time = Date.valueOf(LocalDate.now());
        Date t = Date.valueOf("2000-05-05");
        ArrayList<LigneCommande> panier = new ArrayList();
        Commande commande=new Commande(camper,panier);
               LigneCommandeService lcs =new LigneCommandeService();

        LigneCommande lc1 = new LigneCommande(2, e1,commande);
        LigneCommande lc2 = new LigneCommande(2, e2,commande);
        panier.add(lc2);
        panier.add(lc1);
        //commande.setPanier(panier);
        CommandeService c=new CommandeService();
        System.out.println(c.afficher());
        // commande.setPanier(lcs.getbyCid(1));
            System.out.println("panierx:"+commande.getPanier());
        commande.setMontant(commande.total());
        commande.setId(1);
        e1.setId(3);
        e2.setId(4);
      
        

    }

}
