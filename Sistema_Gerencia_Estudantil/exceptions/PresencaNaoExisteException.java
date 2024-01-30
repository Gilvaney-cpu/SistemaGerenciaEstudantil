package Sistema_Gerencia_Estudantil.exceptions;


public class PresencaNaoExisteException extends Exception {
    private String presencaBuscada;

    public PresencaNaoExisteException(String nome) {
        super("A presença do ID '" + nome + "' NÃO existe no sistema");
        this.presencaBuscada = nome;
    }

    public String getPresencaBuscada() {
        return presencaBuscada;
    }
}
