/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.Services;

import ijacampi.Entities.LignePanier;
import ijacampi.Entities.Produit;
import ijacampi.Interface.Iservice;
import ijacampi.utils.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author brahim
 */
public class LignePanierService implements Iservice<LignePanier> {

    Connection con = DBConnexion.getInstance().getCnx();

    @Override
    public ArrayList<LignePanier> afficher() {
        ArrayList<LignePanier> res = new ArrayList<LignePanier>();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Ligne_Panier";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int produit_id = rs.getInt("produit_id");
                int quantite = rs.getInt("quantite");
                 int utilisateur_id =rs.getInt("utilisateur_id");
                LignePanier E = new LignePanier(id, produit_id,utilisateur_id, quantite);
                res.add(E);
            }
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return res;
    }

    @Override
    public void Ajouter(LignePanier e) {
 String query="insert into Ligne_Panier (produit_id,int utilisateur_id,quantite) values (?,?,?)";
       
        try {
                PreparedStatement preparedStmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
    
               
                preparedStmt.setInt(1, e.getProduit_id());
                preparedStmt.setInt(2, e.getUtilisateur_id());
                
                preparedStmt.setInt(3, e.getQuantite());
                
                
                preparedStmt.execute();
                ResultSet res=preparedStmt.getGeneratedKeys();
                while(res.next())
                {
                   e.setId(res.getInt(1));
                }
                System.out.println("Insertion equipement Avec Succes");
                System.out.println(e.getId());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

    }

    @Override
    public void modifier(LignePanier e) {
         try {
            PreparedStatement preparedStmt = con.prepareStatement("update Ligne_Panier set produit_id=?,utilisateur_id=?,quantite=? where id=?");
         
            preparedStmt.setInt(1, e.getProduit_id());
            preparedStmt.setInt(2, e.getUtilisateur_id());

            preparedStmt.setInt(3, e.getQuantite());
            preparedStmt.setInt(4, e.getId());
            
            preparedStmt.execute();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @Override
    public void supprimer(LignePanier e) {
 try {
            PreparedStatement preparedStmt = con.prepareStatement(" delete from Ligne_Panier where id= ?");
            preparedStmt.setInt(1, e.getId());
            preparedStmt.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
