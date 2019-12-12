/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import template.Template;
import client.Client;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.User;
import entities.evenement;
import entities.produit_donation;
import service.MyServiceDonation;
import util.Authentification;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import server.Server;

/**
 * FXML Controller class
 *
 * @author AHMED
 */
public class AjouterDoController implements Initializable {

    @FXML
    private JFXTextField nom_do;
    @FXML
    private JFXTextArea description_do;
    @FXML
    private ImageView image_p;
    @FXML
    private JFXTextField adresse_do;
    @FXML
    private TextField tel_do;
    @FXML
    private RadioButton garcon_do;
    @FXML
    private RadioButton fille_do;
    
    
    private ToggleGroup toggle;
    
     private Path pathfrom;
    private Path pathto;
    private File Current_file;
         private String file_image ;
 private final User currentUser=Authentification.user;
     final FileChooser fileChooser = new FileChooser();
    

     
     
      private Desktop desktop = Desktop.getDesktop();
     /* hedhia t7otha fel client wel admin : (server / client)  */
         public static ArrayList<Thread> threads;

    private MyServiceDonation ms=new MyServiceDonation();
    @FXML
    private Button fichier;
    @FXML
    private Button ajoutDo;
    @FXML
    private ComboBox<String> categorie;
    @FXML
    private FontAwesomeIconView webcamf;

    

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggle =new ToggleGroup();
                  this.fille_do.setToggleGroup(toggle);
                  this.garcon_do.setToggleGroup(toggle);
                  this.garcon_do.setSelected(true);
                  
                  
                  categorie.getItems().add("Vétements");
                     categorie.getItems().add("Outils scolaire ");
                      categorie.getItems().add("Jeux");
                 categorie.getSelectionModel().selectFirst();

