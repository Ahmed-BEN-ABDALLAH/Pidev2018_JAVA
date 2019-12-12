/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import template.Template;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author said
 */
public class categorieController implements Initializable {

    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;

    Produit p =new Produit();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
             AnchorPane box = FXMLLoader.load(getClass().getResource("/views/drawer.fxml"));
             drawer.open();
             drawer.setSidePane(box);
             
             HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
             transition.setRate(1);
             hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                 transition.setRate(transition.getRate() * 1);
                 transition.play();
                 
                 if (drawer.isShown()) {
                     drawer.close();
                 }
                 else
                 {
                     drawer.open();
                 }
                 
             });
          
         } catch (IOException ex) {
             Logger.getLogger(ProduitsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    

    @FXML
    private void pane1(MouseEvent event) throws IOException {
            p.setCategrie_courant("vêtements");
            Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/listCategorie.fxml"))));             
    }

    @FXML
    private void pane2(MouseEvent event) throws IOException {
                       p.setCategrie_courant("chaussures");

               Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/listCategorie.fxml"))));             

    }

    @FXML
    private void pane5(MouseEvent event) throws IOException {
        p.setCategrie_courant("jouets");
            Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/listCategorie.fxml"))));             

    }

    @FXML
    private void pane6(MouseEvent event) throws IOException {
        p.setCategrie_courant("lits");
            Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/listCategorie.fxml"))));             

    }

    @FXML
    private void pane7(MouseEvent event) throws IOException {
        p.setCategrie_courant("bureaux");
            Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/listCategorie.fxml"))));             

    }

    @FXML
    private void pane8(MouseEvent event) throws IOException {
    p.setCategrie_courant("bibliothéques");
            Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/listCategorie.fxml"))));             

    }

    @FXML
    private void pane4(MouseEvent event) throws IOException {
    p.setCategrie_courant("pyjamas");
            Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/listCategorie.fxml"))));             

    }

    @FXML
    private void pane3(MouseEvent event) throws IOException {
    p.setCategrie_courant("sous-vêtements");
            Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/listCategorie.fxml"))));             

    }
    
}