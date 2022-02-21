/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.DBconnection;
import com.edu.entities.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nmedia
 */
public class User_service  {
    
Connection mc;
    PreparedStatement ste;

    public User_service() {
        mc=DBconnection.getInstance().getCnx();
    }
    
    public void ajouterUser(Utilisateur p){
        String sql ="insert into utilisateurs(nom,prenom,date_naissance,num_tel,adresse,login,mdp,role,id_group) Values(?,?,?,?,?,?,?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, p.getNom());
            ste.setString(2, p.getPrenom());
              ste.setString(3, p.getDate_naissance());
               ste.setInt(4, p.getNum_tel());
               ste.setString(5,p.getAdresse());

              ste.setString(6, p.getLogin());
               ste.setString(7, p.getMdp());
               ste.setString(8,p.getRole());
                ste.setInt(9,p.getId_group());

            ste.executeUpdate();
            System.out.println("Utilisateur Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public void modifieruser(Utilisateur p){
      String req="UPDATE utilisateurs(nom,prenom,date_naissance,num_tel,adresse,login,mdp,role,id_group) "
                    + "VALUES(?,?,?,?,?,?,?,?)";
           try {
            ste=mc.prepareStatement(req);
            ste.setString(1, p.getNom());
            ste.setString(2, p.getPrenom());
              ste.setString(3, p.getDate_naissance());
               ste.setInt(4, p.getNum_tel());
               ste.setString(5,p.getAdresse());

              ste.setString(6, p.getLogin());
               ste.setString(7, p.getMdp());
               ste.setString(8,p.getRole());
                ste.setInt(9, p.getId_group());

            
            ste.executeUpdate();
                        System.out.println("Utilisateur modifiée");

        } catch (SQLException ex) {
                System.out.println(ex.getMessage());

        }
    }
         public List<Utilisateur> afficherUser(){
        List<Utilisateur> users = new ArrayList<>();
        String sql="select * from utilisateurs";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Utilisateur p = new Utilisateur();
                p.setId_user(rs.getInt("id_user"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setDate_naissance(rs.getString("date_naissance"));
                p.setAdresse(rs.getString("adresse"));
                p.setNum_tel(rs.getInt("Num_tel"));
                p.setLogin(rs.getString("login"));
                p.setMdp(rs.getString("mdp"));
               p.setRole(rs.getString("role"));
                               p.setId_group(rs.getInt("id_group"));

                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return users;
        
        
    }
         public void supprimeruser(Utilisateur p) {
                     String sql ="delete from utilisateurs where id_user=?";
                     
    try {
            ste=mc.prepareStatement(sql);
                        ste.setInt(1, p.getId_user());

          ste.executeUpdate();
                        System.out.println("Utilisateur supprimé");

        } catch (SQLException ex) {
                System.out.println(ex.getMessage());

        }
         
         }

public void rechercheParNom(String Nom){
    try{
        String sql="select* from utilisateurs where Nom="+Nom;
        ste=mc.prepareStatement(sql);
        ste.executeQuery();
        if(Nom=="nom"){
           System.out.println("Utilisateur trouvé");}
        else{System.out.println("Utilisateur  non trouvé");
        
        }

    
    }catch (SQLException ex) {
                System.out.println(ex.getMessage());

        }

}
}
