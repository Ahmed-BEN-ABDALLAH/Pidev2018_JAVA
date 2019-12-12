/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import entities.baby;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static jdk.nashorn.internal.objects.NativeArray.map;
import netscape.javascript.JSObject;
import service.serviceBaby;

/**
 * FXML Controller class
 *
 * @author ghada
 */
public class DirectionController implements Initializable,MapComponentInitializedListener {

    @FXML
    private GoogleMapView mapview;
         private GoogleMap map;
                 serviceBaby servicebb=new serviceBaby();
    baby p1= new baby();
     
                   serviceBaby service= new serviceBaby();




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                  mapview.addMapInitializedListener(this);
                  p1=service.GetBabybyid(baby.getId_courant());
                  System.out.println(p1.longitude);

        // TODO
    }    

    @Override
    public void mapInitialized() {
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
 // map.addUIEventHandler(UIEventType.click, (JSObject obj) -> {
           // LatLong l3 = new LatLong((JSObject) obj.getMember("latLng"));
            //System.out.println("LatLong: lat: " + l3.getLatitude() + " lng: " + l3.getLongitude());
             //l2.setText(""+l3.getLatitude());
            //l1.setText("" +l3.getLongitude());
              LatLong baby = new LatLong(p1.getLatitude(),p1.getLongitude());
          // MarkerOptions markerOptions = new MarkerOptions();

           MarkerOptions markerOptions1 = new MarkerOptions();
           markerOptions1.position(baby).visible(Boolean.TRUE);
             Marker joeSmithMarker = new Marker(markerOptions1);
               
                 LatLong esprit = new LatLong(36.8984456,10.1886537);
          // MarkerOptions markerOptions = new MarkerOptions();

           MarkerOptions markerOptions2 = new MarkerOptions();
           markerOptions2.position(esprit).visible(Boolean.TRUE).title("votre position");
          
             Marker moi = new Marker(markerOptions2);     
        map.addMarker( moi );
         InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
       infoWindowOptions.content("votre position");

       InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
       fredWilkeInfoWindow.open(map, moi);

                System.out.println("aaaaaaaa");
                 map.addMarker( joeSmithMarker );

                                
            }
    
}

