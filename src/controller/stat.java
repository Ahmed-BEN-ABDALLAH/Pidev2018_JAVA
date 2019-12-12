/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import service.ServiceStat;
import util.MyConnexion;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class stat implements Initializable {

    ObservableList<PieChart.Data> stat=FXCollections.observableArrayList();

    ArrayList<String> libelle = new ArrayList<String>();
    ArrayList<Integer> quantiteDispo = new ArrayList<Integer>();
    @FXML
    private PieChart piechart;
    @FXML
    private BarChart<String, Integer> barchart;
    ServiceStat service_stat= new ServiceStat();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
try {
           
            
            Statement stm =  MyConnexion.getInstance().getConnection().createStatement();
               ResultSet rest=stm.executeQuery("select nom , quantite from produit");
              
               while(rest.next())
               {
                   libelle.add(rest.getString("nom"));
                   quantiteDispo.add(rest.getInt("quantite"));
                   stat.add(new PieChart.Data(rest.getString("nom"), rest.getInt("quantite")));
               }
    }
    catch (SQLException ex) {
            Logger.getLogger(stat.class.getName()).log(Level.SEVERE, null, ex);
        }
        piechart.setAnimated(true);
        piechart.maxHeight(1000);
       piechart.setData(stat);
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
  
        for (Entry<String,Integer> i: service_stat.getStat().entrySet() ) {
            String nom=i.getKey();
            int nbr=i.getValue();
            XYChart.Data<String, Integer> d = new XYChart.Data<>(nom, nbr);
            series1.getData().add(d);
        }
        
        barchart.getData().addAll(series1);
       
    }
    
    
}