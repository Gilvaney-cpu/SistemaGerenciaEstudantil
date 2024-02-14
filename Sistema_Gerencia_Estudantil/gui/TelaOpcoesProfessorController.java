package Sistema_Gerencia_Estudantil.gui;

import java.io.IOException;

import Sistema_Gerencia_Estudantil.MainApp;
import Sistema_Gerencia_Estudantil.negocio.Fachada;
import Sistema_Gerencia_Estudantil.negocio.beans.Professor;
import Sistema_Gerencia_Estudantil.negocio.beans.Usuario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class TelaOpcoesProfessorController {

	@FXML
    private Button btnDiarioDeClasse;

    @FXML
    private Button btnGestao;

    @FXML
    private Button btnLogoff;

    @FXML
    private ImageView imgViewIcon;

    @FXML
    private Label labelUser;
    @FXML
    private Label labelWelcome;
    
    
    //Image image = new Image(getClass().getResourceAsStream("study-gray-icon.jpg"));
    Stage primaryStage;
    Parent root;
    Scene scene;
    
  // private Professor p = (Professor) Object.getUserData();
   // String nome = (String) primaryStage.getUserData();
    
    
    
    //TODO FALTA MAPEAR OS MÉTODOS E ALTERAR O ARQUIVO FXML NO SCENEBUILDER
    //TODO FALTA TBM VER OS MÉTODOS getUserData() [telaInicialController] e setUserData(Object) [telaOpcoesProfessorController]]
    
     
     @FXML
     public void btnLogoffClicked(ActionEvent event) throws IOException {
    	 primaryStage = (Stage) btnLogoff.getScene().getWindow();
     	FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("gui/telaInicial.fxml"));
         scene = new Scene(fxmlLoader.load());
         primaryStage.setTitle("Sistema Gerencia Estudantil");
         primaryStage.getIcons().add(new Image("sge-icon.png"));
         primaryStage.setScene(scene);
         //primaryStage.getUserData();
         
         
         
         
         
         
     }
     @FXML
     public void btnDiarioDeClasseClicked(ActionEvent event) throws IOException {
    	 System.out.println("Professor LOGADO - TELA DIARIO DE CLASSE");
    	 //primaryStage.getUserData();
    	 //primaryStage = (Stage) btnDiarioDeClasse.getScene().getWindow();

    	 //logoff
    	 
          //btnDiarioDeClasse
          primaryStage = (Stage) btnDiarioDeClasse.getScene().getWindow();
    	 FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("gui/telaDiarioDeClasse.fxml"));//trocar o path
          scene = new Scene(fxmlLoader.load());
          primaryStage.setTitle("Sistema Gerencia Estudantil");
          primaryStage.getIcons().add(new Image("sge-icon.png"));
          primaryStage.setScene(scene);
         // Professor p = (Professor) primaryStage.getUserData();
          //labelUser.setText(p.getNome());
          primaryStage.show();
          
          //primaryStage.getUserData();
     }
     @FXML
     public void btnGestaoClicked(ActionEvent event) throws IOException {
    	 System.out.println("Professor LOGADO - TELA GESTAO");
    	// primaryStage.getUserData();
    	 primaryStage = (Stage) btnGestao.getScene().getWindow();
       	FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("gui/telaGestao.fxml"));//trocar o path
           scene = new Scene(fxmlLoader.load());
           primaryStage.setTitle("Sistema Gerencia Estudantil");
           primaryStage.getIcons().add(new Image("sge-icon.png"));
           primaryStage.setScene(scene);
           //primaryStage.show();
           //primaryStage.getUserData();
     }
     /*
     public void inicializar() throws IOException {
    	 //primaryStage.getUserData();
     	//FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("gui/telaOpcoesProfessor.fxml"));
        // scene = new Scene(fxmlLoader.load());
        // primaryStage.setTitle("Sistema Gerencia Estudantil");
        // primaryStage.getIcons().add(new Image("sge-icon.png"));
        // primaryStage.setScene(scene);
        // primaryStage.show();
    	 scene.getUserData();
         labelUser.setText(((Professor) scene.getUserData()).getNome());
     }*/
     public void initData(Professor prof) {
    	 labelUser.setText("");
     }
}
