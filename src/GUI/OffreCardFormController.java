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
    private Label lbfrais;
    
    private myListener myListener;

    private Moyen_Transport Moyen_Transport;
    @FXML
    private Label lbtype;
    @FXML
    private Label lbmatricule;
    @FXML
    private Label lbmarque;
    @FXML
    private Label lbnbrplace;
    
    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(Moyen_Transport);
    }
    
    public void setData(Moyen_Transport Moyen_Transport, myListener myListener) {
        this.Moyen_Transport = Moyen_Transport;
        this.myListener = myListener;
        lbtype.setText(Moyen_Transport.getType());
        lbfrais.setText( String.valueOf(Moyen_Transport.getFrais())+ " "+"TND");
        lbmatricule.setText(Moyen_Transport.getMatricule());
        lbmarque.setText(Moyen_Transport.getMarque());
        lbnbrplace.setText(String.valueOf(Moyen_Transport.getNbr_place()));
        
        
    }

}
