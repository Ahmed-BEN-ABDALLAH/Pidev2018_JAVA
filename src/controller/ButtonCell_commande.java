/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import template.Template;
import com.sun.prism.impl.Disposer;
import entities.Produit;
import entities.commande;
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
import service.ServiceCommande;
import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author said
 */
public class ButtonCell_commande extends TableCell<Disposer.Record, Boolean> {
    service.ServiceCommande service_commande= new ServiceCommande();

            final Button valider = new Button(" valider ");

    public ButtonCell_commande() {
        int idf=2;

            valider.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent t) {
                        // get Selected Item
                        commande Produitcourant = (commande) ButtonCell_commande.this.getTableView().getItems().get(ButtonCell_commande.this.getIndex());
                        //remove selected item from the table list
                        ObservableList<commande> list= FXCollections.observableArrayList();
                        for (commande cmd:service_commande.afficheCommande(idf) )
                            {
//                                if(cmd.getValide()==0)
//                                {
                                    list.add(cmd);
//                                }                         
                            }
                    try {
                        service_commande.valide_btn(Produitcourant);
                        Produitcourant.setValide(1);
                    } catch (SQLException ex) {
                        Logger.getLogger(ButtonCell_commande.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        Produitcourant.setValide(1);
                       // list.remove(Produitcourant);
                        //Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/affiche.fxml"))));             
                      fournisseur.said=1;
                    try {             
                        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/fournisseur.fxml"))));
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonCell_commande.class.getName()).log(Level.SEVERE, null, ex);
                    }
    
                }
            });
    }
@Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
               // setGraphic(cellButton2);
                setGraphic(valider);
            }
        }
    
}
