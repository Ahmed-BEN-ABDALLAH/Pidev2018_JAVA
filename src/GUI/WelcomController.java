/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ghada
 */
public class WelcomController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void home(MouseEvent event) throws IOException {
        
        
                                 template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/menuAdmin.fxml"))));   

    }

    @FXML
    private void next(MouseEvent event) throws IOException {
                                 template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/MenuGhada.fxml"))));   

    }
    
}
