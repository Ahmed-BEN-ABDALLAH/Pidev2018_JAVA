/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;





import entities.evenement;
import com.sun.prism.impl.Disposer.Record;
import entities.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import service.MyServiceEvenement;
import util.Authentification;

/**
 *
 * @author said
 */



class ButtonCell2 extends TableCell<Record, Boolean> {
        final Button cellButton = new Button("INVITER");
               private final User currentUser=Authentification.user;
  evenement e=  new evenement();
  
    MyServiceEvenement service_pr=new MyServiceEvenement();
        ButtonCell2(){
            
        	//Action when the button is pressed
            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    try {
                        // get Selected Item
                        User usercourant  = (User) ButtonCell2.this.getTableView().getItems().get(ButtonCell2.this.getIndex());
                        //remove selected item from the table list
        
           
       
         
              e = service_pr.GetEvbyid(evenement.getId_courant());
                     
                        
              
                        System.out.println(usercourant );
                     
               
                        
                    
                        User.setId_courant_user(usercourant.getId());
                        
                        
                       int a= User.getId_courant_user();
                        
                        System.out.println(" "+a);
                        
                        System.out.println("______________________________________________________________________________________");
                        System.out.println("id event "+e.getId()+"______ l id de user est "+User.getId_courant_user()+" _____nom event est "+e.getNom()+"_______ usser name "+currentUser.getUsername()+"______image est  "+e.getImage()+"adresse event est "+e.getAdresse());
                                                System.out.println("______________________________________________________________________________________");

                        service_pr.insertionNotif(e.getId(),User.getId_courant_user(), e.getNom(), currentUser.getUsername(), e.getImage(), e.getAdresse());
                        
                        
                    cellButton.setDisable(true);
        //template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/afficheFXML.fxml"))));             
                    } catch (SQLException ex) {
                        Logger.getLogger(ButtonCell2.class.getName()).log(Level.SEVERE, null, ex);
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