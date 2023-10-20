/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class InterfaceTicketController implements Initializable {

    @FXML
    private Label labeldate;
    @FXML
    private Label labellieu;
    @FXML
    private Label labelprix;
    @FXML
    private Label labelnom;
    @FXML
    private ImageView QRpath_a;
    private Image image1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
        // TODO
    public void setEventInfo(String nom, String date, String lieu,  int prix , String Qr) {
        labelnom.setText(nom);
        labeldate.setText(date);
        labellieu.setText(lieu);
    
        labelprix.setText(Integer.toString(prix));
        System.err.println("qr"+Qr);
                image1 = new Image("file:///"+Qr);
        QRpath_a.setImage(image1);

    } 
   /* public void setnom_a (String nom_a){
        Eventnom =nom_a ;
        labelnom.setText(Eventnom);*/

}
