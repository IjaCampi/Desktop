
package Test;


import entites.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Omar Amri
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
            
        try {
            URL fxURL = getClass().getResource("../GUI/HomeForm.fxml");
            Parent root;
            root = FXMLLoader.load(fxURL);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("ijacampii");
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
            
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
