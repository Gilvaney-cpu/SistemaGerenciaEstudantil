package Sistema_Gerencia_Estudantil.gui;

import java.io.IOException;

import Sistema_Gerencia_Estudantil.MainApp;
import Sistema_Gerencia_Estudantil.exceptions.ProfessorJaExisteException;
import Sistema_Gerencia_Estudantil.exceptions.ProfessorNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.Fachada;
import Sistema_Gerencia_Estudantil.negocio.beans.Professor;
import Sistema_Gerencia_Estudantil.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class TelaInicialController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private String cpf;
	private String senha;
	private String nome;

    @FXML
    private Button btnCadastro;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField txtField;
    
    @FXML private TextField txtNome;	//nome do usuario logado [NOVO CODIGO]
    
    @FXML
    Alert alert;
    @FXML
    private Button btnDiarioDeClasse;
    
     /* @FXML
    private Label labelUserNome;*/
    
    @FXML
    public void btnLoginClicked(ActionEvent event) throws IOException, ProfessorNaoExisteException, ProfessorJaExisteException {
    	ActionEvent e = event;
    	/* Validação do CPF e Senha do usuário */
    	cpf = txtField.getText().toString();
    	senha = passwordField.getText().toString();
    	Professor p = new Professor("",cpf,senha,"");
    	boolean b = validacao(cpf,senha);
    	
    	
    	//labelUserNome.setText(p.getNome());
    	if(cpf.isBlank() || senha.isBlank())
    	{
    		alert = new Alert(AlertType.WARNING);
        	alert.setTitle("Aviso");
        	alert.setHeaderText("Não existe o CPF ' "+ cpf + " ' no sistema.");
        	alert.setContentText("Insira novamente seu CPF e SENHA!");
        	alert.show();
        	txtField.clear();
        	passwordField.clear();
    	}
    	
    	if(b) {
    		 Object obj = new Object();
    		 obj = Fachada.getInstance().procurarProfessor(p);
    		
    		System.out.println("Professor LOGADO - TELA PROFESSOR");
    		String nome = p.getNome();
    		stage = (Stage) btnLogin.getScene().getWindow();
        	FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("gui/telaOpcoesProfessor.fxml"));
            scene = new Scene(fxmlLoader.load());
            stage.setTitle("Sistema Gerencia Estudantil");
            stage.getIcons().add(new Image("sge-icon.png"));
            stage.setScene(scene);
            //scene.setUserData(p);
           // FachadaTela.getInstance().getTelaOpcoesProfessorController().initData((Professor)obj);
            stage.show();
             stage.setUserData(p.getNome());
            
            
            //scene.setUserData(p);
           // txtNome.setText(nome);
           // stage.setUserData(p);
            
            
    	} else {
    		alert = new Alert(AlertType.WARNING);
        	alert.setTitle("Aviso");
        	alert.setHeaderText("Não existe o CPF ' "+ cpf + " ' no sistema.");
        	alert.setContentText("Insira novamente seu CPF e SENHA!");
        	alert.show();
        	txtField.clear();
        	passwordField.clear();
    	}
    	
    	/*
    	if(p != null && Fachada.getInstance().procurarProfessor(p).getCPF().equalsIgnoreCase(cpf)) {
    			//&& Fachada.getInstance().procurarProfessor(p).getSenha().equalsIgnoreCase(senha) ) {
    	System.out.println("Siga adiante!");
    	} else {
    		
    		alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Aviso");
        	alert.setHeaderText("Não existe esse CPF no sistema.");
        	alert.setContentText("Insira novamente seu cpf e senha!");
        	alert.show();
        	//throw new ProfessorNaoExisteException(cpf);
    	}
    	*/
    	/*
    	/* Snippet pra trocar de tela 
    	root = FXMLLoader.load(getClass().getResource("/gui/TelaOpcoesProfessor.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.getIcons().add(new Image("sge-icon.png"));
		stage.setTitle("Sistema de Gerencia Estudantil");
    	stage.setScene(scene);
    	stage.show();
    	*/
    	/* if { //checar se existe alguem no repositorio com nome e senha
    	 * 		// checar se a senha está correta
    	 * } else {
    	 * alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Aviso");
    	alert.setHeaderText("CONTA NÃO ENCONTRADA");
    	alert.setContentText("Insira os dados novamente!");
    	alert.show();
    	 * }*/
    			
    }
    
    @FXML
public void btnCadastroClicked(ActionEvent event) throws IOException {
    	
    	
    	alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Aviso");
    	alert.setHeaderText("Procure sua equipe gestora para ter acesso.");
    	alert.setContentText("Somente pessoas autorizadas podem fazer a inserção no sistema!");
    	alert.show();
    }
    
    
    @SuppressWarnings("unused")
	public boolean validacao(String cpf, String senha) throws ProfessorJaExisteException {
    	boolean certo = false;
    	
    	String cpfBuscado = cpf;
    	String senhaBuscada = senha;
    	Professor p4 = new Professor("Marcelo Carneiro Leao", "64027277090", "password4","8558");
    	Fachada.getInstance().cadastrarProfessor(p4);
    	try {
			if(Fachada.getInstance().procurarProfessor(p4).getCPF().equals(cpf)
					&& Fachada.getInstance().procurarProfessor(p4).getSenha().equals(senha)){
				certo = true;
			};
		} catch (ProfessorNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return certo;
    }
    
    /*  setUserData(Object)*/
    /*
    private void sendData(ActionEvent event) {
    	  // Step 1
    	  Usuario u = new Usuario(p);
    	  // Step 2
    	  Node node = (Node) event.getSource();
    	  // Step 3
    	  Stage stage = (Stage) node.getScene().getWindow();
    	  stage.close();
    	  try {
    	    // Step 4
    	    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/telaInicial.fxml"));
    	    // Step 5
    	    stage.setUserData(u);
    	    // Step 6
    	    Scene scene = new Scene(root);
    	    stage.setScene(scene);
    	    // Step 7
    	    stage.show();
    	  } catch (IOException e) {
    	    System.err.println(String.format("Error: %s", e.getMessage()));
    	  }
    	}*/
    /*
    public void inicializar() throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("gui/telaOpcoesProfessor.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sistema Gerencia Estudantil");
        stage.getIcons().add(new Image("sge-icon.png"));
        stage.setScene(scene);
    }*/
}

