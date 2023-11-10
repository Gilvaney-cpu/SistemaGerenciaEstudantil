package Sistema_Gerencia_Estudantil;

import java.util.ArrayList;


public class notasDisciplina {
    private Turma id; // serve como o nome da disciplina
    private Disciplina disciplina;
    private ArrayList<Integer> notas;

    public notasDisciplina (Turma id, Disciplina disciplina) {
     setId(id);
     setDisciplina(disciplina);
     notas = new ArrayList<Integer>();
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

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    public double getValor() {
        return 0;
    }
}
