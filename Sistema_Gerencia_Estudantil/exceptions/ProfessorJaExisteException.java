package Sistema_Gerencia_Estudantil.exceptions;


public class ProfessorJaExisteException extends Exception{
    private String cpfBuscado;

    /* Método Construtor */
    public ProfessorJaExisteException(String cpf) {
        super("O CPF '" + cpf + "' já existe no sistema");
        this.cpfBuscado = cpf;
    }

    public String getCpfBuscado() {
        return cpfBuscado;
    }

}
