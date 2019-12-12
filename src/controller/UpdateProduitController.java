
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import template.Template;
import entities.Produit;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.fxml.Initializable;
import service.ServiceProduit;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import com.sun.prism.impl.Disposer.Record;
import java.awt.Desktop;
import static java.awt.SystemColor.desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import service.ServiceProduit;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UpdateProduitController implements Initializable {

        ServiceProduit service_pr=new ServiceProduit();
//
//    private Produit P;
//    @FXML
//    private Button ajout;
//    @FXML
//    private JFXTextField nom_pr;
//    @FXML
//    private JFXTextField prix_pr;
//    @FXML
//    private JFXTextField age_pr;
//    @FXML
//    private JFXTextField stock_pr;
//    @FXML
//    private JFXRadioButton homme;
//    @FXML
//    private ToggleGroup genre;
//    @FXML
//    private JFXRadioButton femme;
//    @FXML
//    private JFXComboBox<String> categorie_pr;
//    @FXML
//    private JFXButton fichier;
//    @FXML
//    private ImageView image_p;
//    @FXML
//    private JFXTextArea description_pr;
//        ObservableList<String> data = FXCollections.observableArrayList("vêtements", "chaussures","sous-vêtements", "pyjamas","jouets","lits","bureaux","bibliothéques");
    
        Produit P=new Produit();
        @FXML
    private Button update;
    @FXML
    private JFXTextField nom_pr;
    @FXML
    private JFXTextField prix_pr;
    @FXML
    private JFXTextField age_pr;
    @FXML
    private JFXTextField stock_pr;
    @FXML
    private ImageView image_p;
    @FXML
    private JFXTextArea description_pr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
       
        
            try {
                Produit P = service_pr.GetProduitbyid(Produit.getId_courant());
                
        nom_pr.setText(P.getNom());
//     
        stock_pr.setText(String.valueOf(P.getStock()));
        prix_pr.setText(String.valueOf(P.getPrix()));
        age_pr.setText(String.valueOf(P.getAge()));
        description_pr.setText(P.getDescription());
//         categorie_pr.setItems(data);
//            
//// TODO
//        } catch (SQLException ex) {
//            Logger.getLogger(UpdateProduitController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }    
//
//    private void update_produit(ActionEvent event) throws SQLException, IOException {
//        P.setNom(nom_pr.getText());
//        P.setStock(Integer.parseInt(stock_pr.getText()));
//        P.setAge(Integer.parseInt(age_pr.getText()));
//        P.setDescription((description_pr.getText()));
//        P.setGenre(radioSelected(event));
//        P.setPrix(Integer.parseInt(age_pr.getText()));
//        P.setCategorie(categorie_pr.getValue());
//        P.setCategorie(categorie_pr.getValue());
//           service_pr.UpdateProduit(P);
//                  Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/affiche.fxml"))));             
//
//    }
//
//    @FXML
//    private void ajout(ActionEvent event) {
//    }
//@FXML
//    private String radioSelected(ActionEvent event) {
//        String genre="";
//        if(homme.isSelected())
//        { genre+= homme.getText(); }
//        if(femme.isSelected())
//        { genre+= femme.getText(); }
//        return genre;
//    }
//
//    @FXML
//    private void fichier_image(ActionEvent event) {
//    }
//    
            } catch (SQLException ex) {
                Logger.getLogger(UpdateProduitController.class.getName()).log(Level.SEVERE, null, ex);
            }
}

    @FXML
    private void update(ActionEvent event) throws SQLException {
        P.setId(Produit.getId_courant());
          P.setNom(nom_pr.getText());
        P.setStock(Integer.parseInt(stock_pr.getText()));
        P.setAge(Integer.parseInt(age_pr.getText()));
        P.setDescription((description_pr.getText()));
             service_pr.UpdateProduit(P);
 Stage stage2  = (Stage) update.getScene().getWindow();
    stage2.close();
        
    }

}