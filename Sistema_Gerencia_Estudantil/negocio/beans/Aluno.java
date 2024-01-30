package Sistema_Gerencia_Estudantil.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno extends Usuario{

    // Atributos
    private LocalDate dataNascimento;
    private String turma;
    private ArrayList<NotasDisciplina> boletim;
    private SituacaoAluno status;
    private Matricula matriculaAluno;
    private ArrayList<Presenca> presencas;

    //Construtor
    public Aluno(String nome, String cpf, String senha, String id,LocalDate dataNascimento, String turma, Matricula matriculaAluno) {
        super(nome, cpf, senha, id);
        this.dataNascimento = dataNascimento;
        this.turma = turma;
        this.boletim = new ArrayList<>();
        this.status = SituacaoAluno.APROVADO;
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

    public SituacaoAluno getStatus() {
        return status;
    }

    public void setStatus(SituacaoAluno status) {
        this.status = status;
    }

    public Matricula getMatriculaAluno() {
        return matriculaAluno;
    }

    public ArrayList<Presenca> getPresencas() {
        return presencas;
    }

    public String toString(){
        /* Devolve o nome, id(super), nome da classe 'professor' do professor */
        return String.format("Nome: %-10s | \nId: %10s | \nCargo: %-10s |\n",this.getNome()
                ,super.getID()
                , this.getClass().getSimpleName().toUpperCase());
    }
}