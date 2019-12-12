/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import com.google.zxing.BarcodeFormat;
import javafx.stage.Stage;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.BadElementException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import template.Template;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Produit;
import static entities.Produit.getPanier;
import entities.User;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.PageAttributes;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.WindowEvent;
import javax.imageio.ImageIO;
import service.ServiceCommande;
import service.ServiceProduit;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author said
 */
public class cart implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Pane pane;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private Text prix_total;
    @FXML
    private Button valider;
      WritableImage A;
com.itextpdf.text.Image  graph;
        User currentUser=Authentification.user;
        ServiceProduit service_pr=new ServiceProduit();
        ServiceCommande service_commande= new ServiceCommande();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
             AnchorPane box = FXMLLoader.load(getClass().getResource("/views/drawer.fxml"));
             drawer.open();
             drawer.setSidePane(box);
             
             HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
             transition.setRate(1);
             hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                 transition.setRate(transition.getRate() * 1);
                 transition.play();
                 
                 if (drawer.isShown()) {
                     drawer.close();
                 }
                 else
                 {
                     drawer.open();
                 }
                 
             });
          } catch (IOException ex) {
             Logger.getLogger(ProduitsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }
        ObservableList<Produit> panier = FXCollections.observableArrayList();
        for (Produit p:getPanier() )
        {
            panier.add(p);

        }
        cart_table(panier);
    }
    
    public void cart_table(ObservableList<Produit> panier)
    {
//        ObservableList<Produit> panier = FXCollections.observableArrayList();
//        for (Produit p:panier2 )
//        {
//            panier.add(p);
//        }
        int prixtotal =0;
        int prixtotal_cell=0;
        int k=0;
        int total_p=0;
        int i=0;
        int width=0;
        ObservableList<Produit> achat = FXCollections.observableArrayList();
        Pane pane=new Pane();
        pane.setLayoutX(269);
        pane.setLayoutY(106);
        anchorpane.getChildren().add(pane);
        while(i<panier.size())
        //for (int i = 0; i < panier.size(); i++) 
        {

            Produit get = panier.get(i);
            
            achat.add(get);
            prixtotal=prixtotal+(get.getQuantite()*get.getPrix());
            prix_total.setText(String.valueOf(prixtotal));
            prixtotal_cell=get.getQuantite()*get.getPrix();
            Group group=new Group();
            group.setLayoutX(0);
            HBox hbglobal=new HBox();
            HBox hb1=new HBox();
            HBox hb1_1=new HBox();
            HBox hb2=new HBox();
            HBox hb3=new HBox();
            HBox hb4=new HBox();
            HBox hb5=new HBox();
            hbglobal.setLayoutX(0);
            hb1.setLayoutX(0);
            hb1_1.setLayoutX(50);
            hb2.setLayoutX(177);
            hb3.setLayoutX(305);
            hb4.setLayoutX(412);
            hb5.setLayoutX(525);
            hbglobal.setLayoutY(20+k);
            hb1.setLayoutY(65+k);
            hb1_1.setLayoutY(65+k);
            hb2.setLayoutY(65+k);
            hb3.setLayoutY(65+k);
            hb4.setLayoutY(65+k);
            hb5.setLayoutY(65+k);
            /***********************************/
            FontAwesomeIconView delete=new FontAwesomeIconView(FontAwesomeIcon.TIMES_CIRCLE);
            delete.setSize("20");
            delete.setFill(Color.RED);
            
            delete.setOnMouseClicked((MouseEvent event) -> {
               //pane.getChildren().remove(group);
               anchorpane.getChildren().remove(pane);
               achat.remove(get);
               int a=Integer.parseInt(prix_total.getText());
               prix_total.setText(String.valueOf(a-(get.getQuantite()*get.getPrix())));
               ProduitsFXMLController.nombreproduits=ProduitsFXMLController.nombreproduits-get.getQuantite();
               cart_table(achat);
            });
         
            String A = get.getImage();
            A = "C:\\xampp\\htdocs\\datatable_21\\"+A;
            File F1 = new File(A);
            Image image2 = new Image(F1.toURI().toString());
            ImageView image=new ImageView();
            image.setFitWidth(60);
            image.setFitHeight(60);
            image.setImage(image2);
            Text t2=new Text(get.getNom());
            Text t3=new Text(String.valueOf(get.getPrix()));
            TextField t4=new TextField(String.valueOf(get.getQuantite()));
            t4.setPrefWidth(45);
            total_p=get.getPrix()*get.getQuantite();
            Button moin =new Button("-");
            Button plus =new Button("+");
            Text t5=new Text(String.valueOf(total_p));
            moin.setOnMouseClicked((MouseEvent event) -> {
                int qnt=Integer.parseInt(t4.getText());
//                   achat.remove(get);
                qnt=qnt-1;
                t4.setText(String.valueOf(qnt));
                t5.setText(String.valueOf(qnt*get.getPrix()));
                int a=Integer.parseInt(prix_total.getText());
                prix_total.setText(String.valueOf(a-get.getPrix()));
                get.setQuantite(qnt);
                ProduitsFXMLController.nombreproduits--;
//              achat.add(get);
//             
//                Produit.Panier=achat;
                if(qnt==0)
                {
                    anchorpane.getChildren().remove(pane);
                    achat.remove(get);
                    prix_total.setText(String.valueOf(a-get.getPrix()));
                    System.out.println("achat after delete" + achat);
                    cart_table(achat);
                }
            });
            plus.setOnMouseClicked((MouseEvent event) -> {
                int qnt=Integer.parseInt(t4.getText());
                qnt=qnt+1;
                t4.setText(String.valueOf(qnt));
                t5.setText(String.valueOf(qnt*get.getPrix()));
                int a=Integer.parseInt(prix_total.getText());
                prix_total.setText(String.valueOf(a+get.getPrix()));
               
                get.setQuantite(qnt);
ProduitsFXMLController.nombreproduits++;
            });
            
            /*************************************/
            hb1.getChildren().addAll(delete);
            hb1_1.getChildren().addAll(image);
            hb1.setStyle("-fx-padding : 15 0 0 15");
            hb1_1.setStyle("-fx-padding : 5 0 0 15");
            hb2.getChildren().add(t2);
            hb2.setStyle("-fx-padding : 15 0 0 15");
            hb3.getChildren().add(t3);
            hb3.setStyle("-fx-padding : 15 0 0 15");
            hb4.getChildren().addAll(moin,t4,plus);
            hb4.setStyle("-fx-padding : 15 0 0 0");
            hb5.getChildren().add(t5);
            hb5.setStyle("-fx-padding : 15 0 0 15");
            group.getChildren().addAll(hb1,hb1_1,hb2,hb3,hb4,hb5);
            Separator sep=new Separator(Orientation.HORIZONTAL);
            sep.setLayoutX(0);
            sep.setLayoutY(144+k);
            sep.setPrefWidth(sep.getWidth() + 690);
            Separator sep2=new Separator(Orientation.VERTICAL);
            sep2.setLayoutX(0);
            sep2.setLayoutY(66+k);
            sep2.setPrefHeight(sep2.getHeight() + 75);
            Separator sep1=new Separator(Orientation.VERTICAL);
            sep1.setLayoutX(693);
            sep1.setLayoutY(66+k);
            sep1.setPrefHeight(sep1.getHeight() + 75);
        //pane.getChildren().addAll(hb1,hb2,hb3,hb4,hb5,sep);
        pane.getChildren().addAll(group,sep,sep1,sep2);
        k=k+80;
        i++;
        }
        panier=(ObservableList<Produit>) achat;
        System.out.println("achat "+achat);
        
        Produit.Panier=panier;
        
    //return panier;
    }    

    @FXML
    private void validationCommande(ActionEvent event) throws IOException, SQLException, WriterException, DocumentException {

        try {
            // System.out.println("COMMANDE "+panier);
            ObservableList<Produit> commande = Produit.Panier;
            ObservableList<Produit> commande2 = null ;
            for (Produit produit : commande) {
                int idp=produit.getId();
                produit.setStock(produit.getStock()-produit.getQuantite());
                service_pr.UpdateProduitStock(produit);
                service_commande.AjoutCommande(produit,idp);
            }
            
         
            ProduitsFXMLController.nombreproduits=0;
            Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/produitsFXML.fxml"))));
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            //jdid
            //qrcode
            //pdf
            
            
            // TODO
            //qrcode
            User currentUser=Authentification.user;
             String myWeb = "reference: "+currentUser.getId()+" les produits sonts:";
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            
            for(Produit P:Produit.getPanier())
            {
            
            myWeb=myWeb+P.getNom();
            
                System.out.println("0000000000000000000000000000"+P.getNom());
            }
            
           
            int width = 300;
            int height = 300;
            String fileType = "png";
            
            BufferedImage bufferedImage = null;
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(java.awt.Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(java.awt.Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            
            System.out.println("Success...");
            
            
            
            
            ObservableList<Produit> pa = FXCollections.observableArrayList();
              Produit.Panier=pa;  
            cart_table(pa);
           
            
            
            
            
            
            
            
            
            
            // qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
            //qrcode.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
            
            A = SwingFXUtils.toFXImage(bufferedImage, null);
            
            ByteArrayOutputStream  byteOutput = new ByteArrayOutputStream();
            
            ImageIO.write( SwingFXUtils.fromFXImage( A, null ), "png", byteOutput );
            
            
            
            graph = com.itextpdf.text.Image.getInstance( byteOutput.toByteArray() );
            
            StackPane root = new StackPane();
            
            
            Document document = new Document();
            
            
            
            OutputStream file = new FileOutputStream(new File("D:\\Test.pdf"));
            
            
            PdfWriter.getInstance(document, file);
            
//            User currentUser=Authentification.user;
            document.open();
            Paragraph p = new Paragraph();
            System.out.println(A);
           
            document.add(new Paragraph("Votre commande MR/Mdme "+currentUser.getNom()+" de reference:"+currentUser.getId()+" Veuillez presentez ce document a la livraison"));
             p.add(graph);
            document.add(p);
            
            document.close();
            
            
            
            file.close();
            //open pdf
            
            
            if(!Desktop.isDesktopSupported()){
                System.out.println("Desktop is not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            
            File file2 = new File("D:\\Test.pdf");
            if(file2.exists()) {desktop.open(file2);}
            //pdf
            
            
            
            
            
            
//       PDFViewer m_PDFViewer;
//
//               //new File("C:\\Users\\ASUS\\Desktop\\a\\pdftest.pdf");
//            m_PDFViewer = new PDFViewer();
//
//                 //BorderPane borderPane1 = new BorderPane(m_PDFViewer);
//                borderPane.setCenter(m_PDFViewer);
//
//
//
        } catch (BadElementException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        }

       
//        Pidevallforkids.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/payement.fxml"))));             
//Stage stage2  = (Stage) valider.getScene().getWindow();
//    stage2.close();
  Stage stage = new Stage();
       stage.setWidth(820);
        stage.setHeight(650);
        stage.centerOnScreen();
        Scene scene = new Scene(new Group());

        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(browser);
        int prix=Integer.parseInt(prix_total.getText());
        String nom=currentUser.getNom();
        webEngine.load("http://localhost/payement/a.php?MONTANT="+prix+"&NAME="+nom+"&EMAIL="+"said@gmail.com");

        scene.setRoot(scrollPane);

        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest((WindowEvent event1) -> {
          

               Alert alert = new Alert(Alert.AlertType.INFORMATION);

                    Stage stage1 = (Stage) alert.getDialogPane().getScene().getWindow();
                    alert.setTitle("Information");
                    alert.setContentText("Merci Pour Votre Confiance ");
                    alert.showAndWait();
    });
    

    }
    
    
    
    
    
    
    
    
    
    
    


        
        
        
        
        
        
        
        
        
        
    }
    

