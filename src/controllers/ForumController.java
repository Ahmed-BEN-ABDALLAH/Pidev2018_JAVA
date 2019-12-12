/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import entities.Categorie;
import entities.Publication;
import entities.Reponse;
import entities.Vues;
import static controllers.CategoriesController.idp;
import static controllers.IntCategorieController.Idlist;
import static controllers.LoginController.idusr;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import service.ServiceCategorie;
import service.ServicePublication;
import service.ServiceReponse;

/**
 * FXML Controller class
 *
 * @author ikbel
 */
public class ForumController extends LoginController implements Initializable {

    @FXML
    private Pane dashbord;
    @FXML
    private JFXButton ajout;
    @FXML
    private JFXButton ajoutt;
    @FXML
    private JFXButton ajouttt;
    @FXML
    private JFXTextArea cont;
    @FXML
    private JFXButton afficher;
    @FXML
    private JFXButton btn;
    @FXML
    private JFXButton modification;
    @FXML
    private Pane titre;
    @FXML
    private Pane showcat;
    @FXML
    private JFXListView<Categorie> cats;
    @FXML
    private JFXListView<Categorie> catm;
    @FXML
    private JFXListView<Publication> lspub2;
    @FXML
    private JFXListView<Reponse> lsrep;
    @FXML
    private JFXListView<Publication> pop;
    @FXML
    private JFXListView<Publication> rec;
    @FXML
    private JFXButton s;
    @FXML
    private JFXButton supps;
    @FXML
    private Pane showpubs;
    @FXML
    private Pane showcoms;
    @FXML
    private Pane poppane;
    @FXML
    private Pane recpane;
    @FXML
    private Pane ajouttpane;
    @FXML
    private ObservableList<Categorie> pooll = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Categorie> pooll1 = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Publication> pooll2 = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Reponse> pooll3 = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Publication> pooll4 = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Publication> pooll5 = FXCollections.observableArrayList();
    int c =0 ;
    public static int idpu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServiceCategorie.change();
        ServiceCategorie.change1();

