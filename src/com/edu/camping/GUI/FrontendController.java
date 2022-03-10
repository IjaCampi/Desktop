/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.camping.GUI;

 
import com.edu.camping.models.Utilisateur;
import com.edu.camping.services.User_service;
import com.edu.camping.tests.MyListener;
import com.edu.camping.utils.DBconnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nmedia
 */
public class FrontendController implements Initializable {
User_service us =new User_service();

    @FXML
    private TextField tfnom;
    
    private MyListener myListener;
    
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfadresse;
    @FXML
    private JFXDatePicker tfdate;
    private Statement ste;
Connection mc=DBconnection.getInstance().getCnx();
    @FXML
    private JFXTextField tflogin;
    @FXML
    private JFXTextField tftel;
    @FXML
    private ImageView img;
    @FXML
    private JFXTextField tfid;
    @FXML
    private JFXButton btnretour;
    @FXML
    private JFXButton btnmodif;
    private Utilisateur Utilisateur;
    @FXML
    private Label lbnom;
    @FXML
    private Label lbprenom;
    @FXML
    private Label lblogin;
    @FXML
    private Label lbtel;
    @FXML
    private Label lbadresse;
    @FXML
    private Label lbrole;
    @FXML
    private Label lbdate;
    @FXML
    private JFXTextField tfad;
    @FXML
    private Label lbprenom1;
    @FXML
    private JFXTextField tfpass;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
    }    
 
   
   

    @FXML
    private void quit(ActionEvent event) {
         try{
            btnretour.getScene().getWindow().hide();
            Parent root =FXMLLoader.load(getClass().getResource("../GUI/DashbordAdmin.fxml"));
                Stage mainStage = new Stage();
                Scene scene= new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
        }catch(Exception e){
    }}
    
    
    
           


    
    
    

    @FXML
    private void modif(ActionEvent event) {
       Utilisateur u=new Utilisateur();
       String nom = tfnom.getText();
       String prenom = tfprenom.getText();    
      String adresse = tfadresse.getText();
         String telephone = tftel.getText();
          int id = Integer.parseInt(tfid.getText());
  String Login = u.getLogin();
    String Date_naissance = u.getDate_naissance();
      String rolee = u.getRole();
//      //   String mdp1 = tfmdp1.getText();
//          String tel = tftel.getText();
     Utilisateur uuu= new Utilisateur(id,nom, prenom ,adresse, telephone,Login,Date_naissance, rolee );
System.out.println(uuu);
    
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
          try{
                  us.updateOne(uuu);
                     alert.setAlertType(Alert.AlertType.INFORMATION);
                     alert.setTitle("User modified");
                     alert.setHeaderText("Results:");
                     alert.setContentText("User modified successfully!");
               } catch (SQLException ex){
                                //Alert Error Tournois :
                       alert.setAlertType(Alert.AlertType.WARNING);
                       alert.setTitle("ERROR");
                       alert.setHeaderText("Adding Error !! ");
                       alert.setContentText(ex.getMessage());
                       //Alert Error Tournois !
        } finally{
              alert.showAndWait();
        }
          }
    
    
    
    public void setData (Utilisateur Utilisateur, MyListener MylistenerProfil){
        this.Utilisateur=Utilisateur;
        this.myListener=myListener;
        
        tfnom.setText(Utilisateur.getNom());
        tfprenom.setText(Utilisateur.getPrenom());
        tfad.setText(Utilisateur.getAdresse());
        
    }
    
}
