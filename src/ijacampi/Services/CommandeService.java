/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.Services;

import ijacampi.Entities.Commande;
import ijacampi.Entities.Produit;
import ijacampi.Interface.Iservice;
import ijacampi.utils.DBConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author brahim
 */
public class CommandeService implements Iservice <Commande> {
Connection con = DBConnexion.getInstance().getCnx();
    @Override
    public ArrayList<Commande> afficher() {
      ArrayList<Commande> res = new ArrayList<Commande>();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Commande";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                float montant=rs.getFloat("montant");
                Date date=rs.getDate("date");
                String adresse = rs.getString("adresse");
                String reference= rs.getString("reference");
                int utilisateur_id=rs.getInt("utilisateur_id");
               // Produit E = new Produit(id,qteStock,nom,marque,description,photo,categorie,prix_ut);
               
               Commande c=new Commande(id,date,reference,montant,adresse);
              
                res.add(c);
            }
            rs.close();

        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return res;  
    }

    @Override
    public void Ajouter(Commande e) {

String query="insert into commande (montant,date,adresse,reference,utilisateur_id) values (?,?,?,?,?)";
       
    try {
            PreparedStatement preparedStmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setFloat(1,e.getMontant() );
            preparedStmt.setDate(2, e.getDate_commande());
            preparedStmt.setString(3, e.getAdresse());
            preparedStmt.setString(4, e.getReference()); 
            preparedStmt.setInt(5, e.getCamper().getId());
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
            System.out.println("x:"+e.getCamper().getId());
        }

    }

    @Override
    public void modifier(Commande e) {
   try {
            PreparedStatement preparedStmt = con.prepareStatement("update commande set  montant=?,date=?,adresse=?,reference=?,utilisateur_id=?  where id=?");
            preparedStmt.setFloat(1, e.getMontant());
            preparedStmt.setDate(2, e.getDate_commande());
            preparedStmt.setString(3, e.getAdresse());
            preparedStmt.setString(4, e.getReference());
            preparedStmt.setInt(5, e.getCamper().getId());
            preparedStmt.setInt(6, e.getId());

            preparedStmt.execute();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }    }

    @Override
    public void supprimer(Commande e) {
         try {
            PreparedStatement preparedStmt = con.prepareStatement(" delete from commande where id= ?");
            preparedStmt.setInt(1, e.getId());
            preparedStmt.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }                
    }
       public int add(Commande e) {

String query="insert into commande (montant,date,adresse,reference,utilisateur_id) values (?,?,?,?,?)";
       
    try {
            PreparedStatement preparedStmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setFloat(1,e.getMontant() );
            preparedStmt.setDate(2, e.getDate_commande());
            preparedStmt.setString(3, e.getAdresse());
            preparedStmt.setString(4, e.getReference()); 
            preparedStmt.setInt(5, e.getCamper().getId());
            preparedStmt.execute();
            ResultSet res=preparedStmt.getGeneratedKeys();
            while(res.next())
            {
               e.setId(res.getInt(1));
            }
            System.out.println("Insertion equipement Avec Succes");
          
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("x:"+e.getCamper().getId());
        }
         return e.getId();
    }
    
}
