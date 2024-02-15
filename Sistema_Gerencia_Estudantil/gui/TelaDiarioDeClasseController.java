package Sistema_Gerencia_Estudantil.gui;

import java.io.IOException;

import Sistema_Gerencia_Estudantil.MainApp;
import Sistema_Gerencia_Estudantil.exceptions.ProfessorNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TelaDiarioDeClasseController {

    @FXML
    private Button btnAtribuirNota;

    @FXML
    private Button btnRealizarFrequencia;

    @FXML
    private Button btnVerTurmas;

    @FXML
    private Button btnVoltar;

    @FXML
    private ImageView imgViewIcon;

    @FXML
    private Label labelUserName;

    @FXML
    private Label labelWelcome;

    Parent root;
    Stage stage;
    Scene scene;
    
    @FXML
    void btnAtribuirNotasClicked(ActionEvent event) {

    		Fachada.getInstance().atribuirNota(null, null, null, null, 0);
    }

    @FXML
    void btnRealizarFrequenciaClicked(ActionEvent event) {

    		Fachada.getInstance().atribuirNota(null, null, null, null, 0);
    }

    @FXML
    void btnVerTurmasClicked(ActionEvent event) throws Exception {

    	Fachada.getInstance().procurarProfessor(null).getTurma().toArray().toString();
    }

    @FXML
    void btnVoltarClicked(ActionEvent event) throws IOException {
    	stage = (Stage) btnVoltar.getScene().getWindow();
     	FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("gui/telaOpcoesProfessor.fxml"));
         scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sistema Gerencia Estudantil");
         stage.getIcons().add(new Image("sge-icon.png"));
         stage.setScene(scene);
         stage.show();
         labelWelcome.setText(null);
    }

}