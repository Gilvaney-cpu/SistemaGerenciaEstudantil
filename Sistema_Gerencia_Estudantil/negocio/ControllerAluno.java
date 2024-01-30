package Sistema_Gerencia_Estudantil.negocio;

import Sistema_Gerencia_Estudantil.dados.RepositorioAluno;
import Sistema_Gerencia_Estudantil.negocio.beans.Aluno;
import Sistema_Gerencia_Estudantil.negocio.beans.Presenca;
import Sistema_Gerencia_Estudantil.negocio.beans.Turma;
import Sistema_Gerencia_Estudantil.negocio.beans.Disciplina;

import java.time.LocalDate;
import java.util.List;

public class ControllerAluno {

    private static ControllerAluno instance;
    private RepositorioAluno repositorioAluno; // conexão com a camada de dados do repositório.

    /* Método construtor */
    private ControllerAluno() {
        this.repositorioAluno = new RepositorioAluno();
    }

    /* */
    public static ControllerAluno getInstance() {
        if (instance == null) {
            instance = new ControllerAluno();
        }
        return instance;
    }

    public void inserir(Aluno objeto) {
        repositorioAluno.inserirAluno(objeto);
    }

    public List<Aluno> listar() {
        return repositorioAluno.listarAlunos();
    }

    public void remover(Aluno objeto) {
        repositorioAluno.removerAluno(objeto);
    }

    public void atualizar(Aluno novoObjeto) {
        repositorioAluno.atualizarAluno(novoObjeto);
    }

    /* Método que atribui presença ao aluno */
    public void atribuirPresenca(Aluno aluno, Turma turma, Disciplina disciplina) {
        /* Checa se a turma e disciplina são nulas */
        if (turma != null && disciplina != null) {
            /* Atribui presença no aluno passando a data, nome da turma e cpf do aluno na presença */
            aluno.getPresencas().add(new Presenca(LocalDate.now(), turma.getNome(),aluno.getCPF()));
        }
    }
}
