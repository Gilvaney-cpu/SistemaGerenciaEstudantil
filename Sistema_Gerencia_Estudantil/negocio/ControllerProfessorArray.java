package Sistema_Gerencia_Estudantil.negocio;

import Sistema_Gerencia_Estudantil.dados.RepositorioProfArray;
import Sistema_Gerencia_Estudantil.dados.RepositorioProfessorArray;
import Sistema_Gerencia_Estudantil.negocio.beans.Professor;

/**
 * @author Ramon Vilela
 */
public class ControllerProfessorArray {

    private RepositorioProfArray repositorioProfArray;

    /* Método Construtor */
    public ControllerProfessorArray() {
        repositorioProfArray = new RepositorioProfArray(100);
    }

    /* Método que cadastra um professor no repositório - Create */
    public void cadastrarProf(Professor p) {
        if(p != null
                && !this.repositorioProfArray.existe(p.getCPF())) {
            this.repositorioProfArray.inserirProf(p);
        } else {
            /* Oportunidade para lidar com o caso de Exceptions */
        }
    }

    /* Método que busca um professor no repositorio e retorna objeto Professor, caso exista - Read */
    public Professor procurar(Professor p) {
        return this.repositorioProfArray.procurarProf(p.getCPF());
    }

    /* Método que verifica se o professor passado como parâmetro está no repositorio
    * Devolve um boolean 'true' caso o professor esteja presente */
    public boolean existe(Professor p) {
        return  this.repositorioProfArray.existe(p.getCPF());
    }

    /* Método que remove o professor passado como parâmetro do repositório  - Delete */
    public void descadastrarProf(Professor professor) {
        Professor p = this.repositorioProfArray.procurarProf(professor.getCPF());
        if(p != null ) {
            this.repositorioProfArray.removerProf(professor.getCPF());
        } else {
            // oportunidade de exceptions aqui
        }
    }

    public RepositorioProfArray getRepositorioProfArray() {
        return repositorioProfArray;
    }

    public void setRepositorioProfArray(RepositorioProfArray repositorioProfArray) {
        this.repositorioProfArray = repositorioProfArray;
    }
}
