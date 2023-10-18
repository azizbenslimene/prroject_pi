/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.gui;

import ecoart.entities.EventAdmin;
import ecoart.services.EventAdminService;
import ecoart.utils.MyConnection;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
  

public class EventAdminController implements Initializable {

    @FXML
    private TableView<EventAdmin> tabResv_a;
    @FXML
    private TableColumn<EventAdmin, String> colnom_a;
    
    @FXML
    private TableColumn<EventAdmin, String> coldate_a;
      @FXML
    private TableColumn<EventAdmin, String> collieu_a;
    @FXML
    private TableColumn<EventAdmin, String> coldesc_a;
    
    @FXML
    private ComboBox<String> combolieu_a= new ComboBox<>();;
    
    @FXML
    private TextField tfnom_a;
    
    @FXML
    private DatePicker daterev_a;
    @FXML
    private Button btajoutResv_a;
    @FXML
    private Button btsupResv_a;
    @FXML
    private Button btmodifResv_a;

    @FXML
    private Button btimgResv_a;
    @FXML
    private ImageView espaceImg_a;
    @FXML
    private AnchorPane main;
    @FXML
    private TableColumn<EventAdmin, String> colprix_a;
    @FXML
    private TextField tfprix_a;
    @FXML
    private TextArea txtdesc_a;
    
       String path;
   MyConnection conx= MyConnection.getInstance();
    Connection myConx=conx.getConnection();
    String query = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Initializes the controller class.
     */
        EventAdminService a =new EventAdminService();
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
       
      
        ObservableList<String> items = FXCollections.observableArrayList("ariana","beja","ben arous","bizert","tatwin","touzeur","tunis","jandouba","zaghwen","silyana","sousse",
                "sidi bouzid","safax","gbeli","gasrin","gafsa","kerwan","keef","mednin","mounastir","manouba","mahdia","nabeul");
            
            
        combolieu_a.setItems(items);

       
        EventAdminService aa =new EventAdminService();
        try {
            aa.ShowReservation(colnom_a, coldate_a, collieu_a, coldesc_a,colprix_a,tabResv_a);
        } catch (SQLException ex) {
            Logger.getLogger(EventAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // TODO
            a.ShowReservation(colnom_a, coldate_a, collieu_a, coldesc_a, colprix_a, tabResv_a);
        } catch (SQLException ex) {
            Logger.getLogger(EventAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
  private void Ajoutresv(MouseEvent event) {
    try {
        
        int id = 0; // You can set the ID as needed, or let the database auto-generate it
        String nom = tfnom_a.getText();
        LocalDate date = daterev_a.getValue();
        String lieu = combolieu_a.getSelectionModel().getSelectedItem().toString();
        String description = txtdesc_a.getText();
        
        
        Image image = espaceImg_a.getImage(); // Get the image from the ImageView
        int prix = Integer.parseInt(tfprix_a.getText());
        
        String emptyString = "";
       byte[] emptyByteArray = emptyString.getBytes();
       
        // Create an EventAdmin object and call ajoutEventAdmin with it
        EventAdmin e = new EventAdmin(id, nom, date, lieu, description,path, prix);
        a.ajoutEventAdmin(e, path);

        a.ShowReservation(colnom_a, coldate_a, collieu_a, coldesc_a, colprix_a, tabResv_a);
        // Optionally, you can handle success or display a message here
    } catch (Exception ex) {
        ex.printStackTrace();
        // Handle errors or display an error message
    }
}


/*private byte[] convertImageToByteArray(Image image) throws IOException {
    BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(bufferedImage, "png", baos);
    return baos.toByteArray();
}*/
  

@FXML
private void Modresv(MouseEvent event) {

     try {
         
        int id = 0; // You can set the ID as needed, or let the database auto-generate it
        String nom = tfnom_a.getText();
        LocalDate date = daterev_a.getValue();
        String lieu = combolieu_a.getSelectionModel().getSelectedItem().toString();
        String description = txtdesc_a.getText();
        
        
       
        int prix = Integer.parseInt(tfprix_a.getText());
        

       
        // Create an EventAdmin object and call ajoutEventAdmin with it
         
        int selectedIndex = tabResv_a.getSelectionModel().getSelectedIndex();
        int selectedId = -1; // Initialize to a default value

if (selectedIndex >= 0) {
    // If a row is selected, retrieve the ID from the database
    EventAdmin selectedEvent = tabResv_a.getSelectionModel().getSelectedItem();
    selectedId = selectedEvent.getId_a();
    
}
            EventAdmin e = new EventAdmin(selectedId, nom, date, lieu, description,path, prix);
            a.modifEventAdmin(e, path);


        a.ShowReservation(colnom_a, coldate_a, collieu_a, coldesc_a, colprix_a, tabResv_a);
        // Optionally, you can handle success or display a message here
    } catch (Exception ex) {
        ex.printStackTrace();
        // Handle errors or display an error message
    }
}






    @FXML
    private void Supresv(MouseEvent event) throws SQLException {
         EventAdmin selectedEvent = tabResv_a.getSelectionModel().getSelectedItem();

    if (selectedEvent != null) {
        int result = a.supprimerEventAdmin(selectedEvent);

        if (result == 1) {
            // Deletion successful, you can update the TableView or take any other action
            a.ShowReservation(colnom_a, coldate_a, collieu_a, coldesc_a, colprix_a, tabResv_a);
        } else if (result == 0) {
            // No records were deleted, possibly the record does not exist
        } else {
            // An error occurred during deletion
        }
    }
    a.ShowReservation(colnom_a, coldate_a, collieu_a, coldesc_a, colprix_a, tabResv_a);
    }

  
    @FXML
    private void tab(MouseEvent event) {
        EventAdmin selectedEvent = tabResv_a.getSelectionModel().getSelectedItem();

if (selectedEvent != null) {
    String nom_a = selectedEvent.getNom_a();
    String lieu_a = selectedEvent.getLieu_a();   
    // Query the database to get the image data and other information based on nom_a and lieu_a
    String query = "SELECT image_a, date_a, prix_a, description_a FROM eventadmin WHERE nom_a = ? AND lieu_a = ?";
    try {
        pst = myConx.prepareStatement(query);
        pst.setString(1, nom_a);
        pst.setString(2, lieu_a);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
             path=rs.getString("image_a");
            File imageFile = new File(path);
            Image image = new Image(imageFile.toURI().toString());
            espaceImg_a.setImage(image);
            System.out.println(path);
            // Fill other JavaFX controls
            tfnom_a.setText(nom_a); // Fill TextField
            daterev_a.setValue(rs.getDate("date_a").toLocalDate()); // Fill DatePicker
            combolieu_a.setValue(lieu_a); // Fill ComboBox
            tfprix_a.setText(String.valueOf(rs.getInt("prix_a"))); // Fill TextField
            txtdesc_a.setText(rs.getString("description_a")); // Fill TextArea
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

    }

    @FXML
    private void importerImg_a(MouseEvent event) {
        
        EventAdminService aa =new EventAdminService();
       path=aa.imporeterImg(main,espaceImg_a);
        System.out.println(path);
    }


    
         @FXML
    private void next_a(MouseEvent event) throws IOException {
    

   Object root = FXMLLoader.load(getClass().getResource("InterfaceEvent.fxml"));
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene((Parent) root);
          primaryStage.setScene(scene);
           primaryStage.show();
    }

   

  
}
