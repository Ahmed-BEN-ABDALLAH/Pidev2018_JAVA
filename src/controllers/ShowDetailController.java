/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.User;
import entities.avisbaby;
import entities.baby;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import service.serviceBaby;
import util.Authentification;
import util.MyConnexion;


/**
 * FXML Controller class
 *
 * @author ghada
 */
public class ShowDetailController implements Initializable {

    @FXML
    private ImageView p_image;
    @FXML
    private Label email;
    @FXML
    private Label datedeb;
    @FXML
    private Label datefin;
    @FXML
    private Label numtel;
    @FXML
    private Label desc;
   

    /**
     * Initializes the controller class.
     */
    
    serviceBaby service= new serviceBaby();
    
    
    
    baby p1= new baby();
    @FXML
    private ImageView like_image;
    @FXML
    private Label nbrelike;
    @FXML
    private Label nbredislike;
    @FXML
    private ImageView dislike_image;
    
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {
       
        
// TODO
p1=service.GetBabybyid(baby.getId_courant());
        
        System.out.println(p1);
      
        
        email.setText(p1.getEmail());
        numtel.setText(String.valueOf(p1.getNumtel()));
        desc.setText(p1.getDescription());
        datedeb.setText(p1.getDisponibilite().toString());
        datefin.setText(p1.getDatefin().toString());
    
         refresh();
          String a=p1.getImage();
       System.out.println(a);
a="C:\\xampp\\htdocs\\datatable_21\\web\\"+a;
     
        
File file =new File(a);

Image image1=new Image(file.toURI().toString());

p_image.setImage(image1);
                                
   
    }    

//    @FXML
    @FXML
    private void like_action(MouseEvent event) throws SQLException {
       
        int A=service.verifavis(baby.getId_courant());
   
       if(A==0)
       {
       
        
           Notifications n =Notifications.create().title("Notification")
             .text("Vous avez deja aimé l'offre de"+p1.nom)
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
       }
       else if (A==1)
       {
        
           Notifications n =Notifications.create().title("Notification")
             .text("Votre avis sur l'offre de"+p1.nom+"a été modifé")
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
       
       }
       else {
        
           Notifications n =Notifications.create().title("Notification")
             .text("Vous avez aimé l'offre de"+p1.nom)
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
       
       }
       refresh();
    }
    
  
    
public void refresh()
{
      nbrelike.setText(String.valueOf(service.nbrelike(baby.getId_courant())));
           nbredislike.setText(String.valueOf(service. nbredislike(baby.getId_courant())));

}

    @FXML
    private void dislikeAction(MouseEvent event) throws SQLException {
        
        {
       
        int A=service.verifavis1(baby.getId_courant());
   
       if(A==0)
       {
       
        
           Notifications n =Notifications.create().title("Notification")
             .text("Vous avez deja réagir l'offre de" +p1.nom)
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
       }
       else if (A==1)
       {
        
           Notifications n =Notifications.create().title("Notification")
             .text("Votre avis sur l'offre de" +p1.nom+ "a été modifé")
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
       
       }
       else {
        
           Notifications n =Notifications.create().title("Notification")
             .text("Vous avez réagir l'offre de" +p1.nom)
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
       
       }
       refresh();
    }
        
        
    }

    
    @FXML
    private void direction(MouseEvent event) throws IOException {
        p1=service.GetBabybyid(baby.getId_courant());

                                       baby.setId_courant(p1.getId());     
       Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/direction.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();  
        
    }

}
     
    
