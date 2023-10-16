/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.services;

import ecoart.entities.Event;
import ecoart.entities.EventAdmin;
import ecoart.utils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.management.Query;

/**
 *
 * @author ASUS
 */
public class EventService {
     MyConnection conx= MyConnection.getInstance();
    Connection myConx=conx.getConnection();
   
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void showevents(Event e, String path) throws SQLException{
    
           

    
  

       
}
    
    
        public void ShowReservation (TableColumn<EventAdmin, String> colnom_a,TableColumn<EventAdmin,String>coldate_a,TableColumn<EventAdmin,String>collieu_a,
            TableColumn<EventAdmin,String>coldesc_a,TableColumn<EventAdmin,Integer> colprix_a,TableView<EventAdmin> tabResv_a) throws SQLException {
         
        
         ObservableList< EventAdmin> resvlist =getEventlist();
        
     
          
         
        colnom_a.setCellValueFactory(new PropertyValueFactory<>("nom_a")); ///nom_a de clase eventadmin
        coldate_a.setCellValueFactory(new PropertyValueFactory<>("date_a"));
        collieu_a.setCellValueFactory(new PropertyValueFactory<>("lieu_a"));
        coldesc_a.setCellValueFactory(new PropertyValueFactory<>("description_a"));
       
        colprix_a.setCellValueFactory(new PropertyValueFactory<>("prix_a"));
        tabResv_a.setItems(resvlist);
}
         private ObservableList<EventAdmin> getEventlist() throws SQLException {
         
          
     
     
   
     String query = "select * from eventadmin,eventuser";
 
 
            pst = myConx.prepareStatement(query);
              ResultSet rs =pst.executeQuery(query);
             ObservableList<EventAdmin> Eventlist =FXCollections.observableArrayList();
            while (rs.next()){
              Eventlist.add(new EventAdmin(
    rs.getInt("id_a"),         ///id_a de DB
    rs.getString("nom_a"),
    rs.getDate("date_a").toLocalDate(),
    rs.getString("lieu_a"),
    rs.getString("description_a"),
    rs.getString("image_a"),
    rs.getInt("prix_a")
));
                      
                        } 
     
     
        return Eventlist;
         
     }
}

