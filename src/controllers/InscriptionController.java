/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
//import com.sun.speech.freetts.Voice;
//import com.sun.speech.freetts.VoiceManager;
import entities.BCrypt;
import entities.User;
import entities.evenement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;

import service.Serviceuser;
import static service.Serviceuser.user;
import util.Authentification;
import util.MyConnexion;

/**
 * FXML Controller class
 *
 * @author Majouli
 */
public class InscriptionController implements Initializable {

    private Connection cnx;
    public static Authentification instance;
    private Connection c;
    private String file_image;

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmpass;
    @FXML
    private TextField numtel;

    @FXML
    private Label lbl;
    @FXML

    private ComboBox<String> role;

    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        role.getItems().add("Admin");
        role.getItems().add("Parents");
        role.getItems().add("baby Sitter");
        role.getItems().add("Responsable Jardin");
        role.getItems().add("VENDEUR");
        role.getSelectionModel().selectFirst();
        c = MyConnexion.getInstance()
                            .getConnection();
        Authentification.getSession().getUser();

    }

    /**
     *
     * @param event
     * @throws java.io.IOException
     */
    public void inscri(ActionEvent event) throws IOException, SQLException {
        Serviceuser userser = new Serviceuser();

        User user = new User();
        System.out.println(" inscri button");
        String p1 = password.getText();
        String p2 = confirmpass.getText();

        if (!p1.equals(p2)) {
            System.out.println(" mdp incorrecte   ");
        } else {
            String p1crypte = BCrypt.hashpw(p1, BCrypt.gensalt());
            user.setAdrese(adresse.getText());
            user.setNom(nom.getText());
            user.setPrenom(prenom.getText());
            user.setUsername(username.getText());
            user.setUsername_canonical(username.getText());
            user.setPassword(p1crypte);

            user.setEmail(email.getText());
            user.setEmail_canonical(email.getText());
 file_image="/images/"+file_image;
   user.setImage(file_image);
        
            int tel = Integer.parseInt(numtel.getText());
            user.setNumtel(tel);
            String r = verifrole(role.getValue());
            user.setRoles(r);

         pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
         pathto = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\web\\images\\"+Current_file.getName());
           Path targetDir = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\web\\images\\");
       System.out.println(targetDir);
            Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
            String re = userser.inscription(user);
            System.out.println(re);
//                                                Voice voice = null;
//        VoiceManager vm = VoiceManager.getInstance();
//        voice = vm.getVoice("kevin16");
//        voice.allocate();
//        voice.speak("Welcome " + username.getText()
//                + " Thanks for you inscription");
            Stage stage = new Stage();
            Parent login = FXMLLoader.load(getClass().getResource("/GUI/login_1.fxml"));

            Scene loginscene = new Scene(login);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(loginscene);
            app_stage.show();

        }

    }

    /*
        System.out.println(username.getText() + "     /// " + pwd.getText());
        Voice voice = null;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin16");
        voice.allocate();
        voice.speak("Welcome " + username.getText()
                + " to our desktop application");
   
        Stage stage = new Stage();
        Parent home = FXMLLoader.load(getClass().getResource("/gui/homepage.fxml"));

        Scene hoomescene = new Scene(home);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(hoomescene);
        app_stage.show();}
        else{
            System.out.println("mdp invalide");}
        }
    }
            public void conn(ActionEvent event){
        System.out.println("***********"+fos.connectedUser.getNom());
   
    
}

}*/
    @FXML
    private void imageDragOver(DragEvent event) {
        Dragboard board = event.getDragboard();
        if (board.hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);

        }

    }

    @FXML
    private void imageDropped(DragEvent event) throws FileNotFoundException {
        Dragboard board = event.getDragboard();
        List<File> phil = board.getFiles();
        FileInputStream fis;
        fis = new FileInputStream(phil.get(0));
        Image img = new Image(fis);
        File selectedFile = phil.get(0);
        if (selectedFile != null) {

            String test = selectedFile.getAbsolutePath();
            System.out.println(test);

            Current_file = selectedFile.getAbsoluteFile();
            file_image = Current_file.getName();
             evenement e= new evenement();
           e.setImage(selectedFile.getName());
            image.setImage(img);
        }
    }

    private String verifrole(String rol) {
        String prop = "a:1:{i:0;s:17:\"ROLE_PROPRIETAIRE\";}";
        String baby = "a:1:{i:0;s:16:\"ROLE_BABY_SITTER\";}";
        String vendeur = "a:1:{i:0;s:12:\"ROLE_VENDEUR\";}";
        String parents = "a:1:{i:0;s:11:\"ROLE_PARENT\";}";

        String role = "pas de role";

        switch (rol) {
           
            case "Parents":
                role = parents;
                break;
            case "baby Sitter":
                role = baby;
                break;
            case "Responsable Jardin":
                role = prop;
                break;
            case "VENDEUR":
                role = vendeur;
                break;

        }

        return role;
    }

}
