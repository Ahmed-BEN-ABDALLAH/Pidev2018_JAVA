/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import template.Template;
import com.sun.prism.impl.Disposer;
import com.sun.prism.impl.Disposer.Record;
import entities.Produit;
import java.io.IOException;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TreeTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import service.ServiceProduit;

/**
 *
 * @author said
 */

class ButtonCell extends TableCell<Record, Boolean> {
        final Button cellButton = new Button("supprimer");
        
         ServiceProduit service_pr=new ServiceProduit();
        ButtonCell(){
        
        	//Action when the button is pressed
            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    try {
                        // get Selected Item
                        Produit Produitcourant = (Produit) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                        //remove selected item from the table list
                        ObservableList<Produit> list= FXCollections.observableArrayList();
                        for (Produit p:service_pr.AfficherProduit() )
                        {
                            list.add(p);
                            
                        }
                        System.out.println(Produitcourant);
                        list.remove(Produitcourant);
                        service_pr.SupprimerProduit(Produitcourant);
                        System.out.println(list);
                        fournisseur.said=2;
                        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/fournisseur.fxml"))));             
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonCell.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
        }
        

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
               // setGraphic(cellButton2);
                setGraphic(cellButton);
            }
        }
    }