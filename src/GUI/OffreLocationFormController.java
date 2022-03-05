
package GUI;

import Services.MoyenTransportService;
import Services.Offre_LocationService;
import Utils.DBConnexion;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import entites.Moyen_Transport;
import entites.Offre_Location;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Utils.DBConnexion;

/**
 * FXML Controller class
 *
 * @author Omar Amri
 */
public class OffreLocationFormController implements Initializable {
    

    @FXML
    private TextField tfrechercher;
    @FXML
    private Button btrechercher;
    @FXML
    private Label lbnumtel;
    @FXML
    private TextField tfnumtel;
    @FXML
    private Label lbfrais;
    @FXML
    private TextField tffrais;
    @FXML
    private Label lbetat;
    @FXML
    private TableView<Offre_Location> tableviewoffres;
    @FXML
    private TableColumn<Offre_Location, String> tvnumtel;
    @FXML
    private TableColumn<Offre_Location, String> tvdatedebut;
    @FXML
    private TableColumn<Offre_Location, String> tvdatefin;
    @FXML
    private TableColumn<Offre_Location, Double> tvfrais;
    @FXML
    private TableColumn<Offre_Location, String> tvetat;
    @FXML
    private Button btnajouteroffres;
    @FXML
    private Button btnmodifieroffres;
    @FXML
    private Button btnlisteoffres;
    @FXML
    private Button btnsupprimeroffres;
    
    Offre_LocationService offLocSer = new Offre_LocationService();
    ObservableList<Offre_Location> listOffreLoc = FXCollections.observableArrayList();
    @FXML
    private Label lbdatedebut;
    @FXML
    private Label lbdatefin;
    @FXML
    private TextField tfdatedebut;
    @FXML
    private TextField tfdatefin;
    @FXML
    private TableColumn<Offre_Location, Integer> clId;
    @FXML
    private TextField tfId;
    @FXML
    private ComboBox<String> combobox;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clId.setVisible(false);
        tfId.setVisible(false);
        
