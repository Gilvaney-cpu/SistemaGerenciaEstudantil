package Sistema_Gerencia_Estudantil.negocio;


import Sistema_Gerencia_Estudantil.dados.RepositorioDisciplinaArray;
import Sistema_Gerencia_Estudantil.negocio.beans.Disciplina;

public class ControllerDisciplinaArray {

    private RepositorioDisciplinaArray repositorioDisciplinaArray;
    private static ControllerDisciplinaArray instance;

    /* Método construtor */
    private ControllerDisciplinaArray() {
        repositorioDisciplinaArray = new RepositorioDisciplinaArray(100);
    }

    /* Implementação Padrão Singleton */
    public static ControllerDisciplinaArray getInstance() {
        if(instance == null) {
            instance = new ControllerDisciplinaArray();
        }

        return instance;
    }

    /* Método que cadastra uma disciplina no repositório - Create */
    public void cadastrarDisciplina(Disciplina d) {

        if(d != null && !this.repositorioDisciplinaArray.existe(d)) {
            this.repositorioDisciplinaArray.inserirDisciplina(d);
        } else {
            /* Oportunidade para lidar com o caso de Exceptions */
        }
    }

    /* Método que retorna uma disciplina passada como parâmetro, se ela constar no repositório */
    public Disciplina procurar(Disciplina d) {
        return this.repositorioDisciplinaArray.procurarDisciplina(d);
    }

    /* Método que remove do repositório a disciplina passada como parâmetro - Delete */
    public void remover(Disciplina disciplina) {
        Disciplina d = this.repositorioDisciplinaArray.procurarDisciplina(disciplina);
        if(d != null) {
            this.repositorioDisciplinaArray.removerDisciplina(d);
        } else {
            // oportunidade de exceptions aqui
        }
    }

    /* Devolve um boolean (true) se o parâmetro passado existe no repositorio */
    public boolean existe(Disciplina d) {
        return this.repositorioDisciplinaArray.existe(d);
    }

}
