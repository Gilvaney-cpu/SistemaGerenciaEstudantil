package Sistema_Gerencia_Estudantil.exceptions;


public class NotasDisciplinaJaExisteException extends Exception {
    private String notaBuscada;

    public NotasDisciplinaJaExisteException(String nome) {
        super("A nota de '" + nome + "' NÃO existe no sistema");
        this.notaBuscada = nome;
    }

    public String getNotaBuscada() {
        return notaBuscada;
    }
}
