/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import template.Template;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author said
 */
public class fournisseur implements Initializable {
public static int said=0;
    @FXML
    private BorderPane BorderPane;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(said==0)
        {
        LoadUI("Ajout");}
        else if(said==1)
        {    LoadUI("listeCommande");
    
        }
        else if(said==2)
        {LoadUI("Affiche");
        }
    }    

    @FXML
    private void Profile(MouseEvent event) {
         LoadUI("profil");
    }

    @FXML
    private void AjoutP(MouseEvent event) throws IOException {
        LoadUI("Ajout");
        
    }

    @FXML
    private void AfficheP(MouseEvent event) {
        LoadUI("Affiche");
    
    }

    @FXML
    private void CommandeP(MouseEvent event) {
        LoadUI("listeCommande");
    } 

    @FXML
    private void Statistique(MouseEvent event) {
        LoadUI("stat");
    }

    @FXML
    private void ReclamationP(MouseEvent event) {
        LoadUI("reclamationp"); 
    }
    
    private void LoadUI(String ui)
    {
        Parent root= null;
        try {
                  // Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/Affiche.fxml"))));             

            root= FXMLLoader.load(getClass().getResource("/views/"+ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(fournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }
        BorderPane.setCenter(root);
    }

    @FXML
    private void logoutp(MouseEvent event) throws IOException {
                                       template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/login_1.fxml"))));

    }
}
