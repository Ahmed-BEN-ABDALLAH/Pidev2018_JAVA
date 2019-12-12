/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import template.Template;
import com.jfoenix.controls.JFXButton;
import entities.Produit;
import entities.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author said
 */
public class drawerController implements Initializable {

    @FXML
    private AnchorPane box;
    @FXML
    private ImageView imgUser;
    @FXML
    private Label labelUser;
    @FXML
    private JFXButton acceuil;
    @FXML
    private JFXButton listproduit;
    @FXML
    private JFXButton categorie;
    @FXML
    private JFXButton panier;
    @FXML
    private JFXButton profile;
    @FXML
    private JFXButton deconnexion;
    private final User currentUser=Authentification.user;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String A = currentUser.getImage();
                                A = "C:\\xampp\\htdocs\\datatable_21\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                              
                               // imgUser.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

 //                               imgUser.setImage(image2);
                                
       
        // TODO
    }    

    @FXML
    private void makeAccueil(ActionEvent event) throws IOException {
        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/menuAdmin.fxml"))));             

    }


    @FXML
    private void makeCompte(ActionEvent event) {
    }

    @FXML
    private void makeDisconnect(ActionEvent event) {
    }

    @FXML
    private void makeProduit(ActionEvent event) throws IOException {
        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/produitsFXML.fxml"))));             

    }

    @FXML
    private void makeCategorie(ActionEvent event) throws IOException {
                Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/categorie.fxml"))));             

    }

    @FXML
    private void makePanier(ActionEvent event) throws IOException {
    Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/cartpage.fxml"))));             

    }

    @FXML
    private void logoutp(MouseEvent event) throws IOException {
                    Produit.Panier.clear();
                                               template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/login_1.fxml"))));

    }
    
}
