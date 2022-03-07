
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.camping.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author nmedia
 */
public class DashbordAdminController implements Initializable {

    @FXML
    private BorderPane DashbordPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

    @FXML
    private void actionuser(ActionEvent event) {
         loadUi("Utilisateur");
    }
    
             private void loadUi(String ui) {
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+ ".fxml"));
        } catch (IOException ex) {
            
        }
        DashbordPane.setCenter(root);
    

    }
    }
    
    
    

