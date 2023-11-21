package Sistema_Gerencia_Estudantil.models;

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

    //Metódos
    public String obterInformacoesMatricula() {  // mostrar os dados da matricula
        return "Matrícula: " + idMatricula +
               "\nDisciplina: " + idDisciplina +
               "\nAno Letivo: " + anoLetivo +
               "\nSemestre: " + semestre;
    }
    
    public boolean validarMatricula() {
        // Lógica de validação da matrícula
        // Exemplo: Verificar se o ano letivo e semestre são válidos
        return (anoLetivo > 0 && semestre >= 1 && semestre <= 2);
    }

    public void atualizarMatricula(String novoIdDisciplina, int novoAnoLetivo, int novoSemestre) {  // Método para Atualizar Informações da Matrícula
        this.idDisciplina = novoIdDisciplina;
        this.anoLetivo = novoAnoLetivo;
        this.semestre = novoSemestre;
    }

    @Override                           // retorna uma representação de string da matrícula, útil para leitura e depuração,
    public String toString() {          // a string inclui os valores dos atributos idMatricula, idDisciplina, anoLetivo e semestre.
        return "Matricula{" +
               "idMatricula='" + idMatricula + '\'' +
               ", idDisciplina='" + idDisciplina + '\'' +
               ", anoLetivo=" + anoLetivo +
               ", semestre=" + semestre +
               '}';
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
