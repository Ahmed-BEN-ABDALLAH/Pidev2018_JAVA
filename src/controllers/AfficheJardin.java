/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXListView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Jardin;
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
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.MyServiceDonation;
import service.MyServiceEvenement;
import service.ServiceJardins;
import util.Authentification;

/**
 *
 * @author AHMED
 */
public class AfficheJardin implements Initializable {

    private final User currentUser = Authentification.user;
    ServiceJardins service_jar = new ServiceJardins();
    produit_donation p = new produit_donation();
    @FXML
    private JFXListView<Pane> ListView_Jardins;
    @FXML
    private JFXListView<Jardin> list_jardin;

    /* @FXML
    private JFXListView<Pane> ListView_Produits ;
    @FXML
    private JFXListView<produit_donation> ListView_Produits1;*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // ListView_Produits.setMouseTransparent( true );
        ListView_Jardins.setFocusTraversable(false);
        getShowPane();

    }

    public void getShowPane() {
        List<Jardin> alljardins = new ArrayList();

        for (Jardin j : service_jar.listjardins()) {
            alljardins.add(j);
            System.out.println(p);
        }
        System.out.println(alljardins);
        int i = 0;
        int j = 0;
        ObservableList<Pane> Panes = FXCollections.observableArrayList();

        List<Jardin> Threejardin = new ArrayList();
        for (Jardin jar : alljardins) {
            if (i == 0) {
                Threejardin.add(jar);
                i++;
                j++;

                if (j == alljardins.size()) {
                    System.out.println("hello322");
                    Panes.add(AddPane(Threejardin));

                    Threejardin.clear();

                }
            } else {
                Threejardin.add(jar);
                i++;
                j++;
                if ((i % 3 == 0) || (j == alljardins.size())) {

                    Panes.add(AddPane(Threejardin));

                    Threejardin.clear();

                }
            }
        }
        ListView_Jardins.setItems(Panes);
    }

    public Pane AddPane(List<Jardin> Threejardin) {
        Pane pane = new Pane();
        int k = 1;
        for (Jardin j3 : Threejardin) {
            if (k == 1) {
                Pane pane2 = new Pane();
                pane2.setLayoutX(25);
                pane2.setLayoutY(50);
                pane2.setPrefWidth(pane2.getWidth() + 215);
                pane2.setPrefHeight(pane2.getHeight() + 200);
                //pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

                Text t = new Text("quick view");
                Text t1 = new Text("acheter");
                t1.setStyle("-fx-font-weight: bold;");
                t.setStyle("-fx-font-weight: bold;");

                String A = j3.getLogo();
                A = "C:\\xampp\\htdocs\\datatable_21\\web\\" + A;
                File F1 = new File(A);
                Image image2 = new Image(F1.toURI().toString());

                ImageView image = new ImageView();
                image.setFitWidth(130);
                image.setFitHeight(140);
                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                image.setImage(image2);
                image.setLayoutX(45);
                image.setLayoutY(-35);
                pane2.getChildren().add(image);

//                                 Button depart= new Button("Annuler");
//                            depart.setLayoutX(50);
//                            depart.setLayoutY(210);
//                                      depart.setOnMouseClicked((MouseEvent event) -> {
//                                     
//                                
//                                          
//                                          
//                                          
//                                           
//                                                   System.out.println("aaaaaaa");
//                                                     evenement.setId_courant(p3.getId());
//                                                 int i =p3.getParticiate();
//                                          
//                                                  ParticiperController part=new ParticiperController();
//                                                  
//                                          System.out.println(i);
//                                    try {
//                                        part.part(p3);
//                                    } catch (SQLException ex) {
//                                        Logger.getLogger(MesPartController.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
//                                    
//                                });
                Text nomt = new Text("Nom : ");
                Label nom = new Label(j3.getNom());
                Text prixt = new Text("Adresse : ");
                Label prix = new Label(String.valueOf(j3.getAdresse()));
                Text telt = new Text("Téléphone: ");
                Label tel = new Label(String.valueOf(j3.getNumtel()));

                telt.setLayoutX(50);
                telt.setLayoutY(220);

                tel.setLayoutX(120);
                tel.setLayoutY(205);
                telt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");

                nomt.setLayoutX(50);
                nomt.setLayoutY(180);

                nom.setLayoutX(100);
                nom.setLayoutY(165);

                prixt.setLayoutX(50);
                prixt.setLayoutY(200);
                prix.setLayoutX(130);
                prix.setLayoutY(185);

                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");

                t1.setOnMouseClicked((MouseEvent event) -> {

                    getShowPane();
                });
                FontAwesomeIconView tq = new FontAwesomeIconView(FontAwesomeIcon.EXPAND);
                tq.setFill(Color.BLUE);
                tq.setSize("20");
                tq.setLayoutX(30);
                tq.setLayoutY(240);
                tq.setCursor(Cursor.HAND);
                /**
                 * ********** quick view**********
                 */

