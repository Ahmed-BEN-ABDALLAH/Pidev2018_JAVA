/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Jardin;
import entities.produit_donation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.MyServiceDonation;
import service.ServiceJardins;

/**
 *
 * @author Majouli
 */
public class onejardinview  implements Initializable {
 


   private Jardin j1 ;
    ServiceJardins jarservice = new ServiceJardins();
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
            j1=jarservice.Getonejardin(Jardin.getId_courant_jardin());
        } catch (SQLException ex) {
            Logger.getLogger(quickview.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    
    
    
      String a=j1.getLogo();
    
a="C:\\xampp\\htdocs\\datatable_21\\web\\"+a;
        System.out.println(j1.getLogo());
File file =new File(a);

Image image1=new Image(file.toURI().toString());

image_p.setImage(image1);
               nomuser.setText(j1.getNom());
               categorie.setText(j1.getAdresseemail());
               int s = j1.getNumtel();
    
       genre.setText(j1.getAdresse());
    
       description.setText(j1.getDescription());
    }
        public void deletejardin() {
    
jarservice.deleteJardin(Jardin.getId_courant_jardin());
        }
        

    
              public void updatejardin() {
                  //jarservice.updatejardin();

              
              
              }
              public void Sendmessage() throws IOException{
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/sendmessage.fxml")));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
              
              }

    
}


