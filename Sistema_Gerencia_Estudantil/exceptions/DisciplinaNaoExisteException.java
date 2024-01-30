package Sistema_Gerencia_Estudantil.exceptions;


public class DisciplinaNaoExisteException extends Exception{
    private String nomeDisciplina;

    public DisciplinaNaoExisteException(String nome) {
        super("A disciplina '" + nome + "' NÃO existe no sistema");
        this.nomeDisciplina = nome;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
}
