/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.camping.GUI;

import com.edu.camping.models.Utilisateur;
import com.edu.camping.services.User_service;
import com.edu.camping.utils.DBconnection;
import java.awt.Window;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nmedia
 */
public class NewLoginController implements Initializable {

    @FXML
    private TextField tflogin;
    @FXML
    private TextField tfpass;
    @FXML
    private Button btvalider;
    @FXML
    private Button tfsignup;
    @FXML
    private BorderPane tfAnchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
private Statement ste;
Connection mc=DBconnection.getInstance().getCnx();

    @FXML
    private void Connecter(ActionEvent event) throws SQLException  {
        
        String role="";
        Utilisateur u=new Utilisateur();
        User_service us=new User_service();
         role= us.getRole(tflogin.getText());
         System.out.println(role);
          Alert alert=new Alert(Alert.AlertType.WARNING);
         
 
           int res = us.VerifParticipation(us.getId_userBynom(tflogin.getText()));
        
        if(tflogin.getText().equals("")|| tfpass.getText().equals("") ){
           
         alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Conditions de saisie");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill all the fields first!");
            alert.showAndWait();
          }
        
        else if(res==0){alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Conditions de saisie");
            alert.setHeaderText(null);
            alert.setContentText("You should sign up!");
            alert.showAndWait();
       
       }
       
         if(res!=0){alert.setAlertType(Alert.AlertType.WARNING);}
        if(role.contains("Admin") ){
           
         u.setRole("Admin");
          loadUi("DashbordAdmin");
         }
    
        if(role.contains("Camper")){

        u.setRole("Camper");
          loadUi("Dashborduser");
        
        } 
        
         if(role.contains("Agent_transport")){

        u.setRole("Agent_transport");
          loadUi("Dashborduser");
        
         
         }
          if(role.contains("Hebergeur")){

        u.setRole("Hebergeur");
          loadUi("Dashborduser");
        
         
         }
    }
      
         private void loadUi(String ui) {
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+ ".fxml"));
        } catch (IOException ex) {
            
        }
        tfAnchor.setCenter(root);
    

    }

    @FXML
    private void signup(ActionEvent event) {
        
        
         
          
        
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
        } catch (IOException ex) {
            
        }
        tfAnchor.setCenter(root);
    

    }

       

    @FXML
    private void oublierpass(MouseEvent event) {
          
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Passwordforget.fxml"));
        } catch (IOException ex) {
            
        }
        tfAnchor.setCenter(root);
    
        
    }
    }

    
             
          

        
          
            
        
    
      
    
         
    
    


   
    
    
    
