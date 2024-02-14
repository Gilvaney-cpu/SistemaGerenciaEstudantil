package Sistema_Gerencia_Estudantil;
	
import java.io.IOException;

import Sistema_Gerencia_Estudantil.gui.FachadaTela;
//import Sistema_Gerencia_Estudantil.negocio.Fachada;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
//import javafx.stage.Window;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.image.*;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.paint.Color;


public class MainApp extends Application {
	/*
	@Override
	public void start(Stage stage) {
		//Stage stage = new Stage();
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600, Color.LIGHTSKYBLUE);
		
		Image icon = new Image("sge-icon.png");		//to set a image as a icon to the stage
		stage.getIcons().add(icon);
		stage.setTitle("Sistema de Gerencia Estudantil");
		stage.setScene(scene);
		stage.show(); // this should be at the bottom of start method
	}
	*/
	
	
	@Override
	public void start (Stage primaryStage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("gui/telaInicial.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	// para conseguir usar o css
		///* String cssFile = this.getClass().getResource("application.css").toExternalForm();		// linha adequada múltiplas cenas
		//scene.getStylesheets().add(cssFile); //
		
		primaryStage.setResizable(true);
		primaryStage.getIcons().add(new Image("sge-icon.png"));
		primaryStage.setTitle("Sistema Gerencia Estudantil");
		primaryStage.setScene(scene);//()FachadaTela.getInstance().getMainScene()
		primaryStage.show();

	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/*
	@Override
    public void start(Stage primaryStage) throws Exception {
    	primaryStage.setScene(FachadaTela.getInstance().getMainScene());
		primaryStage.setTitle("Sistema Gerencia Estudantil");
		
		primaryStage.getIcons().add(new Image("sge-icon.png"));
		FachadaTela.getInstance().setPrimaryStage(primaryStage);
		primaryStage.show();
    }*/
    /*
    public static void main(String[] args) {
        MainApp.launch(args);
    }*/
    

}
