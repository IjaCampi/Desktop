
package ijacampi.Services;

import ijacampi.Interface.Iservice;
import ijacampi.utils.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ijacampi.Entities.Moyen_Transport;
import ijacampi.Entities.Offre_Location;
import ijacampi.Entities.Utilisateur;


/**
 *
 * @author Omar Amri
 */
public class MoyenTransportService implements Iservice<Moyen_Transport>{
    
    Connection cnx = DBConnexion.getInstance().getCnx();

    

    @Override
    public void Ajouter(Moyen_Transport e) throws SQLException{
        String req="INSERT INTO moyen_transport (type,matricule,marque,nbr_place,frais) VALUES (?,?,?,?,?)";
       
            PreparedStatement pst = cnx.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, e.getType());
            pst.setString(2, e.getMatricule());
            pst.setString(3, e.getMarque());
            pst.setInt(4, e.getNbr_place());
            pst.setDouble(5, e.getFrais());
            //pst.setInt(5, e.getUser().getId_user());
            pst.executeUpdate();
            ResultSet res=pst.getGeneratedKeys();
            while(res.next())
            {
               e.setId_transport(res.getInt(1));
            }
            System.out.println("Moyen Transport bien Ajouté");
    }

    @Override
    public void supprimer(Moyen_Transport e) throws SQLException{

            PreparedStatement preparedStmt = cnx.prepareStatement("DELETE FROM moyen_transport WHERE matricule= ?");
            
            preparedStmt.setString(1, e.getMatricule());
            
            preparedStmt.executeUpdate();
            
            System.out.println("Moyen Transport bien Supprimé");


    }

    @Override
    public void modifier(Moyen_Transport e) throws SQLException{

            PreparedStatement preparedStmt = cnx.prepareStatement("update moyen_transport set type=?,matricule=?,marque=?,nbr_place=?,frais=?  WHERE id_transport=?");
            
            preparedStmt.setInt(1, e.getId_transport());
            preparedStmt.setString(2, e.getType());
            preparedStmt.setString(3, e.getMatricule());
            preparedStmt.setString(4, e.getMarque());
            preparedStmt.setInt(5, e.getNbr_place());
            preparedStmt.setDouble(6, e.getFrais());
            //preparedStmt.setInt(6, e.getUser().getId_user());
            preparedStmt.execute();
            
            System.out.println("Moyen Transport bien Modifié");
        
    }

    @Override
    public ArrayList<Moyen_Transport> afficher() throws SQLException{
        
        ArrayList<Moyen_Transport> lesMoyensT = new ArrayList<>();


            String req="SELECT * FROM moyen_transport";
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            
            while (rst.next()){
                int id = rst.getInt("id_transport");
                String type = rst.getString("type");
                String matricule = rst.getString("matricule");
                String marque = rst.getString("marque");
                int nbr_place = rst.getInt("nbr_place");
                Double frais = rst.getDouble("frais");
                //int id_user = rst.getInt("id_user");
                
                //User_service userSer = new User_service();
                
                //Utilisateur user = userSer.afficher().get(id_user);
                
                Moyen_Transport moyen = new Moyen_Transport(id,type,matricule,marque,nbr_place,frais);
                lesMoyensT.add(moyen);
                System.out.println(lesMoyensT);

            }
            
           
           
        return lesMoyensT;

    }

    public ArrayList<Moyen_Transport> trierNbrPlaces() throws SQLException {
        
        ArrayList<Moyen_Transport> lesMoyensTriers = new ArrayList<>();

     String req = "SELECT * FROM moyen_transport order by nbr_place desc";
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);

            while(rst.next()) {
                Moyen_Transport moyenT = new Moyen_Transport();
                
                moyenT.setNbr_place(rst.getInt("nbr_place"));
                
                lesMoyensTriers.add(moyenT);
}
        
        return lesMoyensTriers;
    }

    public ArrayList<Moyen_Transport> rechercheParNbrPlaces(Moyen_Transport e) throws SQLException {
        
        
        
        ArrayList<Moyen_Transport> lesMoyensRech = new ArrayList<>();
        
     String req = "SELECT * FROM moyen_transport WHERE nbr_place=?";
     
            PreparedStatement preparedStmt = cnx.prepareStatement(req);
            preparedStmt.setInt(1, e.getNbr_place());
            ResultSet rst = preparedStmt.executeQuery();

            while(rst.next()) {
                Moyen_Transport moyenT = new Moyen_Transport();
                
                moyenT.setNbr_place(rst.getInt("nbr_place"));
                
                lesMoyensRech.add(moyenT);
}     
        return lesMoyensRech;
        
    }


    public ArrayList<Moyen_Transport> rechercheParMarque(Moyen_Transport e) throws SQLException {

        ArrayList<Moyen_Transport> lesMoyensRech = new ArrayList<>();
        

     String req = "SELECT * FROM moyen_transport WHERE marque=?";
     
            PreparedStatement preparedStmt = cnx.prepareStatement(req);
            preparedStmt.setNString(1, e.getMarque());
            ResultSet rst = preparedStmt.executeQuery();

            while(rst.next()) {
                Moyen_Transport moyenT = new Moyen_Transport();
                
                moyenT.setMarque(rst.getString("marque"));
                
                lesMoyensRech.add(moyenT);
}
        
        return lesMoyensRech;
    }


    public ArrayList<Moyen_Transport> trierMarque() throws SQLException {
        
        
        
        ArrayList<Moyen_Transport> lesMoyensTriers = new ArrayList<>();

     String req = "SELECT * FROM moyen_transport order by marque";
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);

            while(rst.next()) {
                Moyen_Transport moyenT = new Moyen_Transport();
                
                moyenT.setMarque(rst.getString("marque"));
                
                lesMoyensTriers.add(moyenT);
}
        
        return lesMoyensTriers;

    }
    
    
    
}