        dashbord.setVisible(true);
        titre.setVisible(true);
        showpubs.setVisible(false);
        showcat.setVisible(false);
        showcoms.setVisible(false);
        supps.setVisible(false);
        showcoms.setVisible(false);
        ajouttpane.setVisible(false);
                poppane.setVisible(false);
        recpane.setVisible(false);

    }    
    @FXML
    public void ShowCategorie() {
        showpubs.setVisible(false);
        showcat.setVisible(true);
        showcoms.setVisible(false);
        cats.setVisible(false);
        supps.setVisible(false);
        showcoms.setVisible(false);
        ajouttpane.setVisible(false);
        poppane.setVisible(false);
        recpane.setVisible(false);
        pooll.clear();
        catm.getItems().clear();

        pooll.addAll(ServiceCategorie.selectNomCategorieM());
        catm.getItems().addAll(pooll);

        catm.setCellFactory(new Callback<ListView<Categorie>, ListCell<Categorie>>() {
            @Override
            public ListCell<Categorie> call(ListView<Categorie> param) {
                com.jfoenix.controls.JFXListCell<Categorie> cellp = new com.jfoenix.controls.JFXListCell() {

                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        HBox content = new HBox(50);

                        content.setPadding(new Insets(2, 2, 2, 30));

                        Label nomcat = new Label();

                        Label nbpub = new Label();

                        Categorie s = ((Categorie) item);
                        if (s != null) {

                            nomcat.setText("Catégorie : " + s.getNom());

                            nbpub.setText("Nombre de publication : " + s.getNbr_publication() + " ");

                            content.getChildren().addAll(nomcat, nbpub);
                            setGraphic(content);

                        }
                    }
                };

                return cellp;
            }

        }
        );

    }
    @FXML
    public void shows(){
        showpubs.setVisible(false);
        showcoms.setVisible(false);
        supps.setVisible(true);
        showcat.setVisible(true);
        cats.setVisible(true);
        supps.setVisible(true);
        showcoms.setVisible(false);
        ajouttpane.setVisible(false);
                poppane.setVisible(false);
        recpane.setVisible(false);
        pooll1.clear();
        cats.getItems().clear();
        Idlist =catm.getSelectionModel().getSelectedItem().getId();
        pooll1.addAll(ServiceCategorie.affichersouscategorie(Idlist));
        cats.getItems().addAll(pooll1);
        System.out.println(pooll1.toString());
        cats.setCellFactory(new Callback<ListView<Categorie>, ListCell<Categorie>>() {
            @Override
            public ListCell<Categorie> call(ListView<Categorie> param) {
                com.jfoenix.controls.JFXListCell<Categorie> cellp1 = new com.jfoenix.controls.JFXListCell() {

                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        HBox content = new HBox(50);

                        content.setPadding(new Insets(2, 2, 2, 30));
                        Label titre = new Label();

                        Label nomcat = new Label();

                        Label nbpub = new Label();

                        Categorie s = ((Categorie) item);
                        if (s != null) {
                            titre.setText("Sous catégorie :        Nombre de publication : ");

                            nomcat.setText(s.getNom());

                            nbpub.setText(s.getNbr_publication() + " ");

                            content.getChildren().addAll(nomcat, nbpub);
                            setGraphic(content);

                        }
                    }
                };

                return cellp1;
            }

        }
        );

    }   
    @FXML
    public void ShowPub() {
        showpubs.setVisible(true);
        showcoms.setVisible(false);
        supps.setVisible(true);
        showcat.setVisible(false);
        cats.setVisible(true);
        supps.setVisible(true);
        showcoms.setVisible(false);
        ajouttpane.setVisible(false);
                poppane.setVisible(false);
        recpane.setVisible(false);
        pooll2.clear();
        lspub2.getItems().clear();
        c=catm.getSelectionModel().getSelectedItem().getId();
        pooll2.addAll(ServicePublication.selectPublicationF(c));
        lspub2.getItems().addAll(pooll2);
        lspub2.setCellFactory(new Callback<ListView<Publication>, ListCell<Publication>>() {
            @Override
            public ListCell<Publication> call(ListView<Publication> param) {
                com.jfoenix.controls.JFXListCell<Publication> cellp2 = new com.jfoenix.controls.JFXListCell() {

                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        HBox content = new HBox(50);

                        content.setPadding(new Insets(2, 2, 2, 30));

                        Label titre_pub = new Label();
                        Label location = new Label();
                        Label nbr_vue = new Label();
                        Label categorie = new Label();
                        Label created = new Label();
                        Label nbr_reponse = new Label();
                        Label contenu = new Label();
                        

                        Publication s = ((Publication) item);
                        if (s != null) {
                            titre_pub.setText("Publication : " + s.getTitre());
                            categorie.setText("categorie : " + ServicePublication.getNomcatt(s.getId_categorie()));
                            location.setText("état : " + s.getLocation() + " ");
                            created.setText("date de creation : " + ServicePublication.convertirDate(s.getCreated()));
                            nbr_vue.setText("nombre de vues : " + s.getNbr_vue());
                            nbr_reponse.setText("nombre de reponses : " + s.getNbrReponse());
                            contenu.setText("contenu : " + s.getContenu());
                            content.getChildren().addAll(titre_pub, categorie, location, created, nbr_vue, nbr_reponse, contenu );
                            setGraphic(content);

                        }
                    }
                };

                return cellp2;
                
            }

        }
        );

    }
    @FXML
    public void ShowPub2() {
        showpubs.setVisible(true);
        showcoms.setVisible(false);
        supps.setVisible(true);
        showcat.setVisible(false);
        cats.setVisible(true);
        supps.setVisible(true);
        showcoms.setVisible(false);
        ajouttpane.setVisible(false);
                poppane.setVisible(false);
        recpane.setVisible(false);
        pooll2.clear();
        lspub2.getItems().clear();
        c=cats.getSelectionModel().getSelectedItem().getId();
        pooll2.addAll(ServicePublication.selectPublicationFor(c));
        lspub2.getItems().addAll(pooll2);
        lspub2.setCellFactory(new Callback<ListView<Publication>, ListCell<Publication>>() {
            @Override
            public ListCell<Publication> call(ListView<Publication> param) {
                com.jfoenix.controls.JFXListCell<Publication> cellp2 = new com.jfoenix.controls.JFXListCell() {

                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        HBox content = new HBox(50);

                        content.setPadding(new Insets(2, 2, 2, 30));

                        Label titre_pub = new Label();
                        Label location = new Label();
                        Label nbr_vue = new Label();
                        Label categorie = new Label();
                        Label created = new Label();
                        Label nbr_reponse = new Label();
                        Label contenu = new Label();
                        

                        Publication s = ((Publication) item);
                        if (s != null) {
                            titre_pub.setText("Publication : " + s.getTitre());
                            categorie.setText("categorie : " + ServicePublication.getNomcatt(s.getId_categorie()));
                            location.setText("état : " + s.getLocation() + " ");
                            created.setText("date de creation : " + ServicePublication.convertirDate(s.getCreated()));
                            nbr_vue.setText("nombre de vues : " + s.getNbr_vue());
                            nbr_reponse.setText("nombre de reponses : " + s.getNbrReponse());
                            contenu.setText("contenu : " + s.getContenu());
                            content.getChildren().addAll(titre_pub, categorie, location, created, nbr_vue, nbr_reponse, contenu );
                            setGraphic(content);

                        }
                    }
                };

                return cellp2;
                
            }

        }
        );

    }
    @FXML
    public void showPubComm() {
        showpubs.setVisible(false);
        showcat.setVisible(false);
        showcoms.setVisible(false);
        cats.setVisible(false);
        supps.setVisible(false);
        showcoms.setVisible(true);
        ajouttpane.setVisible(false);
        poppane.setVisible(false);
        recpane.setVisible(false);
        pooll1.clear();
        lsrep.getItems().clear();
        idp=lspub2.getSelectionModel().getSelectedItem().getId();
        System.out.println("lalalallalalala"+idp);
        List <Vues> lst= ServicePublication.selectViews(idusr, idp);
        if(lst.isEmpty())
        {
         ServicePublication.insertView(idusr,idp);
         ServicePublication.updateView(idp);
        }
        pooll3.addAll(ServiceReponse.selectReponse(idp));
        lsrep.getItems().addAll(pooll3);

        lsrep.setCellFactory(new Callback<ListView<Reponse>, ListCell<Reponse>>() {
            @Override
            public ListCell<Reponse> call(ListView<Reponse> param) {
                com.jfoenix.controls.JFXListCell<Reponse> cellp3 = new com.jfoenix.controls.JFXListCell() {

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

                return cellp3;
            }

        }
        );
    }
         @FXML
    public void Add() {
        showpubs.setVisible(false);
        showcat.setVisible(false);
        showcoms.setVisible(false);
        cats.setVisible(false);
        supps.setVisible(false);
        showcoms.setVisible(false);
        ajouttpane.setVisible(true);
                poppane.setVisible(false);
        recpane.setVisible(false);
    }
     @FXML
    public void AddComm() {
        int a= lspub2.getSelectionModel().getSelectedItem().getId();
        ServicePublication.updateP(a);
        Date d = new Date(System.currentTimeMillis());
        Reponse r =new Reponse(       
       /*this.contenu = contenu;
        this.created = created;
        this.id_user = id_user;*/
                a,
                cont.getText(),
                d,
                idusr
                
        );
       
        ServiceReponse.insertReponse(r);
        cont.clear();
        
        } 
    
@FXML
    public void showPubpop() {
        showpubs.setVisible(false);
        showcat.setVisible(false);
        showcoms.setVisible(false);
        cats.setVisible(false);
        supps.setVisible(false);
        showcoms.setVisible(false);
        ajouttpane.setVisible(false);
        poppane.setVisible(true);
        recpane.setVisible(false);
        pooll4.clear();
        pop.getItems().clear();
       
        pooll4.addAll(ServicePublication.selectPublicationPop());
        pop.getItems().addAll(pooll4);

        pop.setCellFactory(new Callback<ListView<Publication>, ListCell<Publication>>() {
            @Override
            public ListCell<Publication> call(ListView<Publication> param) {
                com.jfoenix.controls.JFXListCell<Publication> cellp4 = new com.jfoenix.controls.JFXListCell() {

                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        HBox content = new HBox(50);

                        content.setPadding(new Insets(2, 2, 2, 30));

                        Label titre_pub = new Label();
                        Label location = new Label();
                        Label nbr_vue = new Label();
                        Label categorie = new Label();
                        Label created = new Label();
                        Label nbr_reponse = new Label();
                        Label contenu = new Label();
                        

                        Publication s = ((Publication) item);
                        if (s != null) {
                            titre_pub.setText("Publication : " + s.getTitre());
                            categorie.setText("categorie : " + ServicePublication.getNomcatt(s.getId_categorie()));
                            location.setText("état : " + s.getLocation() + " ");
                            created.setText("date de creation : " + ServicePublication.convertirDate(s.getCreated()));
                            nbr_vue.setText("nombre de vues : " + s.getNbr_vue());
                            nbr_reponse.setText("nombre de reponses : " + s.getNbrReponse());
                            contenu.setText("contenu : " + s.getContenu());
                            content.getChildren().addAll(titre_pub, categorie, location, created, nbr_vue, nbr_reponse, contenu );
                            setGraphic(content);
                        }
                
                    }
                };

                return cellp4;
            }

        }
        );
    }
    @FXML
    public void showPubrec() {
        showpubs.setVisible(false);
        showcat.setVisible(false);
        showcoms.setVisible(false);
        cats.setVisible(false);
        supps.setVisible(false);
        showcoms.setVisible(false);
        ajouttpane.setVisible(false);
        poppane.setVisible(false);
        recpane.setVisible(true);
        pooll5.clear();
        rec.getItems().clear();
       
        pooll5.addAll(ServicePublication.selectPublicationRec());
        rec.getItems().addAll(pooll5);

        rec.setCellFactory(new Callback<ListView<Publication>, ListCell<Publication>>() {
            @Override
            public ListCell<Publication> call(ListView<Publication> param) {
                com.jfoenix.controls.JFXListCell<Publication> cellp5 = new com.jfoenix.controls.JFXListCell() {

                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        HBox content = new HBox(50);

                        content.setPadding(new Insets(2, 2, 2, 30));

                        Label titre_pub = new Label();
                        Label location = new Label();
                        Label nbr_vue = new Label();
                        Label categorie = new Label();
                        Label created = new Label();
                        Label nbr_reponse = new Label();
                        Label contenu = new Label();
                        

                        Publication s = ((Publication) item);
                        if (s != null) {
                            titre_pub.setText("Publication : " + s.getTitre());
                            categorie.setText("categorie : " + ServicePublication.getNomcatt(s.getId_categorie()));
                            location.setText("état : " + s.getLocation() + " ");
                            created.setText("date de creation : " + ServicePublication.convertirDate(s.getCreated()));
                            nbr_vue.setText("nombre de vues : " + s.getNbr_vue());
                            nbr_reponse.setText("nombre de reponses : " + s.getNbrReponse());
                            contenu.setText("contenu : " + s.getContenu());
                            content.getChildren().addAll(titre_pub, categorie, location, created, nbr_vue, nbr_reponse, contenu );
                            setGraphic(content);
                        }
                    }
                };

                return cellp5;
            }

        }
        );
    }
    @FXML
    public void Spub() {
          try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/Categories.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                }
    @FXML
    public void Scom() {
          try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/GererCommentaire.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                }
    @FXML
    public void SeeMore() {
        idpu=lspub2.getSelectionModel().getSelectedItem().getId();
          try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/GererCat.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }                                    
                                }
     @FXML
    public void Shcom() {
          try {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/SeeCom.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }          
}
}
