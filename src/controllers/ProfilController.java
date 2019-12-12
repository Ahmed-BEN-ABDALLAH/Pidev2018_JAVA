/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.User;
import entities.baby;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.serviceBaby;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author ghada
 */
public class ProfilController implements Initializable {
private final User currentUser=Authentification.user;
 serviceBaby service= new serviceBaby();
    
    
    
    User p1= new User();
    @FXML
    private Label nom;
    @FXML
    private ImageView image;
    @FXML
    private Label adresse;
    @FXML
    private Label email;
    @FXML
    private Label description;
    @FXML
    private Label prix;
    @FXML
    private Label numtel;
    @FXML
    private ImageView edit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // p1=currentUser.getId();

      p1=service.AfficherProfil();
        
        System.out.println(currentUser);
      
           nom.setText(p1.getNom());
        email.setText(p1.getEmail());
        numtel.setText(String.valueOf(p1.getNumtel()));
        description.setText(p1.getDescription());
         adresse.setText(p1.getAdrese());

//        disponibilite.setText(currentUser.getDisponibilite().toString());
//        datefin.setText(currentUser.getDatefin().toString());
prix.setText(String.valueOf(p1.getPrix()));
    
         //refresh();
          String a=p1.getImage();
       System.out.println(a);
a="C:\\xampp\\htdocs\\datatable_21\\web\\"+a;
     
        
File file =new File(a);

Image image1=new Image(file.toURI().toString());

image.setImage(image1);
                                
   
    }    

    @FXML
    private void editAction(MouseEvent event) throws IOException {
       // User.setConnectedUser(currentUser);
        
        
          Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/UpdateProfil.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        
        
    }
    }    
    

