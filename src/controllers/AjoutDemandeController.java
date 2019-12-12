/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import entities.baby;
import entities.demande;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import netscape.javascript.JSObject;
import org.controlsfx.control.Notifications;
import service.serviceBaby;
import service.serviceDemande;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author ghada
 */
public class AjoutDemandeController implements Initializable,MapComponentInitializedListener{

    @FXML
    private Button btn;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXTextField numtel;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXDatePicker disponibilite;
    @FXML
    private JFXDatePicker datefin;
    @FXML
    private Button Image_fichier;
    @FXML
    private ImageView image_p;
serviceDemande service_b = new serviceDemande();
 int k=0;
       
             Marker marker2;
    /**
     * Initializes the controller class.
     */
     final FileChooser fileChooser = new FileChooser();
     private Desktop desktop = Desktop.getDesktop();
     private String file_image ;
    
    private JFXButton fichier;

    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    @FXML
    private JFXTextField l1;
    @FXML
    private JFXTextField l2;
    @FXML
    private GoogleMapView mapview;
         private GoogleMap map;
    @FXML
    private AnchorPane anchomap;
    @FXML
    private JFXTextField code;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapview.addMapInitializedListener(this);
        // TODO
    }    

     private boolean testNumberInput(String a)
    {
        boolean b=false;
        if(a.matches("^[0-9]*"))
        {
            b=true;
        }
        return b;
    }
     
     private boolean testTextInput(String a){
     
     boolean b= true ;
      if(a.length()==0 || testNumberInput(a)){
           b=false; }
      
      return b;
     
     }
       private boolean NoDate(){
     boolean  test=false;
      System.out.println(ChronoUnit.DAYS.between(this.disponibilite.getValue(), this.datefin.getValue()));  
      
         int a=(int) ChronoUnit.DAYS.between(this.disponibilite.getValue(), this.datefin.getValue());
         int b=(int) ChronoUnit.DAYS.between(LocalDate.now(), this.disponibilite.getValue());
        System.out.println("aaaaaaaaaa"+b);
    if (a<0  || b<0)
    {
  
        test=true;
        
    }
    return test;
    }
     
    @FXML
    private void ajouter(ActionEvent event) throws IOException {
         demande b = new demande();
    
    if (!checkText(nom.getText()))
    {         Alert a =new Alert(null, "verifier votre nom", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");}


else if (!checkText(prenom.getText())){  Alert a =new Alert(null, "verifier votre prenom", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");}
else if (!checkText(description.getText())){  Alert a =new Alert(null, "verifier votre description", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");}
else if (!checkText(adresse.getText())){  Alert a =new Alert(null, "verifier votre adresse", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");}
   
 else if (NoDate()){
//     Alert alert =new Alert(Alert.AlertType.WARNING, " Date début doit étre supérieur à date fin", ButtonType.CLOSE);
//        alert.showAndWait();
//   
notif(event);
   }
 else if (!testNumberInput(prix.getText())){ Alert a =new Alert(null, " verifier votre prix", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     }
 else if (!testNumberInput(numtel.getText())){ Alert a =new Alert(null, " verifier votre numero de telephone", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");}
else
{ 
          b.setNom(nom.getText());
        b.setPrenom(prenom.getText());
        b.setAdrese(adresse.getText());
         b.setDescription(description.getText());
         b.setNumtel(Integer.parseInt(numtel.getText()));
         b.setEmail(email.getText());
      b.setPrix(Integer.parseInt(prix.getText()));
        
   Date disponibilite = Date.valueOf(this.disponibilite.getValue());
   Date datefin = Date.valueOf(this.datefin.getValue());
   b.setDisponibilite(disponibilite);
   b.setDatefin(datefin);
   b.setIdb(Authentification.user.getId());
      b.setLongitude(Double.parseDouble(l1.getText()));
            b.setLatitude(Double.parseDouble(l2.getText()));
    
    
               file_image="/images/"+file_image;
        b.setImage(file_image);
        
        
            pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
            pathto = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\images\\"+Current_file.getName());
            Path targetDir = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\images\\");
          
  
           
            Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
        service_b.ajouterP(b);
        MenuGhadaController.setTest(1);
       template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/MenuDemande.fxml"))));             

    }
    
    
    
    
    
    }
        
    private void checkWrittenNumber(KeyEvent event) {
        
    if(this.testNumberInput(prix.getText()))
    {
       
        System.out.println("correct");
        
    }
    else
    {
         Alert a =new Alert(null, " please insert number in prix field", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     
        
    }
        if(this.testNumberInput(numtel.getText()))
    {
       
        System.out.println("correct");
        
    }
    else
    {
         Alert a =new Alert(null, " please insert number in prix field", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     
        
    }
    
    
    
    }
      private void notif(ActionEvent event) {
     Notifications n =Notifications.create().title("")
             .text("Date début doit étre supériur à date fin ou date début sépérieur au date d'aujourd'hui")
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("clicked on notification");
             }
             });
     n.showWarning();
        
    }

    
    
    
        
        
        
    

    @FXML
    private void Image_fichier(ActionEvent event) throws MalformedURLException {
  Current_file = fileChooser.showOpenDialog(template.Template.getInstance().getStage());
                    if (Current_file != null) {
//                        openFile(file);
                        System.out.println(Current_file.toURI().toURL().toExternalForm());
                     file_image= Current_file.getName();
                    }
        
         
    Image image2 = new Image(Current_file.toURI().toString());
             
image_p.setImage(image2);
          System.out.println();
                    


    }

      private boolean checkText(String b ) {
        
           if(this.testTextInput(b) || (this.testTextInput(b)) ||(this.testTextInput(b)) || (this.testTextInput(b)))
    {
                
return true;
      
        
    }
           
    else
    {
return false;
     
        
    }
      }

    @Override
    public void mapInitialized() {
        {
        
        
        
        {
//           LatLong joeSmithLocation = new LatLong(47.6182, -122.3231);
//        LatLong joshAndersonLocation = new LatLong(47.6297, -122.3431);
//        LatLong bobUnderwoodLocation = new LatLong(47.6397, -122.3031);
//        LatLong tomChoiceLocation = new LatLong(47.6497, -122.3325);
//        LatLong fredWilkieLocation = new LatLong(47.6597, -122.3357);
        
        
        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();
        
        mapOptions.center(new LatLong(36.8064948,10.1815316))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);
                 // MarkerOptions markerOptions = new MarkerOptions();  
         map = mapview.createMap(mapOptions);
       // anchomap.getChildren().add(mapview); 
  map.addUIEventHandler(UIEventType.click, (JSObject obj) -> {
            LatLong l3 = new LatLong((JSObject) obj.getMember("latLng"));
            //System.out.println("LatLong: lat: " + l3.getLatitude() + " lng: " + l3.getLongitude());
             l2.setText(""+l3.getLatitude());
            l1.setText("" +l3.getLongitude());
           MarkerOptions markerOptions = new MarkerOptions();

            markerOptions.position(new LatLong(l3.getLatitude(), l3.getLongitude()))
                    .visible(Boolean.TRUE)
                   .title("Evenement ici ");
                                  // map.addMarker(marker);
           
    // k=0;           
   // map.addMarker(marker2);

  if (k==0){
           Marker marker = new Marker(markerOptions);


//if (k==0){                                 
    map.addMarker(marker);
    marker2=marker;

   k++;}
else {
    
    
    map.removeMarker(marker2) ;
    //Marker marker3=marker2;
        

 marker2 = new Marker(markerOptions);
    map.addMarker(marker2);
 k++;
  //Marker marker3=marker2;
//  map.removeMarker(marker3);
  
  }
      System.out.println(k);


//if (k==0){                                 
        

                                           

//    else{
    

//      Marker marker2 = new Marker(markerOptions);
//                                                 map.addMarker(marker2);
//                                                 k=0;

         //marker2=marker; 
       
//}

//}
//else{map.removeMarker(marker2);
           // Marker marker = new Marker(markerOptions);

//  map.addMarker(marker);
//  map.removeMarker(marker2);
//    //      marker2=marker;
//k=0;
//}
    });
    //}


        //Add markers to the map
//        MarkerOptions markerOptions1 = new MarkerOptions();
//        markerOptions1.position(joeSmithLocation);
//        
//        MarkerOptions markerOptions2 = new MarkerOptions();
//        markerOptions2.position(joshAndersonLocation);
//        
//        MarkerOptions markerOptions3 = new MarkerOptions();
//        markerOptions3.position(bobUnderwoodLocation);
//        
//        MarkerOptions markerOptions4 = new MarkerOptions();
//        markerOptions4.position(tomChoiceLocation);
//        
//        MarkerOptions markerOptions5 = new MarkerOptions();
//        markerOptions5.position(fredWilkieLocation);
        
//        Marker joeSmithMarker = new Marker(markerOptions1);
//        Marker joshAndersonMarker = new Marker(markerOptions2);
//        Marker bobUnderwoodMarker = new Marker(markerOptions3);
//        Marker tomChoiceMarker= new Marker(markerOptions4);
//        Marker fredWilkieMarker = new Marker(markerOptions5);
//        
//        map.addMarker( joeSmithMarker );
//        map.addMarker( joshAndersonMarker );
//        map.addMarker( bobUnderwoodMarker );
//        map.addMarker( tomChoiceMarker );
//        map.addMarker( fredWilkieMarker );
        
//        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
//        infoWindowOptions.content("<h2>Fred Wilkie</h2>"
//                                + "Current Location: Safeway<br>"
//                                + "ETA: 45 minutes" );

//        InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
//        fredWilkeInfoWindow.open(map, fredWilkieMarker);
        
       
    
    }



        
        
        

    }
    }

    @FXML
    private void checkmail(MouseEvent event) {
        
         if(this.testTextInput(email.getText()) )
    {
                   this.code.setVisible(true);

        System.out.println("correct");
        
    }
           
    else
    {
         Alert a =new Alert(null, " please insert text in textfield", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     
        
    }
        
       
        }
    
    int i = (int) Math.random()*5;
String aaa=String.valueOf(i);

    @FXML
    private void verifcode(MouseEvent event) {
        {
        if (code.getText().equals(aaa)){
             Notifications n =Notifications.create().title("Notification")
             .text("Code correcte")
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
     
        
        
        
        }
        else {
        
         Notifications n =Notifications.create().title("Notification")
             .text("Verifiez votre code")
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
     
        
        }
    }
    }
    
}
