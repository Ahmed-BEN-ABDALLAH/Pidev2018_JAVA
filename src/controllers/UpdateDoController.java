/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.evenement;
import entities.produit_donation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.MyServiceDonation;
import template.Template;

/**
 *
 * @author AHMED
 */
public class UpdateDoController implements Initializable {

       final FileChooser fileChooser = new FileChooser();
    MyServiceDonation service_p = new MyServiceDonation(); 
private  produit_donation P;
    private JFXTextField nom;
    @FXML
    private JFXTextField nom_do;
    @FXML
    private JFXTextArea description_do;
    @FXML
    private JFXTextField adresse_do;
    @FXML
    private TextField tel_do;
    @FXML
    private RadioButton garcon_do;
    @FXML
    private RadioButton fille_do;
    @FXML
    private ImageView image_p;
    @FXML
    private Button ajoutDo;
    @FXML
    private ComboBox<String> categorie;
    @FXML
    private JFXButton fichier;
    @FXML
    private FontAwesomeIconView webcamf;
    private ToggleGroup toggle;
    
    
   private File Current_file;
         private String file_image ;
            
     private Path pathfrom;
    private Path pathto;
    ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        toggle =new ToggleGroup();
                  this.fille_do.setToggleGroup(toggle);
                  this.garcon_do.setToggleGroup(toggle);
                  this.garcon_do.setSelected(false);
        
                  
        try {
              P = service_p.GetDobyid(produit_donation.getId_courant_do());
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    
        
          categorie.getItems().add("Vétements");
                     categorie.getItems().add("Outils scolaire ");
                      categorie.getItems().add("Jeux");
                 categorie.getSelectionModel().selectFirst();
        
        
    nom_do.setText(P.getNom());
    description_do.setText(P.getDescription());
    adresse_do.setText(P.getAdresse());
    garcon_do.setSelected(true);
    tel_do.setText(String.valueOf(P.tel));
       String a=P.getImage();
         a = "C:\\xampp\\htdocs\\datatable_21\\web\\"+a;
        System.out.println(P.getImage());
File file =new File(a);

Image image1=new Image(file.toURI().toString());

image_p.setImage(image1);
    
    
    
    }
    
    
    ;

    @FXML
    private void addButton(ActionEvent event) throws SQLException, IOException {
        
        
        
        
        
      
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
          image_p.setImage(image);
    }
    }
    @FXML
    private void ajoutDo(ActionEvent event) throws IOException, SQLException {
        
        System.out.println("aa111111");
          
         P.setNom(nom_do.getText());
      P.setAdresse(adresse_do.getText());
      P.setDescription(description_do.getText());
      
        System.out.println(P.getImage());
         if (this.toggle.getSelectedToggle().equals(this.fille_do)){
                 
                        P.setGenre("Fille");
        }
        else {
      
      P.setGenre("Garçon");

        }
         
         
         
     
            file_image="/images/"+file_image;
   P.setImage(file_image);
        
   
         System.out.println("aa111111");
        
            pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
            pathto = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\web\\images\\"+Current_file.getName());
            Path targetDir = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\web\\images\\");
        System.out.println(targetDir);
                    Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
         
        
                          System.out.println("aa111111");
              System.out.println("+++++"+P); 
              
           service_p.updateProd(P);
           
           
                  template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/MyMenuDoFXML.fxml"))));             
   
          System.out.println("____"+P);
         
        
        
    }

    @FXML
    private void fichier_image(ActionEvent event) throws MalformedURLException {
        
          
        Current_file = fileChooser.showOpenDialog(Template.getInstance().getStage());
                    if (Current_file != null) {
//                        openFile(file);
                        System.out.println(Current_file.toURI().toURL().toExternalForm());
                     file_image= Current_file.getName();
                    }
        
         
    Image image2 = new Image(Current_file.toURI().toString());
image_p.setImage(image2);
          
                    
                    
        final GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(fichier, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));   
        
        
        
        
        
    }

    @FXML
    private void webcamF(MouseEvent event) throws IOException {
              Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/WebCamPreview.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    
}
