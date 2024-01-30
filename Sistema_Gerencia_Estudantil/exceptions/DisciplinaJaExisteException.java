package Sistema_Gerencia_Estudantil.exceptions;


public class DisciplinaJaExisteException extends Exception{
private String nomeDisciplina;

public DisciplinaJaExisteException(String nome) {
    super("A disciplina '" + nome + "' já existe no sistema");
    this.nomeDisciplina = nome;
}

public String getNomeDisciplina() {
    return nomeDisciplina;
}
}
