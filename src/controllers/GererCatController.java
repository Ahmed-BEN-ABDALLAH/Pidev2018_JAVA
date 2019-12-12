/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import entities.Categorie;
import entities.Publication;
import entities.Publicationresolu;
import entities.Reponse;
import java.net.URL;
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
import service.ServiceCategorie;
import service.ServicePublication;
import service.ServiceReponse;

/**
 * FXML Controller class
 *
 * @author ikbel
 */
public class GererCatController extends ForumController implements Initializable {
    @FXML
    private Pane afpane;
    @FXML
    private Pane affpane;
    @FXML
    private JFXListView<Publication> lspub = new JFXListView<Publication>();
    @FXML
    private JFXListView<Reponse> lscom = new JFXListView<Reponse>();
    private ObservableList<Reponse> pooll1 = FXCollections.observableArrayList();
    @FXML
    private JFXButton appr;
    private ObservableList<Publication> pooll = FXCollections.observableArrayList();
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label lc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        affpane.setVisible(false);
        lspub.setVisible(true);
        if(ServicePublication.getSeeMore2(idpu).getResolu()==1){
        appr.setVisible(true);
        }
        else
        {
            appr.setVisible(false);
            System.out.println(ServicePublication.getSeeMore2(idpu).getResolu());
        }
        afpane.setVisible(true);
        l1.setText("Comments : "+ServicePublication.getSeeMore2(idpu).getNbrReponse());
        l2.setText("Vues : "+ServicePublication.getSeeMore2(idpu).getNbr_vue());
        l3.setText(""+ServicePublication.convertirDate(ServicePublication.getSeeMore2(idpu).getCreated()));
         pooll.clear();
        lspub.getItems().clear();
        pooll.addAll(ServicePublication.getSeeMore(idpu));
        lspub.getItems().addAll(pooll);
        lspub.setCellFactory(new Callback<ListView<Publication>, ListCell<Publication>>() {
            @Override
            public ListCell<Publication> call(ListView<Publication> param) {
                com.jfoenix.controls.JFXListCell<Publication> cellp = new com.jfoenix.controls.JFXListCell() {

                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        HBox content = new HBox(50);

                        content.setPadding(new Insets(2, 2, 2, 30));

                        
                        Label contenu = new Label();
                        

                        Publication s = ((Publication) item);
                        if (s != null) {
                           
                            contenu.setText("" + s.getContenu());
                            content.getChildren().addAll(contenu );
                            setGraphic(content);


                        }
                    }
                };

                return cellp;
            }

        }
        );

    
        // TODO
    }    
    @FXML
                public void ComResolu()
                {
        affpane.setVisible(true);
        lspub.setVisible(true);
        lscom.setVisible(true);
        
        afpane.setVisible(true);
        lc.setText("Author : "+ ServiceReponse.getNomAuthor((ServiceReponse.selectRepons(ServicePublication.selectRepRes(idpu))).getId_user()));
        int a=ServicePublication.selectRepRes(idpu);
         pooll1.clear();
        lscom.getItems().clear();
        pooll1.addAll(ServiceReponse.selectReponse(a));
        lscom.getItems().addAll(pooll1);
        lscom.setCellFactory(new Callback<ListView<Reponse>, ListCell<Reponse>>() {
            @Override
            public ListCell<Reponse> call(ListView<Reponse> param) {
                com.jfoenix.controls.JFXListCell<Reponse> cellp = new com.jfoenix.controls.JFXListCell() {

                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        HBox content = new HBox(50);

                        content.setPadding(new Insets(2, 2, 2, 30));

                        
                        Label contenu = new Label();
                        

                        Reponse s = ((Reponse) item);
                        if (s != null) {
                           
                            contenu.setText("" + s.getContenu());
                            content.getChildren().addAll(contenu );
                            setGraphic(content);


                        }
                    }
                };

                return cellp;
            }

        }
        );

    
       
    }    
    
    
}
