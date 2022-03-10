/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import entities.Avis;
import entities.Reclamation;
import entities.Sos;
import services.AvisService;
import services.ReclamationService;
import services.SosService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Pidev  extends Application {
  
    @Override
    public void start(Stage stage) throws Exception {
      
//         Parent root = FXMLLoader.load(getClass().getResource("/Gui/ShowAvis.fxml"));
         Parent root = FXMLLoader.load(getClass().getResource("/Gui/AfficherMerReclamation.fxml"));


        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