                System.out.println(p);
                tq.setOnMouseClicked((MouseEvent event) -> {
                    Jardin.setId_courant_jardin(j3.getId());

                    try {
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/viewjardin.fxml")));
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException e) {
                        Logger logger = Logger.getLogger(getClass().getName());
                        logger.log(Level.SEVERE, "Failed to create new Window.", e);
                    }
                });

                pane.getChildren().addAll(pane2, nomt, prixt, nom, prix, tq, tel, telt);

            }
            if (k == 2) {
                Pane pane2 = new Pane();
                pane2.setLayoutX(300);
                pane2.setLayoutY(50);
                pane2.setPrefWidth(pane2.getWidth() + 215);
                pane2.setPrefHeight(pane2.getHeight() + 200);
                //pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

                Text t = new Text("quick view");
                Text t1 = new Text("acheter");
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

                String A = j3.getLogo();
                A = "C:\\xampp\\htdocs\\datatable_21\\web\\" + A;
                File F1 = new File(A);
                Image image2 = new Image(F1.toURI().toString());

                ImageView image = new ImageView();
                image.setFitWidth(130);
                image.setFitHeight(140);
                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                image.setImage(image2);
                image.setLayoutX(45);
                image.setLayoutY(-35);
                pane2.getChildren().add(image);

                Text nomt = new Text("Nom : ");
                Label nom = new Label(j3.getNom());
                Text prixt = new Text("Adresse : ");
                Label prix = new Label(String.valueOf(j3.getAdresse()));
                nomt.setLayoutX(325);
                nomt.setLayoutY(180);
                nom.setLayoutX(375);
                nom.setLayoutY(165);
                prixt.setLayoutX(325);
                prixt.setLayoutY(200);
                prix.setLayoutX(405);
                prix.setLayoutY(185);
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");

                Text telt = new Text("Téléphone: ");
                Label tel = new Label(String.valueOf(j3.getNumtel()));

                telt.setLayoutX(325);
                telt.setLayoutY(220);

                tel.setLayoutX(405);
                tel.setLayoutY(205);
                telt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");

                FontAwesomeIconView tq = new FontAwesomeIconView(FontAwesomeIcon.EXPAND);
                tq.setFill(Color.BLUE);
                tq.setSize("20");
                tq.setLayoutX(305);
                tq.setLayoutY(240);
                tq.setCursor(Cursor.HAND);
                /**
                 * ********** quick view**********
                 */

                tq.setOnMouseClicked((MouseEvent event) -> {
                    Jardin.setId_courant_jardin(j3.getId());

                    try {
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/viewjardin.fxml")));

                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException e) {
                        Logger logger = Logger.getLogger(getClass().getName());
                        logger.log(Level.SEVERE, "Failed to create new Window.", e);
                    }
                });

                pane.getChildren().addAll(pane2, nomt, prixt, nom, prix, tq, tel, telt);

                /**
                 * ***************** 222  delete*******************
                 */
//                       
                /**
                 * ************** *************
                 */
//                            /************  update2 ****************/
//                                        
//                               FontAwesomeIconView fu=new FontAwesomeIconView(FontAwesomeIcon.EDIT);
//                             fu.setFill(Color.BLUE);
//                              fu.setSize("30");
//                              fu.setLayoutX(477);
//                             fu.setLayoutY(85);
//                             fu.setCursor(Cursor.HAND);
//                           
//                             
//                           
//                         
//                                               fu.setOnMouseClicked((MouseEvent event) -> {
//                                  evenement.setId_courant(p3.getId());
//                                        
//       try {
//        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/UpdateEvFXML.fxml")));
//
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//    } catch (IOException e) {
//        Logger logger = Logger.getLogger(getClass().getName());
//        logger.log(Level.SEVERE, "Failed to create new Window.", e);
//    }                                    
//                                });
//                                               
//                                          pane.getChildren().add(fu);       
//                                 
//                            
//                            
//                            /***********************************************/
            }

            if (k == 3) {
                Pane pane2 = new Pane();
                pane2.setLayoutX(575);
                pane2.setLayoutY(50);
                pane2.setPrefWidth(pane2.getWidth() + 215);
                pane2.setPrefHeight(pane2.getHeight() + 200);
                //pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

                Text t = new Text("quick view");
                Text t1 = new Text("acheter");
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
                String A = j3.getLogo();
                A = "C:\\xampp\\htdocs\\datatable_21\\web\\" + A;
                File F1 = new File(A);
                Image image2 = new Image(F1.toURI().toString());

                ImageView image = new ImageView();
                image.setFitWidth(130);
                image.setFitHeight(140);
                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                image.setImage(image2);
                image.setLayoutX(45);
                image.setLayoutY(-35);
                pane2.getChildren().add(image);

                Text nomt = new Text("Nom : ");
                Label nom = new Label(j3.getNom());
                Text prixt = new Text("Adresse : ");
                Label prix = new Label(String.valueOf(j3.getAdresse()));
                nomt.setLayoutX(600);
                nomt.setLayoutY(180);
                nom.setLayoutX(650);
                nom.setLayoutY(165);
                prixt.setLayoutX(600);
                prixt.setLayoutY(200);
                prix.setLayoutX(680);
                prix.setLayoutY(185);
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");

                Text telt = new Text("Téléphone: ");
                Label tel = new Label(String.valueOf(j3.getNumtel()));

                telt.setLayoutX(600);
                telt.setLayoutY(220);

                tel.setLayoutX(680);
                tel.setLayoutY(205);
                telt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");

                FontAwesomeIconView tq = new FontAwesomeIconView(FontAwesomeIcon.EXPAND);
                tq.setFill(Color.BLUE);
                tq.setSize("20");
                tq.setLayoutX(580);
                tq.setLayoutY(240);
                tq.setCursor(Cursor.HAND);
                /**
                 * ********** quick view**********
                 */

                tq.setOnMouseClicked((MouseEvent event) -> {
                    Jardin.setId_courant_jardin(j3.getId());

                    try {
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/viewjardin.fxml")));

                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException e) {
                        Logger logger = Logger.getLogger(getClass().getName());
                        logger.log(Level.SEVERE, "Failed to create new Window.", e);
                    }
                });

                pane.getChildren().addAll(pane2, nomt, prixt, nom, prix, tq, tel, telt);
//                                         /******************* 333  delete********************/
//                        
//                           FontAwesomeIconView f=new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT);
//                             f.setFill(Color.RED);
//                              f.setSize("30");
//                              f.setLayoutX(590);
//                             f.setLayoutY(85);
//                             f.setCursor(Cursor.HAND);
//                             
//                             f.setOnMouseClicked((MouseEvent event) -> {
//                              
//                                    try {
//                                        service_pr.deleteEv(p3,p3.getId());
//                                    } catch (SQLException ex) {
//                           three             Logger.getLogger(MesEv.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
//                                     ListView_Produits.setItems(null);
//                                      getShowPane();
//                                });
//                            pane.getChildren().add(f);
//                            
//                            
////                                     /************  update333 ****************/
//                                        
//                               FontAwesomeIconView fu=new FontAwesomeIconView(FontAwesomeIcon.EDIT);
//                             fu.setFill(Color.BLUE);
//                              fu.setSize("30");
//                              fu.setLayoutX(755);
//                             fu.setLayoutY(85);
//                             fu.setCursor(Cursor.HAND);
//                           
//                             
//                           
//                         
//                                               fu.setOnMouseClicked((MouseEvent event) -> {
//                                  evenement.setId_courant(p3.getId());
//                                        
//       try {
//        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/UpdateEvFXML.fxml")));
//
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//    } catch (IOException e) {
//        Logger logger = Logger.getLogger(getClass().getName());
//        logger.log(Level.SEVERE, "Failed to create new Window.", e);
//    }                                    
//                                });
//                                               
//                                          pane.getChildren().add(fu);       
//                                 
//                            
//                            
//                            /***********************************************/

                /**
                 * ***************************
                 */
            }
            k++;

        }
        return pane;
    }

}
