
package Services;

import Interfaces.IServices;
import Utils.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entites.Offre_Location;

/**
 *
 * @author Omar Amri
 */
public class Offre_LocationService implements IServices<Offre_Location>{
    
    Connection cnx = DBConnexion.getInstance().getCnx();

    @Override
    public void ajouter(Offre_Location entity) throws SQLException {

            String req="INSERT INTO offre_location(date_debut,date_fin,frais,etat,num_tel) VALUES(?,?,?,?,?)";
            
            PreparedStatement pst = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            
            pst.setString(1, entity.getDate_debut());
            pst.setString(2, entity.getDate_fin());
            pst.setDouble(3, entity.getFrais());
            pst.setString(4, entity.getEtat());
            pst.setString(5, entity.getNum_tel());
            
            pst.executeUpdate();
            
            ResultSet res=pst.getGeneratedKeys();
            while(res.next())
            {
               entity.setId_offrelocation(res.getInt(1));
            }
            
            
            System.out.println("Offre Location bien Ajouté");

    }

    @Override
    public void supprimer(Offre_Location e) throws SQLException {

            PreparedStatement preparedStmt = cnx.prepareStatement("DELETE FROM offre_location WHERE num_tel= ?");
            
            System.out.println(e.getNum_tel());
            preparedStmt.setString(1, e.getNum_tel());
            
            preparedStmt.executeUpdate();
            
            System.out.println("Offre Location bien Supprimé");
    }
    

    @Override
    public void modifier(Offre_Location entity) throws SQLException {
        

             
            PreparedStatement pst = cnx.prepareStatement("UPDATE offre_location SET `num_tel`=?, `date_debut`=?,`date_fin`=?,`frais`=?,etat=? WHERE num_tel=?");

            pst.setString(1, entity.getNum_tel());
            pst.setString(2, entity.getDate_debut());
            pst.setString(3, entity.getDate_fin());
            pst.setDouble(4, entity.getFrais());
            pst.setString(5, entity.getEtat());
            pst.setInt(6, entity.getId_offrelocation());
            
            pst.executeUpdate();
            
            System.out.println("Moyen Transport bien Modifié");
            
        

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
                offre.setEtat(rst.getString("etat"));
                offre.setNum_tel(rst.getString("num_tel"));
                offre.setDate_debut(rst.getString("date_debut"));
                offre.setDate_fin(rst.getString("date_fin"));
                offre.setFrais(rst.getDouble("frais"));
                offre.setEtat(rst.getString("etat"));
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
            preparedStmt.setString(1, e.getDate_debut());
            ResultSet rst = preparedStmt.executeQuery();

            while(rst.next()) {
                
                Offre_Location offreLoc = new Offre_Location();
                
                offreLoc.setDate_debut(rst.getString("date_debut"));
                
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
                
                offreLoc.setDate_debut(rst.getString("etat"));
                
                lesOffresRech.add(offreLoc);
}
}       catch (SQLException ex) {
            ex.getMessage();
        }
        
        return lesOffresRech;
    }

   
    
}
