/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.HttpURLConnection;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author seif
 */
public class SmsController implements Initializable {

    @FXML
    private JFXTextField ak;
    @FXML
    private JFXTextField se;
    @FXML
    private JFXTextField num;
    @FXML
    private TextArea msg;
    @FXML
    private JFXButton bte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ak.setText("63tM/P4ylv0-ET8XJahZ3Tvss5x3Y0LSWOBP1Wle2Q");
        
        // TODO
    }    
    
    
    
    public void envoyer(ActionEvent event) {
        
        String apik = "apikey=" + ak.getText();
			String mess = "&message=" + msg.getText();
			String send = "&sender=" + se.getText();
			String numb = "&numbers=" + num.getText();
        
        		try {
			// Construct data
			String apiKey = "apikey=" + ak.getText();
			String message = "&message=" + msg.getText();
			String sender = "&sender=" + se.getText();
			String numbers = "&numbers=" + num.getText();
                            System.out.println(apiKey);
                            System.out.println(message);
                            System.out.println(sender);
                            System.out.println(numbers);
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				/*stringBuffer.append(line);*/
                                JOptionPane.showMessageDialog(null, "okki");
			}
			rd.close();
			
			/*return stringBuffer.toString();*/
		} catch (Exception e) {
                       JOptionPane.showMessageDialog(null, e);
			System.out.println("Error SMS "+e);
                        
                         System.out.println(apik);
                            System.out.println(mess);
                            System.out.println(send);
                            System.out.println(numb);
			/*return "Error "+e;*/
		}
	}
    
    
}
