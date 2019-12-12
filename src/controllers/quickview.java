/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.evenement;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import  service.MyServiceEvenement;
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
    evenement p1 = new evenement();
   MyServiceEvenement service = new MyServiceEvenement();
  
    @FXML
    private Text nomorgt;
    @FXML
    private Text adresset;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            p1=service.GetEvbyid(evenement.getId_courant());
        } catch (SQLException ex) {
            Logger.getLogger(quickview.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
      
        
        nom_p.setText(p1.getNom());
        p_prix.setText(String.valueOf(p1.getPrix()));
        p_desc.setText(p1.getDescription());
          adresset.setText(p1.getAdresse());
        
          nomorgt.setText("  "+p1.getNomorg());
          String a=p1.getImage();
    
a="C:\\xampp\\htdocs\\datatable_21\\web\\"+a;
        System.out.println(p1.getImage());
File file =new File(a);

Image image1=new Image(file.toURI().toString());

p_image.setImage(image1);
                                
   
    }    
    
}
