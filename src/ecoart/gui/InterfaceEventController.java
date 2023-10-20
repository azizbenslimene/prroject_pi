/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.gui;


import ecoart.entities.Event;
import ecoart.entities.EventAdmin;
import ecoart.services.EventService;
import ecoart.utils.MyConnection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
public class InterfaceEventController implements Initializable {

    @FXML
    private TableColumn<EventAdmin, String> colnom_event;
    @FXML
    private TableColumn<EventAdmin, String> coldate_event;
    @FXML
    private TableColumn<EventAdmin, String> collieu_event;
    @FXML
    private TableColumn<EventAdmin, String> coldesc_event;
    @FXML
    private TableColumn<EventAdmin, Integer> colprix_event;
    @FXML
    private AnchorPane anchorpane_event;
    @FXML
    private ImageView imageview_event;
    @FXML
    private Button btresv_event;
    @FXML
    private TableView<EventAdmin> tabview_event;
    
    EventService ES=new EventService();
    
     String path;
   MyConnection conx= MyConnection.getInstance();
    Connection myConx=conx.getConnection();
    String query = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ES.ShowReservation(colnom_event, coldate_event, collieu_event, coldesc_event, colprix_event, tabview_event);
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void tab_event(MouseEvent event) throws SQLException {
        
         String query = "SELECT image_a FROM eventadmin";
         
         pst = myConx.prepareStatement(query);

         ResultSet rs = pst.executeQuery();
    
    while (rs.next()) {
        String path = rs.getString("image_a");
        File imageFile = new File(path);
        Image image = new Image(imageFile.toURI().toString());
        imageview_event.setImage(image);
        System.out.println(path);
    }
    }
    @FXML
    private void reserverTicket(MouseEvent event ) throws IOException {
        
    EventAdmin selectedEvent = tabview_event.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceTicket.fxml"));
        Parent root = loader.load();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Vous pouvez choisir le format que vous souhaitez
    String formattedDate = selectedEvent.getDate_a().format(formatter);
        InterfaceTicketController ticketController = loader.getController();
                System.err.println(" selectedEvent.getPathQR()"+ selectedEvent.getPathQR()+" selectedEvent.getNom()"+ selectedEvent.getImage_a());

        ticketController.setEventInfo(
            selectedEvent.getNom_a(),
            formattedDate,
            selectedEvent.getLieu_a(),
          
            selectedEvent.getPrix_a(),
            selectedEvent.getPathQR()

                
        );
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
   
    }

    @FXML
    private void retour_ev(MouseEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("EventUser.fxml"));
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene((Parent) root);
          primaryStage.setScene(scene);
           primaryStage.show();
    }

}

