/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.controlsfx.control.Notifications;
import template.Template;
import util.Authentification;

/**
 *
 * @author AHMED
 */
public class AccessAdminController {

    @FXML
    private ImageView p_image;
      private Path pathfrom;
    private Path pathto;
    private File Current_file;
         private String file_image ;
 private final User currentUser=Authentification.user;
     final FileChooser fileChooser = new FileChooser();
    @FXML
    private FontAwesomeIconView unlock;

    @FXML
    private void image_fichier(MouseEvent event) throws MalformedURLException {
        
         Current_file = fileChooser.showOpenDialog(Template.getInstance().getStage());
                    if (Current_file != null) {
//                        openFile(file);
                        System.out.println(Current_file.toURI().toURL().toExternalForm());
                     file_image= Current_file.getName();
                    }
           System.out.println("--------"+Current_file.getAbsolutePath());
         
    Image image2 = new Image(Current_file.toURI().toString());
p_image.setImage(image2);
          
                
                    
     
        
        
        
        
    }

    private void unlock(MouseEvent event) throws IOException {
        
       
                
                
                
                
    }

    @FXML
    private void close(MouseEvent event) throws IOException {
                                            template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/login_1.fxml"))));    

        
    }

    @FXML
    private void unlockad(MouseEvent event) throws IOException {
        
         BufferedImage imgA = null;
		BufferedImage imgB = null;

		try
		{
                        String s=Current_file.getAbsolutePath();
			File fileA = new File(s);
			File fileB = new File("C:\\Users\\AHMED\\Pictures\\x.jpg");
                    System.out.println(fileA);
                    System.out.println(fileB);
			imgA = ImageIO.read(fileA);
			imgB = ImageIO.read(fileB);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		int width1 = imgA.getWidth();
		int width2 = imgB.getWidth();
		int height1 = imgA.getHeight();
		int height2 = imgB.getHeight();

		if ((width1 != width2) || (height1 != height2)){
			System.out.println("Error: Images dimensions"+" mismatch");
                
                            Notifications n =Notifications.create().title("Notification")
             .text("ACCESS DENIED")
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showError();
                
                
                
                
                }
		else
		{
			long difference = 0;
			for (int y = 0; y < height1; y++)
			{
				for (int x = 0; x < width1; x++)
				{
					int rgbA = imgA.getRGB(x, y);
					int rgbB = imgB.getRGB(x, y);
					int redA = (rgbA >> 16) & 0xff;
					int greenA = (rgbA >> 8) & 0xff;
					int blueA = (rgbA) & 0xff;
					int redB = (rgbB >> 16) & 0xff;
					int greenB = (rgbB >> 8) & 0xff;
					int blueB = (rgbB) & 0xff;
					difference += Math.abs(redA - redB);
					difference += Math.abs(greenA - greenB);
					difference += Math.abs(blueA - blueB);
				}
			}

			// Total number of red pixels = width * height
			// Total number of blue pixels = width * height
			// Total number of green pixels = width * height
			// So total number of pixels = width * height * 3
			double total_pixels = width1 * height1 * 3;

			// Normalizing the value of different pixels
			// for accuracy(average pixels per color
			// component)
			double avg_different_pixels = difference /total_pixels;
			// There are 255 values of pixels in total
			double percentage = (avg_different_pixels /255) * 100;
			System.out.println("Difference Percentage-->" +percentage);
                    if (percentage==0) {
                        
                                    template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/AdminInterfaceFXML.fxml"))));    

                    }
                    else {
                    
                    Notifications n =Notifications.create().title("Notification")
             .text("ACCESS DENIED")
             .graphic(null)
             .position(Pos.BASELINE_LEFT)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showError();
                    
                    }
                    
        
                }
    }
    
}
