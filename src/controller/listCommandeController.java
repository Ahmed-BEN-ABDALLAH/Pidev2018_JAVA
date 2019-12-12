/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.prism.impl.Disposer;
import entities.Produit;
import entities.User;
import entities.commande;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import service.ServiceCommande;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author said
 */
public class listCommandeController implements Initializable {

    service.ServiceCommande service_commande= new ServiceCommande();
    @FXML
    private TableColumn<commande, Integer> idc;
    @FXML
    private TableColumn<commande, String> nom;
    @FXML
    private TableColumn<commande, Integer> qnt;
    @FXML
    private TableColumn<commande, Integer> age;
    @FXML
    private TableColumn<commande, String> genre;
    @FXML
    private TableColumn<commande, String> categorie;
    @FXML
    private TableView<commande> table_view;
    //commande cmd=new commande();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       User currentUser=Authentification.user;
       ObservableList<commande> list= FXCollections.observableArrayList();
      
        for (commande cmd:service_commande.afficheCommande(currentUser.getId()) )
        {
//            if(cmd.getValide()==0)
//            {
                list.add(cmd);
//            }
        }
            
      
        idc.setCellValueFactory(new PropertyValueFactory<>("idc"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        qnt.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));

        TableColumn col_action = new TableColumn<>("valider");
        table_view.getColumns().add(col_action);
        
        col_action.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_action.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

    
                    
             @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCell_commande();
            }
        
        });
            
    table_view.setItems(list);
    }    
    

}
