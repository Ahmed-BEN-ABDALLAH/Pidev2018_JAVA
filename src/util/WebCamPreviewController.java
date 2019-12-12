package util;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import com.github.sarxos.webcam.Webcam;
import com.mysql.jdbc.Buffer;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.controlsfx.control.Notifications;
import static sun.audio.AudioPlayer.player;


/**
 * This is controller for WebCamPreview FXML.
 * 
 * @author Rakesh Bhatt (rakeshbhatt10)
 */
public class WebCamPreviewController implements Initializable {

	@FXML
	Button btnStartCamera;

	@FXML
	Button btnStopCamera;

	@FXML
	Button btnDisposeCamera;

	@FXML
	ComboBox<WebCamInfo> cbCameraOptions;

	@FXML
	BorderPane bpWebCamPaneHolder;

	@FXML
	FlowPane fpBottomPane;

	@FXML
	ImageView imgWebCamCapturedImage;
    @FXML
    private Button capture;
    @FXML
    private Font x1;
   private Path pathfrom;
    @FXML
    private void capture(ActionEvent event) throws IOException {
     
     BufferedImage c=selWebCam.getImage();
pathfrom=FileSystems.getDefault().getPath("C:\\Users\\AHMED\\");
        ImageView i=new ImageView();
       java.util.Date d=new java.util.Date();
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
String s=dateFormat.format(d);
        System.out.println(s);
       File file= new File(s+"Pidev.jpg");
      ImageIO.write(c, "JPG", file);
       pathfrom = FileSystems.getDefault().getPath("C:\\Users\\AHMED\\Documents\\NetBeansProjects\\template\\"+file.getPath());
        System.out.println("______"+pathfrom);
            Path pathto = FileSystems.getDefault().getPath("C:\\Users\\AHMED\\Desktop\\"+file.getName());
            System.out.println("_ _ _ _"+pathto);
            Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
  
           stopCamera(event);
         Notifications n =Notifications.create().title("Notification")
             .text("Votre photo sur bureau")
             .graphic(null)
             .position(Pos.BASELINE_LEFT)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();

    }

	private class WebCamInfo {

		private String webCamName;
		private int webCamIndex;

		public String getWebCamName() {
			return webCamName;
		}

		public void setWebCamName(String webCamName) {
			this.webCamName = webCamName;
		}

		public int getWebCamIndex() {
			return webCamIndex;
		}

		public void setWebCamIndex(int webCamIndex) {
			this.webCamIndex = webCamIndex;
		}

		@Override
		public String toString() {
			return webCamName;
		}
	}

	private BufferedImage grabbedImage;
	private Webcam selWebCam = null;
	private boolean stopCamera = false;
	private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();

	private String cameraListPromptText = "Choose Camera";

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		fpBottomPane.setDisable(true);
		ObservableList<WebCamInfo> options = FXCollections.observableArrayList();
		int webCamCounter = 0;
		for (Webcam webcam : Webcam.getWebcams()) {
			WebCamInfo webCamInfo = new WebCamInfo();
			webCamInfo.setWebCamIndex(webCamCounter);
			webCamInfo.setWebCamName(webcam.getName());
			options.add(webCamInfo);
			webCamCounter++;
		}
		cbCameraOptions.setItems(options);
		cbCameraOptions.setPromptText(cameraListPromptText);
		cbCameraOptions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<WebCamInfo>() {

			@Override
			public void changed(ObservableValue<? extends WebCamInfo> arg0, WebCamInfo arg1, WebCamInfo arg2) {
				if (arg2 != null) {
					System.out.println("WebCam Index: " + arg2.getWebCamIndex() + ": WebCam Name:" + arg2.getWebCamName());
					initializeWebCam(arg2.getWebCamIndex());
				}
			}
		});
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				setImageViewSize();
			}
		});

	}

	protected void setImageViewSize() {

		double height = bpWebCamPaneHolder.getHeight();
		double width = bpWebCamPaneHolder.getWidth();
		imgWebCamCapturedImage.setFitHeight(height);
		imgWebCamCapturedImage.setFitWidth(width);
		imgWebCamCapturedImage.prefHeight(height);
		imgWebCamCapturedImage.prefWidth(width);
		imgWebCamCapturedImage.setPreserveRatio(true);

	}

	protected void initializeWebCam(final int webCamIndex) {

		Task<Void> webCamIntilizer = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				if (selWebCam == null) {
					selWebCam = Webcam.getWebcams().get(webCamIndex);
					selWebCam.open();
				} else {
					closeCamera();
					selWebCam = Webcam.getWebcams().get(webCamIndex);
					selWebCam.open();
				}
				startWebCamStream();
				return null;
			}

		};

		new Thread(webCamIntilizer).start();
		fpBottomPane.setDisable(false);
		btnStartCamera.setDisable(true);
	}

	protected void startWebCamStream() {

		stopCamera = false;
		Task<Void> task = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				while (!stopCamera) {
					try {
						if ((grabbedImage = selWebCam.getImage()) != null) {

							Platform.runLater(new Runnable() {

								@Override
								public void run() {
									final Image mainiamge = SwingFXUtils
										.toFXImage(grabbedImage, null);
									imageProperty.set(mainiamge);
								}
							});

							grabbedImage.flush();

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				return null;
			}

		};
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
		imgWebCamCapturedImage.imageProperty().bind(imageProperty);

	}

	private void closeCamera() {
		if (selWebCam != null) {
			selWebCam.close();
		}
	}

    @FXML
	public void stopCamera(ActionEvent event) {
		stopCamera = true;
		btnStartCamera.setDisable(false);
		btnStopCamera.setDisable(true);
                
                
	}

    @FXML
	public void startCamera(ActionEvent event) {
//		stopCamera = false;
//		startWebCamStream();
//		btnStartCamera.setDisable(true);
//		btnStopCamera.setDisable(false);
    //            BufferedImage image = ConverterFactory.convertToType(webcam.getImage(), BufferedImage.TYPE_3BYTE_BGR);
                
	}

    @FXML
	public void disposeCamera(ActionEvent event) {
		stopCamera = true;
		closeCamera();
		btnStopCamera.setDisable(true);
		btnStartCamera.setDisable(true);
                
	}
}
