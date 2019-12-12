/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import animation.FadeInLeftTransition;
import animation.FadeInRightTransition;
import animation.FadeInTransition;
import animation.FadeInUpTransition;
import connexionbd.basededonnees;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Herudi
 */
public class controllSplash implements Initializable {

    private static controllSplash instance;
    @FXML
    private Text lblWelcome;
    @FXML
    private Text lblRudy;
    @FXML
    private VBox vboxBottom;
    @FXML
    private Label lblClose;
    @FXML
    private Text Labelmessage;
    basededonnees baza;
    Stage stage;
    @FXML
    private ImageView imgLoading;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    public void closeSplash() {
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            longStart();
        } catch (InterruptedException ex) {
            Logger.getLogger(controllSplash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(controllSplash.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblClose.setOnMouseClicked((MouseEvent event) -> {
            closeSplash();
        });
        // TODO
    }

    void longStart() throws InterruptedException, IOException {

        new FadeInLeftTransition(lblWelcome).play();
        new FadeInRightTransition(lblRudy).play();
        new FadeInTransition(vboxBottom).play();
        new FadeInTransition(Labelmessage).play();
        PauseTransition delay = new PauseTransition(Duration.seconds(6));
        PauseTransition delay2 = new PauseTransition(Duration.seconds(4));
        if (!baza.getInstance().testexistdatabase()) {
            delay2.setOnFinished(event -> Labelmessage.setText("Base de données introuvable"));
            delay.setOnFinished(event -> template.Template.getInstance().getStage().close());
        } else {
            delay2.setOnFinished(event -> Labelmessage.setText("connection établie"));
            delay.setOnFinished(event -> {
                try {
                    template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/login_1.fxml"))));
                } catch (IOException ex) {
                    Logger.getLogger(controllSplash.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        }

        delay.play();
        delay2.play();
    }

    public void messageInformation(String msg) {
        Labelmessage.setText(msg);
    }

    public static controllSplash getInstance() {
        if (instance == null) {
            instance = new controllSplash();
        }
        return instance;
    }
}
