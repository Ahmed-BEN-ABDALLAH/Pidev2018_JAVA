/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.baby;
import entities.demande;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import service.serviceDemande;

/**
 * FXML Controller class
 *
 * @author ghada
 */
public class UpdateDemandeController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXTextField numtel;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXDatePicker disponibilite;
    @FXML
    private JFXDatePicker datefin;
    @FXML
    private Button Image_fichier;
    @FXML
    private ImageView image_p;

    /**
     * Initializes the controller class.
     */
    
    
          final FileChooser fileChooser = new FileChooser();
     private Desktop desktop = Desktop.getDesktop();
     private String file_image ;
    
    private JFXButton fichier;

    private Path pathfrom;
    private Path pathto;
    private File Current_file;
serviceDemande servicebb = new serviceDemande();
     private demande b;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      System.out.println("aaaaaaaaaaa");
        
            b = servicebb.GetBabybyid(baby.getId_courant());
          
        nom.setText(b.getNom());
        System.out.println(b.getPrenom());
        prenom.setText(b.getPrenom());
        numtel.setText(String.valueOf(b.getNumtel()));
        prix.setText(String.valueOf(b.getPrix()));
        adresse.setText(b.getAdrese());
        description.setText(b.getDescription());
            // TODO
       email.setText(b.getEmail());     

    }
      

    @FXML
    private void modifier_baby(ActionEvent event) throws IOException {
     try {
            b.setNom(nom.getText());
       
               
        b.setPrenom(prenom.getText());
        b.setAdrese(adresse.getText());
         b.setDescription(description.getText());
         b.setNumtel(Integer.parseInt(numtel.getText()));
         b.setEmail(email.getText());
      b.setEmail(prix.getText());
        
   Date disponibilite = Date.valueOf(this.disponibilite.getValue());
   Date datefin = Date.valueOf(this.datefin.getValue());
   b.setDisponibilite(disponibilite);
   b.setDatefin(datefin);
   
  b.setImage("images/"+Current_file.getName());
        
   
   
   
   
            servicebb.updatebaby(b);             
          template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/MenuGhada.fxml"))));
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBabyController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void Image_fichier1(ActionEvent event) {
                    Current_file = fileChooser.showOpenDialog(template.Template.getInstance().getStage());
                    if (Current_file != null) {
                        try {
                            //                        openFile(file);
                            System.out.println(Current_file.toURI().toURL().toExternalForm());
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(UpdateDemandeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     file_image= Current_file.getName();
                    }
        
         
    Image image2 = new Image(Current_file.toURI().toString());
             
image_p.setImage(image2);
          System.out.println();
        
        
        
        
    }
    
}
