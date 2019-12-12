/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.evenement;
import entities.produit_donation;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import service.MyServiceDonation;
import service.MyServiceEvenement;

/**
 *
 * @author AHMED
 */
public class quickviewContoller implements Initializable {

   private produit_donation p1 ;
    MyServiceDonation service = new MyServiceDonation();
    @FXML
    private ImageView image_p;
    @FXML
    private Text nomuser;
    @FXML
    private Text categorie;
    @FXML
    private Text genre;
    @FXML
    private Text datenow;
    @FXML
    private Text description;
    
    
    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    try {
            p1=service.GetDobyid(produit_donation.getId_courant_do());
        } catch (SQLException ex) {
            Logger.getLogger(quickview.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    
    
    
      String a=p1.getImage();
    
a="C:\\xampp\\htdocs\\datatable_21\\web\\"+a;
        System.out.println(p1.getImage());
File file =new File(a);

Image image1=new Image(file.toURI().toString());

image_p.setImage(image1);
               nomuser.setText(p1.getNomuser());
               categorie.setText(p1.getCategorie());
       genre.setText(p1.getGenre());
    datenow.setText(p1.getDatenow().toString());
       description.setText(p1.getDescription());
    }
    
}
