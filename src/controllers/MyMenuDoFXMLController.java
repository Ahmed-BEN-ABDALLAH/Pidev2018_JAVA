/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import client.Client;
import static controllers.AjouterDoController.threads;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.User;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import service.MyServiceEvenement;
import util.Authentification;

/**
 * FXML Controller class
 *
 * @author AHMED
 */
public class MyMenuDoFXMLController implements Initializable {
    
     private final User currentUser=Authentification.user;

      @FXML
    private BorderPane BorderPane;
    @FXML
    private Text nbr;
    MyServiceEvenement s=new MyServiceEvenement();
      int nbrnotif;   
    @FXML
    private Text user;
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        LoadUI("AfficheDoFXML");
        user.setText(currentUser.getUsername());
    
    }    

    @FXML
    private void Profile(MouseEvent event) {
    }

 
  @FXML
    private void ToHome(MouseEvent event) throws IOException {
          template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/menuAdmin.fxml"))));   
        
        
    }
    
    private void LoadUI(String ui)
    {
        Parent root= null;
        try {
                  // Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/Affiche.fxml"))));             

            root= FXMLLoader.load(getClass().getResource("/GUI/"+ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MyMenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        BorderPane.setCenter(root);
        
    }

    private void notif(MouseEvent event) throws IOException {
        
        System.out.println("aaaaaaa nekhdem ");
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/NotifFXML.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        
    }

    private void notification(MouseEvent event) throws IOException {
        
        
        
          System.out.println("aaaaaaa nekhdem ");
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/NotifFXML.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void AjoutDo(MouseEvent event) {
           LoadUI("AjouterDoFXML");
        
    }

    @FXML
    private void AfiicheDo(MouseEvent event) {
          LoadUI("AfficheDoFXML");
    }

    @FXML
    private void MesDo(MouseEvent event) {
   
                  LoadUI("MesDoFXML");
    }

    @FXML
    private void chat(MouseEvent event) {
        
        
        
        
          Stage primaryStage = new Stage();
        threads = new ArrayList<Thread>();
		primaryStage.setTitle("Messenger");
		primaryStage.setScene(makeInitScene(primaryStage));
		primaryStage.show();
        
    }

   public Scene makeInitScene(Stage primaryStage) {
		/* Make the root pane and set properties */
		GridPane rootPane = new GridPane();
		rootPane.setPadding(new Insets(20));
		rootPane.setVgap(10);
		rootPane.setHgap(10);
		rootPane.setAlignment(Pos.CENTER);

		/* Make the text fields and set properties */
		TextField nameField = new TextField(currentUser.getUsername());
               
		TextField hostNameField = new TextField("localhost");
		TextField portNumberField = new TextField("8888");
                hostNameField.setDisable(true);
                portNumberField.setDisable(true);
                nameField.setDisable(true);
		/* Make the labels and set properties */
		Label nameLabel = new Label("Nom: ");
		Label hostNameLabel = new Label("HostName");
		Label portNumberLabel = new Label("PortNumber");
		Label errorLabel = new Label();
		/* Make the button and its handler */
		Button submitClientInfoButton = new Button("Connecter");
		submitClientInfoButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent Event) {
				// TODO Auto-generated method stub
				/* Instantiate the client class and start it's thread */
				Client client;
				try {
					client = new Client(hostNameField.getText(), Integer
							.parseInt(portNumberField.getText()), nameField
							.getText());
					Thread clientThread = new Thread(client);
					clientThread.setDaemon(true);
					clientThread.start();
					threads.add(clientThread);
					
					/* Change the scene of the primaryStage */
					primaryStage.close();
					primaryStage.setScene(makeChatUI(client));
					primaryStage.show();
				}
				catch(ConnectException e){
					errorLabel.setTextFill(Color.RED);
					errorLabel.setText("Le serveur est fermer revenez plus tard");
				}
				catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					errorLabel.setTextFill(Color.RED);
					errorLabel.setText("Le serveur est fermer revenez plus tard");
				}
				
			}
		});

		/*
		 * Add the components to the root pane arguments are (Node, Column
		 * Number, Row Number)
		 */
		rootPane.add(nameField, 0, 0);
		rootPane.add(nameLabel, 1, 0);
		rootPane.add(hostNameField, 0, 1);
		rootPane.add(hostNameLabel, 1, 1);
		rootPane.add(portNumberField, 0, 2);
		rootPane.add(portNumberLabel, 1, 2);
		rootPane.add(submitClientInfoButton, 0, 3, 2, 1);
		rootPane.add(errorLabel, 0, 4);
		/* Make the Scene and return it */
		return new Scene(rootPane, 400, 400);
	}


   
   
    public Scene makeChatUI(Client client) {
		/* Make the root pane and set properties */
		GridPane rootPane = new GridPane();
		rootPane.setPadding(new Insets(20));
		rootPane.setAlignment(Pos.CENTER);
		rootPane.setHgap(10);
		rootPane.setVgap(10);

		/*
		 * Make the Chat's listView and set it's source to the Client's chatLog
		 * ArrayList
		 */
		ListView<String> chatListView = new ListView<String>();
		chatListView.setItems(client.chatLog);

		/*
		 * Make the chat text box and set it's action to send a message to the
		 * server
		 */
		TextField chatTextField = new TextField();
		chatTextField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				client.writeToServer(chatTextField.getText());
				chatTextField.clear();
                                String bip = "message.mp3";
Media hit = new Media(new File(bip).toURI().toString());
MediaPlayer mediaPlayer = new MediaPlayer(hit);
mediaPlayer.play();
			}
		});
 
  
		/* Add the components to the root pane */
		rootPane.add(chatListView, 0, 0);
		rootPane.add(chatTextField, 0, 1);

		/* Make and return the scene */
		return new Scene(rootPane, 400, 400);

	}
        
    
}
