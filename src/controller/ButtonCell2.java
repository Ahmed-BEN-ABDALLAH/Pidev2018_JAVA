/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Produit;
import template.Template;
import com.sun.prism.impl.Disposer;
import com.sun.prism.impl.Disposer.Record;
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
import javafx.stage.Stage;
import service.ServiceProduit;

/**
 *
 * @author said
 */



class ButtonCell2 extends TableCell<Record, Boolean> {
        final Button cellButton = new Button("modifier");
         ServiceProduit service_pr=new ServiceProduit();
        ButtonCell2(){
            
        	//Action when the button is pressed
            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    try {
                        // get Selected Item
                        Produit Produitcourant = (Produit) ButtonCell2.this.getTableView().getItems().get(ButtonCell2.this.getIndex());
                        //remove selected item from the table list
                        
                        System.out.println(Produitcourant);
                        Produit.setId_courant(Produitcourant.getId());
                           Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/views/updateProduit.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
                        //Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/updateProduit.fxml"))));             
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
                setGraphic(cellButton);
            }
        }
    }