        combobox.setItems(FXCollections.observableArrayList("Disponible", "Epuisé"));
    }    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {

        String num_tel = tfnumtel.getText();
        String date_debut = tfdatedebut.getText();
        String date_fin = tfdatefin.getText();
        Double frais = parseDouble(tffrais.getText());
        String etat = combobox.getValue();

        
        Offre_Location offLoc = new Offre_Location(date_debut,date_fin,frais,etat,num_tel);
        Offre_LocationService offLocService = new Offre_LocationService();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        if(num_tel.isEmpty() || date_debut.isEmpty() || date_fin.isEmpty()){
        
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erreur..!");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir les champs..!");
            alert.showAndWait();
        }
        
        offLocService.ajouter(offLoc);
        
        alert.setTitle("Succée");
        alert.setHeaderText("");
        alert.setContentText("Offre Location bien Ajoutée..");
        alert.showAndWait();
        
        listOffreLoc.clear();
        afficher();
        
        tfnumtel.setText("");
        tfdatedebut.setText("");
        tfdatefin.setText("");
        tffrais.setText("");
        combobox.setValue("");
       
        
        
        
        
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        
        Connection cnx = DBConnexion.getInstance().getCnx();
        
        String num_tel = tfnumtel.getText();
        String date_debut = tfdatedebut.getText();
        String date_fin = tfdatefin.getText();
        Double frais = parseDouble(tffrais.getText());
        String etat = combobox.getValue();
        int id_offrelocation = Integer.parseInt(tfId.getText());
        
        String sql = "update offre_location set"
                + "date_debut = '"+date_debut+"'"
                + ",date_fin = '"+date_fin+"'"
                + ",frais = "+frais+""
                + ",etat = '"+etat+"'"
                + "num_tel = '"+num_tel+"'"
                + " where id_offrelocation = '" +id_offrelocation +"'";
        
        PreparedStatement pst = cnx.prepareStatement(sql);
        pst.execute();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        if(num_tel.isEmpty() || date_debut.isEmpty() || date_fin.isEmpty() || etat.isEmpty()){
        
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Erreur..!");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez remplir les champs..!");
            alert.showAndWait();
        }
        

        alert.setTitle("Succée");
        alert.setHeaderText("");
        alert.setContentText("Moyen Transport bien Modifiée..");
        alert.showAndWait();
        
        tfnumtel.setText("");
        tfdatedebut.setText("");
        tfdatefin.setText("");
        tffrais.setText("");
        combobox.setValue("");
        
        listOffreLoc.clear();
        afficher();
    }

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        


        
        Offre_Location offLoc = new Offre_Location(tableviewoffres.getSelectionModel().getSelectedItem().getNum_tel());
      
        Offre_LocationService offLocService = new Offre_LocationService();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        offLocService.supprimer(offLoc);
        alert.setTitle("Succée");
        alert.setHeaderText("");
        alert.setContentText("Offre Location bien Supprimée..");
                
        alert.showAndWait();
        
        tfnumtel.setText("");
        tfdatedebut.setText("");
        tfdatefin.setText("");
        tffrais.setText("");
        combobox.setValue("");
        
        listOffreLoc.clear();
        afficher();
        
    }

    @FXML
    private void rechercher() throws SQLException {
        
        
    Offre_LocationService offLocService= new Offre_LocationService() ;
    List<Offre_Location>results = new ArrayList<>();
    results = offLocService.afficher();
     FilteredList<Offre_Location> filteredData = new FilteredList<>(listOffreLoc , b -> true);
		Offre_Location o = new Offre_Location();

		tfrechercher.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Offre_Location -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Offre_Location.getNum_tel().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}else if (Offre_Location.getDate_debut().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}else if (Offre_Location.getDate_fin().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}else if (Offre_Location.getEtat().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}else if (String.valueOf(o.getEtat()).indexOf(lowerCaseFilter) != -1) 
					return true;
				     else  
				    	 return false;
			});
		});
                
                
                SortedList<Offre_Location> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(tableviewoffres.comparatorProperty());
		
		tableviewoffres.setItems(sortedData);
               
        
    }

    @FXML
    private void afficher() {
        
        
        listOffreLoc.clear();
        
        tvnumtel.setSortType(TableColumn.SortType.ASCENDING);
        tvdatedebut.setSortType(TableColumn.SortType.ASCENDING);
        tvdatefin.setSortType(TableColumn.SortType.ASCENDING);
        tvfrais.setSortType(TableColumn.SortType.ASCENDING);
        
        tvnumtel.setCellValueFactory(new PropertyValueFactory<Offre_Location, String>("num_tel"));
        System.out.println(tvnumtel.getCellData(0));
        
        tvdatedebut.setCellValueFactory(new PropertyValueFactory<Offre_Location, String>("date_debut"));
        System.out.println(tvdatedebut.getCellData(1));
        
        tvdatefin.setCellValueFactory(new PropertyValueFactory<Offre_Location, String>("date_fin"));
        System.out.println(tvdatefin.getCellData(2));
        
        tvfrais.setCellValueFactory(new PropertyValueFactory<Offre_Location, Double>("frais"));
        System.out.println(tvfrais.getCellData(3));
        
        tvetat.setCellValueFactory(new PropertyValueFactory<Offre_Location, String>("etat"));
        System.out.println(tvetat.getCellData(3));
        
        clId.setCellValueFactory(new PropertyValueFactory<Offre_Location, Integer>("id_offrelocation"));
        clId.setVisible(false);

        listOffreLoc.addAll(offLocSer.afficher());
        
        tableviewoffres.setItems(listOffreLoc);
        System.out.println(listOffreLoc);
        
    }
    
    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) throws SQLException {
        
        int index = tableviewoffres.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    
            Connection cnx = DBConnexion.getInstance().getCnx();
            
            tfnumtel.setText(tvnumtel.getCellData(index).toString());
            tfdatedebut.setText(tvdatedebut.getCellData(index).toString());
            tfdatefin.setText(tvdatefin.getCellData(index).toString());
            tffrais.setText(tvfrais.getCellData(index).toString());
            combobox.setValue(tvetat.getCellData(index).toString());
            tfId.setText(clId.getCellData(index).toString());
            
    }
    
}
