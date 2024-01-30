package Sistema_Gerencia_Estudantil.negocio;

import Sistema_Gerencia_Estudantil.dados.RepositorioMatricula;
import Sistema_Gerencia_Estudantil.negocio.beans.Matricula;

import java.util.List;

public class ControllerMatricula {

    private static ControllerMatricula instance;
    private RepositorioMatricula repositorioMatricula; // conexão com a camada de dados do repositório.

    /* Método construtor */
    private ControllerMatricula() {
        this.repositorioMatricula = new RepositorioMatricula();
    }

    /* Implementação do Singleton Pattern */
    public static ControllerMatricula getInstance() {
        if (instance == null) {
            instance = new ControllerMatricula();
        }
        return instance;
    }

    public void inserir(Matricula objeto) {
        repositorioMatricula.inserirMatricula(objeto);
    }

    public List<Matricula> listar() {
        return repositorioMatricula.listarMatriculas();
    }

    public void remover(Matricula objeto) {
        repositorioMatricula.removerMatricula(objeto);
    }

    public void atualizar(Matricula novoObjeto) {
        repositorioMatricula.atualizarMatricula(novoObjeto);
    }
}
