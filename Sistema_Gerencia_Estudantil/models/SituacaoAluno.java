package Sistema_Gerencia_Estudantil.models;

public enum SituacaoAluno {
    APROVADO,
    REPROVADO,
    RECUPERACAO,
    FINAL;

    //Metódos

    // Método para obter uma descrição textual da situação do aluno
    public String getDescricao() {
        switch (this) {
            case APROVADO:
                return "Aprovado";
            case REPROVADO:
                return "Reprovado";
            case RECUPERACAO:
                return "Recuperação";
            case FINAL:
                return "Final";
            default:
                return "Desconhecido";
        }
    }

    // Método para verificar se a situação do aluno indica sucesso
    public boolean isSuccess() {
        return this == APROVADO;
    }

    // Método para verificar se a situação do aluno indica a necessidade de recuperação
    public boolean needsRecuperacao() {
        return this == RECUPERACAO;
    }
    
    // Método para verificar se a situação do aluno indica reprovação
    public boolean isReprovado() {
        return this == REPROVADO;
    }

    // Método para verificar se a situação do aluno indica final
    public boolean isFinal() {
        return this == FINAL;
    }
}
