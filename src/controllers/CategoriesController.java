/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Categorie;
import entities.Publication;
import entities.Publicationresolu;
import entities.Reponse;
import static controllers.IntCategorieController.Idlist;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
public class CategoriesController extends LoginController implements Initializable  {
    @FXML
    private JFXTextField titpub;
    @FXML
    private JFXTextField titr;
    @FXML
    private Pane dashbord;
    @FXML
    private JFXButton ajout;
    @FXML
    private JFXButton afficher;
    @FXML
    private Pane titre;
    @FXML
    private Pane addpane;
    @FXML
    private JFXTextArea pub;
    @FXML
    private JFXTextArea contmod;
    @FXML
    private JFXButton addbtn;
    @FXML
    private JFXButton mod;
    @FXML
    private JFXComboBox<String> cat;
    @FXML
    private Pane affpane;
    @FXML
    private JFXListView<Publication> lspub = new JFXListView<Publication>();
    @FXML
    private JFXListView<Publication> lspubs = new JFXListView<Publication>();

    @FXML
    private JFXButton showdet;
    @FXML
    private JFXButton showrep;
    @FXML
    private Pane modpane;
    @FXML
    private Pane moddpane;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton resolu;
    @FXML
    private JFXButton nonresolu;
    @FXML
    private Pane commpane;
    @FXML
    private JFXListView<Reponse> lscom;
    @FXML
    private JFXListView<Reponse> lsrep = new JFXListView<Reponse>();
    @FXML
    private Label cn;
    @FXML
    private Label t;
    @FXML
    private ObservableList<String> pooll2 = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Publication> pooll = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Publication> pooll3 = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Reponse> pooll1 = FXCollections.observableArrayList();
    static int idp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceCategorie.change();
        ServiceCategorie.change1();
        System.out.println("Id:"+idusr);

        dashbord.setVisible(true);
        titre.setVisible(true);
        addpane.setVisible(false);
        affpane.setVisible(false);
        modpane.setVisible(false);
//        moddpane.setVisible(false);
//        commpane.setVisible(false);
        lsrep.setVisible(false);
        resolu.setVisible(false);
        nonresolu.setVisible(false);
        pooll2.addAll(ServiceCategorie.selectCategories());
        cat.setItems(pooll2);
        // TODO
    }    
    @FXML
    public void AddPub() {
     addpane.setVisible(true);
        affpane.setVisible(false);
        modpane.setVisible(false);
      //  moddpane.setVisible(false);
        //commpane.setVisible(false);
                resolu.setVisible(false);
        nonresolu.setVisible(false);
    }
      @FXML
    public void ShowPub() {
        addpane.setVisible(false);
        affpane.setVisible(true);
        modpane.setVisible(false);
       // moddpane.setVisible(false);
        //commpane.setVisible(false);
        lsrep.setVisible(false);
        showrep.setVisible(true);
        lspub.setVisible(true);
                resolu.setVisible(false);
        nonresolu.setVisible(false);
        pooll.clear();
        lspub.getItems().clear();
     

        pooll.addAll(ServicePublication.selectPublication(idusr));
          System.out.println(idusr);
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

                return cellp;
                
            }

        }
        );

    }
       @FXML
    public void AjoutPub() {
        addpane.setVisible(true);
        affpane.setVisible(false);
        modpane.setVisible(false);
      //  moddpane.setVisible(false);
        //commpane.setVisible(false);
        showrep.setVisible(false);
                resolu.setVisible(false);
        nonresolu.setVisible(false);
        lsrep.setVisible(false);
        if(cat.getValue() !=null){

          // Timestamp stamp = new Timestamp(System.currentTimeMillis());
  
          String loc="en attente";
        int a= ServiceCategorie.getIdcat(cat.getValue());
        
        Publication p =new Publication(
                idusr,
                a,
                a,
               titpub.getText(),
                1, 
                (int) System.currentTimeMillis(),
                0,
                loc,
                pub.getText());
       
        ServicePublication.insertPublication(p);
        pub.clear();
        cat.setValue("");
        
        } 
    }


    @FXML
    public void showPubComm() {
        lspub.setVisible(false);
        lsrep.setVisible(true);
        showrep.setVisible(false);
                resolu.setVisible(true);
        nonresolu.setVisible(true);
        pooll1.clear();
        lsrep.getItems().clear();
        idp=lspub.getSelectionModel().getSelectedItem().getId();
        System.out.println("kkkkkkkkkkkk"+idp);
        pooll1.addAll(ServiceReponse.selectReponse(idp));
        lsrep.getItems().addAll(pooll1);

        lsrep.setCellFactory(new Callback<ListView<Reponse>, ListCell<Reponse>>() {
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
    @FXML
    public void mettreResolu() {
        ServiceReponse.change2();
       int r= lsrep.getSelectionModel().getSelectedItem().getId();
        System.out.println(r);
       int c = ServiceReponse.getIdpub(r);
        System.out.println(c);
       Publicationresolu p =new Publicationresolu(
                c,c,r);
       
        ServiceReponse.Myresolu(p);
    }
    @FXML
    public void mettreNonResolu() {
    ServiceReponse.change2();
     int r= lsrep.getSelectionModel().getSelectedItem().getId();
        System.out.println(r);
       int p = ServiceReponse.getIdpub(r);
       int pr= ServiceReponse.getIdpubR(r);
        System.out.println(p);
        ServiceReponse.MyNonresolu(pr,p);
       
    }
      public void ShowPubs() {
        addpane.setVisible(false);
        affpane.setVisible(true);
        modpane.setVisible(true);
        //moddpane.setVisible(false);
       // commpane.setVisible(false);
       lspubs.setVisible(true);
       modifier.setVisible(true);
         mod.setVisible(false);
         titr.setVisible(false);
         contmod.setVisible(false);
        cn.setVisible(false);
        t.setVisible(false);
        lsrep.setVisible(false);
        showrep.setVisible(false);
        lspub.setVisible(false);
                resolu.setVisible(false);
        nonresolu.setVisible(false);
        pooll3.clear();
        lspubs.getItems().clear();
     

        pooll3.addAll(ServicePublication.selectPublicationM(idusr));
        System.out.println(idusr);
        lspubs.getItems().addAll(pooll3);
        lspubs.setCellFactory(new Callback<ListView<Publication>, ListCell<Publication>>() {
            @Override
            public ListCell<Publication> call(ListView<Publication> param) {
                com.jfoenix.controls.JFXListCell<Publication> cellp3 = new com.jfoenix.controls.JFXListCell() {

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

                return cellp3;
                
            }

        }
        );

    }
        public void modifier_p()
    { 
        lspubs.setVisible(false);
        modifier.setVisible(false);
        mod.setVisible(true);
        cn.setVisible(true);
        t.setVisible(true);
        titr.setVisible(true);
        contmod.setVisible(true);
    }
      public void modifier_pub()
    { 

        int i = lspubs.getSelectionModel().getSelectedItem().getId();
        ServicePublication.updatePublication(contmod.getText(), titr.getText(), i);
        contmod.clear();
        titr.clear();
        
    }
}
