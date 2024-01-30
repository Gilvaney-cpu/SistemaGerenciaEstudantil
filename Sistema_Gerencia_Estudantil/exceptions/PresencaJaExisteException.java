package Sistema_Gerencia_Estudantil.exceptions;


public class PresencaJaExisteException extends Exception {
    private String nomePresenca;

    public PresencaJaExisteException(String nome) {
        super("A presença do ID '" + nome + "' já existe no sistema");
        this.nomePresenca = nome;
    }

    public String getNomePresenca() {
        return nomePresenca;
    }
}
