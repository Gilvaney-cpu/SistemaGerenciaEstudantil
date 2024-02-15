package Sistema_Gerencia_Estudantil.gui;

import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class FachadaTela {
	
	private Stage primaryStage;
	private Scene mainScene;
	private TelaInicialController telaInicialController;
	
	private Scene opcoesProfessor;
	private TelaOpcoesProfessorController telaOpcoesProfessorController;
	private Scene diarioDeClasse;
	private TelaDiarioDeClasseController telaDiarioDeClasseController;
	private Scene gestao;
	private TelaGestaoController telaGestaoController;
	
	
	private static FachadaTela instance;
	
	
	private FachadaTela() {
		this.inicializar();
	}
	
	public static FachadaTela getInstance() {
		if(instance == null) {
			instance = new FachadaTela();
		}
		
		return instance;
	}

	private void inicializar() {
		        
        //telaInicial
        try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			AnchorPane mainAnchorPane = fxmlLoader.load(getClass()
					.getResource("gui/telaInicial.fxml").openStream()); //.openStream());
			this.mainScene = new Scene(mainAnchorPane);
			this.telaInicialController = (TelaInicialController) fxmlLoader.getController(); //this.mainScreenController = (MainScreenController) fxmlLoader.getController();
			
			//telaOpcoesProfessor
			fxmlLoader = new FXMLLoader();
			AnchorPane opcoesProfessorPane = fxmlLoader.load(getClass()
					.getResource("gui/telaOpcoesProfessor.fxml").openStream());            
			this.opcoesProfessor = new Scene(opcoesProfessorPane); 
			this.telaOpcoesProfessorController = (TelaOpcoesProfessorController)fxmlLoader.getController();
			
			//telaDiarioDeClasse
			fxmlLoader = new FXMLLoader();
			BorderPane diarioDeClassePane = fxmlLoader.load(getClass()
			        .getResource("gui/telaDiarioDeClasse.fxml").openStream());
			this.diarioDeClasse = new Scene(diarioDeClassePane);
			this.telaDiarioDeClasseController = (TelaDiarioDeClasseController)fxmlLoader.getController();
			
			//telaGestao
			fxmlLoader = new FXMLLoader();
			BorderPane gestaoPane = fxmlLoader.load(getClass()
			        .getResource("gui/telaGestao.fxml").openStream());            
			this.gestao = new Scene(gestaoPane); 
			this.telaGestaoController = (TelaGestaoController) fxmlLoader.getController();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public Scene getMainScene() {
		return mainScene;
	}

	public TelaInicialController getTelaInicialController() {
		return telaInicialController;
	}

	public Scene getOpcoesProfessor() {
		return opcoesProfessor;
	}

	public TelaOpcoesProfessorController getTelaOpcoesProfessorController() {
		return telaOpcoesProfessorController;
	}

	public Scene getDiarioDeClasse() {
		return diarioDeClasse;
	}

	public TelaDiarioDeClasseController getTelaDiarioDeClasseController() {
		return telaDiarioDeClasseController;
	}

	public Scene getGestao() {
		return gestao;
	}

	public TelaGestaoController getTelaGestaoController() {
		return telaGestaoController;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	

}
