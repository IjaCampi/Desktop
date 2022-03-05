/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import entites.Offre_Location;
import Services.Offre_LocationService;
import java.util.Random;

/**
 * FXML Controller class
 *
 * @author Omar Amri
 */
public class StoreInterfaceController implements Initializable {

    @FXML
    private VBox chosenEquipementCard;
    @FXML
    private Label MarqLabelvalue;
    @FXML
    private TextField quantiteTextField;
    @FXML
    private Button BtnCommander;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Label lbgetfrais;
    @FXML
    private ImageView EquipementImg;
    @FXML
    private Label EqMarqLabel;
    @FXML
    private Label lbfraisnom;

    /**
     * Initializes the controller class.
     */
    
    
    private void setChosenOffre(Offre_Location e) {
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", rand_num);
        EqNameLable.setText(e.getNom());
        EqPriceLabel.setText(String.valueOf(e.getPrix()) + " " + "TND");
        MarqLabelvalue.setText(e.getMarque());
        MarqLabelvalue.setText(e.getMarque());
        MarqLabelvalue.setText(e.getMarque());
        chosenEquipementCard.setStyle("-fx-background-color:" + colorCode + ";\n"
                + "    -fx-background-radius: 30;");
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // fruits.addAll(getData());
        Offre_LocationService offreLocation = new Offre_LocationService();
        if (offreLocation.getall().size() > 0) {
            //  setChosenFruit(fruits.get(0));
            setChosenEquipement(offreLocation.getall().get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Offre_Location e) {
                    setChosenEquipement(e);
                   StoreInterfaceController.current_id=e.getId();
                }
            };
        }
        
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < equipements.getall().size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EquipementFxml.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EquipementFxmlController equipemementController = fxmlLoader.getController();
                // itemController.setData(fruits.get(i),myListener);
                equipemementController.setData(equipements.getall().get(i), myListener);
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
        // TODO
    }    

    @FXML
    private void ajouterLigneCommande(ActionEvent event) {
    }
    
}
