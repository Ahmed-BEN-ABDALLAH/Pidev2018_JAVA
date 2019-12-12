/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static controllers.AjouterDoController.threads;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.Server;

/**
 *
 * @author AHMED
 */
public class AdminInterfaceGhada implements Initializable{

    @FXML
    private BorderPane BorderPane;
    @FXML
    private Text nbr;

    @FXML
    private void AjoutP(MouseEvent event) {
    }

    @FXML
    private void AfficheP(MouseEvent event) {
    }

    
    
    
       private void LoadUI(String ui)
    {
        Parent root= null;
        try {
                  // Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/Affiche.fxml"))));             

            root= FXMLLoader.load(getClass().getResource("/GUI/"+ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MapController.class.getName()).log(Level.SEVERE, null, ex);
        }
        BorderPane.setCenter(root);
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    private void evenement(MouseEvent event) {
        
        LoadUI("");
    }

    @FXML
    private void dec(MouseEvent event) throws IOException {
        
                              template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/login_1.fxml"))));

    }

  
    
    
//    
//    public Scene makePortUI(Stage primaryStage) {
//		/* Make the root and set properties */
//		GridPane rootPane = new GridPane();
//		rootPane.setPadding(new Insets(20));
//		rootPane.setVgap(10);
//		rootPane.setHgap(10);
//		rootPane.setAlignment(Pos.CENTER);
//
//		/* Text label and field for port Number */
//		Text portText = new Text("Port Number");
//		Label errorLabel = new Label();
//		errorLabel.setTextFill(Color.RED);
//		TextField portTextField = new TextField("8888");
//                portTextField.setDisable(true);
//		portText.setFont(Font.font("Tahoma"));
//		/*
//		 * "Done" button and its click handler When clicked, another method is
//		 * called
//		 */
//		Button portApprovalButton = new Button("Activer server");
//		portApprovalButton.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				/* Make the server and it's thread, and run it */
//				try {
//					Server server = new Server(Integer.parseInt(portTextField
//							.getText()));
//					Thread serverThread = (new Thread(server));
//					serverThread.setName("Server Thread");
//					serverThread.setDaemon(true);
//					serverThread.start();
//					threads.add(serverThread);
//					/* Change the view of the primary stage */
//					primaryStage.hide();
//					primaryStage.setScene(makeServerUI(server));
//					primaryStage.show();
//				}catch(IllegalArgumentException e){
//					errorLabel.setText("Invalid port number");
//				} catch (IOException ex) {
//                            }
//				
//			}
//		});
//		
//		/* Add the views to the pane */
//		rootPane.add(portText, 0, 0);
//		rootPane.add(portTextField, 0, 1);
//		rootPane.add(portApprovalButton, 0, 2);
//		rootPane.add(errorLabel, 0, 3);
//		/*
//		 * Make the Scene and return it Scene has constructor (Parent, Width,
//		 * Height)
//		 */
//		return new Scene(rootPane, 400, 300);
//	}
//	public Scene makeServerUI(Server server){
//		/* Make the root pane and set properties */
//		GridPane rootPane = new GridPane();
//		rootPane.setAlignment(Pos.CENTER);
//		rootPane.setPadding(new Insets(20));
//		rootPane.setHgap(10);
//		rootPane.setVgap(10);
//		
//		/* Make the server log ListView */
//		Label logLabel = new Label("Server Log");
//		ListView<String> logView = new ListView<String>();
//		ObservableList<String> logList = server.serverLog;
//		logView.setItems(logList);
//		
//		/* Make the client list ListView */
//		Label clientLabel = new Label("Clients Connected");
//		ListView<String> clientView = new ListView<String>();
//		ObservableList<String> clientList = server.clientNames;
//		clientView.setItems(clientList);
//		
//		/* Add the view to the pane */
//		rootPane.add(logLabel, 0, 0);
//		rootPane.add(logView, 0, 1);
//		rootPane.add(clientLabel, 0, 2);
//		rootPane.add(clientView, 0, 3);
//		
//		/* Make scene and return it,
//		 * Scene has constructor (Parent, Width, Height)
//		 *  */
//		return new Scene(rootPane, 400, 600);
//	}
//     
//    @FXML
//    private void serveur(MouseEvent event) {
//   Stage primaryStage = new Stage();
//        threads = new ArrayList<Thread>();
//		primaryStage.setTitle("Serveur admin");
//		primaryStage.setScene(makePortUI(primaryStage));
//		primaryStage.show();
//        
//        
//        
//    }

    @FXML
    private void Donation(MouseEvent event) {
        
        LoadUI("AdminOffre");
    }
//            template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/IntCategorie.fxml"))));

    }
    
    
    

