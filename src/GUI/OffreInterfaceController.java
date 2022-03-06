/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.MoyenTransportService;
import Services.Offre_LocationService;
import Test.myListener;
import entites.Moyen_Transport;
import entites.Offre_Location;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.layout.Region;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Omar Amri
 */
public class OffreInterfaceController implements Initializable {


    @FXML
    private Label lbetat;
    @FXML
    private Label lbfrais;
    @FXML
    private Label lbdatedebut;
    @FXML
    private Label lbdatefin;
    @FXML
    private Label lbnumtel;
    @FXML
    private Button btnReserver;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    
    private myListener myListener;
    @FXML
    private VBox chosenOffreCard;

    /**
     * Initializes the controller class.
     */
    
    private void setChosenOffres(Offre_Location e) {
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", rand_num);
        lbetat.setText(e.getEtat());
        lbfrais.setText(String.valueOf(e.getFrais()) + " " + "TND");
        lbdatedebut.setText(e.getDate_debut());
        lbdatefin.setText(e.getDate_fin());
        lbnumtel.setText(e.getNum_tel());
        chosenOffreCard.setStyle("-fx-background-color:" + colorCode + ";\n"
                + "    -fx-background-radius: 30;");
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Offre_LocationService Offre_LocationService = new Offre_LocationService();
        if (Offre_LocationService.afficher().size() > 0) {
            //  setChosenFruit(fruits.get(0));
            setChosenOffres(Offre_LocationService.afficher().get(0));
            myListener = new myListener() {
                
                @Override
                public void onClickListener(Offre_Location Offre_Location) {
                    
                    setChosenOffres(Offre_Location);
                    
                    
                }
            };
        }
        
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < Offre_LocationService.afficher().size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("OffreCardForm.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OffreCardFormController OffreCardController = fxmlLoader.getController();
                // itemController.setData(fruits.get(i),myListener);
                OffreCardController.setData(Offre_LocationService.afficher().get(i), myListener);
                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    @FXML
    private void ajouterLigneCommande(ActionEvent event) {
    }
    
}
