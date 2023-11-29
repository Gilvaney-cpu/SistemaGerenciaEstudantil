package Sistema_Gerencia_Estudantil.negocio.beans;


import java.time.LocalTime;
import java.util.ArrayList;

public class Disciplina {

    private String nome;
    private Professor professor; // - idProfessor: String
    private LocalTime horario; // - horario: String
    private ArrayList<Aluno> alunos; // - idAluno: String
    private ArrayList<Double> notasDisciplina; // - nota: notasDisciplina
    private ArrayList<Presenca> presencas;
    private Turma turma;

    public Disciplina (String nome, Professor professor, LocalTime horario, Turma turma) {
        setNome(nome);
        setProfessor(professor);
        setHorario(horario);
        alunos = new ArrayList<Aluno>();
        presencas = new ArrayList<Presenca>();
        setTurma(turma);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome != null && (!nome.isBlank()) ) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException();
        }
    }


    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {

        if (professor != null) {
            this.professor = professor;
        }
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {

        if (horario != null &&
                (horario.getHour() > 0 && horario.getHour() <= 24)) {
            this.horario = horario;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Double> getNotasDisciplina() {
        return notasDisciplina;
    }

    public void setNotasDisciplina(ArrayList<Double> notasDisciplina) {
        this.notasDisciplina = notasDisciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}