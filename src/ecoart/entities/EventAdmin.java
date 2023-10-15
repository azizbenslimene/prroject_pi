/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.entities;

import java.time.LocalDate;
import javafx.scene.image.Image;

/**
 *
 * @author ASUS
 */
  public class EventAdmin {
   private int id_a;
    private String nom_a;
    private LocalDate date_a;
    private String lieu_a;
    private String description_a;
    private byte[] image_a; // Change the image data type to byte array
    private int prix_a;
    
    
    
    public EventAdmin() {
    }

    public EventAdmin(int id_a, String nom_a, LocalDate date_a, String lieu_a, String description_a, byte[] image_a, int prix_a) {
        this.id_a = id_a;
        this.nom_a = nom_a;
        this.date_a = date_a;
        this.lieu_a = lieu_a;
        this.description_a = description_a;
        this.image_a = image_a;
        this.prix_a = prix_a;
    }

    public EventAdmin(int id, String nom, LocalDate date, String lieu, String description, int prix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EventAdmin(int id, String nom, LocalDate date, String lieu, String description, byte[] imageData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    public String getNom_a() {
        return nom_a;
    }

    public void setNom_a(String nom_a) {
        this.nom_a = nom_a;
    }

    public LocalDate getDate_a() {
        return date_a;
    }

    public void setDate_a(LocalDate date_a) {
        this.date_a = date_a;
    }

    public String getLieu_a() {
        return lieu_a;
    }

    public void setLieu_a(String lieu_a) {
        this.lieu_a = lieu_a;
    }

    public String getDescription_a() {
        return description_a;
    }

    public void setDescription_a(String description_a) {
        this.description_a = description_a;
    }

    public byte[] getImage_a() {
        return image_a;
    }

    public void setImage_a(byte[] image_a) {
        this.image_a = image_a;
    }

    public int getPrix_a() {
        return prix_a;
    }

    public void setPrix_a(int prix_a) {
        this.prix_a = prix_a;
    }

    
   
    

   

  
    
    
}
