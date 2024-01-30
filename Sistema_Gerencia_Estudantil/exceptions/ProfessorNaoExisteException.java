package Sistema_Gerencia_Estudantil.exceptions;


public class ProfessorNaoExisteException extends Exception {
    private String cpfBuscado;

    public ProfessorNaoExisteException (String cpf) {
        super("O CPF '" + cpf + "' NÃO existe no sistema");
        this.cpfBuscado = cpf;
    }

    public String getCpfBuscado() {
        return cpfBuscado;
    }
}
