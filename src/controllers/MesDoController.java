/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  controllers;
import template.Template;
import com.jfoenix.controls.JFXListView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.User;
import entities.evenement;
import entities.produit_donation;
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
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.MyServiceDonation;
import service.MyServiceEvenement;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MesDoController implements Initializable {

    
           

        
               private final User currentUser=Authentification.user;
     MyServiceDonation service_pr=new MyServiceDonation();
     public produit_donation p = new produit_donation();
    @FXML
    private JFXListView<Pane> ListView_Produits ;
    @FXML
    private JFXListView<produit_donation> ListView_Produits1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
       // ListView_Produits.setMouseTransparent( true );
ListView_Produits.setFocusTraversable( false );
          getShowPane();
         
          
    }
    
 
    public void getShowPane()
    {
        List <produit_donation> AllProducts  = new ArrayList();
        for (produit_donation p: service_pr.MesDo())
        {
            AllProducts.add(p);
        }
        System.out.println(AllProducts);
        int i=0;
        int j=0;
        ObservableList<Pane> Panes = FXCollections.observableArrayList();  

        List <produit_donation> ThreeProducts= new ArrayList();
        for (produit_donation p:AllProducts )
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
    public Pane AddPane( List<produit_donation> ThreeProduct)
    {
        Pane pane = new Pane();
                    int k =1;
                    for (produit_donation p3:ThreeProduct )
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
                           
                        Text t=new Text("quick view");        
                        Text t1=new Text("acheter");        
                        t1.setStyle("-fx-font-weight: bold;");
                        t.setStyle("-fx-font-weight: bold;");
//                        HBox hb=new HBox(t);
//                        HBox hb2=new HBox(t1);
//                        
//                        
//                                hb.setLayoutX(0);
//                                hb.setLayoutY(170);
//                                hb.setPrefWidth(hb.getWidth() + 190); 
//                                hb.setPrefHeight(hb.getHeight() + 75);
//                                hb.setStyle("-fx-background-color: #2cbae3");
//                                
//                                hb2.setLayoutX(173);
//                                hb2.setLayoutY(170);
//                                hb2.setPrefWidth(hb.getWidth() + 40); 
//                                hb2.setPrefHeight(hb.getHeight() + 75);
//                                hb2.setStyle("-fx-background-color: #2cbae3");
//                                pane2.getChildren().addAll(hb,hb2);
                                
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
                                Text prixt=new Text("Etat : ");
                                Label prix = new Label(p3.getEtat());
                                nomt.setLayoutX(50);
                                nomt.setLayoutY(180);
                                nom.setLayoutX(100);
                                nom.setLayoutY(165);
                                prixt.setLayoutX(50);
                                prixt.setLayoutY(200);
                                prix.setLayoutX(130);
                                prix.setLayoutY(185);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : Blue");
                                
                           
                         
                                
                                
                                
                            t1.setOnMouseClicked((MouseEvent event) -> {
                                     
                                
                                      getShowPane();
                                });
              
                                   
//                              
                            
                            
                            
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);
                        
                        /******************* delete 111  ********************/
                        
                                         
                             FontAwesomeIconView f=new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
                             f.setFill(Color.RED);
                              f.setSize("30");
                              f.setLayoutX(170);
                             f.setLayoutY(230);
                             f.setCursor(Cursor.HAND);
                           
                           
                         
                             
                             f.setOnMouseClicked((MouseEvent event) -> {
                              
                                    try {
                                        service_pr.deleteProd(p3.getId());
                                    } catch (SQLException ex) {
                                        Logger.getLogger(MesEv.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                     ListView_Produits.setItems(null);
                                      getShowPane();
                                });
                            pane.getChildren().add(f);
                            
                            
                            /******************************/
                            
                            
                            
                            /**************  update 111 ********************/
                            
                              
                               FontAwesomeIconView fu=new FontAwesomeIconView(FontAwesomeIcon.EDIT);
                             fu.setFill(Color.BLUE);
                              fu.setSize("30");
                              fu.setLayoutX(205);
                             fu.setLayoutY(230);
                             fu.setCursor(Cursor.HAND);
                           
                             
                           
                         
                                               fu.setOnMouseClicked((MouseEvent event) -> {
                                  produit_donation.setId_courant_do(p3.getId());
                                  
                                        
       try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/UpdateDoFXML.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                });
                                               
                                          pane.getChildren().add(fu);       
                                 
                            
                            
                            /***********************************************/
                      
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
                            
                        Text t=new Text("quick view");        
                        Text t1=new Text("acheter");        
                        t1.setStyle("-fx-font-weight: bold;");
                        t.setStyle("-fx-font-weight: bold;");
//                        HBox hb=new HBox(t);
//                        HBox hb2=new HBox(t1);
//                        
//                        
//                                hb.setLayoutX(0);
//                                hb.setLayoutY(170);
//                                hb.setPrefWidth(hb.getWidth() + 190); 
//                                hb.setPrefHeight(hb.getHeight() + 75);
//                                hb.setStyle("-fx-background-color: #2cbae3");
//                                
//                                hb2.setLayoutX(173);
//                                hb2.setLayoutY(170);
//                                hb2.setPrefWidth(hb.getWidth() + 40); 
//                                hb2.setPrefHeight(hb.getHeight() + 75);
//                                hb2.setStyle("-fx-background-color: #2cbae3");
//                                pane2.getChildren().addAll(hb,hb2);
                                
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
                                Text prixt=new Text("Etat : ");
                                Label prix = new Label(p3.getEtat());
                                nomt.setLayoutX(325);
                                nomt.setLayoutY(180);
                                nom.setLayoutX(375);
                                nom.setLayoutY(165);
                                prixt.setLayoutX(325);
                                prixt.setLayoutY(200);
                                prix.setLayoutX(405);
                                prix.setLayoutY(185);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #blue");
                         
                                
      
                                   Label etat = new Label(p3.getEtat());
                             
                                etat.setLayoutX(325);
                                etat.setLayoutY(220);
                         
                            
                                   
                                
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix,etat); 
                                 
                        /******************* 222  delete********************/
                        
                           
                             
                             
                             
                             
                             FontAwesomeIconView f=new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
                             f.setFill(Color.RED);
                              f.setSize("30");
                              f.setLayoutX(445);
                             f.setLayoutY(230);
                             f.setCursor(Cursor.HAND);
                           
                             
                             
                             f.setOnMouseClicked((MouseEvent event) -> {
                                 try {
                                        service_pr.deleteProd(p3.getId());
                                    } catch (SQLException ex) {
                                        Logger.getLogger(MesEv.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                     ListView_Produits.setItems(null);
                                      getShowPane();
                                  
                                });
                            pane.getChildren().add(f);
                            
                            
                            /**************** **************/
                            
                            /************  update2 ****************/
                                        
                               FontAwesomeIconView fu=new FontAwesomeIconView(FontAwesomeIcon.EDIT);
                             fu.setFill(Color.BLUE);
                              fu.setSize("30");
                              fu.setLayoutX(477);
                             fu.setLayoutY(230);
                             fu.setCursor(Cursor.HAND);
                         
                             
                           
                         
                                               fu.setOnMouseClicked((MouseEvent event) -> {
                                  produit_donation.setId_courant_do(p3.getId());
                                        
       try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/UpdateDoFXML.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                });
                                               
                                          pane.getChildren().add(fu);       
                                 
                            
                            
                            /***********************************************/
                      
                            
                            
                            
                            
                            
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
                            
                        Text t=new Text("quick view");        
                        Text t1=new Text("acheter");        
                        t1.setStyle("-fx-font-weight: bold;");
                        t.setStyle("-fx-font-weight: bold;");
//                        HBox hb=new HBox(t);
//                        HBox hb2=new HBox(t1);
//                        
//                        
//                                hb.setLayoutX(0);
//                                hb.setLayoutY(170);
//                                hb.setPrefWidth(hb.getWidth() + 190); 
//                                hb.setPrefHeight(hb.getHeight() + 75);
//                                hb.setStyle("-fx-background-color: #2cbae3");
//                                
//                                hb2.setLayoutX(173);
//                                hb2.setLayoutY(170);
//                                hb2.setPrefWidth(hb.getWidth() + 40); 
//                                hb2.setPrefHeight(hb.getHeight() + 75);
//                                hb2.setStyle("-fx-background-color: #2cbae3");
//                                pane2.getChildren().addAll(hb,hb2);
//                                
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
                                Text prixt=new Text("Etat : ");
                                Label prix = new Label(p3.getEtat());
                                nomt.setLayoutX(600);
                                nomt.setLayoutY(180);
                                nom.setLayoutX(650);
                                nom.setLayoutY(165);
                                prixt.setLayoutX(600);
                                prixt.setLayoutY(200);
                                prix.setLayoutX(680);
                                prix.setLayoutY(185);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : blue");
                                
                                
                               
                                   Label etat = new Label(p3.getEtat());
                             
                                etat.setLayoutX(600);
                                etat.setLayoutY(220);
                             
                             
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix,etat);
                                         /******************* 333  delete********************/
                        
                           FontAwesomeIconView f=new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
                             f.setFill(Color.RED);
                              f.setSize("30");
                              f.setLayoutX(730);
                             f.setLayoutY(230);
                             f.setCursor(Cursor.HAND);
                             
                           
                             f.setOnMouseClicked((MouseEvent event) -> {
                                    try {
                                        service_pr.deleteProd(p3.getId());
                                    } catch (SQLException ex) {
                                        Logger.getLogger(MesEv.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                     ListView_Produits.setItems(null);
                                      getShowPane();
                             
                                });
                            pane.getChildren().add(f);
                            
                            
                                     /************  update333 ****************/
                                        
                               FontAwesomeIconView fu=new FontAwesomeIconView(FontAwesomeIcon.EDIT);
                             fu.setFill(Color.BLUE);
                              fu.setSize("30");
                              fu.setLayoutX(755);
                             fu.setLayoutY(230);
                             fu.setCursor(Cursor.HAND);
                           
                             
                           
                         
                                               fu.setOnMouseClicked((MouseEvent event) -> {
                                  produit_donation.setId_courant_do(p3.getId());
                                                   System.out.println("----------"+p3);
                                        
       try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/UpdateDoFXML.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                });
                                               
                                          pane.getChildren().add(fu);       
                                 
                            
                            
                            /***********************************************/
                            
                            /******************************/
                                }
                            k++;
                            
                            }
                    return pane;
    }

}