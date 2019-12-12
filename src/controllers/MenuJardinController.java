/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import service.MyServiceEvenement;
import util.Authentification;

/**
 *
 * @author Majouli
 */
public class MenuJardinController {
       private final User currentUser=Authentification.user;

      @FXML
    private BorderPane BorderPane;
    @FXML
    private Text nbr;
    MyServiceEvenement s=new MyServiceEvenement();
      int nbrnotif;   
      
     @FXML
    private void ToHome(MouseEvent event) throws IOException {
          template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/menuAdmin.fxml"))));   
        
        
    }
  
   
        @FXML

    private void AjoutJardin(MouseEvent event) throws IOException {
        LoadUI("addjardin");
        
        
    }   
        @FXML

    private void Toutejardins(MouseEvent event) throws IOException {
        LoadUI("Affichejardin");
        
        
    }  
        @FXML

    private void Mesjardins(MouseEvent event) throws IOException {
        LoadUI("MesJardin");
        
        
    }     
        @FXML

    private void Mesmessages(MouseEvent event) throws IOException {
         // template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/AfficheMessage.fxml"))));   
        
                LoadUI("AfficheMessage");

    }
       private void LoadUI(String ui)
    {
        Parent root= null;
        try {
                  // Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/Affiche.fxml"))));             

            root= FXMLLoader.load(getClass().getResource("/GUI/"+ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MyMenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        BorderPane.setCenter(root);
        
    }
}
