/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.gui;


import ecoart.entities.EventUser;
import static ecoart.gui.HomePage.main;

import ecoart.services.EventUserService;
import ecoart.utils.MyConnection;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EventUserController implements Initializable {

    @FXML
    private DatePicker daterev_u;
    @FXML
    private Button btajoutResv_u;
    @FXML
    private Button btsupResv_u;
    @FXML
    private Button btmodifResv_u;
    @FXML
    private TableView<EventUser> tabResv_u;
    @FXML
    private TableColumn<EventUser, String> colnom_u;
    @FXML
    private TableColumn<EventUser, String> coldate_u;
    @FXML
    private TableColumn<EventUser, String> collieu_u;
    @FXML
    private TableColumn<EventUser, String> coldesc_u;
    @FXML
    private ComboBox<String> combolieu_u;
    @FXML
    private Button btimgResv_u;
    @FXML
    private AnchorPane main_u;
    @FXML
    private ImageView espaceImg_u;
    @FXML
    private TextField tfnom_u;
    
    @FXML
    private TableColumn<EventUser, String> colprix_u;
    @FXML
    private TextField tfprix_u;
    @FXML
    private TextArea txtdesc_u;

    
    MyConnection conx= MyConnection.getInstance();
    Connection myConx=conx.getConnection();
    String query = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Initializes the controller class.
     */
        EventUserService a =new EventUserService();
    @FXML
    private ImageView btnext_u;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         ObservableList<String> items = FXCollections.observableArrayList(
            "Value 1",
            "Value 2",
            "Value 3",
            "Value 4",
            "Value 5");
        combolieu_u.setItems(items);

       
       
        try {
            a.ShowReservation(colnom_u, coldate_u, collieu_u, coldesc_u,colprix_u,tabResv_u);
        } catch (SQLException ex) {
            Logger.getLogger(EventUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // TODO
            a.ShowReservation(colnom_u, coldate_u, collieu_u, coldesc_u, colprix_u, tabResv_u);
        } catch (SQLException ex) {
            Logger.getLogger(EventUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    


    @FXML
    private void Ajoutresv_u(MouseEvent event) {
        
        try {
        
        int id = 0; // You can set the ID as needed, or let the database auto-generate it
        String nom = tfnom_u.getText();
        LocalDate date = daterev_u.getValue();
        String lieu = combolieu_u.getSelectionModel().getSelectedItem().toString();
        String description = txtdesc_u.getText();
        
        
        Image image = espaceImg_u.getImage(); // Get the image from the ImageView
        int prix = Integer.parseInt(tfprix_u.getText());
        
        String emptyString = "";
       byte[] emptyByteArray = emptyString.getBytes();
       
        // Create an EventUser object and call ajoutEventUser with it
        EventUser e = new EventUser(id, nom, date, lieu, description,emptyByteArray, prix);
        a.ajoutEventUser(e, image);

        a.ShowReservation(colnom_u, coldate_u, collieu_u, coldesc_u, colprix_u, tabResv_u);
        // Optionally, you can handle success or display a message here
    } catch (Exception ex) {
        ex.printStackTrace();
        // Handle errors or display an error message
    }
    }

    @FXML
    private void Supresv_u(MouseEvent event) throws SQLException {
        
        
         EventUser selectedEvent = tabResv_u.getSelectionModel().getSelectedItem();

    if (selectedEvent != null) {
        int result = a.supprimerEventUser(selectedEvent);

        if (result == 1) {
            // Deletion successful, you can update the TableView or take any other action
            a.ShowReservation(colnom_u, coldate_u, collieu_u, coldesc_u, colprix_u, tabResv_u);
        } else if (result == 0) {
            // No records were deleted, possibly the record does not exist
        } else {
            // An error occurred during deletion
        }
    }
    a.ShowReservation(colnom_u, coldate_u, collieu_u, coldesc_u, colprix_u, tabResv_u);
    }

    @FXML
    private void Modresv_u(MouseEvent event) {
        
             try {
         
        int id = 0; // You can set the ID as needed, or let the database auto-generate it
        String nom = tfnom_u.getText();
        LocalDate date = daterev_u.getValue();
        String lieu = combolieu_u.getSelectionModel().getSelectedItem().toString();
        String description = txtdesc_u.getText();
        
        
        Image image = espaceImg_u.getImage(); // Get the image from the ImageView
        int prix = Integer.parseInt(tfprix_u.getText());
        
        String emptyString = "";
       byte[] emptyByteArray = emptyString.getBytes();
       
        // Create an EventUser object and call ajoutEventUser with it
         
        int selectedIndex = tabResv_u.getSelectionModel().getSelectedIndex();
        int selectedId = -1; // Initialize to a default value

if (selectedIndex >= 0) {
    // If a row is selected, retrieve the ID from the database
    EventUser selectedEvent = tabResv_u.getItems().get(selectedIndex);
    selectedId = selectedEvent.getId_u();
}
            EventUser e = new EventUser(id, nom, date, lieu, description,emptyByteArray, prix);
            a.modifEventUser(e, image, selectedIndex, selectedId);


        a.ShowReservation(colnom_u, coldate_u, collieu_u, coldesc_u, colprix_u, tabResv_u);
        // Optionally, you can handle success or display a message here
    } catch (Exception ex) {
        ex.printStackTrace();
        // Handle errors or display an error message
    }
    }

    @FXML
    private void tab_u(MouseEvent event) {
        
         EventUser selectedEvent = tabResv_u.getSelectionModel().getSelectedItem();

if (selectedEvent != null) {
    String nom_u = selectedEvent.getNom_u();
    String lieu_u = selectedEvent.getLieu_u();
    
    // Query the database to get the image data and other information based on nom_a and lieu_a
    String query = "SELECT image, date, prix, description FROM eventuser WHERE nom = ? AND lieu = ?";

    try {
        pst = myConx.prepareStatement(query);
        pst.setString(1, nom_u);
        pst.setString(2, lieu_u);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            // Retrieve the image data as a byte array
            byte[] imageData = rs.getBytes("image");

            // Convert the byte array to an Image
            Image image = new Image(new ByteArrayInputStream(imageData));

            // Set the image in the ImageView
            espaceImg_u.setImage(image);

            // Fill other JavaFX controls
            tfnom_u.setText(nom_u); // Fill TextField
            daterev_u.setValue(rs.getDate("date").toLocalDate()); // Fill DatePicker
            combolieu_u.setValue(lieu_u); // Fill ComboBox
            tfprix_u.setText(String.valueOf(rs.getInt("prix"))); // Fill TextField
            txtdesc_u.setText(rs.getString("description")); // Fill TextArea
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    }

    @FXML
    private void importerImg_u(MouseEvent event) {
        EventUserService a =new EventUserService();
        a.imporeterImg(main_u,espaceImg_u);
    }


    @FXML
    private void combolieu_u(ActionEvent event) {
    }

    @FXML
    private void next_u(MouseEvent event) throws IOException {
        
        Object root = FXMLLoader.load(getClass().getResource("InterfaceEvent.fxml"));
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene((Parent) root);
          primaryStage.setScene(scene);
           primaryStage.show();
    }

   
    
}
