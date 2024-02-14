package Sistema_Gerencia_Estudantil.gui;

import java.io.IOException;

import Sistema_Gerencia_Estudantil.MainApp;
import Sistema_Gerencia_Estudantil.exceptions.ProfessorJaExisteException;
import Sistema_Gerencia_Estudantil.negocio.Fachada;
import Sistema_Gerencia_Estudantil.negocio.beans.Professor;
import Sistema_Gerencia_Estudantil.negocio.beans.Matricula;
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

public class TelaGestaoController {

    @FXML
    private Button btnCadastrarProfessor;

    @FXML
    private Button btnCriarTurma;

    @FXML
    private Button btnMatricularAluno;

    @FXML
    private Button btnVoltar;

    @FXML
    private ImageView imgViewIcon;

    @FXML
    private Label labelUserName;

    @FXML
    private Label labelWelcome;
    
    Parent root;
    Scene scene;
    Stage stage;

    @FXML
    void btnCadastrarProfessorClicked(ActionEvent event) throws ProfessorJaExisteException {
    		Professor p = new Professor(null, null, null, null);
    		Fachada.getInstance().cadastrarProfessor(p);
    }

    @FXML
    void btnCriarTurmaClicked(ActionEvent event) {
    		
    }

    @FXML
    void btnMatricularAlunoClicked(ActionEvent event) {
    	Matricula m = new Matricula(null, null, 0, 0);
    	Fachada.getInstance().inserirMatricula(m);
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