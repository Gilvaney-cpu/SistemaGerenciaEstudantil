package Sistema_Gerencia_Estudantil.exceptions;


public class NotasDisciplinaNaoExisteException extends Exception {
    private String nomeDisciplina;

    public NotasDisciplinaNaoExisteException (String nome) {
        super("A nota de '" + nome + "' NÃO existe no sistema");
        this.nomeDisciplina = nome;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
}

