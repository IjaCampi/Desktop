/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Omar Amri
 */
public class OffreLocationFormController implements Initializable {

    @FXML
    private TableView<?> tableReservation;
    @FXML
    private TableColumn<?, ?> tvdatedebut;
    @FXML
    private TableColumn<?, ?> tvdatefin;
    @FXML
    private TableColumn<?, ?> tvplace;
    @FXML
    private TableColumn<?, ?> clId;
    @FXML
    private Button btnlisteoffres;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfrechercher;
    @FXML
    private Button btrechercher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getSelected(MouseEvent event) {
    }

    @FXML
    private void rechercher(KeyEvent event) {
    }
    
}
