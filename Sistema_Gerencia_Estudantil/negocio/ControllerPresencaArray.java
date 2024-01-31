package Sistema_Gerencia_Estudantil.negocio;

import Sistema_Gerencia_Estudantil.dados.RepositorioPresencaArray;
import Sistema_Gerencia_Estudantil.exceptions.PresencaJaExisteException;
import Sistema_Gerencia_Estudantil.exceptions.PresencaNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.beans.Presenca;


public class ControllerPresencaArray {

    private RepositorioPresencaArray repositorioPresencaArray;
    private static ControllerPresencaArray instance;

    private ControllerPresencaArray() {

        this.repositorioPresencaArray = RepositorioPresencaArray.getInstance();
    }

    public static ControllerPresencaArray getInstance() {
        if(instance == null) {
            instance = new ControllerPresencaArray();
        }
        return instance;
    }

    /* Método que insere uma Presenca no repositório - Create */
    public void inserir(Presenca p) throws PresencaJaExisteException {
        if(p != null && (!repositorioPresencaArray.existePresenca(p))) {
            repositorioPresencaArray.cadastrarPresenca(p);
            repositorioPresencaArray.salvarArquivo();
        } else {
            if(p == null) {
                throw new IllegalArgumentException("Parâmetro passado é inválido!");
            } else {
                throw new PresencaJaExisteException(p.getIdAluno());
            }
        }
    }

    /* Devolve um boolean (true) se a Presenca passada como parâmetro existe no repositorio */
    public boolean existe(Presenca p) {
        boolean resposta = false;
        if(p != null) {
            resposta = repositorioPresencaArray.existePresenca(p);
        }
        return resposta;
    }

    /* Retorna uma Presenca que esteja inserida no repositório - Read */
    public Presenca procurar(Presenca p) throws PresencaNaoExisteException {
        return repositorioPresencaArray.procurarPresenca(p);
    }

    /* Remove uma Presenca do repositório, se ela estiver nele - Delete*/
    public void remover(Presenca p) throws PresencaNaoExisteException {
        Presenca presenca = repositorioPresencaArray.procurarPresenca(p);
        if(p != null) {
            repositorioPresencaArray.removerPresenca(presenca);
            repositorioPresencaArray.salvarArquivo();
        } else {
            throw new PresencaNaoExisteException(p.getIdAluno());
        }
    }

}
