
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Omar Amri
 */
public class DBConnexion {
    
    
    private String URL="jdbc:mysql://localhost:3306/ijacampi";
    private String USER="root";
    private String PWD="";
    private Connection cnx;
    private static DBConnexion instance;
    
    
    private DBConnexion(){
        
        try {
            cnx= DriverManager.getConnection(URL,USER,PWD);
            System.out.println("Vous étes Connecté..!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
           
    }
    
    
    public static DBConnexion getInstance(){
        if (instance == null)
            instance = new DBConnexion();
        return (instance);
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
