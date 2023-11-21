package Sistema_Gerencia_Estudantil.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Professor extends Usuario {

    private ArrayList<Turma> turma;
    private boolean ativo;
    private ArrayList<Disciplina> disciplina;

    /* Método construtor */
    public Professor(String nome, String cpf, String senha, String id) {

        super(nome, cpf, senha, id); // herança da classe Usuario.
        turma = new ArrayList<Turma>();
        this.disciplina = new ArrayList<>();
        this.ativo = true;
    }

    public ArrayList<Turma> getTurma() {
        return turma;
    }

    public void setTurma(ArrayList<Turma> turma) {
        this.turma = turma;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public ArrayList<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(ArrayList<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

    /* Método que insere uma nota para determinado aluno passado */
    public void atribuirNota(Turma turma, Disciplina disciplina, Aluno aluno, double nota) {
        /* Verifica se os parâmetros passados são nulos e se a nota (double) está entre 0 e 10 */
        if ((turma != null && disciplina != null)
                && ((aluno != null) && (nota >= 0.0 && nota <= 10.0))) {
            /* percorre por todas as turmas do professor*/
            for (int i = 0; i < this.getTurma().size(); i++) {
                /* Verifica se aluno, disciplina e turma são encontrados s*/
                if (aluno.equals(this.getDisciplina().get(i).getAlunos().get(i))
                        && ((this.getDisciplina().contains(disciplina) && this.getTurma().contains(turma)))) {

                    this.getDisciplina().get(i).getAlunos().get(i)
                            .getBoletim().get(i)
                            .getDisciplina()
                            .getNotasDisciplina().add(nota); // adiciona a nota desejada
                }
            }
        }

    }

    /* Método que atribui presença ao aluno */
    public void atribuirPresenca(Turma turma, Disciplina disciplina, Aluno aluno) {
        /* Checa se a turma, aluno e disciplina são nulos */
        if ((turma != null && aluno != null) && disciplina != null) {
            /* Percorre por todas as turmas do professor */
            for (int i = 0; i < this.getTurma().size(); i++) {
                /* Verifica se a turma e aluno são os mesmos */
                if (this.getTurma().get(i).equals(turma)
                        && this.getTurma().get(i).getDisciplinas().get(i).getAlunos().get(i).equals(aluno)) {
                    /* Atribui presença no aluno passando a data, nome da turma e cpf do aluno na presença */
                    this.getTurma().get(i)
                            .getDisciplinas().get(i)
                            .getAlunos().get(i)
                            .getPresencas()
                            .add(new Presenca(LocalDate.now(), turma.getNome(), super.getCPF()));
                }
            }
        }

    }

    public String toString(){
        /* Devolve o nome, id(super), nome da classe 'professor' do professor */
        return String.format("Nome: %10s | \nId: %10s | \nCargo: %10s | \n",this.getNome()
                ,super.getID()
                , this.getClass().getSimpleName().toUpperCase());
    }
}
