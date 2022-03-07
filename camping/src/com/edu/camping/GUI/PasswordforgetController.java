/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.camping.GUI;

import com.edu.camping.models.Utilisateur;
import com.edu.camping.services.User_service;
import com.edu.camping.utils.DBconnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nmedia
 */
public class PasswordforgetController implements Initializable {

    @FXML
    private TextField tfnewpass;
    @FXML
    private TextField tfcpass;
    @FXML
    private Button btnok;
 User_service us=new User_service();

        ObservableList<Utilisateur>listusers=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ok(ActionEvent event) throws SQLException {
         Connection cnx = DBconnection.getInstance().getCnx();
        
            String sql= "update utilisateurs set password = ? where login= ?";
             PreparedStatement pst = cnx.prepareStatement(sql);
          pst.execute();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        if(tfnewpass.equals(" ")|| tfcpass.equals(" ") ){
        
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erreur..!");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir les champs..!");
            alert.showAndWait();
        }
        tfnewpass.setText("");
        tfcpass.setText("");
        alert.setTitle("Succée");
        alert.setHeaderText("Modifiée");
        alert.setContentText("password  bien Modifiée..");
        
        alert.showAndWait();
        
       
        
       
    }}
    

