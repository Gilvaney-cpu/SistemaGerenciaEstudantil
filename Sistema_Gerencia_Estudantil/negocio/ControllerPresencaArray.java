package Sistema_Gerencia_Estudantil.negocio;

import Sistema_Gerencia_Estudantil.dados.RepositorioPresencaArquivo;
import Sistema_Gerencia_Estudantil.exceptions.PresencaJaExisteException;
import Sistema_Gerencia_Estudantil.exceptions.PresencaNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.beans.Presenca;


public class ControllerPresencaArray {

    private RepositorioPresencaArquivo repositorioPresencaArquivo;
    private static ControllerPresencaArray instance;

    private ControllerPresencaArray() {

        this.repositorioPresencaArquivo = RepositorioPresencaArquivo.getInstance();
    }

    public static ControllerPresencaArray getInstance() {
        if(instance == null) {
            instance = new ControllerPresencaArray();
        }
        return instance;
    }

    /* Método que insere uma Presenca no repositório - Create */
    public void inserir(Presenca p) throws PresencaJaExisteException {
        if(p != null && (!repositorioPresencaArquivo.existePresenca(p))) {
            repositorioPresencaArquivo.cadastrarPresenca(p);
            //repositorioPresencaArray.salvarArquivo();
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
            resposta = repositorioPresencaArquivo.existePresenca(p);
        }
        return resposta;
    }

    /* Retorna uma Presenca que esteja inserida no repositório - Read */
    public Presenca procurar(Presenca p) throws PresencaNaoExisteException {
        return repositorioPresencaArquivo.procurarPresenca(p);
    }

    /* Remove uma Presenca do repositório, se ela estiver nele - Delete*/
    public void remover(Presenca p) throws PresencaNaoExisteException {
        Presenca presenca = repositorioPresencaArquivo.procurarPresenca(p);
        if(p != null) {
            repositorioPresencaArquivo.removerPresenca(presenca);
           // repositorioPresencaArray.salvarArquivo();
        } else {
            throw new PresencaNaoExisteException(p.getIdAluno());
        }
    }

}
