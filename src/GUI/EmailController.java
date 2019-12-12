/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import entities.User;
import entities.baby;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.controlsfx.control.Notifications;
import service.serviceBaby;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author ghada
 */
public class EmailController implements Initializable {

    @FXML
    private Label offre;
       private String username = "allforkidssite08@gmail.com";
    private String password = "allforkidsghada";
    
baby b = new serviceBaby().GetBabybyid(baby.getId_courant());
private final User currentUser=Authentification.user;
    @FXML
    private JFXTextField contenue;
    @FXML
    private Label nom;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         offre.setText(currentUser.getNom());
        contenue.setText("Ce message est envoyé par l'utilisateur" + currentUser.getNom());
        // TODO
    }    

    @FXML
    private void envoyer(MouseEvent event) throws IOException {
          Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
// Etape 2 : Création de l'objet Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("allforkidssite08@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(b.email));
            message.setSubject("Test email");
            message.setText(contenue.getText());
// Etape 3 : Envoyer le message
            Transport.send(message);
            System.out.println("Message_envoye");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
     
        
        
        
        
        }
        
             Notifications n =Notifications.create().title("Notification")
             .text("Message envoyé avec succés")
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
     
        
        
        
        
    }



        
        
        
        
        
    }
    

