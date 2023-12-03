package Sistema_Gerencia_Estudantil.negocio;

import Sistema_Gerencia_Estudantil.dados.RepositorioProfessor;
import Sistema_Gerencia_Estudantil.negocio.beans.*;

import java.time.LocalDate;
import java.util.List;


public class ControllerProfessor {

    private static ControllerProfessor instance;
    private RepositorioProfessor repositorioProfessor; // conexão com a camada de dados do repositório.


    /* Método construtor */
    private ControllerProfessor () {
        this.repositorioProfessor = new RepositorioProfessor();
    }

    /* Implementação do Sigleton Pattern */
    public static ControllerProfessor getInstance() {
        if(instance == null) {
            instance = new ControllerProfessor();
        }
        return instance;
    }


    public void inserir(Professor objeto) {
        repositorioProfessor.inserirProfessor(objeto);
    }

    public List<Professor> listar() {
        return repositorioProfessor.listarProfessores();
    }

    public void remover(Professor objeto) {
        repositorioProfessor.removerProfessor(objeto);
    }

    public void atualizar(Professor novoObjeto) {

        repositorioProfessor.atualizarProfessor(novoObjeto);
    }

    /* Método que insere uma nota para determinado aluno passado */
    public void atribuirNota(Professor professor, Turma turma, Disciplina disciplina, Aluno aluno, double nota) {
        /* Verifica se os parâmetros passados são nulos e se a nota (double) está entre 0 e 10 */
        if ( ((turma != null && disciplina != null) && (professor != null))
                && ((aluno != null) && (nota >= 0.0 && nota <= 10.0))) {
            /* percorre por todas as turmas do professor*/
            for (int i = 0; i < professor.getTurma().size(); i++) {
                /* Verifica se aluno, disciplina e turma são encontrados s*/
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
        if ( (turma != null && aluno != null) && (professor != null && disciplina != null) ) {
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
