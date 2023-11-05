package Sistema_Gerencia_Estudantil;


import java.time.LocalTime;
import java.util.ArrayList;

public class Disciplina {

    private String nome;
    private Professor professor; // - idProfessor: String
    private LocalTime horario; // - horario: String
    private Arraylist<Aluno> alunos; // - idAluno: String
    private ArrayList<Integer> notasDisciplina; // - nota: notasDisciplina
    private ArrayList<Presenca> presencas;

    public Disciplina (String nome, Professor professor, LocalTime horario) {
        setNome(nome);
        setProfessor(professor);
        setHorario(horario);
        alunos = new ArrayList<Aluno>();
        presencas = new ArrayList<Presenca>();

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

    public Arraylist<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Arraylist<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Integer> getNotasDisciplina() {
        return notasDisciplina;
    }

    public void setNotasDisciplina(ArrayList<Integer> notasDisciplina) {
        this.notasDisciplina = notasDisciplina;
    }

}