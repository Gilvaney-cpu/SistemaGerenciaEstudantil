package Sistema_Gerencia_Estudantil;

public class Turma { //Atributos
    private int ID;
    private String nome;
    private String IDaluno;
    private String turno;

    public Turma(int ID, String nome, String IDaluno, String turno){ //Instanciamento dos atributos {
        this.ID = ID;
        this.nome = nome;
        this.IDaluno = IDaluno;
        this.turno = turno;
    }

     // Método para adicionar um aluno à turma
    public void adicionarAluno(String IDaluno) {
        alunos.add(IDaluno);
    }
    //exemplo:
    Turma turma = new Turma(1, "Turma A", "Manhã");
turma.adicionarAluno("12345");
turma.adicionarAluno("67890");

//gets e sets
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIDaluno() {
        return IDaluno;
    }
//funções primárias de get e set
    public void setIDaluno(String IDaluno) {
        this.IDaluno = IDaluno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
