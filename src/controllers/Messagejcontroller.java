package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Jardin;
import entities.Messages;
import entities.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceJardins;
import service.ServiceMsgs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Majouli
 */
public class Messagejcontroller {
    @FXML
    private TextField objet;
    @FXML
    private JFXTextField contenue;
    @FXML
    private JFXButton send;
       private Jardin j1 ;
    ServiceJardins jarservice = new ServiceJardins();
    ServiceMsgs servicemsg = new ServiceMsgs();
    Messages msg= new Messages();
    User user = new User();

    
    
    public void initialize(URL location, ResourceBundle resources) {
  

    }
    public void envoyer() throws SQLException{
              System.out.println("**********************************************");

    try {
            j1=jarservice.Getonejardin(Jardin.getId_courant_jardin());
        } catch (SQLException ex) {
            Logger.getLogger(quickview.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Message sent");
        msg.setId_recepteur(j1.proprietaire);
        msg.setIdEmetteur(User.getId_courant_user());
               msg.setObjet(objet.getText());
               msg.setContenu_message(contenue.getText());
 servicemsg.addmsg(msg);
    Stage s = (Stage) send.getScene().getWindow();
        s.close();
    }
    
}
