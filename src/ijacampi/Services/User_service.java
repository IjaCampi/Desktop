/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.Services;


import ijacampi.Entities.Utilisateur;
import ijacampi.Interface.Iservice;
import ijacampi.utils.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nmedia
 */
public class User_service implements Iservice<Utilisateur> {
    
Connection mc=DBConnexion.getInstance().getCnx();
private Statement ste;

    /**
     *
     * @param p
     * @throws java.sql.SQLException
     */
    @Override
    public void Ajouter(Utilisateur p)   {
       
           String sql ="insert into utilisateurs(nom,prenom,date_naissance,num_tel,adresse,login,mdp,role) Values(?,?,?,?,?,?,?,?)";
         try{
           PreparedStatement ste=mc.prepareStatement(sql);
            ste=mc.prepareStatement(sql);
            ste.setString(1, p.getNom());
            ste.setString(2, p.getPrenom());
              ste.setString(3, p.getDate_naissance());
               ste.setInt(4, p.getNum_tel());
               ste.setString(5,p.getAdresse());

              ste.setString(6, p.getLogin());
               ste.setString(7, p.getMdp());
               ste.setString(8,p.getRole());
              
            ste.executeUpdate();
            System.out.println("Utilisateur Ajoutée");
         }
         catch(Exception e){
             e.getMessage();
         }
        
    }
@Override
    public void modifier(Utilisateur p){
 
           
              String sql="UPDATE utilisateurs SET nom=?,prenom=?,date_naissance=?,num_tel=?,adresse=?,login=?,mdp=?,role=? where id_user=?";
              try{
              PreparedStatement ste=mc.prepareStatement(sql);

               ste=mc.prepareStatement(sql);
               ste.setString(1, p.getNom());
               ste.setString(2, p.getPrenom());
               ste.setString(3, p.getDate_naissance());
               ste.setInt(4, p.getNum_tel());
               ste.setString(5,p.getAdresse());
               ste.setString(6, p.getLogin());
               ste.setString(7, p.getMdp());
               ste.setString(8,p.getRole());
                ste.setInt(9,p.getId());
              
         
            ste.executeUpdate();
              System.out.println("Utilisateur modifié");
              }
             catch(Exception e){
                 e.getMessage();
             }

       
    }

         public List<Utilisateur> getAll() throws SQLException{
        List<Utilisateur> users = new ArrayList<>();
        
             String sql="select * from utilisateur";
              PreparedStatement ste=mc.prepareStatement(sql);
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
         users.add(new Utilisateur(rs.getInt("id_user"),rs.getInt("Num_tel"),rs.getString("nom"), rs.getString("prenom"),rs.getString("adresse"),rs.getString("login"),rs.getString("mdp"),rs.getString("role"),rs.getString("date_naissance")));

                       
                
            }
       
        System.out.println(users);
        return users;
        
        
    }

         public void deleteOne1(int id)throws SQLException {
             
           String sql ="DELETE from utilisateurs where id_user=?";
           PreparedStatement ste=mc.prepareStatement(sql);
            ste=mc.prepareStatement(sql);
            ste.setInt(1, id);
            ste.executeUpdate();
              System.out.println("Utilisateur supprimé");
        }         
         


public ArrayList<Utilisateur> trierNom() throws SQLException {
        
        ArrayList<Utilisateur> lesusersTriers = new ArrayList<>();
        
        try {

     String req = "SELECT * FROM Utilisateurs order by Nom desc";
            Statement st = mc.createStatement();
            ResultSet rst = st.executeQuery(req);

            while(rst.next()) {
                Utilisateur us1 = new Utilisateur();
                
                us1.setNom(rst.getString("Nom"));
                us1.setPrenom(rst.getString("Prenom"));
               us1.setDate_naissance(rst.getString("date_naissance"));
               us1.setNum_tel(rst.getInt("Num_tel"));
               us1.setAdresse(rst.getString("adresse"));
               us1.setLogin(rst.getString("login"));
               us1.setMdp(rst.getString("mdp"));
               us1.setRole(rst.getString("role"));
              
                
                lesusersTriers.add(us1);
}
}       catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        
        return lesusersTriers;
    }
 public ArrayList<Utilisateur> rechercheParNom(Utilisateur e) throws SQLException {
        
        
        
        ArrayList<Utilisateur> lesusersRech = new ArrayList<>();
        
        try {

     String req = "SELECT * FROM Utilisateurs WHERE Nom=?";
     
            PreparedStatement preparedStmt = mc.prepareStatement(req);
            preparedStmt.setString(1, e.getNom());
            ResultSet rst = preparedStmt.executeQuery();

            while(rst.next()) {
                Utilisateur us1 = new Utilisateur();
                
                us1.setNom(rst.getString("Nom"));
                 us1.setPrenom(rst.getString("Prenom"));
               us1.setDate_naissance(rst.getString("date_naissance"));
               us1.setNum_tel(rst.getInt("Num_tel"));
               us1.setAdresse(rst.getString("adresse"));
               us1.setLogin(rst.getString("login"));
               us1.setMdp(rst.getString("mdp"));
               us1.setRole(rst.getString("role"));
              
                
               lesusersRech.add(us1);
}
}       catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return lesusersRech;
        
    }
 public String getRole(String username) {
        String role = "";
        try {
            PreparedStatement pre = mc.prepareStatement("select role from Utilisateurs where login=?");
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                role = rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return role;
    }
   public int VerifParticipation(int Id_user) {
          int res=0;
        try {
            PreparedStatement pre = mc.prepareStatement("select count(*) from utilisateurs where Id_user=?");
            pre.setInt(1, Id_user);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
               res = rs.getInt(1);
               
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return res;
    }
   
        public int getId_userBynom(String i) throws SQLException {
        ste = mc.createStatement();
        int id_user = 0;

        try {

            PreparedStatement pre = mc.prepareStatement("SELECT Id_user  from utilisateurs where nom=?");
            pre.setString(1, i);
   
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {


                
                 id_user = rs.getInt("Id_user");

            }
        } catch (SQLException ex) {
        }

        return id_user;

    }

    @Override
    public ArrayList<Utilisateur> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Utilisateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    }


