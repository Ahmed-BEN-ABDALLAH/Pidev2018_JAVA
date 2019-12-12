/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.baby;
import entities.demande;
import java.io.File;
import java.net.URL;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import service.serviceDemande;

/**
 * FXML Controller class
 *
 * @author ghada
 */
public class ShowDeatilDemandeController implements Initializable {

    @FXML
    private ImageView p_image;
    @FXML
    private Label email;
    @FXML
    private Label datedeb;
    @FXML
    private Label datefin;
    @FXML
    private Label numtel;
    @FXML
    private Label desc;

    /**
     * Initializes the controller class.
     */
       serviceDemande service= new serviceDemande();
       demande p1= new demande();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        p1=service.GetBabybyid(demande.getId_courant());
        
        System.out.println(p1);
      
        
        email.setText(p1.getEmail());
        numtel.setText(String.valueOf(p1.getNumtel()));
        desc.setText(p1.getDescription());
        datedeb.setText(p1.getDisponibilite().toString());
        datefin.setText(p1.getDatefin().toString());
    
         refresh();
          String a=p1.getImage();
       System.out.println(a);
a="C:\\xampp\\htdocs\\datatable_21\\web\\"+a;
     
        
File file =new File(a);

Image image1=new Image(file.toURI().toString());

p_image.setImage(image1);
                                
   
    } 
        // TODO
    }    
    

