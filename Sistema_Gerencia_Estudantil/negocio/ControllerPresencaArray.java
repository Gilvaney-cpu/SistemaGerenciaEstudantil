package Sistema_Gerencia_Estudantil.negocio;

import Sistema_Gerencia_Estudantil.dados.RepositorioPresencaArray;
import Sistema_Gerencia_Estudantil.negocio.beans.Presenca;

/**
 * Singleton Pattern
 */
public class ControllerPresencaArray {

    private RepositorioPresencaArray repositorioPresencaArray;
    private static ControllerPresencaArray instance;

    private ControllerPresencaArray() {
        this.repositorioPresencaArray = new RepositorioPresencaArray(100);
    }

    public static ControllerPresencaArray getInstance() {
        if(instance == null) {
            instance = new ControllerPresencaArray();
        }
        return instance;
    }

    /* Método que insere uma Presenca no repositório - Create */
    public void inserir(Presenca p) {
        if(p != null && (!repositorioPresencaArray.existePresenca(p))) {
            repositorioPresencaArray.cadastrarPresenca(p);
        } else {
            /* Oportunidade para lidar com o caso de Exceptions
            * //throw new NaoExisteException();
            * */
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
    public Presenca procurar(Presenca p) {
        return repositorioPresencaArray.procurarPresenca(p);
    }

    /* Remove uma Presenca do repositório, se ela estiver nele - Delete*/
    public void remover(Presenca p) {
        Presenca presenca = repositorioPresencaArray.procurarPresenca(p);
        if(p != null) {
            repositorioPresencaArray.removerPresenca(presenca);
        } else {
            /* Possibilidade de levantamento de exceção
            * throw new NaoExisteException();
            * */
        }
    }

}
