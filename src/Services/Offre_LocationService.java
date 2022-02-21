
package Services;

import Interfaces.IServices;
import Utils.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pi.ijacampi.entites.Offre_Location;

/**
 *
 * @author Omar Amri
 */
public class Offre_LocationService implements IServices<Offre_Location>{
    
    Connection cnx = DBConnexion.getInstance().getCnx();

    @Override
    public void ajouter(Offre_Location entity) {
        
        try {
            String req="INSERT INTO offre_location(date_debut,date_fin,frais,etat,id_transport) VALUES(?,?,?,?,?)";
            
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setDate(1, entity.getDate_debut());
            pst.setDate(2, entity.getDate_fin());
            pst.setDouble(3, entity.getFrais());
            pst.setString(4, entity.getEtat());
            pst.setInt(5, entity.getId_transport());
            
            System.out.println("Offre Location bien Ajouté");
            
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @Override
    public void supprimer(Offre_Location entity) {
        
        try {
            String req="DELETE FROM offre_location WHERE id_offrelocation=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setInt(1, entity.getId_offrelocation());
            
            pst.executeUpdate();
            
            System.out.println("Offre Location bien Supprimé");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    

    @Override
    public void modifier(Offre_Location entity) {
        
         try {
            String req="UPDATE offre_location SET date_debut=?,date_fin=?,frais=?,etat=?,id_transport=? WHERE id_offrelocation=?";
            
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setInt(1, entity.getId_offrelocation());
            pst.setDate(2, entity.getDate_debut());
            pst.setDate(3, entity.getDate_fin());
            pst.setDouble(4, entity.getFrais());
            pst.setString(5, entity.getEtat());
            pst.setInt(6, entity.getId_transport());
            
            pst.executeUpdate();
            
            System.out.println("Moyen Transport bien Modifié");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        

    }

    @Override
    public ArrayList<Offre_Location> afficher() {
        
         ArrayList<Offre_Location> lesOffres = new ArrayList<>();
            
        String req="SELECT * FROM offre_location";
        
        try {
            
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            
            while (rst.next()){
                
                Offre_Location offre = new Offre_Location();
                
                offre.setId_offrelocation(rst.getInt("id_offrelocation"));
                offre.setDate_debut(rst.getDate("date_debut"));
                offre.setDate_fin(rst.getDate("date_fin"));
                offre.setFrais(rst.getDouble("frais"));
                offre.setEtat(rst.getString("etat"));
                offre.setId_transport(rst.getInt("id_transport"));
                lesOffres.add(offre);
            }
            
            st.executeQuery(req);
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        return lesOffres;
     
        
    }
    
    public ArrayList<Offre_Location> trierFraisPlus() throws SQLException {
        
        ArrayList<Offre_Location> lesOffresTriers = new ArrayList<>();
        
        try {

     String req = "SELECT * FROM offre_location order by frais";
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);

            while(rst.next()) {
                Offre_Location moyenT = new Offre_Location();
                
                moyenT.setFrais(rst.getDouble("frais"));
                
                lesOffresTriers.add(moyenT);
}
}       catch (SQLException ex) {
            ex.getMessage();
        }
        
        return lesOffresTriers;
    }
    
    
    public ArrayList<Offre_Location> trierFraisMoins() throws SQLException {
        
        ArrayList<Offre_Location> lesOffresTriers = new ArrayList<>();
        
        try {

     String req = "SELECT * FROM offre_location order by frais desc";
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);

            while(rst.next()) {
                Offre_Location moyenT = new Offre_Location();
                
                moyenT.setFrais(rst.getDouble("frais"));
                
                lesOffresTriers.add(moyenT);
}
}       catch (SQLException ex) {
            ex.getMessage();
        }
        
        return lesOffresTriers;
    }
    
     public ArrayList<Offre_Location> rechercheParDateDebut(Offre_Location e) throws SQLException {

        ArrayList<Offre_Location> lesOffresRech = new ArrayList<>();
        
        try {

     String req = "SELECT * FROM offre_location WHERE date_debut=?";
     
            PreparedStatement preparedStmt = cnx.prepareStatement(req);
            preparedStmt.setDate(1, e.getDate_debut());
            ResultSet rst = preparedStmt.executeQuery();

            while(rst.next()) {
                
                Offre_Location offreLoc = new Offre_Location();
                
                offreLoc.setDate_debut(rst.getDate("date_debut"));
                
                lesOffresRech.add(offreLoc);
}
}       catch (SQLException ex) {
            ex.getMessage();
        }
        
        return lesOffresRech;
    }
     
     public ArrayList<Offre_Location> rechercheParEtat(Offre_Location e) throws SQLException {

        ArrayList<Offre_Location> lesOffresRech = new ArrayList<>();
        
        try {

     String req = "SELECT * FROM offre_location WHERE etat=?";
     
            PreparedStatement preparedStmt = cnx.prepareStatement(req);
            preparedStmt.setString(1, e.getEtat());
            ResultSet rst = preparedStmt.executeQuery();

            while(rst.next()) {
                
                Offre_Location offreLoc = new Offre_Location();
                
                offreLoc.setDate_debut(rst.getDate("etat"));
                
                lesOffresRech.add(offreLoc);
}
}       catch (SQLException ex) {
            ex.getMessage();
        }
        
        return lesOffresRech;
    }

   
    
}
