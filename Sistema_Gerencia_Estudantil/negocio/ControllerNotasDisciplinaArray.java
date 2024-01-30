package Sistema_Gerencia_Estudantil.negocio;


import Sistema_Gerencia_Estudantil.dados.RepositorioNotasDisciplinaArray;
import Sistema_Gerencia_Estudantil.exceptions.NotasDisciplinaJaExisteException;
import Sistema_Gerencia_Estudantil.exceptions.NotasDisciplinaNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.beans.NotasDisciplina;


public class ControllerNotasDisciplinaArray {

    private RepositorioNotasDisciplinaArray repositorioNotasDisciplinaArray;
    private static ControllerNotasDisciplinaArray instance;


    /* Método construtor */
    private ControllerNotasDisciplinaArray() {
        //this.repositorioNotasDisciplinaArray = new RepositorioNotasDisciplinaArray(100);
        this.repositorioNotasDisciplinaArray = RepositorioNotasDisciplinaArray.getInstance();
    }

    /* Implementação Padrão Singleton */
    public static ControllerNotasDisciplinaArray getInstance() {
        if(instance == null) {
            instance = new ControllerNotasDisciplinaArray();
        }
        return instance;
    }

    /* Método que cadastra uma NotaDisciplina no repositório - Create */
    public void inserir(NotasDisciplina n) throws NotasDisciplinaJaExisteException {

        if (n != null
                && (!this.repositorioNotasDisciplinaArray.existe(n))) {
            this.repositorioNotasDisciplinaArray.inserirNotasDisciplina(n);
            this.repositorioNotasDisciplinaArray.salvarArquivo();
        } else {
            if (n == null) {
                throw new IllegalArgumentException("Parâmetro passado é inválido!");
            } else {
                throw new NotasDisciplinaJaExisteException(n.getDisciplina().getNome());
            }
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
    public NotasDisciplina procurar(NotasDisciplina n) throws NotasDisciplinaNaoExisteException {

        return this.repositorioNotasDisciplinaArray.procurarNotasDisciplina(n);
    }

    /* Remove uma NotasDiciplina do repositório, caso ela exista nele  - Delete */
    public void remover(NotasDisciplina n) throws NotasDisciplinaNaoExisteException {
        NotasDisciplina notinha = this.repositorioNotasDisciplinaArray.procurarNotasDisciplina(n);
        if(notinha != null) {
            this.repositorioNotasDisciplinaArray.removerNotaDisciplina(notinha);
            this.repositorioNotasDisciplinaArray.salvarArquivo();
        } else {
            throw new NotasDisciplinaNaoExisteException(n.getDisciplina().getNome());
        }
    }


}
