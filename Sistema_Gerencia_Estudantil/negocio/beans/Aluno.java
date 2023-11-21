package Sistema_Gerencia_Estudantil.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno {

    // Atributos
    private LocalDate dataNascimento;
    private String turma;
    private ArrayList<NotasDisciplina> boletim;
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
    //Metódos 
    public ArrayList<NotasDisciplina> getNotas(Disciplina disciplina) {  // retorna uma lista com as notas do aluno em uma determinada disciplina.
        ArrayList<NotasDisciplina> notas = new ArrayList<>();
        for (NotasDisciplina nota : boletim) {
            if (nota.getDisciplina().equals(disciplina)) {
              notas.add(nota);
            }
        }
        return notas;
    }

    public double getMedia(Disciplina disciplina) {                      //calcula a média das notas do aluno em uma determinada disciplina.
        ArrayList<NotasDisciplina> notas = getNotas(disciplina);
        double soma = 0;
        for (NotasDisciplina nota : notas) {
            soma += nota.getValor();
        }
        return soma / notas.size();
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

    public ArrayList<NotasDisciplina> getBoletim() {
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