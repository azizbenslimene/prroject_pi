/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
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
    private TableColumn<?, ?> colnom_event;
    @FXML
    private TableColumn<?, ?> coldate_event;
    @FXML
    private TableColumn<?, ?> collieu_event;
    @FXML
    private TableColumn<?, ?> coldesc_event;
    @FXML
    private TableColumn<?, ?> colprix_event;
    @FXML
    private AnchorPane anchorpane_event;
    @FXML
    private ImageView imageview_event;
    @FXML
    private Button btresv_event;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tab_event(MouseEvent event) {
    }

    @FXML
    private void reserverTicket(MouseEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("InterfaceTicket.fxml"));
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene((Parent) root);
          primaryStage.setScene(scene);
           primaryStage.show();
    }
    
}
