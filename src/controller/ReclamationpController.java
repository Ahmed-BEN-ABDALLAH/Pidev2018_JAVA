/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXListView;
import entities.Produit;
import entities.commande;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import service.ServiceProduit;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReclamationpController implements Initializable {

    @FXML
    private JFXListView<Pane> allcommandes;
    @FXML
    private ListView<Pane> notificationcommande;
    
    ServiceProduit servicepr = new ServiceProduit();
    @FXML
    private Label reclamationsproduit;
    @FXML
    private Label nbrnotif;
    
    int i=0;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
                 
                 ObservableList<Produit> list= FXCollections.observableArrayList();
        for (Produit p:servicepr.AfficherProduitstock() )
        {
            list.add(p);
            
        };
                 ObservableList<Produit> list2= FXCollections.observableArrayList();
        for (Produit p:servicepr.AfficherProduitstock2() )
        {
            list2.add(p);
            
        };
        nbrnotif.setText(String.valueOf(list.size()));
        
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        for (int j = 0; j < list2.size(); j++) {
            Produit get = list2.get(j);
          
        Pane pane2=new Pane();
                                pane2.setLayoutX(10);
                                pane2.setLayoutY(10);
                                pane2.setPrefWidth(pane2.getWidth() + 350); 
                                pane2.setPrefHeight(pane2.getHeight() + 75);
                                
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle("-fx-border-color: #383d3b ;");
        Text t1=new Text("nom");t1.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t2=new Text("prix");t2.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t3=new Text("categorie");t3.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t4=new Text("age");t4.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t5=new Text("genre");t5.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text tt1=new Text();tt1.setText(get.getNom());
        Text tt2=new Text();tt2.setText(String.valueOf(get.getPrix()));
        Text tt3=new Text();tt3.setText(get.getCategorie());
        Text tt4=new Text();tt4.setText(String.valueOf(get.getAge()));
        Text tt5=new Text();tt5.setText(get.getGenre());
        
        t1.setLayoutX(15);tt1.setLayoutX(15);
        t2.setLayoutX(75);tt2.setLayoutX(75);
        t3.setLayoutX(135);tt3.setLayoutX(135);
        t4.setLayoutX(215);tt4.setLayoutX(215);
        t5.setLayoutX(255);tt5.setLayoutX(255);
        ////
        t1.setLayoutY(15);tt1.setLayoutY(40);
        t2.setLayoutY(15);tt2.setLayoutY(40);
        t3.setLayoutY(15);tt3.setLayoutY(40);
        t4.setLayoutY(15);tt4.setLayoutY(40);
        t5.setLayoutY(15);tt5.setLayoutY(40);
        
pane2.getChildren().addAll(t1,t2,t3,t4,t5,tt1,tt2,tt3,tt4,tt5);
panes.add(pane2);
}
allcommandes.setItems(panes);
notificationcommande.setVisible(false);
        
    }    

    @FXML
    private void showlist2(MouseEvent event) throws SQLException {
        if(i==0)
        {
                 ObservableList<Produit> list= FXCollections.observableArrayList();
        for (Produit p:servicepr.AfficherProduitstock() )
        {
            list.add(p);
            
        };
        ObservableList<Pane> panesnotif = FXCollections.observableArrayList();
            for (int j = 0; j < list.size(); j++) {
                Produit get = list.get(j);
            
       Pane pane3=new Pane();
                                pane3.setLayoutX(10);
                                pane3.setLayoutY(10);
                                pane3.setPrefWidth(pane3.getWidth() + 50); 
                                pane3.setPrefHeight(pane3.getHeight() + 20);
        pane3.setStyle("-fx-border-color: #383d3b ; -fx-background-radius: 10; -fx-border-radius: 5 ");
        Text tnom=new Text("nom :");
        Text tnom1=new Text();
        tnom1.setText(get.getNom());
        tnom.setLayoutX(5);
        tnom.setLayoutY(15);
        tnom1.setLayoutX(40);
        tnom1.setLayoutY(15);
        pane3.getChildren().addAll(tnom,tnom1);
       panesnotif.add(pane3);
       
        }
        notificationcommande.setItems(panesnotif);
        
        notificationcommande.setVisible(true);
        for (Produit p:servicepr.AfficherProduitstock() )
        {
            
            servicepr.UpdateProduitstock(p);
        };


        i++;
        
        }
        else{
                nbrnotif.setText(String.valueOf(0));  
         notificationcommande.setVisible(false);
            ObservableList<Produit> list2= FXCollections.observableArrayList();
        for (Produit p:servicepr.AfficherProduitstock2() )
        {
            list2.add(p);
            
        };
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        for (int j = 0; j < list2.size(); j++) {
            Produit get = list2.get(j);
          
        Pane pane2=new Pane();
                                pane2.setLayoutX(10);
                                pane2.setLayoutY(10);
                                pane2.setPrefWidth(pane2.getWidth() + 350); 
                                pane2.setPrefHeight(pane2.getHeight() + 75);
                                
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle("-fx-border-color: #383d3b ;");
        Text t1=new Text("nom");t1.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t2=new Text("prix");t2.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t3=new Text("categorie");t3.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t4=new Text("age");t4.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t5=new Text("genre");t5.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text tt1=new Text();tt1.setText(get.getNom());
        Text tt2=new Text();tt2.setText(String.valueOf(get.getPrix()));
        Text tt3=new Text();tt3.setText(get.getCategorie());
        Text tt4=new Text();tt4.setText(String.valueOf(get.getAge()));
        Text tt5=new Text();tt5.setText(get.getGenre());
        
        t1.setLayoutX(15);tt1.setLayoutX(15);
        t2.setLayoutX(75);tt2.setLayoutX(75);
        t3.setLayoutX(135);tt3.setLayoutX(135);
        t4.setLayoutX(215);tt4.setLayoutX(215);
        t5.setLayoutX(255);tt5.setLayoutX(255);
        ////
        t1.setLayoutY(15);tt1.setLayoutY(40);
        t2.setLayoutY(15);tt2.setLayoutY(40);
        t3.setLayoutY(15);tt3.setLayoutY(40);
        t4.setLayoutY(15);tt4.setLayoutY(40);
        t5.setLayoutY(15);tt5.setLayoutY(40);
        
pane2.getChildren().addAll(t1,t2,t3,t4,t5,tt1,tt2,tt3,tt4,tt5);
panes.add(pane2);
}
allcommandes.setItems(panes);
         i=0;
        }
    }

    @FXML
    private void showlist(MouseEvent event) throws SQLException {
        if(i==0)
        {
                 ObservableList<Produit> list= FXCollections.observableArrayList();
        for (Produit p:servicepr.AfficherProduitstock() )
        {
            list.add(p);
            
        };
        ObservableList<Pane> panesnotif = FXCollections.observableArrayList();
            for (int j = 0; j < list.size(); j++) {
                Produit get = list.get(j);
            
       Pane pane3=new Pane();
                                pane3.setLayoutX(10);
                                pane3.setLayoutY(10);
                                pane3.setPrefWidth(pane3.getWidth() + 50); 
                                pane3.setPrefHeight(pane3.getHeight() + 20);
        pane3.setStyle("-fx-border-color: #383d3b ; -fx"
                + "-background-radius: 10; -fx-border-radius: 5 ");
        Text tnom=new Text("nom :");
        Text tnom1=new Text();
        tnom1.setText(get.getNom());
        tnom.setLayoutX(5);
        tnom.setLayoutY(15);
        tnom1.setLayoutX(40);
        tnom1.setLayoutY(15);
        pane3.getChildren().addAll(tnom,tnom1);
       panesnotif.add(pane3);       
        }
        notificationcommande.setItems(panesnotif);
        
        notificationcommande.setVisible(true);
        for (Produit p:servicepr.AfficherProduitstock() )
        {
            
            servicepr.UpdateProduitstock(p);
        };


        i++;
        
        }
        else{
         nbrnotif.setText(String.valueOf(0));  
         notificationcommande.setVisible(false);
            ObservableList<Produit> list2= FXCollections.observableArrayList();
        for (Produit p:servicepr.AfficherProduitstock2() )
        {
            list2.add(p);
            
        };
        
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        for (int j = 0; j < list2.size(); j++) {
            Produit get = list2.get(j);
          
        Pane pane2=new Pane();
                                pane2.setLayoutX(10);
                                pane2.setLayoutY(10);
                                pane2.setPrefWidth(pane2.getWidth() + 350); 
                                pane2.setPrefHeight(pane2.getHeight() + 75);
                                
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle("-fx-border-color: #383d3b ;");
        Text t1=new Text("nom");t1.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t2=new Text("prix");t2.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t3=new Text("categorie");t3.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t4=new Text("age");t4.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text t5=new Text("genre");t5.setStyle("-fx-font-weight: bold;-fx-fill : #2a2af5");
        Text tt1=new Text();tt1.setText(get.getNom());
        Text tt2=new Text();tt2.setText(String.valueOf(get.getPrix()));
        Text tt3=new Text();tt3.setText(get.getCategorie());
        Text tt4=new Text();tt4.setText(String.valueOf(get.getAge()));
        Text tt5=new Text();tt5.setText(get.getGenre());
        
        t1.setLayoutX(15);tt1.setLayoutX(15);
        t2.setLayoutX(75);tt2.setLayoutX(75);
        t3.setLayoutX(135);tt3.setLayoutX(135);
        t4.setLayoutX(215);tt4.setLayoutX(215);
        t5.setLayoutX(255);tt5.setLayoutX(255);
        ////
        t1.setLayoutY(15);tt1.setLayoutY(40);
        t2.setLayoutY(15);tt2.setLayoutY(40);
        t3.setLayoutY(15);tt3.setLayoutY(40);
        t4.setLayoutY(15);tt4.setLayoutY(40);
        t5.setLayoutY(15);tt5.setLayoutY(40);
        
pane2.getChildren().addAll(t1,t2,t3,t4,t5,tt1,tt2,tt3,tt4,tt5);
panes.add(pane2);
}
allcommandes.setItems(panes);
         i=0;
        }
    }
    
}