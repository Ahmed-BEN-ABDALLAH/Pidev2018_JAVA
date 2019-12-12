/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import entities.Jardin;
import entities.User;
import entities.evenement;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;
import service.MyServiceEvenement;
import service.ServiceJardins;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author Majouli
 */
public class jardinController implements Initializable {
    @FXML
    private TextField nomjardin;
    @FXML
    private TextField adresse_jar;
    @FXML
    private JFXTextArea description_jar;
    @FXML
    private TextField tel_jar;
    @FXML
    private TextField adresse_mail;
      @FXML

    private ImageView logo;

    
 private User fos;

       private final User currentUser=Authentification.user;
       
       private Desktop desktop = Desktop.getDesktop();
    
     final FileChooser fileChooser = new FileChooser();
     
     private String file_image ;
      
     
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    @FXML
    private ImageView image_jar;
    private JFXButton fichier;
    
         private  ServiceJardins sj=new ServiceJardins();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(currentUser.getId());
    }    
     
    private boolean testNumberInput(String a)
    {
        boolean b=false;
        if(a.matches("^[0-9]*"))
        {
            b=true;
        }
        return b;
    }
 
    @FXML
    private void addbutton(ActionEvent event) throws IOException, SQLException {
        Jardin jar=new Jardin();
        jar.setNom(nomjardin.getText());
        jar.setAdresse(adresse_jar.getText());
             jar.setNumtel(Integer.parseInt(tel_jar.getText()));

        jar.setDescription(description_jar.getText());
  
        jar.setAdresseemail(adresse_mail.getText());

 jar.setProprietaire(currentUser.getId());
 
   file_image="/images/"+file_image;
   jar.setLogo(file_image);
        
        
            pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
            pathto = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\images\\"+Current_file.getName());
            Path targetDir = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\images\\");
        System.out.println(targetDir);
                    Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);

   /************ is empty verify***************/

   if(nomjardin.getText().length()==0){
    nomjardin.setStyle("-fx-text-inner-color: red");
            nomjardin.setStyle("-fx-prompt-text-fill: red");
            nomjardin.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez nommer votre jardin!");
            alert.showAndWait();
            nomjardin.setCursor(Cursor.WAIT);
            nomjardin.setStyle("-fx-text-inner-color:  #663399");
            nomjardin.setStyle("-fx-prompt-text-fill:  #663399");

   
   }
   else if(adresse_jar.getText().length()==0){
   
  
    adresse_jar.setStyle("-fx-text-inner-color: red");
            adresse_jar.setStyle("-fx-prompt-text-fill: red");
            adresse_jar.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saiisr l'adresse de l'event!");
            alert.showAndWait();
            adresse_jar.setCursor(Cursor.WAIT);
            adresse_jar.setStyle("-fx-text-inner-color:  #663399");
            adresse_jar.setStyle("-fx-prompt-text-fill:  #663399");

   
   }
      else if(description_jar.getText().length()==0){
   
  
    description_jar.setStyle("-fx-text-inner-color: red");
            description_jar.setStyle("-fx-prompt-text-fill: red");
            description_jar.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
         
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saiisr la description de l'event!");
            alert.showAndWait();
            description_jar.setCursor(Cursor.WAIT);
            description_jar.setStyle("-fx-text-inner-color:  #663399");
            description_jar.setStyle("-fx-prompt-text-fill:  #663399");

   
   }
   

else
{ 
      
sj.addjardin(jar);
         Notifications n =Notifications.create().title("Notification")
             .text("Ajouter efféctué avec succés")
             .graphic(null)
             .position(Pos.BASELINE_LEFT)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
    template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/Jardinsmenu.fxml"))));   


}  
        
        
       
    
    }
            @FXML
    private void imageDragOver(DragEvent event) {
             Dragboard board = event.getDragboard();
      if (board.hasFiles()) {
        event.acceptTransferModes(TransferMode.ANY);
      }
        
    }

    @FXML
    private void imageDropped(DragEvent event) throws FileNotFoundException {
                  Dragboard board = event.getDragboard();
        List<File> phil = board.getFiles();
        FileInputStream fis;
          fis = new FileInputStream(phil.get(0));
        Image image = new Image(fis);
      File selectedFile = phil.get(0);
        if (selectedFile != null) {
           
         String test = selectedFile.getAbsolutePath();
            System.out.println(test);
            
            Current_file=selectedFile.getAbsoluteFile();
            file_image=Current_file.getName();
           evenement e= new evenement();
           e.setImage(selectedFile.getName());
          logo.setImage(image);
    }
    
  

    

    }

    
}
