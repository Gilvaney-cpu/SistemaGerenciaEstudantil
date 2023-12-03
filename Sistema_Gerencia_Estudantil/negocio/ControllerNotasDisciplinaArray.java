package Sistema_Gerencia_Estudantil.negocio;


import Sistema_Gerencia_Estudantil.dados.RepositorioNotasDisciplinaArray;
import Sistema_Gerencia_Estudantil.negocio.beans.NotasDisciplina;


public class ControllerNotasDisciplinaArray {

    private RepositorioNotasDisciplinaArray repositorioNotasDisciplinaArray;
    private static ControllerNotasDisciplinaArray instance;


    /* Método construtor */
    private ControllerNotasDisciplinaArray() {
        this.repositorioNotasDisciplinaArray = new RepositorioNotasDisciplinaArray(100);
    }

    /* Implementação Padrão Singleton */
    public static ControllerNotasDisciplinaArray getInstance() {
        if(instance == null) {
            instance = new ControllerNotasDisciplinaArray();
        }
        return instance;
    }

    /* Método que cadastra uma NotaDisciplina no repositório - Create */
    public void inserir(NotasDisciplina n) {

        if(n != null && (!this.repositorioNotasDisciplinaArray.existe(n))) {
            this.repositorioNotasDisciplinaArray.inserirNotasDisciplina(n);
        } else {
            /* Oportunidade para lidar com o caso de Exceptions */
        }
    }

    /* Devolve um boolean (true) se a NotasDisciplina  passada como parâmetro existe no repositorio */
    public boolean existe(NotasDisciplina n) {
        boolean confirmacao = false;
        if(n != null) {
            confirmacao = this.repositorioNotasDisciplinaArray.existe(n);
        }
        return confirmacao;
    }

    /* Retorna uma NotasDiciplina se ela estiver no repositório - Read */
    public NotasDisciplina procurar(NotasDisciplina n) {

        return this.repositorioNotasDisciplinaArray.procurarNotasDisciplina(n);
    }

    /* Remove uma NotasDiciplina do repositório, caso ela exista nele  - Delete */
    public void remover(NotasDisciplina n) {
        NotasDisciplina notinha = this.repositorioNotasDisciplinaArray.procurarNotasDisciplina(n);
        if(notinha != null) {
            this.repositorioNotasDisciplinaArray.removerNotaDisciplina(notinha);
        } else {
            // oportunidade de exceptions aqui (throw new NaoExisteException();)
        }
    }


}
