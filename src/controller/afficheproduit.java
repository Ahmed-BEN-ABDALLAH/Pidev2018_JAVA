/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.prism.impl.Disposer;
import entities.Produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import service.ServiceProduit;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import com.sun.prism.impl.Disposer.Record;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.TableCell;
import template.Template;
/**
 * FXML Controller class
 *
 * @author said
 */
public class afficheproduit implements Initializable {

    ServiceProduit service_pr=new ServiceProduit();
 
    private TableView table = new TableView();
    private ListView<Produit> allproducts_LV;
    @FXML
    private TableView<Produit> table_view;
    @FXML
    private TableColumn<Produit, String> nom_col;
    @FXML
    private TableColumn<Produit, Integer> stock_col;
    @FXML
    private TableColumn<Produit, Integer> quantite_col;
    @FXML
    private TableColumn<Produit, Integer> id_col;
    @FXML
    private Button supp;
    @FXML
    private TableColumn<Produit, Integer> prix_col;
    @FXML
    private TableColumn<Produit, String> categorie_col;
    @FXML
    private TableColumn<Produit, String> description_col;
    @FXML
    private TableColumn<Produit, Integer> age_col;
    @FXML
    private TableColumn<Produit, String> genre_col;
    @FXML
    private TableColumn<Produit, String> image_col;


    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Produit> list= FXCollections.observableArrayList();
        for (Produit p:service_pr.AfficherProduitfournisseur() )
        {
            list.add(p);
            
        }
      
        
 nom_col.setCellValueFactory(new PropertyValueFactory<>("nom"));
 stock_col.setCellValueFactory(new PropertyValueFactory<>("stock"));
 //quantite_col.setCellValueFactory(new PropertyValueFactory<>("quantite"));
 prix_col.setCellValueFactory(new PropertyValueFactory<>("prix"));
 id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
 categorie_col.setCellValueFactory(new PropertyValueFactory<>("categorie"));
 description_col.setCellValueFactory(new PropertyValueFactory<>("description"));
 age_col.setCellValueFactory(new PropertyValueFactory<>("age"));
 genre_col.setCellValueFactory(new PropertyValueFactory<>("genre"));
 image_col.setCellValueFactory(new PropertyValueFactory<>("image"));
 
        TableColumn col_action = new TableColumn<>("supprimer");
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
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell();
            }
        
        });
        //modifier
        TableColumn col_modifier = new TableColumn<>("modifier");
        table_view.getColumns().add(col_modifier);
        
        col_modifier.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_modifier.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell2();
            }
        
        });
  

        
        //getTreeTableView().getSelectionModel().getSelectedItem().getValue();
        table_view.setItems(list);
    }    


    
    


    
}