        // TODO
    }    

       
    private void addButton(ActionEvent event) throws IOException {
        
        /*produit_donation prod=new  produit_donation();
        
        prod.setNom(nom_do.getText());
        prod.setAdresse(adresse_do.getText());
        prod.setDescription(description_do.getText());
           prod.setEtat("En attente");
           
            if (this.toggle.getSelectedToggle().equals(this.fille_do))
            {
                   prod.setGenre("Fille");
                   
            }
            
        else
            
            {
      
             prod.setGenre("Garçon");

            }
            
        prod.setTel(Integer.parseInt(tel_do.getText()));
        
             file_image="/images/"+file_image;
   prod.setImage(file_image);
        
        
            pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
            pathto = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\web\\images\\"+Current_file.getName());
            Path targetDir = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\web\\images\\");
                    
            Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);

            ms.insertionProd(prod);*/
        
        
        /*Hedha bouton lel admin bech yactivi el server*/
         Stage primaryStage = new Stage();
        threads = new ArrayList<Thread>();
		primaryStage.setTitle("Serveur admin");
		primaryStage.setScene(makePortUI(primaryStage));
		primaryStage.show();
            
    }

 @FXML
   private void fichier_image(ActionEvent event) throws MalformedURLException {
        
        Current_file = fileChooser.showOpenDialog(Template.getInstance().getStage());
                    if (Current_file != null) {
//                        openFile(file);
                        System.out.println(Current_file.toURI().toURL().toExternalForm());
                     file_image= Current_file.getName();
                    }
        
         
    Image image2 = new Image(Current_file.toURI().toString());
image_p.setImage(image2);
          
                    
                    
        final GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(fichier, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));    
        
    }
 
     private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                AjouterDoController.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
     
     
  
     
     
     /*Hedha bouton lel client bech iconnecti lel chat */
    private void chat(ActionEvent event) {
         Stage primaryStage = new Stage();
        threads = new ArrayList<Thread>();
		primaryStage.setTitle("JavaFX Chat Client");
		primaryStage.setScene(makeInitScene(primaryStage));
		primaryStage.show();
    }
    
    
    
    
    /*Hedhom lil admin bech i7el el serveur */
     public Scene makePortUI(Stage primaryStage) {
		/* Make the root and set properties */
		GridPane rootPane = new GridPane();
		rootPane.setPadding(new Insets(20));
		rootPane.setVgap(10);
		rootPane.setHgap(10);
		rootPane.setAlignment(Pos.CENTER);

		/* Text label and field for port Number */
		Text portText = new Text("Port Number");
		Label errorLabel = new Label();
		errorLabel.setTextFill(Color.RED);
		TextField portTextField = new TextField("8888");
                portTextField.setDisable(true);
		portText.setFont(Font.font("Tahoma"));
		/*
		 * "Done" button and its click handler When clicked, another method is
		 * called
		 */
		Button portApprovalButton = new Button("Activer server");
		portApprovalButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				/* Make the server and it's thread, and run it */
				try {
					Server server = new Server(Integer.parseInt(portTextField
							.getText()));
					Thread serverThread = (new Thread(server));
					serverThread.setName("Server Thread");
					serverThread.setDaemon(true);
					serverThread.start();
					threads.add(serverThread);
					/* Change the view of the primary stage */
					primaryStage.hide();
					primaryStage.setScene(makeServerUI(server));
					primaryStage.show();
				}catch(IllegalArgumentException e){
					errorLabel.setText("Invalid port number");
				} catch (IOException ex) {
                            }
				
			}
		});
		
		/* Add the views to the pane */
		rootPane.add(portText, 0, 0);
		rootPane.add(portTextField, 0, 1);
		rootPane.add(portApprovalButton, 0, 2);
		rootPane.add(errorLabel, 0, 3);
		/*
		 * Make the Scene and return it Scene has constructor (Parent, Width,
		 * Height)
		 */
		return new Scene(rootPane, 400, 300);
	}
	public Scene makeServerUI(Server server){
		/* Make the root pane and set properties */
		GridPane rootPane = new GridPane();
		rootPane.setAlignment(Pos.CENTER);
		rootPane.setPadding(new Insets(20));
		rootPane.setHgap(10);
		rootPane.setVgap(10);
		
		/* Make the server log ListView */
		Label logLabel = new Label("Server Log");
		ListView<String> logView = new ListView<String>();
		ObservableList<String> logList = server.serverLog;
		logView.setItems(logList);
		
		/* Make the client list ListView */
		Label clientLabel = new Label("Clients Connected");
		ListView<String> clientView = new ListView<String>();
		ObservableList<String> clientList = server.clientNames;
		clientView.setItems(clientList);
		
		/* Add the view to the pane */
		rootPane.add(logLabel, 0, 0);
		rootPane.add(logView, 0, 1);
		rootPane.add(clientLabel, 0, 2);
		rootPane.add(clientView, 0, 3);
		
		/* Make scene and return it,
		 * Scene has constructor (Parent, Width, Height)
		 *  */
		return new Scene(rootPane, 400, 600);
	}
        
        
        /*Hedhom teb3in el bouton mta3 li bech ya7ki : EL CLIENT */
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
			}
		});

		/* Add the components to the root pane */
		rootPane.add(chatListView, 0, 0);
		rootPane.add(chatTextField, 0, 1);

		/* Make and return the scene */
		return new Scene(rootPane, 400, 400);

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

   
            
       private boolean testNumberInput(String a)
    {
        boolean b=false;
        if(a.matches("^[0-9]*"))
        {
            b=true;
        }
        return b;
    }
        
        
        @FXML
    private void ajoutDo(ActionEvent event) throws IOException {
        
        
         produit_donation prod=new  produit_donation();
        
        prod.setNom(nom_do.getText());
        prod.setAdresse(adresse_do.getText());
        prod.setDescription(description_do.getText());
           prod.setEtat("En attente");
           
            if (this.toggle.getSelectedToggle().equals(this.fille_do))
            {
                   prod.setGenre("Fille");
                   
            }
            
        else
            
            {
      
             prod.setGenre("Garçon");

            }
            
        prod.setTel(Integer.parseInt(tel_do.getText()));
               
             
       file_image="/images/"+file_image;
      

            prod.setIdu(currentUser.getId());
            prod.setAppro(0);
            prod.setNomuser(currentUser.getUsername());
            prod.setCategorie(categorie.getValue());
             
            
            if(nom_do.getText().length()==0){
    nom_do.setStyle("-fx-text-inner-color: red");
            nom_do.setStyle("-fx-prompt-text-fill: red");
            nom_do.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez nommer votre donation!");
            alert.showAndWait();
            nom_do.setCursor(Cursor.WAIT);
            nom_do.setStyle("-fx-text-inner-color:  #663399");
            nom_do.setStyle("-fx-prompt-text-fill:  #663399");

   
   }
            
            else if (description_do.getText().length()==0){
            
            
            
            description_do.setStyle("-fx-text-inner-color: red");
            description_do.setStyle("-fx-prompt-text-fill: red");
            description_do.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez insérer la description!");
            alert.showAndWait();
            description_do.setCursor(Cursor.WAIT);
            description_do.setStyle("-fx-text-inner-color:  #663399");
            description_do.setStyle("-fx-prompt-text-fill:  #663399");

            
            
            
            }
                      else if (adresse_do.getText().length()==0){
            
            
            
            adresse_do.setStyle("-fx-text-inner-color: red");
            adresse_do.setStyle("-fx-prompt-text-fill: red");
            adresse_do.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez insérer la description!");
            alert.showAndWait();
            adresse_do.setCursor(Cursor.WAIT);
            adresse_do.setStyle("-fx-text-inner-color:  #663399");
            adresse_do.setStyle("-fx-prompt-text-fill:  #663399");

            
            
            
            }
            
                           
            
            
                            else if(file_image.length()==8 )
                                
                            {
                            
                            
                             
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez insérer l'image !");
            alert.showAndWait();
        
                            }
            
              
        
        
               else{
                                 prod.setImage(file_image);
            pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
            pathto = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\web\\images\\"+Current_file.getName());
            Path targetDir = FileSystems.getDefault().getPath("C:\\xampp\\htdocs\\datatable_21\\web\\images\\");
                    
            Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);

            
            ms.insertionProd(prod);
                                 template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/MyMenuDoFXML.fxml"))));   

                       }

    }



        @FXML
    private void imageDragOver(DragEvent event) {
             Dragboard board = event.getDragboard();
      if (board.hasFiles()) {
        event.acceptTransferModes(TransferMode.ANY);
      }
        
    }

    @FXML
    private void imageDropped(DragEvent event) throws FileNotFoundException {
                  Dragboard board = event.getDragboard();
        List<File> phil = board.getFiles();
        FileInputStream fis;
          fis = new FileInputStream(phil.get(0));
        Image image = new Image(fis);
      File selectedFile = phil.get(0);
        if (selectedFile != null) {
           
         String test = selectedFile.getAbsolutePath();
            System.out.println(test);
            
            Current_file=selectedFile.getAbsoluteFile();
            file_image=Current_file.getName();
           evenement e= new evenement();
           e.setImage(selectedFile.getName());
          image_p.setImage(image);
    }
    
  

    

    }

   

    @FXML
    private void webcamF(MouseEvent event) throws IOException {
          Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/WebCamPreview.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        

        
    }

    @FXML
    private void testNumber(KeyEvent event) {
        
        
         if(this.testNumberInput(tel_do.getText()))
    {
       
        System.out.println("correct");
        
    }
    else
    {
         Alert a =new Alert(Alert.AlertType.ERROR, " insérer seulement des chiffres ", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
     
        
    }
    }

   

    
    
}