package Sistema_Gerencia_Estudantil.dados;


import Sistema_Gerencia_Estudantil.negocio.beans.Disciplina;

public class RepositorioDisciplinaArray {
    private Disciplina[] disciplinas;
    private int proxima;

    /* Método construtor */
    public RepositorioDisciplinaArray(int tamanho) {
        disciplinas = new Disciplina[tamanho];
        proxima = 0;
    }

    /* Insere uma disciplina no repositório - Create */
    public void inserirDisciplina(Disciplina d) {

        if (d != null) {
            this.disciplinas[this.proxima] = d; // adiciona na posição em que a variável proxima estiver.
            this.proxima++;
            /* Dobra o tamanho o array caso ele na última posição */
            if (this.proxima == this.disciplinas.length) {
                this.duplicaDisciplinaArray();
            }
        }
    }

    /* Dobra o tamanho do array do repositório */
    public void duplicaDisciplinaArray() {
        if (this.disciplinas != null && this.disciplinas.length > 0) {
            Disciplina[] arrayDuplicado = new Disciplina[this.disciplinas.length * 2];
            for (int i = 0; i < this.disciplinas.length; i++) {
                arrayDuplicado[i] = this.disciplinas[i];
            }
            this.disciplinas = arrayDuplicado;
        }
    }

    /* Retorna a posição de uma disciplina no repositório */
    public int procurarPosicao(Disciplina d) {
        int posicao = 0; // indice inicial no array.
        boolean achou = false; // flag para identificar o id desejado.
        /* Percorre o repositório buscando a disciplina desejada */
        while ((!achou) && (posicao < this.proxima)) {
            /* Se o ID da turma da diciplina passada coincidir com a disciplina do repositorio */
            if (d.getTurma().getID() == this.disciplinas[posicao].getTurma().getID()
                    && d.getNome().equals(this.disciplinas[posicao].getNome())) {
                achou = true; // flag recebe 'true' se achou.
            } else {
                posicao++; // avança o índice.
            }
        }
        return posicao; // retorna o índice da disciplina no repositório.
    }

    public boolean existe(Disciplina d) {
        boolean existe = false;
        int indice = this.procurarPosicao(d);
        if (indice != proxima) {
            existe = true;
        }

        return existe;
    }

    /* Método que remove disciplina do repositório - Delete */
    public void removerDisciplina(Disciplina d) {
        if (d != null) {
            int i = procurarPosicao(d);
            if (i != this.proxima) {
            this.disciplinas[i] = this.disciplinas[this.proxima - 1];
            this.disciplinas[this.proxima - 1] = null;
            this.proxima--;
            } else {
                /* código para apresentar erro ao usuário */
                //possibilidade de inserção de exceptions
            }
        }

    }

    /* Método que retorna uma disciplina do repositório  - Read */
    public Disciplina procurarDisciplina(Disciplina d) {
        Disciplina resultado = null;
        if (d != null) {
            int i = this.procurarPosicao(d);
            if(i != this.proxima) {
                resultado = this.disciplinas[i];
            }

        }
        return resultado;
    }

}