/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import controllers.UpdateBabyController;
import entities.User;
import entities.baby;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import service.serviceBaby;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author ghada
 */
public class UpdateProfilController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXTextField numtel;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField prix;
    @FXML
    private Button Image_fichier;
    @FXML
    private ImageView image_p;
    
    
          final FileChooser fileChooser = new FileChooser();
     private Desktop desktop = Desktop.getDesktop();
     private String file_image ;
    
    private JFXButton fichier;

    private Path pathfrom;
    private Path pathto;
    private File Current_file;


    
    
    
    
        serviceBaby servicebb=new serviceBaby();
     private User b;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          b = servicebb.AfficherProfil();
          
        nom.setText(b.getNom());
        email.setText(b.getEmail());
         numtel.setText(String.valueOf(b.getNumtel()));
             description.setText(b.getDescription());
             prix.setText(String.valueOf(b.getPrix()));
//        System.out.println(b.getPrenom());
   
        adresse.setText(b.getAdrese());
    
            

   }
    
        
        
        
        

    @FXML
    private void modifierAction(MouseEvent event) throws IOException, SQLException {
        
         
        
    
            b.setNom(nom.getText());
                   b.setPrenom(prenom.getText());

              b.setImage("images/"+Current_file.getName());
        
        //b.setPrenom(prenom.getText());
        b.setAdrese(adresse.getText());
         b.setDescription(description.getText());
         b.setNumtel(Integer.parseInt(numtel.getText()));
        // currentUser.setEmail(email.getText());
      b.setPrix(Integer.parseInt(prix.getText()));
        
     
   

   
   
   
   
            servicebb.updatProfil(b);             
          template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/MenuGhada.fxml"))));
       
    }
        
        
    

    @FXML
    private void image_fichier(MouseEvent event) throws MalformedURLException {
        
        Current_file = fileChooser.showOpenDialog(template.Template.getInstance().getStage());
                    if (Current_file != null) {
//                        openFile(file);
                        System.out.println(Current_file.toURI().toURL().toExternalForm());
                     file_image= Current_file.getName();
                    }
        
         
    Image image2 = new Image(Current_file.toURI().toString());
             
image_p.setImage(image2);
          System.out.println();
     
    }
    
}
