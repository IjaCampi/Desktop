/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.camping.GUI;

import com.edu.camping.models.Mail;
import com.edu.camping.models.Utilisateur;
import com.edu.camping.services.User_service;
import com.edu.camping.utils.DBconnection;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nmedia
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfNum_tel;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tflogin;
    @FXML
    private TextField tfpass;
    @FXML
    private Button btretour;
    @FXML
    private Button btsave;
    @FXML
    private RadioButton btnrole;
    @FXML
    private JFXDatePicker tfdate;
     
    @FXML
    private BorderPane tfAnchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
        
    

    @FXML
    private void enregistrer(ActionEvent event) {
        
   String nom = tfnom.getText();
        String prenom = tfprenom.getText();
        String adresse = tfadresse.getText();
        int Num_tel = Integer.parseInt(tfNum_tel.getText());
         

         String login = tflogin.getText();
           String password = tfpass.getText();
        String role = btnrole.getText();


        Utilisateur u = new Utilisateur(Num_tel,nom,prenom,adresse,login,password,role,tfdate.getValue().format(DateTimeFormatter.ISO_DATE));
                        User_service us = new User_service();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);  
          if(nom.isEmpty()||prenom.isEmpty()||adresse.isEmpty()||login.isEmpty()||password.isEmpty()||role.isEmpty()){
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erreur..!");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir les champs..!");
            alert.showAndWait();
        }
        else{
        try{
            
        us.addOne(u);
        alert.setTitle("Succée");
        alert.setHeaderText("Ajoutée");
        alert.setContentText("Utilisateur bien inscrit..");
        
        }catch (SQLException ex) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Erreur..!");
            alert.setHeaderText(" user n'a pas inscrit");
            alert.setContentText(ex.getMessage());
        }finally{
            alert.showAndWait();
        }
        
        Mail.send(
		"houssemjebali@gmail.com",
		"houssem1998",
		"houssem.jbali@esprit.tn",
		"Bienvenu sur IJA CAMPI",
		"Creation Compte effectué!"
	);
        
        }
}

    @FXML
    

    private void retour(ActionEvent event) {
      try{
            btretour.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/newLogin.fxml"));
                Stage mainStage = new Stage();
                Scene scene= new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
        }catch(Exception e){
    }
}
}