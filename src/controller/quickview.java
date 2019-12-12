/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jfoenix.controls.JFXListView;

import entities.Produit;
import entities.commentaireP;
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
/**
 * FXML Controller class
 *
 * @author said
 */
public class quickview implements Initializable {

    @FXML
    private ImageView p_image;
    @FXML
    private Text nom_p;
    @FXML
    private Text p_prix;
    @FXML
    private Label p_desc;

    /**
     * Initializes the controller class.
     */
    Produit p1 = new Produit();
   ServiceProduit service = new ServiceProduit();
    @FXML
    private Rating rating;
    @FXML
    private Label label_rating;
    @FXML
    private ImageView qrcode;
    @FXML
    private JFXListView<commentaireP> ListView_Produits;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
          
                
                try {
                    
                    
                    
                    
                    Produit Pcourant = new Produit();
                    
                    try {
                        Pcourant = service.GetProduitbyid(Produit.getId_courant());
                        // TODO
                        //qrcode
                    } catch (SQLException ex) {
                        Logger.getLogger(quickview.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
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
                        Logger.getLogger(quickview.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(quickview.class.getName()).log(Level.SEVERE, null, ex);
                }
                                
    
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
    


  
    
}