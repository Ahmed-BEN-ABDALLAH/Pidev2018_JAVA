/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jfoenix.controls.JFXButton;

import entities.Produit;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;
import  service.ServiceProduit;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import controller.quickview;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.User;
import entities.commentaireP;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class QuickviewController implements Initializable {
  private final User currentUser=Authentification.user;
    @FXML
    private AnchorPane Anchorpane;
    @FXML
    private ImageView p_image;
    @FXML
    private Text nom_p;
    @FXML
    private Text p_prix;
    @FXML
    private Label p_desc;
    @FXML
    private Rating rating;
    @FXML
    private Label label_rating;
    @FXML
    private ImageView qrcode;
    @FXML
    private JFXTextArea commentairecontenu;
    @FXML
    private FontAwesomeIconView addcomment;
    @FXML
    private JFXListView<Pane> commentairelist;

    /**
     * Initializes the controller class.
     */
    Produit p1 = new Produit();
   ServiceProduit service = new ServiceProduit();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
         
                    Produit Pcourant = new Produit();
          
                
                try {
                    
                    
                    
                   
                    
             
                        Pcourant = service.GetProduitbyid(Produit.getId_courant());
                        // TODO
                        //qrcode
                  
                    QRCodeWriter qrCodeWriter = new QRCodeWriter();
                    String myWeb = "http://ALLforkids.tn/nom="+Pcourant.getNom()+"/id="+Pcourant.getId();
                    int width = 300;
                    int height = 300;
                    String fileType = "png";
                    
                    BufferedImage bufferedImage = null;
                    BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
                    bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                    bufferedImage.createGraphics();
                    
                    Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(0, 0, width, height);
                    graphics.setColor(Color.BLACK);
                    
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            if (byteMatrix.get(i, j)) {
                                graphics.fillRect(i, j, 1, 1);
                            }
                        }
                    }
                    
                    System.out.println("Success...");
                    
                    
                    
                    ImageView qrView = new ImageView();
                    qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
                    qrcode.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
                    StackPane root = new StackPane();
                    root.getChildren().add(qrView);
                    
                    
                    
                    
                    
                    
                    //qrcode
                    
                    //rating.ratingProperty().setValue(2);
                    rating.ratingProperty().addListener(new ChangeListener<Number>(){
                        @Override
                        public void changed(ObservableValue<? extends Number> observable, Number t, Number t1) {
                            label_rating.setText("rating : "+ t1.toString());
                            
                            
                        }
                        
                        
                    });
                    try {
                        p1=service.GetProduitbyid(Produit.getId_courant());
                    } catch (SQLException ex) {
                        Logger.getLogger(QuickviewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    System.out.println(p1);
                    nom_p.setText(p1.getNom());
                    p_prix.setText(String.valueOf(p1.getPrix()));
                    p_desc.setText(p1.getDescription());
                    String A = p1.getImage();
                    A = "C:\\xampp\\htdocs\\datatable_21\\"+A;
                    File F1 = new File(A);
                    Image image2 = new Image(F1.toURI().toString());
                    p_image.setImage(image2);
                    
                    
                } catch (WriterException ex) {
                    Logger.getLogger(QuickviewController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
            Logger.getLogger(QuickviewController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void Validerrating(ActionEvent event) throws SQLException {
        p1=service.GetProduitbyid(Produit.getId_courant());
        p1.getId();
        
        System.out.println(p1.getId());
        String r=label_rating.getText();
        String sousChaine = r.substring(9, 10);
//System.out.println(sousChaine);
int rate= Integer.parseInt(sousChaine);
        System.out.println(rate);
        service.AjouterRating(rate, p1.getId(),p1.getNom());
        
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
