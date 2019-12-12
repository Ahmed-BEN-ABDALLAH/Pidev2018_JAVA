/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.sun.prism.impl.Disposer;
import entities.Produit;
import static entities.Produit.getPanier;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import static javax.swing.UIManager.get;

/**
 * FXML Controller class
 *
 * @author said
 */
public class PanierController implements Initializable {
TextField txt = new TextField();
Text total = new Text();
    Produit p=new Produit();
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
//    @FXML
//    private TableColumn<Produit, Integer> id_p;
    @FXML
    private TableColumn<Produit, String> nom_p;
    @FXML
    private TableColumn<Produit, String> image_p;
    @FXML
    private TableView<Produit> table_view;
    @FXML
    private TableColumn<Produit, Integer> quantite_p;
    @FXML
    private TableColumn<Produit, Integer> prix_p;
    @FXML
    private TableColumn<Produit, Integer> prixtotal_p;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
             AnchorPane box = FXMLLoader.load(getClass().getResource("/views/drawer.fxml"));
             drawer.open();
             drawer.setSidePane(box);
             
             HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
             transition.setRate(1);
             hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                 transition.setRate(transition.getRate() * 1);
                 transition.play();
                 
                 if (drawer.isShown()) {
                     drawer.close();
                 }
                 else
                 {
                     drawer.open();
                 }
                 
             });
             
            
         } catch (IOException ex) {
             Logger.getLogger(ProduitsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
        ObservableList<Produit> panier = FXCollections.observableArrayList();
        for (Produit p:getPanier() )
        {
            panier.add(p);
            System.out.println(panier);
        }
        int prixtotal =0;
        int prixtotal_cell=0;
        for (int i = 0; i < panier.size(); i++) {
            Produit get = panier.get(i);
            //System.out.println("quan "+get.getQuantite());
            prixtotal=prixtotal+(get.getQuantite()*get.getPrix());
            prixtotal_cell=get.getQuantite()*get.getPrix();
        }
        System.out.println("prix total "+prixtotal);
         //id_p.setCellValueFactory(new PropertyValueFactory<>("id"));
         nom_p.setCellValueFactory(new PropertyValueFactory<>("nom"));
         image_p.setCellValueFactory(new PropertyValueFactory<>("image"));
         quantite_p.setCellValueFactory(new PropertyValueFactory<>("quantite"));
         prix_p.setCellValueFactory(new PropertyValueFactory<>("prix"));
         prixtotal_p.setCellValueFactory(new PropertyValueFactory<>("id"));
         
         TableColumn col_action = new TableColumn<>("prit total");
        table_view.getColumns().add(col_action);
       
    prixtotal_p.setCellFactory((TableColumn<Produit, Integer> param) -> {
            return new TableCell<Produit, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    }
                    if (item != null) {
                        String b=quantite_p.getText();
                        
//                        int a= b*5;
//                        System.out.println("pritot "+a);
                        //Text t=new Text(String.valueOf(a));
                        //System.out.println(txt.getText());
                        total.setText(txt.getText());
//                        Text t1=new Text(txt.getText());
                       
                        setGraphic(total);
                    }
                }
            };
        });
    
    image_p.setCellFactory((TableColumn<Produit, String> param) -> {
            return new TableCell<Produit, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    }
                    if (item != null) {
                        String A = item;
                                A = "C:\\xampp\\htdocs\\datatable_21\\"+A;
                                File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                
                        ImageView imageView = new ImageView(image2);
                        imageView.setFitHeight(50);
                        imageView.setFitWidth(50);
                        setGraphic(imageView);
                    }
                }
            };
        });
    
    quantite_p.setCellFactory((TableColumn<Produit, Integer> param) -> {
            return new TableCell<Produit, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    }
                    if (item != null) {
                         Button cellButton2 = new Button("+");
                         Button cellButton = new Button("-");
                        
        final Pane p = new Pane();
        final HBox hb = new HBox();
         
                txt.setText(String.valueOf(item));
                if(item>0)
                {
                cellButton.setOnMouseClicked((MouseEvent event) -> {
                    int a=item;
                   
                    a=a-1;
                    txt.setText(String.valueOf(a));
                    
                    updateItem(a,empty);
                    
                });
                }
                cellButton2.setOnMouseClicked((MouseEvent event) -> {
                    int a=item;
                    a=a+1;
                    txt.setText(String.valueOf(a));
                    
                    updateItem(a,empty);
                });
        hb.setLayoutX(0);
        hb.setLayoutY(12);
        hb.getChildren().addAll(cellButton,txt,cellButton2);
        p.getChildren().add(hb);
                                
                        setGraphic(p);
                    }
                }
            };
        });
    
//    TableColumn col_action = new TableColumn<>("quantite");
//        table_view.getColumns().add(col_action);
//        
//    col_action.setCellValueFactory(
//                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
//                ObservableValue<Boolean>>() {
//
//            @Override
//            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
//                return new SimpleBooleanProperty(p.getValue() != null);
//            }
//        });
//
//        //Adding the Button to the cell
//        col_action.setCellFactory(
//                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {
//
//    
//                    
//             @Override
//            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
//                return new ButtonCell_quantite();
//            }
//        
//        });
//    

table_view.setItems(panier);
        
    }    
    
}
