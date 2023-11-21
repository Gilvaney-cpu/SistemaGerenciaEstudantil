package Sistema_Gerencia_Estudantil.negocio.beans;

import java.util.ArrayList;


public class NotasDisciplina {
    private Turma id; // serve como o nome da disciplina
    private Disciplina disciplina;
    private ArrayList<Double> notas;
    private ArrayList<Aluno> alunos;

    public NotasDisciplina (Turma id, Disciplina disciplina) {
     setId(id);
     setDisciplina(disciplina);
     notas = new ArrayList<Double>();
     alunos = new ArrayList<>();
    }

    public Turma getId() {
        return id;
    }

    public void setId(Turma id) {
        if (id != null) {
            this.id = id;
        }
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        if (disciplina != null) {
            this.disciplina = disciplina;
        }
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public double getValor() {
        return 0;
    }
}
