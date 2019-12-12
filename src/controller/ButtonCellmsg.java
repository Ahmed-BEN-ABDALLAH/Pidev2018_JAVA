/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import template.Template;
import com.sun.prism.impl.Disposer.Record;
import entities.Messages;
import entities.User;
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
import service.ServiceMsgs;


/**
 *
 * @author Majouli
 */
public class ButtonCellmsg extends TableCell<Record, Boolean> {
    final Button cellButtonmsg = new Button("supprimer");
        
    ServiceMsgs servicemsg = new ServiceMsgs();
      public  ButtonCellmsg(){
        
        	//Action when the button is pressed
            cellButtonmsg.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    try {
                        // get Selected Item
                        Messages Messagecouant = (Messages) ButtonCellmsg.this.getTableView().getItems().get(ButtonCellmsg.this.getIndex());
                        //remove selected item from the table list
                        ObservableList<Messages> list= FXCollections.observableArrayList();
                        for (Messages m:servicemsg.listmsgs(User.getId_courant_user()))
                        {
                            list.add(m);
                            
                        }
                        System.out.println(Messagecouant);
                        list.remove(Messagecouant);
                        servicemsg.deletemsg(Messagecouant.getId());
                        System.out.println(list);
                        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/AfficheMessage.fxml"))));             
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
                setGraphic(cellButtonmsg);
            }
        }
        
}
    

