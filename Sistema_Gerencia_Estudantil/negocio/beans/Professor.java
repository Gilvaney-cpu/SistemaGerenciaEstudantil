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

    public String toString(){
        /* Devolve o nome, id(super), nome da classe 'professor' do professor */
        return String.format("Nome: %-10s | \nId: %10s | \nCargo: %-10s |\n",this.getNome()
                ,super.getID()
                , this.getClass().getSimpleName().toUpperCase());
    }

    public boolean equals(Professor professor) {
        boolean b = false;
        if(professor != null) {
           if(this.getCPF().equals(professor.getCPF())) {
                b = true;
            }
        }
        return b;
    }
}
