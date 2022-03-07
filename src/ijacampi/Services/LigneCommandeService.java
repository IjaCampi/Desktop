/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.Services;

import ijacampi.Entities.LigneCommande;
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
public class LigneCommandeService implements Iservice <LigneCommande> {
    Connection con = DBConnexion.getInstance().getCnx();
    @Override
    public ArrayList<LigneCommande> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Ajouter(LigneCommande e) {
String query="insert into ligne_commande (quantite,equipement_id,commande_id) values (?,?,?)";
       
    try {
            PreparedStatement preparedStmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setInt(1,e.getQuantite());
            preparedStmt.setInt(2, e.getEquipement().getId());
            preparedStmt.setInt(3, e.getCommande().getId());
            
            preparedStmt.execute();
            ResultSet res=preparedStmt.getGeneratedKeys();
            while(res.next())
            {
               e.setId(res.getInt(1));
            }
            System.out.println("Insertion LigneCommande Avec Succes");
            System.out.println(e.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
    }

    @Override
    public void modifier(LigneCommande e) {
  try {
            PreparedStatement preparedStmt = con.prepareStatement("update ligne_commande set  quanite=?,equipement_id=?,commande_id=?  where id=?");
            preparedStmt.setInt(1, e.getQuantite());
            preparedStmt.setInt(2, e.getCommande().getId());
            preparedStmt.setInt(3, e.getEquipement().getId());
            preparedStmt.setInt(4, e.getId());
            preparedStmt.execute();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }       }

    @Override
    public void supprimer(LigneCommande e) {
 try {
            PreparedStatement preparedStmt = con.prepareStatement(" delete from ligne_commande where id= ?");
            preparedStmt.setInt(1, e.getId());
            preparedStmt.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }         
    }
    
}
