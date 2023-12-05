package Sistema_Gerencia_Estudantil.dados;

import Sistema_Gerencia_Estudantil.negocio.beans.Aluno;

import java.util.ArrayList;

public class RepositorioAluno {

    private ArrayList<Aluno> repositorioAluno = new ArrayList<>();

    public RepositorioAluno() {
        /* método construtor vazio */
    }

    /* Adiciona o aluno passado como parâmetro ao repositório - Create */
    public void inserirAluno(Aluno aluno) {
        if (aluno != null) {
            if (repositorioAluno.isEmpty() || !repositorioAluno.contains(aluno)) {
                repositorioAluno.add(aluno);
            }
        }
    }

    /* Retorna uma lista de alunos cadastrados no repositório  - Retrieve */
    public ArrayList<Aluno> listarAlunos() {
        ArrayList<Aluno> lista = new ArrayList<>();
        if (!repositorioAluno.isEmpty()) {
            for (Aluno a : repositorioAluno) {
                lista.add(a);
            }
        }
        return lista;
    }

    /* Remove aluno (passado como parâmetro) do repositório - Delete */
    public void removerAluno(Aluno aluno) {
        if (aluno != null && repositorioAluno.contains(aluno)) {
            repositorioAluno.remove(aluno);
        }
    }

    /* Atualiza um aluno que já esteja no repositório  - Update*/
    public ArrayList<Aluno> atualizarAluno(Aluno aluno) {
        ArrayList<Aluno> lista = new ArrayList<>();
        if (aluno != null && repositorioAluno.contains(aluno)) {
            for (int i = 0; i < repositorioAluno.size(); i++) {
                if (repositorioAluno.get(i).getMatricula().equals(aluno.getMatricula())) {
                    repositorioAluno.remove(repositorioAluno.get(i)); // removeu o aluno desejado
                }
            }
            this.inserirAluno(aluno); // reinseriu o aluno
            lista = this.listarAlunos();
        }
        return lista; // devolve a lista com o aluno atualizado
    }
}
