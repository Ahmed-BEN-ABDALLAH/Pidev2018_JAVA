/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXListView;
import com.sun.prism.impl.Disposer;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Jardin;
import entities.Messages;
import entities.User;
import entities.evenement;
import entities.produit_donation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import service.MyServiceDonation;
import service.MyServiceEvenement;
import service.ServiceJardins;
import service.ServiceMsgs;
import util.Authentification;

/**
 *
 * @author AHMED
 */
public class GererJardins implements Initializable {

    private final User currentUser = Authentification.user;
    ServiceJardins service_jar = new ServiceJardins();
    ServiceMsgs servicemsg = new ServiceMsgs();
    @FXML
    private TableView<Jardin> tablejardin;
    @FXML
    private TableColumn<Jardin, String> nom;
    @FXML
    private TableColumn<Jardin, String> description;
    @FXML
    private TableColumn<Jardin, String> adresse;
    @FXML
    private TableColumn<Jardin, String> numtel;
    @FXML
    private TableColumn<Jardin, String> adressemail;
    @FXML
    private TableColumn<Jardin, String> etat;

    @FXML
    private Button supp;
        @FXML
private PieChart stat;
        

    @FXML
    private JFXListView<Jardin> list_jardin;
    private TableView table = new TableView();

    /* @FXML
    private JFXListView<Pane> ListView_Produits ;
    @FXML
    private JFXListView<produit_donation> ListView_Produits1;*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int accepter = service_jar.getStat("accepter");
                int attente = service_jar.getStat("attente");
        int refuser = service_jar.getStat("refuser");

        ObservableList<PieChart.Data> pie =
                FXCollections.observableArrayList(
                new PieChart.Data("Jardin Accepeter", accepter),
                new PieChart.Data("Jardin Refuser", refuser),
                new PieChart.Data("Jardin En Attente", attente));
       stat.setData(pie);
        ObservableList<Jardin> list = FXCollections.observableArrayList();
        service_jar.toutejardins().forEach((m) -> {
            list.add(m);
        });
        System.out.println(list);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        numtel.setCellValueFactory(new PropertyValueFactory<>("numtel"));
        adressemail.setCellValueFactory(new PropertyValueFactory<>("adresseemail"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));

        TableColumn accepeter_action = new TableColumn<>("Accepter");
        tablejardin.getColumns().add(accepeter_action);

        accepeter_action.setCellValueFactory(
                            new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> m) {
                return new SimpleBooleanProperty(m.getValue() != null);
            }
        });

        //Adding the Button to the cell
        accepeter_action.setCellFactory(
                            new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> m) {
                return new controller.ButtonCellaccepeter();
            }

        });
         //refuser
        TableColumn col_refuser = new TableColumn<>("refuser");
        tablejardin.getColumns().add(col_refuser);
        
        col_refuser.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_refuser.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new controller.ButtonCellrefuser();
            }
        
        });
  

        tablejardin.setItems(list);
    }

}
