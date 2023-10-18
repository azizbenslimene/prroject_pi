/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.gui;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import ecoart.entities.Event;
import ecoart.entities.EventAdmin;
import ecoart.services.EventService;
import java.io.IOException;
import java.net.URL;
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
    @FXML
    private Label labeleventnom;
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
    private void tab_event(MouseEvent event) {
    }

    @FXML
    private void reserverTicket(MouseEvent event ) throws IOException {
        
    EventAdmin selectedEvent = tabview_event.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceTicket.fxml"));
        Parent root = loader.load();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Vous pouvez choisir le format que vous souhaitez
    String formattedDate = selectedEvent.getDate_a().format(formatter);
        InterfaceTicketController ticketController = loader.getController();
        ticketController.setEventInfo(
            selectedEvent.getNom_a(),
            formattedDate,
            selectedEvent.getLieu_a(),
            selectedEvent.getDescription_a(),
            selectedEvent.getPrix_a()
        );

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }

}

