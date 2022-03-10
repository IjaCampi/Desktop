/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.Services;

import ijacampi.Entities.Commande;
import ijacampi.Entities.Equipement;
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
    private CommandeService cs=new CommandeService();
    private EquipementService es=new EquipementService();
    @Override
    public ArrayList<LigneCommande> afficher() {
  ArrayList<LigneCommande> res = new ArrayList<LigneCommande>();
         
         try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM ligne_commande";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int equipement_id = rs.getInt("equipement_id");
                int commande_id = rs.getInt("commande_id");
                int  quantite= rs.getInt("quantite");
                Equipement e=es.getall().get(equipement_id);
                Commande c=cs.afficher().get(commande_id);
                 LigneCommande E=new LigneCommande(id,e,c,quantite);
                                res.add(E);
                
             //   Equipement E = new Equipement(id,nom,categorie,prix,marque,description,photo,client_id,evenement_id);
              //  res.add(E);
            }
            rs.close();

        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return res;      }

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
     
    
    
    public ArrayList<LigneCommande> getbyCommandeid(int id_commande) {
           ArrayList<LigneCommande> list = new ArrayList<LigneCommande>();
           LigneCommande e=new LigneCommande();
  try {
            PreparedStatement preparedStmt = con.prepareStatement("SELECT * FROM ligne_commande  where commande_id="+ id_commande );
           // preparedStmt.setInt(1,id_commande);
            preparedStmt.execute();
             ResultSet res=preparedStmt.getGeneratedKeys();
            while(res.next())
            {
               e.setId(res.getInt(1));
              
               e.setEquipement(es.getall().get(res.getInt(2)));
               e.setCommande(cs.afficher().get(res.getInt(3)));
               e.setQuantite(res.getInt(4));
               list.add(e);
            }
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }       
        return list;
     }
    
    public ArrayList<LigneCommande> getbyCid(int idC)
    {
          ArrayList<LigneCommande> res = new ArrayList<LigneCommande>();

           try {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM ligne_commande where commande_id=" + idC ;
               System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int equipement_id = rs.getInt("equipement_id");
                int commande_id = rs.getInt("commande_id");
                int  quantite= rs.getInt("quantite");
                Equipement e=es.getall().get(equipement_id);
                Commande c=cs.afficher().get(commande_id);
                LigneCommande E=new LigneCommande(id,e,c,quantite);
                System.out.println(E);
             
                res.add(E);
             //   Equipement E = new Equipement(id,nom,categorie,prix,marque,description,photo,client_id,evenement_id);
              //  res.add(E);
            }
            rs.close();

        }
        catch (Exception e) {
            System.err.println("error:"+e.getMessage());
        }
        return res;
    }
}
