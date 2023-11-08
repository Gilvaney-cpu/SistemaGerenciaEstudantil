package Sistema_Gerencia_Estudantil;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno {

    // Atributos
    private LocalDate dataNascimento;
    private String turma;
    private ArrayList<notasDisciplina> boletim;
    private situacaoAluno status;
    private Matricula matriculaAluno;
    private ArrayList<Presenca> presencas;

    //Construtor
    public Aluno(LocalDate dataNascimento, String turma, Matricula matriculaAluno) {
        this.dataNascimento = dataNascimento;
        this.turma = turma;
        this.boletim = new ArrayList<>();
        this.status = situacaoAluno.APROVADO;
        this.matriculaAluno = matriculaAluno;
        this.presencas = new ArrayList<>();
    }

    // Getters e setters para os atributos
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public ArrayList<notasDisciplina> getBoletim() {
        return boletim;
    }

    public situacaoAluno getStatus() {
        return status;
    }

    public void setStatus(situacaoAluno status) {
        this.status = status;
    }

    public Matricula getMatriculaAluno() {
        return matriculaAluno;
    }

    public ArrayList<Presenca> getPresencas() {
        return presencas;
    }
}