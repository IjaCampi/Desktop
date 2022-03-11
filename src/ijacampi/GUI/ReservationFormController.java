
package ijacampi.GUI;

import ijacampi.Services.Offre_LocationService;
import ijacampi.Entities.Offre_Location;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

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
            offLocService.Ajouter(offLoc);
        
        alert.setTitle("Succée");
        alert.setHeaderText("");
        alert.setContentText("Moyen Transport Resrvée..");
        alert.showAndWait();
            
        }
        
        
        
        

        //tfdatedebut.setValue("");
        //tfdatefin.setValue("");
        
    }

    
}
