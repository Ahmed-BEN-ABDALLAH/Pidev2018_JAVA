/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import entities.Reponse;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import service.ServiceReponse;

/**
 * FXML Controller class
 *
 * @author ikbel
 */
public class GererCommentaireController extends LoginController implements Initializable {

    @FXML
    private Pane dashbord;
    @FXML
    private JFXButton afficher;
    @FXML
    private JFXButton modif;
    @FXML
    private Pane titre;
    @FXML
    private Pane affpane;
    @FXML
    private JFXListView<Reponse> lspub = new JFXListView<Reponse>();
    @FXML
    private Pane modpane;
    @FXML
    private JFXListView<Reponse> lspubs = new JFXListView<Reponse>();
    @FXML
    private ObservableList<Reponse> pooll = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Reponse> pooll1 = FXCollections.observableArrayList();
    @FXML
    private JFXTextArea contmod;
    @FXML
    private JFXButton mod;
    @FXML
    private JFXButton modifier;
    @FXML
    private Label cn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dashbord.setVisible(true);
        titre.setVisible(true);
        affpane.setVisible(false);
        modpane.setVisible(false);
        lspub.setVisible(false);
        lspubs.setVisible(false);
        contmod.setVisible(false);
        mod.setVisible(false);
        modifier.setVisible(false);
        cn.setVisible(false);
    }    
     public void showPubComm() {
        modpane.setVisible(false);
        affpane.setVisible(true);
        lspub.setVisible(true);
                lspubs.setVisible(false);
        contmod.setVisible(false);
        mod.setVisible(false);
        modifier.setVisible(false);
        cn.setVisible(false);
        pooll.clear();
        lspub.getItems().clear();
        pooll.addAll(ServiceReponse.selectReponseUsr(idusr));
         System.out.println(idusr);
        lspub.getItems().addAll(pooll);
        lspub.setCellFactory(new Callback<ListView<Reponse>, ListCell<Reponse>>() {
            @Override
            public ListCell<Reponse> call(ListView<Reponse> param) {
                com.jfoenix.controls.JFXListCell<Reponse> cellp = new com.jfoenix.controls.JFXListCell() {

                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        HBox content = new HBox(50);

                        content.setPadding(new Insets(2, 2, 2, 30));

                        Label user = new Label();
                        Label contenu = new Label();
                        Label created = new Label();
    
                        

                        Reponse s = ((Reponse) item);
                        if (s != null) {
                            created.setText("created : " + s.getCreated());
                            contenu.setText("contenu : " + s.getContenu());
                            user.setText("author : " + ServiceReponse.getNomAuthor(s.getId_user()) + " ");
                            content.getChildren().addAll(created, contenu, user );
                            setGraphic(content);

                        }
                    }
                };

                return cellp;
            }

        }
        );
    }
         public void showPubComm2() {
        modpane.setVisible(true);
        affpane.setVisible(false);
        lspub.setVisible(false);
        lspubs.setVisible(true);
        contmod.setVisible(false);
        mod.setVisible(false);
        cn.setVisible(false);
        modifier.setVisible(true);
        pooll1.clear();
        lspubs.getItems().clear();
        pooll1.addAll(ServiceReponse.selectReponseUsr2(idusr));
         System.out.println(idusr);
        lspubs.getItems().addAll(pooll1);
        lspubs.setCellFactory(new Callback<ListView<Reponse>, ListCell<Reponse>>() {
            @Override
            public ListCell<Reponse> call(ListView<Reponse> param) {
                com.jfoenix.controls.JFXListCell<Reponse> cellp1 = new com.jfoenix.controls.JFXListCell() {

                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        HBox content = new HBox(50);

                        content.setPadding(new Insets(2, 2, 2, 30));

                        Label user = new Label();
                        Label contenu = new Label();
                        Label created = new Label();
    
                        

                        Reponse s = ((Reponse) item);
                        if (s != null) {
                            
                            created.setText("created : " + s.getCreated());
                            contenu.setText("contenu : " + s.getContenu());
                            user.setText("author : " + ServiceReponse.getNomAuthor(s.getId_user()) + " ");
                            content.getChildren().addAll(created, contenu, user );
                            setGraphic(content);

                        }
                    }
                };

                return cellp1;
            }

        }
        );
    }
           public void modifier_c()
           {
       
        lspubs.setVisible(false);
        contmod.setVisible(true);
        mod.setVisible(true);
        modifier.setVisible(false);
        cn.setVisible(true);
    }
      public void modifier_comm()
    { 
        int i = lspubs.getSelectionModel().getSelectedItem().getId();
        System.out.println(i);
        ServiceReponse.updateReponse(i,contmod.getText() );
        contmod.clear();
    }
}
