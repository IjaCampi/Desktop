
package GUI;

import Services.Offre_LocationService;
import Services.Mail;
import entites.Moyen_Transport;
import entites.Offre_Location;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Omar Amri
 */
public class ReservationFormController implements Initializable {

    @FXML
    private Label lbdatedebut;
    @FXML
    private DatePicker tfdatedebut;
    @FXML
    private Label lbdatefin;
    @FXML
    private DatePicker tfdatefin;
    @FXML
    private TextField tfId;
    @FXML
    private Button btnreserver;
    @FXML
    private TextField tfplace;
    @FXML
    private Button btnretour;
    @FXML
    private AnchorPane apres;
    
    private Parent parent;
    @FXML
    private AnchorPane ap;
    
   private TableView<Moyen_Transport> tableReservations;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfId.setVisible(false);
    }    

    @FXML
    private void reserver(ActionEvent event) throws SQLException {
        
        
        //String date_debut = tfdatedebut.getText();
        //String date_fin = tfdatefin.getText();
        
        LocalDate dd = tfdatedebut.getValue();
        Date date_debut = Date.valueOf(dd);
        LocalDate df = tfdatefin.getValue();
        Date date_fin = Date.valueOf(df);
        
        String place = tfplace.getText();

        
        Offre_Location offLoc = new Offre_Location(date_debut,date_fin,place);
        Offre_LocationService offLocService = new Offre_LocationService();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        if(date_debut.equals("") || date_fin.equals("") || place.equals("")){
        
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erreur..!");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir les champs..!");
            alert.showAndWait();
        }else {
            offLocService.ajouter(offLoc);
        
        alert.setTitle("Succée");
        alert.setHeaderText("");
        alert.setContentText("Moyen Transport Resrvée..");
        alert.showAndWait();
        
        
        
        Mail.send(
            "amri.omar@esprit.tn",
		"213JMT1357",
		"wissal.saadi@isticbc.org",
		"IJACAMPI Services Clients",
		"Check : Reservation bien effectuée.."
                
	);
        }
        
        
        
        

        //tfdatedebut.setValue("");
        //tfdatefin.setValue("");
        
    }

    @FXML
    private void OffreInterface(MouseEvent event) {
        try {
            parent = FXMLLoader.load(getClass().getResource("/GUI/OffreCardForm.fxml"));
            apres.getChildren().removeAll();
            apres.getChildren().setAll(parent);
        } catch (IOException ex) {
            Logger.getLogger(ReservationFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    

    
}
