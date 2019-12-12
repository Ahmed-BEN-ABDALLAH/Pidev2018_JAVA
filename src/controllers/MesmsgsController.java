/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.prism.impl.Disposer.Record;
import com.jfoenix.controls.JFXListView;
import com.sun.prism.impl.Disposer;

import entities.Messages;
import entities.User;
import entities.produit_donation;

import java.net.URL;
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
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.Pane;

import javafx.util.Callback;
import service.ServiceJardins;
import service.ServiceMsgs;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author Majouli
 */
public class MesmsgsController implements Initializable {

    private final User currentUser = Authentification.user;
    ServiceJardins service_jar = new ServiceJardins();
    ServiceMsgs servicemsg = new ServiceMsgs();
    @FXML
    private TableView<Messages> tablemsg;
    @FXML
    private TableColumn<Messages, String> objet;
    @FXML
    private TableColumn<Messages, String> contenu;
    @FXML
    private Button supp;
    @FXML
    private JFXListView<Pane> ListView_msgs;
    @FXML
    private JFXListView<Messages> list_msgs;
    private TableView table = new TableView();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<Messages> list = FXCollections.observableArrayList();
        for (Messages m : servicemsg.listmsgs(User.getId_courant_user())) {
            list.add(m);

        }

        objet.setCellValueFactory(new PropertyValueFactory<>("objet"));
        contenu.setCellValueFactory(new PropertyValueFactory<>("contenu_message"));

        TableColumn col_action = new TableColumn<>("supprimer");
        tablemsg.getColumns().add(col_action);

        col_action.setCellValueFactory(
                            new Callback<TableColumn.CellDataFeatures<Record, Boolean>, ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> m) {
                return new SimpleBooleanProperty(m.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_action.setCellFactory(
                            new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> m) {
                return new controller.ButtonCellmsg();
            }

        });

        tablemsg.setItems(list);
    }

}
