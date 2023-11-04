public class Disciplina {

    private String nome;
    private Professor professor;
    private DateTime horario;
    private Arraylist<Aluno> alunos;

    public Disciplina (String nome, Professor professor, DateTime horario, Aluno aluno) {
        this.nome = nome;
        this.professor = professor;
        this.horario = horario;
        this.alunos = new ArrayList<>(aluno);

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

    public DateTime getHorario() {
        return horario;
    }

    public void setHorario(DateTime horario) {

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
}