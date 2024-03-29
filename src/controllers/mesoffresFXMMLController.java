/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXListView;
import entities.baby;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import service.serviceBaby;

/**
 * FXML Controller class
 *
 * @author ghada
 */
public class mesoffresFXMMLController implements Initializable {
            
     serviceBaby service_baby=new serviceBaby();
     baby p = new baby();
    

    @FXML
    private JFXListView<Pane> ListView_Produits;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView_Produits.setFocusTraversable( false );
          getShowPane();
          
    }
  
      public void getShowPane()
    {
        List <baby> AllProducts  = new ArrayList();
        for (baby p: service_baby.Affichermesbaby())
        {
            AllProducts.add(p);
        }
        System.out.println(AllProducts);
        int i=0;
        int j=0;
        ObservableList<Pane> Panes = FXCollections.observableArrayList();  

        List <baby> ThreeProducts= new ArrayList();
        for (baby p:AllProducts )
        {
            if(i==0)
            {
                ThreeProducts.add(p);
                i++;
                j++;
                
                     if(j==AllProducts.size())
                {System.out.println("hello322");
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
    public Pane AddPane( List<baby> ThreeProduct)
    {
        Pane pane = new Pane();
                    int k =1;
                    for (baby p3:ThreeProduct )
                        {
                         if(k == 1)
                            {
                                Pane pane2=new Pane();
                                pane2.setLayoutX(25);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                        Text t=new Text("Modifier");        
                        Text t1=new Text("Supprimer");        
                        t1.setStyle("-fx-font-weight: bold;");
                        t.setStyle("-fx-font-weight: bold;");
                        HBox hb=new HBox(t);
                        HBox hb2=new HBox(t1);
                        
                        
                                hb.setLayoutX(0);
                                hb.setLayoutY(170);
                                hb.setPrefWidth(hb.getWidth() + 150); 
                                hb.setPrefHeight(hb.getHeight() + 75);
                                hb.setStyle("-fx-background-color: #2cbae3");
                                
                                hb2.setLayoutX(140);
                                hb2.setLayoutY(170);
                                hb2.setPrefWidth(hb.getWidth() + 40); 
                                hb2.setPrefHeight(hb.getHeight() + 75);
                                hb2.setStyle("-fx-background-color: #2cbae3");
                                pane2.getChildren().addAll(hb,hb2);
                                
                                String A = p3.getImage();
                                A = "C:\\xampp\\htdocs\\datatable_21\\web\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(130);
                                image.setFitHeight(140);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(45);
                                image.setLayoutY(-35);
                                pane2.getChildren().add(image);
                                
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("prix : ");
                                Label prix = new Label(String.valueOf(p3.getPrix())+" DT");
                                nomt.setLayoutX(50);
                                nomt.setLayoutY(180);
                                nom.setLayoutX(100);
                                nom.setLayoutY(165);
                                prixt.setLayoutX(50);
                                prixt.setLayoutY(200);
                                prix.setLayoutX(100);
                                prix.setLayoutY(185);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                            t.setOnMouseClicked((MouseEvent event) -> {
            baby.setId_courant(p3.getId());
                                        
       try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/UpdateBaby.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                });
                                      t1.setOnMouseClicked((MouseEvent event) -> {
           service_baby.SupprimerBaby(p3);
           
           Notifications n =Notifications.create().title("Notification")
             .text("Suppression efféctué avec succés")
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
           
           
                                                                         
                                });
                            
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);
//               
                            }
                            if(k == 2)
                            {
                               Pane pane2=new Pane();
                                pane2.setLayoutX(300);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                        Text t=new Text("Modifier");        
                        Text t1=new Text("Supprimer");        
                        t1.setStyle("-fx-font-weight: bold;");
                        t.setStyle("-fx-font-weight: bold;");
                        HBox hb=new HBox(t);
                        HBox hb2=new HBox(t1);
                        
                        
                                hb.setLayoutX(0);
                                hb.setLayoutY(170);
                                hb.setPrefWidth(hb.getWidth() + 150); 
                                hb.setPrefHeight(hb.getHeight() + 75);
                                hb.setStyle("-fx-background-color: #2cbae3");
                                
                                hb2.setLayoutX(140);
                                hb2.setLayoutY(170);
                                hb2.setPrefWidth(hb.getWidth() + 40); 
                                hb2.setPrefHeight(hb.getHeight() + 75);
                                hb2.setStyle("-fx-background-color: #2cbae3");
                                pane2.getChildren().addAll(hb,hb2);
                                
                                String A = p3.getImage();
                                     A = "C:\\xampp\\htdocs\\datatable_21\\web\\"+A;
                                System.out.println(A);
                                File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(130);
                                image.setFitHeight(140);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(45);
                                image.setLayoutY(-35);
                                pane2.getChildren().add(image);
                                
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("prix : ");
                                Label prix = new Label(String.valueOf(p3.getPrix())+" DT");
                                nomt.setLayoutX(325);
                                nomt.setLayoutY(180);
                                nom.setLayoutX(375);
                                nom.setLayoutY(165);
                                prixt.setLayoutX(325);
                                prixt.setLayoutY(200);
                                prix.setLayoutX(375);
                                prix.setLayoutY(185);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                
                                            t.setOnMouseClicked((MouseEvent event) -> {
            baby.setId_courant(p3.getId());
                                        
       try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/UpdateBaby.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                });
                                            
                                            
                                                               t1.setOnMouseClicked((MouseEvent event) -> {
           service_baby.SupprimerBaby(p3);
                                        
                                    try {                                  
                                        template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/MenuGhada.fxml"))));
                                    } catch (IOException ex) {
                                        Logger.getLogger(mesoffresFXMMLController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });
                            
                            //t1.setOnMouseClicked((MouseEvent event) -> {
                                      //Produit.setPanier(p3);
                                   //  ListeCommande();
                                     // getShowPane();
                            //    });
                            //t.setOnMouseClicked((MouseEvent event) -> {
                                     // Produit.setPanier(p3);
                                 
                               // });
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);                    
                            }
                            
                            if(k == 3)
                                {
                                   Pane pane2=new Pane();
                                pane2.setLayoutX(575);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                        Text t=new Text("Modifier");        
                        Text t1=new Text("Supprimer");        
                        t1.setStyle("-fx-font-weight: bold;");
                        t.setStyle("-fx-font-weight: bold;");
                        HBox hb=new HBox(t);
                        HBox hb2=new HBox(t1);
                        
                        
                                hb.setLayoutX(0);
                                hb.setLayoutY(170);
                                hb.setPrefWidth(hb.getWidth() + 150); 
                                hb.setPrefHeight(hb.getHeight() + 75);
                                hb.setStyle("-fx-background-color: #2cbae3");
                                
                                hb2.setLayoutX(140);
                                hb2.setLayoutY(170);
                                hb2.setPrefWidth(hb.getWidth() + 40); 
                                hb2.setPrefHeight(hb.getHeight() + 75);
                                hb2.setStyle("-fx-background-color: #2cbae3");
                                pane2.getChildren().addAll(hb,hb2);
                                
                                String A = p3.getImage();
                               A = "C:\\xampp\\htdocs\\datatable_21\\web\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(130);
                                image.setFitHeight(140);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(45);
                                image.setLayoutY(-35);
                                pane2.getChildren().add(image);
                                
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("prix : ");
                                Label prix = new Label(String.valueOf(p3.getPrix())+" DT");
                                nomt.setLayoutX(600);
                                nomt.setLayoutY(180);
                                nom.setLayoutX(650);
                                nom.setLayoutY(165);
                                prixt.setLayoutX(600);
                                prixt.setLayoutY(200);
                                prix.setLayoutX(650);
                                prix.setLayoutY(185);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
//                            t1.setOnMouseClicked((MouseEvent event) -> {
//                                   //   Produit.setPanier(p3);
//                       
//                                      getShowPane();
//                                });
                                       t.setOnMouseClicked((MouseEvent event) -> {
            baby.setId_courant(p3.getId());
                                        
       try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/UpdateBaby.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                });
                                       
                                       
                   t1.setOnMouseClicked((MouseEvent event) -> {
           service_baby.SupprimerBaby(p3);
                                        
                                    try {                                  
                                        template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/MenuGhada.fxml"))));
                                    } catch (IOException ex) {
                                        Logger.getLogger(mesoffresFXMMLController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });
                            
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);
                                    
                                }
                            k++;
                            
                            }
                    return pane;
    }
  
  
  
    }    
    

