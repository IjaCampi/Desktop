/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.camping.tests;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author nmedia
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage)  {
      
    
    
            // try {
            // URL fxUrl=getClass().getResource("../GUI/AddUserForm.fxml");
            //Parent root =FXMLLoader.load(fxUrl);
            //Scene scene= new Scene(root);
            //primaryStage.setScene(scene);
            //primaryStage.setTitle("Add user");
            //primaryStage.show();
            // } catch (IOException ex) {
            // System.out.println(ex.getMessage());
            
            
            try{
            
            AnchorPane pan=FXMLLoader.load(getClass().getResource("../GUI/newLogin.fxml"));
                   Scene scene= new Scene(pan);

        
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login ");
            primaryStage.show();
        } catch (IOException ex) {
        System.out.println(ex.getMessage());
   
    }
        }
    public static void main(String[]args) {
         launch(args);
    }
    
}
