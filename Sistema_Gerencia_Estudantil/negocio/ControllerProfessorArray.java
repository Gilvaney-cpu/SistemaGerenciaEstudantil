package Sistema_Gerencia_Estudantil.negocio;

import Sistema_Gerencia_Estudantil.dados.RepositorioProfArray;
import Sistema_Gerencia_Estudantil.dados.RepositorioProfessorArray;
import Sistema_Gerencia_Estudantil.exceptions.ProfessorJaExisteException;
import Sistema_Gerencia_Estudantil.exceptions.ProfessorNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.beans.*;

import java.time.LocalDate;


public class ControllerProfessorArray {

    private RepositorioProfArray repositorioProfArray;
    private static ControllerProfessorArray instance;

    /* Método Construtor */
    private ControllerProfessorArray() {
        //repositorioProfArray = new RepositorioProfArray(100);
        repositorioProfArray = RepositorioProfArray.getInstance();
    }

    public static ControllerProfessorArray getInstance() {
        if (instance == null) {
            instance = new ControllerProfessorArray();
        }
        return instance;
    }

    /* Método que cadastra um professor no repositório - Create */
    public void cadastrarProf(Professor p) throws ProfessorJaExisteException {
        if (p != null
                && !this.repositorioProfArray.existe(p.getCPF())) {
            this.repositorioProfArray.inserirProf(p);
            this.repositorioProfArray.salvarArquivo();
        } else {
            if (p == null) {
                throw new IllegalArgumentException("Parâmetro passado é inválido!");
            } else {

                throw new ProfessorJaExisteException(p.getCPF());
            }
        }
    }

    /* Método que busca um professor no repositorio e retorna objeto Professor, caso exista - Read */
    public Professor procurar(Professor p) throws ProfessorNaoExisteException {
        return this.repositorioProfArray.procurarProf(p.getCPF());
    }

    /* Método que verifica se o professor passado como parâmetro está no repositorio
     * Devolve um boolean 'true' caso o professor esteja presente */
    public boolean existe(Professor p) {
        return this.repositorioProfArray.existe(p.getCPF());
    }

    /* Método que remove o professor passado como parâmetro do repositório  - Delete */
    public void descadastrarProf(Professor professor) throws ProfessorNaoExisteException {
        Professor p = this.repositorioProfArray.procurarProf(professor.getCPF());
        if (p != null) {
            this.repositorioProfArray.removerProf(professor.getCPF());
            this.repositorioProfArray.salvarArquivo();
        } else {
            // oportunidade de exceptions aqui
            throw new ProfessorNaoExisteException(professor.getCPF());
        }
    }


    /* Método que insere uma nota para determinado aluno passado */
    public void atribuirNota(Professor professor, Turma turma, Disciplina disciplina, Aluno aluno, double nota) {
        /* Verifica se os parâmetros passados são nulos e se a nota (double) está entre 0 e 10 */
        if (((turma != null && disciplina != null) && (professor != null))
                && ((aluno != null) && (nota >= 0.0 && nota <= 10.0))) {
            /* percorre por todas as turmas do professor*/
            for (int i = 0; i < professor.getTurma().size(); i++) {
                /* Verifica se aluno, disciplina e turma são encontrados */
                if (aluno.equals(professor.getDisciplina().get(i).getAlunos().get(i))
                        && ((professor.getDisciplina().contains(disciplina) && professor.getTurma().contains(turma)))) {

                    professor.getDisciplina().get(i).getAlunos().get(i)
                            .getBoletim().get(i)
                            .getDisciplina()
                            .getNotasDisciplina().add(nota); // adiciona a nota desejada
                }
            }
        }

    }


    /* Método que atribui presença ao aluno */
    public void atribuirPresenca(Professor professor, Turma turma, Disciplina disciplina, Aluno aluno) {
        /* Checa se a turma, aluno e disciplina são nulos */
        if ((turma != null && aluno != null) && (professor != null && disciplina != null)) {
            /* Percorre por todas as turmas do professor */
            for (int i = 0; i < professor.getTurma().size(); i++) {
                /* Verifica se a turma e aluno são os mesmos */
                if (professor.getTurma().get(i).equals(turma)
                        && professor.getTurma().get(i).getDisciplinas().get(i).getAlunos().get(i).equals(aluno)) {
                    /* Atribui presença no aluno passando a data, nome da turma e cpf do aluno na presença */
                    professor.getTurma().get(i)
                            .getDisciplinas().get(i)
                            .getAlunos().get(i)
                            .getPresencas()
                            .add(new Presenca(LocalDate.now(), turma.getNome(), professor.getCPF()));
                }
            }
        }
    }
}
