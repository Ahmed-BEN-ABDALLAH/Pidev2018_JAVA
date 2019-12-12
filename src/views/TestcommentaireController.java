/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import controller.quickview;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Produit;
import entities.User;
import entities.commentaireP;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import service.ServiceProduit;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TestcommentaireController implements Initializable {
     private final User currentUser=Authentification.user;
    @FXML
    private JFXTextArea commentairecontenu;
    @FXML
    private FontAwesomeIconView addcomment;
    @FXML
    private JFXListView<Pane> commentairelist;

    /**
     * Initializes the controller class.
     */
       ServiceProduit service = new ServiceProduit();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Produit Pcourant = new Produit();
                    
                    try {
                        Pcourant = service.GetProduitbyid(Produit.getId_courant());
                        // TODO
                        //qrcode
                        
                        System.out.println(Pcourant.getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(quickview.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    ObservableList<Pane> commentaireliste = FXCollections.observableArrayList();  
       for (commentaireP c:service.AfficherCommentaireP(Pcourant))
        {
            
             Pane pane = new Pane();
        pane.setStyle(" -fx-background-color: white");
                                
                       JFXButton t1=new JFXButton("supprimer");    
            
                        t1.setStyle("-fx-font-weight: bold;");
                        
                     
                        HBox hb2=new HBox(t1);
                        
                        
                                hb2.setLayoutX(250);
                                hb2.setLayoutY(0);
                                hb2.setPrefWidth( 100); 
                                hb2.setPrefHeight( 35);
                                hb2.setStyle("-fx-background-color: #ea7066; ; -fx-background-radius: 0 0 10 0;");
                        
                                
                                Text quan1=new Text(c.getContent());        
                              // Label quant2 = new Label(String.valueOf(c.getContent()));
                                quan1.setLayoutX(10);
                                quan1.setLayoutY(20);
                                
                        quan1.setStyle("-fx-font-weight: bold;-fx-fill : #d82819;-fx-font-size:15px;");
                        //quant2.setStyle("-fx-font-weight: bold;-fx-fill : #d82819;-fx-font-size:15px;");
                         if(currentUser.getId()==c.getUser_id())
                        {
                        pane.getChildren().addAll(quan1,hb2);
                        }
                        else{
                            pane.getChildren().addAll(quan1);
                        
                        }
                              t1.setOnMouseClicked((MouseEvent event2) -> {
                                  service.deletecommentaire(c.getId());
                 try {
                     template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/testcommentaire.fxml"))));
                 } catch (IOException ex) {
                     Logger.getLogger(TestcommentaireController.class.getName()).log(Level.SEVERE, null, ex);
                 }

                              });
                                
      commentaireliste.add(pane);
                   
        
        // TODO
    }
       commentairelist.setItems(commentaireliste);
       
    }

    @FXML
    private void ajoutercommentaireproduit(MouseEvent event) {
        commentaireP c2 = new commentaireP();
        c2.setContent(commentairecontenu.getText());
        c2.setProduit_id(Produit.getId_courant());
        c2.setUser_id(currentUser.getId());
        service.AjouterCommentaire(c2);
        
         Produit Pcourant = new Produit();
                    
                    try {
                        Pcourant = service.GetProduitbyid(Produit.getId_courant());
                        // TODO
                        //qrcode
                        
                        System.out.println(Pcourant.getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(quickview.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
         ObservableList<Pane> commentaireliste = FXCollections.observableArrayList();  
       for (commentaireP c:service.AfficherCommentaireP(Pcourant))
        {
             Pane pane = new Pane();
        pane.setStyle(" -fx-background-color: white");
                                
                       JFXButton t1=new JFXButton("supprimer");    
            
                        t1.setStyle("-fx-font-weight: bold;");
                        
                     
                        HBox hb2=new HBox(t1);
                        
                        
                                hb2.setLayoutX(250);
                                hb2.setLayoutY(0);
                                hb2.setPrefWidth( 100); 
                                hb2.setPrefHeight( 35);
                                hb2.setStyle("-fx-background-color: #ea7066; ; -fx-background-radius: 0 0 10 0;");
                        
                                
                                Text quan1=new Text(c.getContent());        
                              // Label quant2 = new Label(String.valueOf(c.getContent()));
                                quan1.setLayoutX(10);
                                quan1.setLayoutY(20);
                                
                        quan1.setStyle("-fx-font-weight: bold;-fx-fill : #d82819;-fx-font-size:15px;");
                        //quant2.setStyle("-fx-font-weight: bold;-fx-fill : #d82819;-fx-font-size:15px;");
                      if(currentUser.getId()==c.getUser_id())
                        {
                        pane.getChildren().addAll(quan1,hb2);
                        }
                        else{
                            pane.getChildren().addAll(quan1);
                        
                        }
                              t1.setOnMouseClicked((MouseEvent event2) -> {
                                  service.deletecommentaire(c.getId());
             refresh();
                              });
                                
      commentaireliste.add(pane);
                   
        
        // TODO
    }
             commentairelist.setItems(commentaireliste);
        
    }
    
    
    public void refresh()
    {
        Produit Pcourant = new Produit();
                    
                    try {
                        Pcourant = service.GetProduitbyid(Produit.getId_courant());
                        // TODO
                        //qrcode
                        
                        System.out.println(Pcourant.getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(quickview.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
         ObservableList<Pane> commentaireliste = FXCollections.observableArrayList();  
       
     for (commentaireP c:service.AfficherCommentaireP(Pcourant))
        {
             Pane pane = new Pane();
        pane.setStyle(" -fx-background-color: white");
                                
                       JFXButton t1=new JFXButton("supprimer");    
            
                        t1.setStyle("-fx-font-weight: bold;");
                        
                     
                        HBox hb2=new HBox(t1);
                        
                        
                                hb2.setLayoutX(250);
                                hb2.setLayoutY(0);
                                hb2.setPrefWidth( 100); 
                                hb2.setPrefHeight( 35);
                                hb2.setStyle("-fx-background-color: #ea7066; ; -fx-background-radius: 0 0 10 0;");
                        
                                
                                Text quan1=new Text(c.getContent());        
                              // Label quant2 = new Label(String.valueOf(c.getContent()));
                                quan1.setLayoutX(10);
                                quan1.setLayoutY(20);
                                
                        quan1.setStyle("-fx-font-weight: bold;-fx-fill : #d82819;-fx-font-size:15px;");
                        //quant2.setStyle("-fx-font-weight: bold;-fx-fill : #d82819;-fx-font-size:15px;");
                        if(currentUser.getId()==c.getUser_id())
                        {
                        pane.getChildren().addAll(quan1,hb2);
                        }
                        else{
                            pane.getChildren().addAll(quan1);
                        
                        }
                        t1.setOnMouseClicked((MouseEvent event2) -> {
                                  service.deletecommentaire(c.getId());
                 refresh();

                              });
                                
      commentaireliste.add(pane);
                   
        
        // TODO
    }
             commentairelist.setItems(commentaireliste);
    
    }
}
