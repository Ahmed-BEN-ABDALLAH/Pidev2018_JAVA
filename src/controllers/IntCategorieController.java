/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import entities.Categorie;
import entities.Publication;
import java.io.File;
import java.io.IOException;
import service.ServiceCategorie;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import service.ServicePublication;
import util.MyConnexion;

/**
 * FXML Controller class
 *
 * @author ikbel
 */
public class IntCategorieController implements Initializable {

    @FXML
    private Pane dashbord;
    @FXML
    private JFXButton ajout;
    @FXML
    private JFXButton afficher;
    @FXML
    private Pane titre;
    @FXML
    private Pane addpane, showcat, modpane;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXComboBox<String> souscats;
    @FXML
    private JFXButton aj;

    @FXML
    private ObservableList<Categorie> pooll = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Categorie> pooll1 = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> pooll2 = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> pooll3 = FXCollections.observableArrayList();
    @FXML
    private JFXListView<Categorie> catm = new JFXListView<Categorie>();
    @FXML
    private JFXListView<Categorie> cats = new JFXListView<Categorie>();
    @FXML
    private JFXListView<String> listcateg = new JFXListView<String>();
    ;
    @FXML
    private JFXButton supps;
    @FXML
    private JFXTextField namemod;
    @FXML
    private Pane affpane;
    @FXML
    private JFXListView<Publication> lspub = new JFXListView<Publication>();
    @FXML
    private JFXButton desappr;
    @FXML
    private JFXButton appr;
        @FXML
    private ObservableList<Publication> pooll4 = FXCollections.observableArrayList();

    static int Idlist;
public static int myx;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceCategorie.change();
        ServiceCategorie.change1();

