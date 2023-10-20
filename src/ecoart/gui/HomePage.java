/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.gui;

/**
 *
 * @author ASUS
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class HomePage extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        try {
            Parent root = FXMLLoader.load(getClass().getResource("EventAdmin.fxml"));
            
            Scene scene = new Scene(root, 1150, 820);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
         }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}