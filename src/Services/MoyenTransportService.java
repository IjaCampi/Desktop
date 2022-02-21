
package Services;

import Interfaces.IServices;
import Utils.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pi.ijacampi.entites.Moyen_Transport;


/**
 *
 * @author Omar Amri
 */
public class MoyenTransportService implements IServices<Moyen_Transport>{
    
    Connection cnx = DBConnexion.getInstance().getCnx();

    

    @Override
    public void ajouter(Moyen_Transport e) throws SQLException{
        String req="INSERT INTO moyen_transport (id_user,type,matricule,marque,image,nbr_place) VALUES (?,?,?,?,?,?)";
       
    try {
            PreparedStatement pst = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);

            
            pst.setInt(1, e.getId_user());
            pst.setString(2, e.getType());
            pst.setString(3, e.getMatricule());
            pst.setString(4, e.getMarque());
            pst.setString(5, e.getImage());
            pst.setInt(6, e.getNbr_place());
            pst.executeUpdate();
            ResultSet res=pst.getGeneratedKeys();
            while(res.next())
            {
               e.setId_transport(res.getInt(1));
            }
            System.out.println("Moyen Transport bien Ajouté");
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    public void supprimer(Moyen_Transport e) throws SQLException{
        try {
            PreparedStatement preparedStmt = cnx.prepareStatement("DELETE FROM moyen_transport WHERE id_transport= ?");
            
            preparedStmt.setInt(1, e.getId_transport());
            
            preparedStmt.executeUpdate();
            
            System.out.println("Moyen Transport bien Supprimé");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } 


    }

    @Override
    public void modifier(Moyen_Transport e) throws SQLException{
        try {
            PreparedStatement preparedStmt = cnx.prepareStatement("UPDATE moyen_transport SET id_user=?,type=?,matricule=?,marque=?,image=?,nbr_place=?  WHERE id_transport=?");
            
            preparedStmt.setInt(1, e.getId_transport());
            preparedStmt.setInt(2, e.getId_user());
            preparedStmt.setString(3, e.getType());
            preparedStmt.setString(4, e.getMatricule());
            preparedStmt.setString(5, e.getMarque());
            preparedStmt.setString(7, e.getImage());
            preparedStmt.setInt(6, e.getNbr_place());
            preparedStmt.executeUpdate();
            
            System.out.println("Moyen Transport bien Modifié");
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @Override
    public ArrayList<Moyen_Transport> afficher() throws SQLException{
        
        ArrayList<Moyen_Transport> lesMoyensT = new ArrayList<>();

        try {
            
            String req="SELECT * FROM moyen_transport";
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            
            while (rst.next()){
                
                Moyen_Transport moyenT = new Moyen_Transport();
                
                moyenT.setId_transport(rst.getInt("id_transport"));
                moyenT.setType(rst.getString("type"));
                moyenT.setMatricule(rst.getString("matricule"));
                moyenT.setMarque(rst.getString("marque"));
                moyenT.setImage(rst.getString("image"));
                moyenT.setNbr_place(rst.getInt("nbr_place"));
                moyenT.setId_user(rst.getInt("id_user"));
                
                lesMoyensT.add(moyenT);

            }
            
            st.executeQuery(req);
            
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        
        return lesMoyensT;

    }

    public ArrayList<Moyen_Transport> trierNbrPlaces() throws SQLException {
        
        ArrayList<Moyen_Transport> lesMoyensTriers = new ArrayList<>();
        
        try {

     String req = "SELECT * FROM moyen_transport order by nbr_place desc";
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);

            while(rst.next()) {
                Moyen_Transport moyenT = new Moyen_Transport();
                
                moyenT.setNbr_place(rst.getInt("nbr_place"));
                
                lesMoyensTriers.add(moyenT);
}
}       catch (SQLException ex) {
            ex.getMessage();
        }
        
        return lesMoyensTriers;
    }

    public ArrayList<Moyen_Transport> rechercheParNbrPlaces(Moyen_Transport e) throws SQLException {
        
        
        
        ArrayList<Moyen_Transport> lesMoyensRech = new ArrayList<>();
        
        try {

     String req = "SELECT * FROM moyen_transport WHERE nbr_place=?";
     
            PreparedStatement preparedStmt = cnx.prepareStatement(req);
            preparedStmt.setInt(1, e.getNbr_place());
            ResultSet rst = preparedStmt.executeQuery();

            while(rst.next()) {
                Moyen_Transport moyenT = new Moyen_Transport();
                
                moyenT.setNbr_place(rst.getInt("nbr_place"));
                
                lesMoyensRech.add(moyenT);
}
}       catch (SQLException ex) {
            ex.getMessage();
        }
        
        return lesMoyensRech;
        
    }


    public ArrayList<Moyen_Transport> rechercheParMarque(Moyen_Transport e) throws SQLException {

        ArrayList<Moyen_Transport> lesMoyensRech = new ArrayList<>();
        
        try {

     String req = "SELECT * FROM moyen_transport WHERE marque=?";
     
            PreparedStatement preparedStmt = cnx.prepareStatement(req);
            preparedStmt.setNString(1, e.getMarque());
            ResultSet rst = preparedStmt.executeQuery();

            while(rst.next()) {
                Moyen_Transport moyenT = new Moyen_Transport();
                
                moyenT.setMarque(rst.getString("marque"));
                
                lesMoyensRech.add(moyenT);
}
}       catch (SQLException ex) {
            ex.getMessage();
        }
        
        return lesMoyensRech;
    }


    public ArrayList<Moyen_Transport> trierMarque() throws SQLException {
        
        
        
        ArrayList<Moyen_Transport> lesMoyensTriers = new ArrayList<>();
        
        try {

     String req = "SELECT * FROM moyen_transport order by marque";
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);

            while(rst.next()) {
                Moyen_Transport moyenT = new Moyen_Transport();
                
                moyenT.setMarque(rst.getString("marque"));
                
                lesMoyensTriers.add(moyenT);
}
}       catch (SQLException ex) {
            ex.getMessage();
        }
        
        return lesMoyensTriers;

    }

   
}