        dashbord.setVisible(true);
        titre.setVisible(true);
        addpane.setVisible(false);
        showcat.setVisible(false);
        modpane.setVisible(false);
        supps.setVisible(false);
        affpane.setVisible(false);
        pooll2.addAll(ServiceCategorie.selectNomCategorie());
        souscats.setItems(pooll2);
        pooll3.addAll(ServiceCategorie.selectNomCategorie());
        listcateg.setItems(pooll3);
        // TODO
    }
    @FXML
    public void UpdateCategorie() {
        addpane.setVisible(false);
        showcat.setVisible(false);
        modpane.setVisible(true);
        affpane.setVisible(false);
    }
    @FXML
    public void AddCategorie() {
        addpane.setVisible(true);
        showcat.setVisible(false);
        modpane.setVisible(false);
        
        affpane.setVisible(false);
    }
    @FXML
    public void ShowCategorie() {
        addpane.setVisible(false);
        showcat.setVisible(true);
        modpane.setVisible(false);
        cats.setVisible(false);
        
        affpane.setVisible(false);
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
        addpane.setVisible(false);
        modpane.setVisible(false);
        supps.setVisible(true);
        showcat.setVisible(true);
        cats.setVisible(true);
        
        affpane.setVisible(false);
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

                        Label nomcat = new Label();

                        Label nbpub = new Label();

                        Categorie s = ((Categorie) item);
                        if (s != null) {

                            nomcat.setText("Sous catégorie : " + s.getNom());

                            nbpub.setText("Nombre de publication : " + s.getNbr_publication() + " ");

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
    public void AjoutCategorie() {
        if(souscats.getValue() !=null){
  
        int a= ServiceCategorie.getIdcat(souscats.getValue());
        Categorie c =new Categorie(
                nom.getText(),
                0,
                "sous-categorie"
                );
       
        ServiceCategorie.inserersouscategorie(c, a);
        
        nom.clear();
        
        souscats.setValue("");
        
        } else
        {
        Categorie c = new Categorie(nom.getText(), 0, "categorie");
        ServiceCategorie.insertCategorie(c);
        nom.clear();
        }
    }

    @FXML
    public void supprimer_categorie() {
        ServiceCategorie.change();
        ServiceCategorie.change1();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation Dialog");
        alert.setContentText("Vous voulez supprimer cette categorie ?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {

            int c = -1;
            if (catm.getSelectionModel().getSelectedItem().getId() != 0) {
                c = catm.getSelectionModel().getSelectedItem().getId();
            } 
            ServiceCategorie.deleteCategorie(c);
            catm.getItems().removeAll(catm.getSelectionModel().getSelectedItems());
        } else {
            System.out.println("cancel");
        }
ShowCategorie();
    }
        @FXML
    public void supprimer_souscategorie() {
         ServiceCategorie.change();
        ServiceCategorie.change1();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation Dialog");
        alert.setContentText("Vous voulez supprimer cette sous categorie ?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {

            int c = -1;
            if (cats.getSelectionModel().getSelectedItem().getId() != 0) {
                c = cats.getSelectionModel().getSelectedItem().getId();
            }

            ServiceCategorie.deleteCategorie(c);
            catm.getItems().removeAll(catm.getSelectionModel().getSelectedItems());
        } else {
            System.out.println("cancel");
        }
        shows();
    }
            public void modifier_categorie()
    { 
        
        String c = listcateg.getSelectionModel().getSelectedItem();
        int i = ServiceCategorie.getIdcat(c);

        ServiceCategorie.updateCategorie(namemod.getText(),i);
        namemod.clear();
        
        
    }
            @FXML
             public void gerPosts()
                {
                     addpane.setVisible(false);
        showcat.setVisible(false);
        modpane.setVisible(false);
        cats.setVisible(false);
        affpane.setVisible(true);
        lspub.setVisible(true);
        pooll4.clear();
        lspub.getItems().clear();
        pooll4.addAll(ServicePublication.selectPublicationAdmin());
        lspub.getItems().addAll(pooll4);
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
    public void mettreApprouver() {
        ServiceCategorie.change();
        ServiceCategorie.change1();
        int r= lspub.getSelectionModel().getSelectedItem().getId();
        System.out.println(r);
        int a= lspub.getSelectionModel().getSelectedItem().getId_categorie();
        ServiceCategorie.getCat(a);
        ServicePublication.updatePublicationApprouver(r);
    }
    @FXML
    public void mettreDesapprouver() {
        ServiceCategorie.change();
        ServiceCategorie.change1();
        int r= lspub.getSelectionModel().getSelectedItem().getId();
        System.out.println(r);

        ServicePublication.updatePublicationDesapprouver(r);
       
    }
     @FXML 
     public void Genererxcell(ActionEvent event ) throws IOException, WriteException, SQLException 
 {
     
      
       
            try {
            
            
                
               
                
                String req ="SELECT nbr_vue, contenu,titre_qestion,location,nbr_reponse FROM publication";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
           
            ResultSet result = ste.executeQuery();   
            
            List <Publication> list = new ArrayList<>(); 
            while(result.next()){
                
              
                list.add(
                new Publication(
                             result.getString("titre_qestion"),
                             result.getString("location"),
                             result.getInt("nbr_vue"),
                             result.getInt("nbr_reponse"),
                             result.getString("contenu")));
                        
                       
                        
                        
                         String filename ="Publicationliste.xls";
        WritableWorkbook workbook =Workbook.createWorkbook(new File(filename));
       WritableSheet sheet = workbook.createSheet("sheet1", 0);
       jxl.write.Label label = new jxl.write.Label(0,0,"Post title");
       jxl.write.Label label2 = new jxl.write.Label(1,0,"Location");
       jxl.write.Label label3 = new jxl.write.Label(2,0,"Number of vues");
       jxl.write.Label label4 = new jxl.write.Label(3,0,"Number of comments");
       jxl.write.Label label5 = new jxl.write.Label(4,0,"Content");
        /*jxl.write.Label l8;
          for(Joueur j :list) {
             
             for(int i =1;i<myx;i++) 
             {
         
             l8 = new jxl.write.Label(1,i,j.getNom());
            sheet.addCell(l8);
          
             }
             
          }*/
          
          int i =0;
          
        for(Publication j :list) {
            do {
                i++;
                String com= String.valueOf(i);
         
             sheet.addCell(new jxl.write.Label(0,i,j.getTitre()));
             sheet.addCell(new jxl.write.Label(1,i,j.getLocation()));
              sheet.addCell(new jxl.write.Number(2,i,j.getNbr_vue()));
              sheet.addCell(new jxl.write.Number(3,i,j.getNbrReponse()));
            sheet.addCell(new jxl.write.Label(4,i,j.getContenu()));
             
            } while(i==myx);
        }
       
      
      
       
          
          
          
       sheet.addCell(label);
       sheet.addCell(label2);
       sheet.addCell(label3);
        sheet.addCell(label4);
         sheet.addCell(label5);
            jxl.write.Label text = new jxl.write.Label(3,8,"A Label Record");
            sheet.addCell(text);
      /* jxl.write.Number number = new jxl.write.Number(0,5,16.55);*/
      /* sheet.addCell(number);*/
       workbook.write();
       workbook.close();
                
          
            }
            
           
            
                
            
          
        }
            
            
                
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            
            
            try {
            
            
                
               
                
                String req1 ="SELECT COUNT(id) as count  FROM publication";
               

            PreparedStatement ste1 = MyConnexion.getInstance().getConnection().prepareStatement(req1);
           
            ResultSet result1 = ste1.executeQuery();   
            
            
            while(result1.next()){
              int x=  result1.getInt(1);
            myx=x;
            }
            
            
     System.out.println(myx);
        
       
    }
            
             catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            }
    
   
       
    
}
