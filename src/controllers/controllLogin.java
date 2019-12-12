/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import animation.FadeInLeftTransition;
import animation.FadeInLeftTransition1;
import animation.FadeInRightTransition;
import entities.BCrypt;
import entities.User;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.Serviceuser;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author kharrat
 */
public class controllLogin implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Text lblWelcome;
    @FXML
    private Text lblUserLogin;
    @FXML
    private Text lblUsername;
    @FXML
    private Text lblPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnregister;
    @FXML

    private Label lblClose;
    Stage stage;
   
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        Platform.runLater(() -> {
            new FadeInRightTransition(lblUserLogin).play();
            new FadeInLeftTransition(lblWelcome).play();
            new FadeInLeftTransition1(lblPassword).play();
            new FadeInLeftTransition1(lblUsername).play();
            new FadeInLeftTransition1(txtUsername).play();
            new FadeInLeftTransition1(txtPassword).play();
            new FadeInRightTransition(btnLogin).play();
            new FadeInRightTransition(btnregister).play();
            lblClose.setOnMouseClicked((MouseEvent event) -> {
                Platform.exit();
                System.exit(0);
            });
        });

    }

    @FXML
    public void LoginButton() throws IOException {
        String styledefault = "-fx-border-color: green;";
        txtUsername.setStyle(styledefault);
        txtPassword.setStyle(styledefault);    
        
                   System.out.println(" login button");
        Serviceuser userser = new Serviceuser();
        String use = txtUsername.getText();

        String pass = txtPassword.getText();

        User user = userser.login(use);

        if (user.getId() == 0) {
            System.out.println("invalide");
        } 
        
        
        {
        if (BCrypt.checkpw(pass, user.getPassword())){

        System.out.println(txtUsername.getText() + "     /// " + txtPassword.getText());
        Authentification.user=user;
        
        if (!user.getRoles().equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}"))
            
        {
            user.setId_courant_user(user.getId());
            user.connectedUser=user;
        template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/menuAdmin.fxml"))));    

        
        }
        /*     Voice voice = null;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin16");
        voice.allocate();
        voice.speak("Welcome " + username.getText()
        + " to our desktop application");*/
        else if   (user.getRoles().equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}"))          
            
            template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/AdminInterfaceFXML.fxml"))));    

       }
      
        
        else System.out.println("invalid"); 
        
        }
        
                
    }

    @FXML
    public void RegisterButton() throws IOException {
        template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/inscription.fxml"))));
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername.setText(txtUsername);
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword.setText(txtPassword);
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

   

    
}
