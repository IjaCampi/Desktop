/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.GUI;

import ijacampi.Entities.Commande;
import ijacampi.Entities.Equipement;
import ijacampi.Entities.LigneCommande;
import ijacampi.Services.LigneCommandeService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author brahim
 */
public class ListCommandeController {
    private Commande commande;
    @FXML
    private TableView<LigneCommande> tvLc;
    private TableColumn<LigneCommande, String> tvfNom;
    @FXML
    private Label reflabel;
    @FXML
    private TextField labeladresse;
    @FXML
    private Label labelvtot;
    ObservableList<LigneCommande> listCommande = FXCollections.observableArrayList();
    @FXML
    private TableColumn<LigneCommande, Integer> tvid;
    @FXML
    private TableColumn<LigneCommande, Integer> tveq;
    @FXML
    private TableColumn<LigneCommande, Integer> tvfc;
    @FXML
    private TableColumn<LigneCommande, Integer> tvfq;
    private LigneCommandeService lcs;
    @FXML
    private Button show;

    /**
     * Initializes the controller class.
     */
        public void SetData(Commande commande)
        {
         
             
            this.commande=commande;
                
            

        }
    public void initialize(URL url, ResourceBundle rb) {
     
    } 

    @FXML
    private void afficher(ActionEvent event) {
            //System.out.println("get id" +commande.getId());
           // System.out.println(lcs.getbyCommandeid(commande.getId()));
       /*  tvid.setCellValueFactory(new PropertyValueFactory<LigneCommande,Integer>("id"));
        tveq.setCellValueFactory(new PropertyValueFactory<LigneCommande,Integer>("id_equipement"));
          tvfc.setCellValueFactory(new PropertyValueFactory<LigneCommande,Integer>("id_commande"));
        tvfq.setCellValueFactory(new PropertyValueFactory<LigneCommande,Integer>("quantite"));
            listCommande.addAll(lcs.getbyCommandeid(commande.getId()));
           tvLc.setItems(listCommande);
*/    
}
    
    
}
