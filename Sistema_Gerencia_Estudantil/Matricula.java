public class Matricula {

    // Atributos
    private String idMatricula;
    private String idDisciplina;
    private int anoLetivo;
    private int semestre;

    //Construtor
    public Matricula(String idMatricula, String idDisciplina, int anoLetivo, int semestre) {
        this.idMatricula = idMatricula;
        this.idDisciplina = idDisciplina;
        this.anoLetivo = anoLetivo;
        this.semestre = semestre;
    }

    // Getters e setters para os atributos
    public String getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(String idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
