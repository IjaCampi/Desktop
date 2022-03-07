/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.Services;

import ijacampi.Entities.Produit;
import ijacampi.Interface.Iservice;
import ijacampi.utils.DBConnexion;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author brahim
 */
public class ProduitService implements Iservice <Produit> {

        
    Connection con = DBConnexion.getInstance().getCnx();
    
    @Override
    public ArrayList<Produit> afficher() {
        ArrayList<Produit> res = new ArrayList<Produit>();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Produit";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                int qteStock = rs.getInt("qtestock");
                String marque= rs.getString("marque");
                String description=rs.getString("description");
                String photo=rs.getString("photo");
                String categorie=rs.getString("categorie");
                float prix_ut=rs.getFloat("prix_ut");       
                Produit E = new Produit(id,qteStock,nom,marque,description,photo,categorie,prix_ut);
                res.add(E);
            }
            rs.close();

        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return res;  
    }

    @Override
    public void Ajouter(Produit e) {
        String query="insert into Produit (qte_stock,nom,marque,description,photo,categorie,prix_ut) values (?,?,?,?,?,?,?)";
       
        try {
                PreparedStatement preparedStmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
    
                preparedStmt.setInt(1, e.getQteStock());
                preparedStmt.setString(2, e.getNom());
                preparedStmt.setString(3, e.getMarque());
                preparedStmt.setString(4, e.getDescription());
                preparedStmt.setString(5, e.getPhoto());
                preparedStmt.setString(6, e.getCategorie());
                preparedStmt.setFloat(7, e.getPrix_ut());
                
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
            }    }

    @Override
    public void modifier(Produit e) {
        try {
            PreparedStatement preparedStmt = con.prepareStatement("update Produit set  qtestock=? ,nom=? ,marque=? ,description=? ,photo=? ,categorie=? ,prix_ut=? where id=?");
            preparedStmt.setInt(1, e.getQteStock());
            preparedStmt.setString(2, e.getNom());
            preparedStmt.setString(3, e.getMarque());
            preparedStmt.setString(4, e.getDescription());
            preparedStmt.setString(5, e.getPhoto());
            preparedStmt.setString(6, e.getCategorie());
            preparedStmt.setFloat(7, e.getPrix_ut());
            preparedStmt.setInt(8, e.getId());
            preparedStmt.execute();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Produit e) {
        try {
            PreparedStatement preparedStmt = con.prepareStatement(" delete from Produit where id= ?");
            preparedStmt.setInt(1, e.getId());
            preparedStmt.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
