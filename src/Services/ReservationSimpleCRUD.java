/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.Hebergement;
import Entitys.ReservationEvenement;
import Entitys.ReservationSimple;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import utiles.MyConnection;

/**
 *
 * @author Seif Labidi
 */
public class ReservationSimpleCRUD {
    Connection cnx2;
    public ReservationSimpleCRUD(){
         cnx2 = MyConnection.getInstance().getCnx();
         }
    public void ajouterReservationSimple(Date dd , Date df , int id ) {
        try {
            String requete2 = "INSERT INTO ReservationSimple (dateDebut,dateFin,id_h)" + "VALUES (?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setDate(1,(Date) dd);
            pst.setDate(2, (Date) df);
            pst.setInt(3, id);
            pst.executeUpdate();
            System.out.println("Reservation effectue!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      public void SupprimerReservationSimple (int id_rs ){
       
      try {
            String req3 = "DELETE FROM ReservationSimple WHERE id_rs=? " ;
            
           PreparedStatement pst2= cnx2.prepareStatement(req3) ;
            pst2.setInt(1,id_rs);
           pst2.executeUpdate() ; 
            System.out.print("Reservation suprrimée! ");
           
                        
        } catch (SQLException ex) {
          System.err.println(ex.getMessage());
         
        }

    
    }
      public boolean AfficherReservationParDateDebut(Date dd,Date df){
        boolean resultat = true;
        try {
            String requete3 = "SELECT * FROM reservationsimple WHERE dateDebut between ? and ? ";
            PreparedStatement pst = cnx2.prepareStatement(requete3);
            pst.setDate(1,dd);
            pst.setDate(2, df);
            ResultSet rs = pst.executeQuery(); 
            if (rs.next() == false) { 
                resultat=false;
                //System.out.println("feragh");
            }
            else {
                //System.out.println("m3eby");
                resultat=true;
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultat;
    }
      public boolean AfficherReservationParDateFin(Date dd,Date df){
        boolean resultat = true;
        try {
            String requete3 = "SELECT * FROM reservationsimple WHERE dateFin between ? and ? ";
            PreparedStatement pst = cnx2.prepareStatement(requete3);
            pst.setDate(1,dd);
            pst.setDate(2, df);
            ResultSet rs = pst.executeQuery(); 
            if (rs.next() == false) { 
                resultat=false;
                //System.out.println("feragh");
            }
            else {
                //System.out.println("m3eby");
                resultat=true;
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultat;
    }
    
}
