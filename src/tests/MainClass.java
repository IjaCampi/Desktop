/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Entitys.Hebergement;
import Services.HebergementCRUD;
import utiles.MyConnection;

/**
 *
 * @author HP
 */
public class MainClass {
   public static void main(String[] args) {
           // MyConnection mc = new MyConnection();
            HebergementCRUD hcd = new HebergementCRUD();
            //Hebergement h2 = new Hebergement(5,"x","xx","xx",1, true ,5);
            //hcd.ajouterHebergement2(h2);
            System.out.println(hcd.afficherHebergement());
            //hcd.SupprimerHebergement (1);
   } 
}
