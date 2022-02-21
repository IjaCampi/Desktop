/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.DBconnection;
import com.edu.entities.Groupe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nmedia
 */
public class Groupe_service {
    Connection mc;
    PreparedStatement ste;

    public Groupe_service() {
        mc=DBconnection.getInstance().getCnx();
    }
    public void ajoutergroupe(Groupe g1){
        String sql ="insert into groupe(nom,description) Values(?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, g1.getNom());
              ste.setString(2, g1.getDescription());
               ste.executeUpdate();
            System.out.println("GROUPE  Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public void modifiergroupe(Groupe g1){
      String req="UPDATE Groupe(nom,description) "
                    + "VALUES(?,?)";
           try {
            ste=mc.prepareStatement(req);
            
            ste.setString(1, g1.getNom());
              ste.setString(2, g1.getDescription());
              

            
            ste.executeUpdate();
                        System.out.println("groupe modifié");

        } catch (SQLException ex) {
                System.out.println(ex.getMessage());

        }
    }
         public List<Groupe> affichergroupe(){
        List<Groupe> users = new ArrayList<>();
        String sql="select * from groupe";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
               Groupe g1 = new Groupe();
                g1.setNom(rs.getString("nom"));
                g1.setDescription(rs.getString("Description"));
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return users;
        
        
    }
         public void supprimergroupe(Groupe g1) {
                     String sql ="delete from groupe where id_group=?";
                     
    try {
            ste=mc.prepareStatement(sql);
                        ste.setInt(1, g1.getId_group());

          ste.executeUpdate();
                        System.out.println("groupe supprimé");

        } catch (SQLException ex) {
                System.out.println(ex.getMessage());

        }
         
         }}

    

