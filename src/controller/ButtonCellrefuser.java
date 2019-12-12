/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.prism.impl.Disposer;
import entities.Jardin;
import java.io.IOException;
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
import service.ServiceJardins;
import template.Template;

/**
 *
 * @author Majouli
 */
public class ButtonCellrefuser extends TableCell<Disposer.Record, Boolean> {
     final Button cellbutonrefuser = new Button("refuser");
        
    ServiceJardins service_jar = new ServiceJardins();
      public  ButtonCellrefuser(){
        
        	//Action when the button is pressed
            cellbutonrefuser.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    try {
                        // get Selected Item
                        Jardin jardincournat = (Jardin) ButtonCellrefuser.this.getTableView().getItems().get(ButtonCellrefuser.this.getIndex());
                        //remove selected item from the table list
                        ObservableList<Jardin> list= FXCollections.observableArrayList();
                        for (Jardin m:service_jar.toutejardins())
                        {
                            list.add(m);
                            
                        }
                        System.out.println(jardincournat);
                        list.remove(jardincournat);
                        service_jar.updateetatjardin(jardincournat.getId(), "refuser");
                        System.out.println(list);
                        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/GererJardins.fxml"))));             
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonCell.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
      }
            @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
               // setGraphic(cellButton2);
                setGraphic(cellbutonrefuser);
            }
        }
        
}
