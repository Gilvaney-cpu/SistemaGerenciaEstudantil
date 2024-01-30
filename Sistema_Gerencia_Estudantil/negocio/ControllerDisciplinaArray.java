package Sistema_Gerencia_Estudantil.negocio;


import Sistema_Gerencia_Estudantil.dados.RepositorioDisciplinaArray;
import Sistema_Gerencia_Estudantil.exceptions.DisciplinaJaExisteException;
import Sistema_Gerencia_Estudantil.exceptions.DisciplinaNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.beans.Disciplina;

public class ControllerDisciplinaArray {

    private RepositorioDisciplinaArray repositorioDisciplinaArray;
    private static ControllerDisciplinaArray instance;

    /* Método construtor */
    private ControllerDisciplinaArray() {
        //repositorioDisciplinaArray = new RepositorioDisciplinaArray(100);
        repositorioDisciplinaArray = RepositorioDisciplinaArray.getInstance();
    }

    /* Implementação Padrão Singleton */
    public static ControllerDisciplinaArray getInstance() {
        if(instance == null) {
            instance = new ControllerDisciplinaArray();
        }

        return instance;
    }

    /* Método que cadastra uma disciplina no repositório - Create */
    public void cadastrarDisciplina(Disciplina d) throws DisciplinaJaExisteException {

        if(d != null
                && !this.repositorioDisciplinaArray.existe(d)) {
            this.repositorioDisciplinaArray.inserirDisciplina(d);
            this.repositorioDisciplinaArray.salvarArquivo();
        } else {
            if (d == null) {
                throw new IllegalArgumentException("Parâmetro passado é inválido!");
            } else {
            throw new DisciplinaJaExisteException(d.getNome());
            }
        }
    }

    /* Método que retorna uma disciplina passada como parâmetro, se ela constar no repositório */
    public Disciplina procurar(Disciplina d) throws DisciplinaNaoExisteException {
        return this.repositorioDisciplinaArray.procurarDisciplina(d);

    }

    /* Método que remove do repositório a disciplina passada como parâmetro - Delete */
    public void remover (Disciplina disciplina) throws DisciplinaNaoExisteException {
        Disciplina disc = this.repositorioDisciplinaArray.procurarDisciplina(disciplina);
        if(disc != null) {
            this.repositorioDisciplinaArray.removerDisciplina(disc);
            this.repositorioDisciplinaArray.salvarArquivo();
        } else {
            // oportunidade de exceptions aqui
            throw new DisciplinaNaoExisteException(disciplina.getNome());
        }
    }

    /* Devolve um boolean (true) se o parâmetro passado existe no repositorio */
    public boolean existe(Disciplina d) {
        return this.repositorioDisciplinaArray.existe(d);
    }

}
