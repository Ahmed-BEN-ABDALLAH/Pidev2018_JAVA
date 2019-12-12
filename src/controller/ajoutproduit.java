/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import template.Template;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Produit;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.controlsfx.control.CheckComboBox;
import service.ServiceProduit;

/**
 *
 * @author said
 */
public class ajoutproduit implements Initializable
{
    ServiceProduit service_pr=new ServiceProduit();
    ObservableList<String> data = FXCollections.observableArrayList("vêtements", "chaussures","sous-vêtements", "pyjamas","jouets","lits","bureaux","bibliothéques");
    
    
    @FXML
    private Button ajout;
    @FXML
    private TextField nom_pr;
    @FXML
    private TextField stock_pr;
    private TextField quantite_pr;
    @FXML
    private JFXTextArea description_pr;
    @FXML
    private JFXTextField age_pr;
    @FXML
    private JFXRadioButton homme;
    @FXML
    private ToggleGroup genre;
    @FXML
    private JFXRadioButton femme;
    
     final FileChooser fileChooser = new FileChooser();
     private Desktop desktop = Desktop.getDesktop();
     private String file_image ;
    
    
    @FXML
    private JFXButton fichier;
    @FXML
    private ImageView image_p;
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    @FXML
    private ComboBox<String> categorie_pr;
    @FXML
    private JFXTextField prix_pr;

  
    @FXML
    private String radioSelected(ActionEvent event) {
        String genre="";
        if(homme.isSelected())
        { genre+= homme.getText(); }
        if(femme.isSelected())
        { genre+= femme.getText(); }
        return genre;
    }
    
    public void initialize(URL url, ResourceBundle rb) {
    categorie_pr.setItems(data);   
    }
    
    @FXML
    private void ajout(ActionEvent event) throws IOException {
           if (!checkText(nom_pr.getText()))
    {         Alert a =new Alert(null, "verifier votre nom", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");}
else if ( nom_pr.getText().length()==0){ Alert a =new Alert(null, " veuillez saisir votre nom", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     }

else if (!checkText(description_pr.getText())){  Alert a =new Alert(null, "verifier votre description", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");}
 else if ( description_pr.getText().length()==0){ Alert a =new Alert(null, " veuillez saisir votre description", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     }

 else if (!testNumberInput(prix_pr.getText())){ Alert a =new Alert(null, "veuillez saisir des chiffres ", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     }
 else if ( prix_pr.getText().length()==0){ Alert a =new Alert(null, " veuillez saisir votre prix", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     }
 else if (!testNumberInput(stock_pr.getText())){ Alert a =new Alert(null, " veuillez saisir des chiffres", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");}
 
 else if ( stock_pr.getText().length()==0){ Alert a =new Alert(null, " veuillez saisir votre stock", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     }
 else if ( stock_pr.getText()=="0"){ Alert a =new Alert(null, "Votre stock doit etre superieur a 0", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     }
  else if (!testNumberInput(age_pr.getText())){ Alert a =new Alert(null, " verifier votre numero Age", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");}
  else if ( age_pr.getText().length()==0){ Alert a =new Alert(null, " veuillez saisir votre age", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     }
else
{ 
  
             Produit p = new Produit();
        p.setNom(nom_pr.getText());
        p.setStock(Integer.parseInt(stock_pr.getText()));
        //p.setQuantite(Integer.parseInt(quantite_pr.getText()));
        p.setPrix(Integer.parseInt(prix_pr.getText()));
        p.setDescription(description_pr.getText());
        p.setGenre(radioSelected(event));
        p.setAge(Integer.parseInt(age_pr.getText()));
        p.setCategorie(categorie_pr.getValue());
        
        file_image="/images/"+file_image;
        p.setImage(file_image);
        
        
            pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
            pathto = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\images\\"+Current_file.getName());
            Path targetDir = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\images\\");
          
  

            Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
        
        
        service_pr.AjoutProduit(p);
       fournisseur.said=2;
       Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/fournisseur.fxml"))));             
    }
    }
    @FXML
     private void fichier_image(ActionEvent event) throws MalformedURLException, IOException {
        
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
   
  private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            
            
            Logger.getLogger(
                afficheproduit.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
    
  
  
  
  
  
  
   private boolean checkText(String b ) {
        
           if(this.testTextInput(b) || (this.testTextInput(b)) ||(this.testTextInput(b)) || (this.testTextInput(b)))
    {
                
return true;
      
        
    }
           
    else
    {
return false;
     
        
    }
      }
   
   
    private boolean testTextInput(String a){
     
     boolean b= true ;
      if(a.length()==0 || testNumberInput(a)){
           b=false; }
      
      return b;
     
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

}
