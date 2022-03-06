/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Test.myListener;
import entites.Moyen_Transport;
import entites.Offre_Location;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Omar Amri
 */
public class OffreCardFormController {

    @FXML
    private Label lbetat;
    @FXML
    private Label lbfrais;
    @FXML
    private Label lbdatedebut;
    @FXML
    private Label lbnumtel;
    
    private myListener myListener;

    private Offre_Location Offre_Location;
    @FXML
    private Label lbdatefin;
    
    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(Offre_Location);
    }
    
    public void setData(Offre_Location Offre_Location, myListener myListener) {
        this.Offre_Location = Offre_Location;
        this.myListener = myListener;
        lbetat.setText(Offre_Location.getEtat());
        lbfrais.setText( String.valueOf(Offre_Location.getFrais())+ " "+"TND");
        lbdatedebut.setText(Offre_Location.getDate_debut());
        lbdatefin.setText(Offre_Location.getDate_fin());
        lbnumtel.setText(Offre_Location.getNum_tel());
        
        
    }
    

    
}
