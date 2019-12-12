/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author ghada
 */
public class MenuDemandeController implements Initializable {

    @FXML
    private BorderPane BorderPane;
    
    
    
     public static int test=0;
  

    

    public static int getTest() {
        return test;
    }

    public static void setTest(int test) {
        MenuDemandeController.test = test;
    }
    @FXML
    private ImageView HOME;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
         if (this.getTest()==0)
        {
        LoadUI("Profil");
    }    
        else {
            LoadUI("affichermesdemandes");
   
          this.setTest(0);
        
        }
    
    
    }    

    @FXML
    private void Profile(MouseEvent event) {
         LoadUI("Profil");
    }

    private void AjoutD(MouseEvent event) {
        
        
        
    }

    private void Profil(MouseEvent event) {
    }

    @FXML
    private void lesdemandes(MouseEvent event) {
        
          LoadUI("DemandeFXML");
           this.setTest(0);
    }

    private void mesdemande(MouseEvent event) {
    }
    @FXML
    private void lesoffres(MouseEvent event) {
        
              LoadUI("BabyFxml");
      //this.setTest(0);
    }

    private void topbabysittes(MouseEvent event) {
        LoadUI("top10baby");
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

    @FXML
    private void ToHome(MouseEvent event) throws IOException {
                         template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/menuAdmin.fxml"))));   

        
        
    }

    @FXML
    private void AjoutP(MouseEvent event) {
               LoadUI("AjoutDemande");
               this.setTest(1);
    
    }

    @FXML
    private void mesoffres(MouseEvent event) {
             LoadUI("affichermesdemandes");
         this.setTest(0);
    }

    

    @FXML
    private void top(MouseEvent event) {
                LoadUI("top10baby");

    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
                                 template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/login_1.fxml"))));   

    }
}
