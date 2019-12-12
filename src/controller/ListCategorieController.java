/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entities.Produit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import service.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ListCategorieController implements Initializable {

     ServiceProduit service_pr=new ServiceProduit();
     Produit p = new Produit();
    @FXML
    private JFXListView<Pane> ListView_Produits ;
    private JFXListView<Produit> ListView_Produits1;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private TextField rechercher;
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
             
             ListView_Produits.setFocusTraversable( false );
             getShowPane();
         } catch (IOException ex) {
             Logger.getLogger(ProduitsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }
       }
    public void getShowPane()
    {
        List <Produit> AllProducts  = new ArrayList();
        for (Produit p:service_pr.AfficherProduitCategorie(p.getCategrie_courant()) )
        {
            AllProducts.add(p);
        }
        int i=0;
        int j=0;
        ObservableList<Pane> Panes = FXCollections.observableArrayList();  

        List <Produit> ThreeProducts= new ArrayList();
        for (Produit p:AllProducts )
        {
            if(i==0)
            {
                ThreeProducts.add(p);
                i++;
                j++;
                
                   if(j==AllProducts.size())
                {
                    Panes.add(AddPane(ThreeProducts));
                
                    ThreeProducts.clear();
                }
            }
            else
            {
                ThreeProducts.add(p);
                    i++;
                    j++;
                if((i%3==0)||(j==AllProducts.size()))
                {
                    Panes.add(AddPane(ThreeProducts));
                
                    ThreeProducts.clear();
                    
                }
            }
        }
       ListView_Produits.setItems(Panes);
}
    public Pane AddPane( List<Produit> ThreeProduct)
    {
        Pane pane = new Pane();
        pane.setStyle(" -fx-background-color: white");
                    int k =1;
                    for (Produit p3:ThreeProduct )
                        {
                         if(k == 1)
                            {
                                Pane pane2=new Pane();
                                pane2.setLayoutX(25);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                        JFXButton t=new JFXButton("détails");    
                        JFXButton t1=new JFXButton("acheter");    
                        t.setStyle("-fx-font-weight: bold;");
                        t1.setStyle("-fx-font-weight: bold;");
                        
                        HBox hb=new HBox(t);
                        HBox hb2=new HBox(t1);
                        
                        
                                hb.setLayoutX(0);
                                hb.setLayoutY(170);
                                hb.setPrefWidth(hb.getWidth() + 160); 
                                hb.setPrefHeight(hb.getHeight() + 35);
                                hb.setStyle("-fx-background-color: #ea7066; -fx-background-radius: 0 0 0 10;");
                                
                                hb2.setLayoutX(155);
                                hb2.setLayoutY(170);
                                hb2.setPrefWidth(hb.getWidth() + 61); 
                                hb2.setPrefHeight(hb.getHeight() + 35);
                                hb2.setStyle("-fx-background-color: #ea7066; ; -fx-background-radius: 0 0 10 0;");
                                pane2.getChildren().addAll(hb,hb2);
                                
                                String A = p3.getImage();
                                A = "C:\\xampp\\htdocs\\datatable_21\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(140);
                                image.setFitHeight(130);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(40);
                                image.setLayoutY(-45);
                                pane2.getChildren().add(image);
                         
                                Rating rating=new Rating();
                                rating.setPrefWidth(20);
                                rating.setPrefHeight(19);
                                rating.setLayoutX(50);
                                rating.setLayoutY(183);
                                int rate = 0;
                             try {
                                 rate = service_pr.AfficherRating(p3.getId());
                             } catch (SQLException ex) {
                                 Logger.getLogger(ProduitsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                             }
                                
                                rating.ratingProperty().setValue(rate);
                                rating.setDisable(true);
                                
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("prix : ");
                                Label prix = new Label(String.valueOf(p3.getPrix())+" DT");
                                nomt.setLayoutX(50);
                                nomt.setLayoutY(160);
                                nom.setLayoutX(100);
                                nom.setLayoutY(145);
                                prixt.setLayoutX(50);
                                prixt.setLayoutY(180);
                                prix.setLayoutX(100);
                                prix.setLayoutY(165);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                            t1.setOnMouseClicked((MouseEvent event) -> {
                                      Produit.setPanier(p3);
                                      getShowPane();
                                });
                            t.setOnMouseClicked((MouseEvent event) -> {
                                  Produit.setId_courant(p3.getId());
                                        
       try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/views/Quickview.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                });
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix,rating);
                            }
                            if(k == 2)
                            {
                               Pane pane2=new Pane();
                                pane2.setLayoutX(300);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10 ;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                        JFXButton t=new JFXButton("détails");    
                        JFXButton t1=new JFXButton("acheter");    
                        t.setStyle("-fx-font-weight: bold;");
                        t1.setStyle("-fx-font-weight: bold;");
                        HBox hb=new HBox(t);
                        HBox hb2=new HBox(t1);
                        
                        
                                hb.setLayoutX(0);
                                hb.setLayoutY(170);
                                hb.setPrefWidth(hb.getWidth() + 160); 
                                hb.setPrefHeight(hb.getHeight() + 35);
                                hb.setStyle("-fx-background-color: #ea7066; -fx-background-radius: 0 0 0 10;");
                                
                                hb2.setLayoutX(155);
                                hb2.setLayoutY(170);
                                hb2.setPrefWidth(hb.getWidth() + 61); 
                                hb2.setPrefHeight(hb.getHeight() + 35);
                                hb2.setStyle("-fx-background-color: #ea7066; ; -fx-background-radius: 0 0 10 0;");
                                pane2.getChildren().addAll(hb,hb2);
                                
                                String A = p3.getImage();
                                A = "C:\\xampp\\htdocs\\datatable_21\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(140);
                                image.setFitHeight(130);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(40);
                                image.setLayoutY(-45);
                                pane2.getChildren().add(image);
                                
                                Rating rating=new Rating();
                                rating.setPrefWidth(20);
                                rating.setPrefHeight(19);
                                rating.setLayoutX(325);
                                rating.setLayoutY(183);
                                int rate = 0;
                             try {
                                 rate = service_pr.AfficherRating(p3.getId());
                             } catch (SQLException ex) {
                                 Logger.getLogger(ProduitsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                             }
                                rating.ratingProperty().setValue(rate);
                                
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("prix : ");
                                Label prix = new Label(String.valueOf(p3.getPrix())+" DT");
                                nomt.setLayoutX(325);
                                nomt.setLayoutY(160);
                                nom.setLayoutX(375);
                                nom.setLayoutY(145);
                                prixt.setLayoutX(325);
                                prixt.setLayoutY(180);
                                prix.setLayoutX(375);
                                prix.setLayoutY(165);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                            t1.setOnMouseClicked((MouseEvent event) -> {
                                      Produit.setPanier(p3);
                                      getShowPane();
                                });
                            t.setOnMouseClicked((MouseEvent event) -> {
                                  Produit.setId_courant(p3.getId());
                                        
       try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/views/Quickview.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                });
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix,rating);                    
                            }
                            
                            if(k == 3)
                                {
                                   Pane pane2=new Pane();
                                pane2.setLayoutX(575);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                        JFXButton t=new JFXButton("détails");    
                        JFXButton t1=new JFXButton("acheter");    
                        t.setStyle("-fx-font-weight: bold;");
                        t1.setStyle("-fx-font-weight: bold;");
                        HBox hb=new HBox(t);
                        HBox hb2=new HBox(t1);
                        
                        
                                hb.setLayoutX(0);
                                hb.setLayoutY(170);
                                hb.setPrefWidth(hb.getWidth() + 160); 
                                hb.setPrefHeight(hb.getHeight() + 35);
                                hb.setStyle("-fx-background-color: #ea7066; -fx-background-radius: 0 0 0 10;");
                                
                                hb2.setLayoutX(155);
                                hb2.setLayoutY(170);
                                hb2.setPrefWidth(hb.getWidth() + 61); 
                                hb2.setPrefHeight(hb.getHeight() + 35);
                                hb2.setStyle("-fx-background-color: #ea7066; ; -fx-background-radius: 0 0 10 0;");
                                pane2.getChildren().addAll(hb,hb2);
                                
                                String A = p3.getImage();
                                A = "C:\\xampp\\htdocs\\datatable_21\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(140);
                                image.setFitHeight(130);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(40);
                                image.setLayoutY(-45);
                                pane2.getChildren().add(image);
                                
                                Rating rating=new Rating();
                                rating.setPrefWidth(20);
                                rating.setPrefHeight(19);
                                rating.setLayoutX(600);
                                rating.setLayoutY(183);
                                int rate = 0;
                             try {
                                 rate = service_pr.AfficherRating(p3.getId());
                             } catch (SQLException ex) {
                                 Logger.getLogger(ProduitsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                             }
                                rating.ratingProperty().setValue(rate);
                                
                                
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("prix : ");
                                Label prix = new Label(String.valueOf(p3.getPrix())+" DT");
                                nomt.setLayoutX(600);
                                nomt.setLayoutY(160);
                                nom.setLayoutX(650);
                                nom.setLayoutY(145);
                                prixt.setLayoutX(600);
                                prixt.setLayoutY(180);
                                prix.setLayoutX(650);
                                prix.setLayoutY(165);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                            t1.setOnMouseClicked((MouseEvent event) -> {
                                      Produit.setPanier(p3);
                                      getShowPane();
                                });
      t.setOnMouseClicked((MouseEvent event) -> {
                                  Produit.setId_courant(p3.getId());
                                        
       try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/views/Quickview.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                });
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix,rating);
                                    
                                }
                            k++;
                            
                            }
                    return pane;
    }


}