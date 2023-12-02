package Sistema_Gerencia_Estudantil.dados;


import Sistema_Gerencia_Estudantil.negocio.beans.Presenca;

public class RepositorioPresencaArray {

    private Presenca[] presencas;
    private int proximo;

    /* Método Construtor*/
    public RepositorioPresencaArray(int size) {
        presencas = new Presenca[size];
        proximo = 0;
    }

    public void cadastrarPresenca(Presenca p) {
        if (p != null) {
            presencas[proximo] = p;
            proximo++;
            if (presencas.length == proximo) {
                duplicarArray();
            }
        }

    }

    private void duplicarArray() {
        if (presencas != null && presencas.length > 0) {
            Presenca[] array = new Presenca[this.presencas.length * 2];
            for (int i = 0; i < this.presencas.length; i++) {
                array[i] = this.presencas[i];
            }
            this.presencas = array;
        }
    }

    public int procurarPosicao(Presenca p) {
        int posicao = 0; // indice inicial no array.
        boolean achou = false; // flag para identificar sucesso.
        /* Percorre o repositório buscando a NotaDisciplina desejada */
            while ((!achou) && (posicao < this.proximo)) {
            /* Verifica se Turma e disciplina são as mesmas que o objeto passado como parâmetro */
                if (p.getIdAluno().equals(presencas[posicao].getIdAluno())
                        && (p.getData().equals(presencas[posicao].getData()))) {
                    achou = true; // flag recebe 'true' se achou.
                } else {
                    posicao++; // Caso contrário, avança o índice.
                }
            }
            return posicao; // retorna o índice da NotaDisciplina no repositório.
        }

    public boolean existePresenca(Presenca p) {
        int i = this.procurarPosicao(p);
        boolean existe = false;
        if( i != proximo) {
            existe = true;
        }
        return existe;
    }

    public void removerPresenca(Presenca p) {
        if(p != null) {
            int i = this.procurarPosicao(p);
            if( i != proximo) {
                presencas[i] = presencas[proximo - 1];
                presencas[proximo - 1] = null;
                proximo--;
            } else {
                /* código para apresentar erro ao usuário */
                //possibilidade de inserção de exceptions
            }
        }
    }

    /* Método que retorna uma NotaDisciplina do repositório  - Read */
    public Presenca procurarPresenca(Presenca p) {
        Presenca presenca = null;
        if(p != null) {
            int i = procurarPosicao(p);
            if( i != proximo) {
                presenca = presencas[i];
            }
        }
        return presenca;
    }


}