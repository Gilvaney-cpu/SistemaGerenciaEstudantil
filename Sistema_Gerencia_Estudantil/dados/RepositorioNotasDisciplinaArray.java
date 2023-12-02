package Sistema_Gerencia_Estudantil.dados;


import Sistema_Gerencia_Estudantil.negocio.beans.Disciplina;
import Sistema_Gerencia_Estudantil.negocio.beans.NotasDisciplina;

public class RepositorioNotasDisciplinaArray {

    private NotasDisciplina[] notasDisciplinas;
    private int proximo;

    public RepositorioNotasDisciplinaArray(int tamanho) {

        this.notasDisciplinas = new NotasDisciplina[tamanho];
        this.proximo = 0;

    }

    public void inserirNotasDisciplina(NotasDisciplina nota) {

        if(nota != null) {
            this.notasDisciplinas[proximo] = nota;
            this.proximo++;

            if(this.notasDisciplinas.length == this.proximo) {
                this.duplicarArray();
            }
        }
    }

    public void duplicarArray() {

        if(this.notasDisciplinas != null && this.notasDisciplinas.length > 0) {
            NotasDisciplina[] array = new NotasDisciplina[this.notasDisciplinas.length * 2];
            for(int i = 0; i < this.notasDisciplinas.length; i++) {
                array[i] = this.notasDisciplinas[i];
            }
            this.notasDisciplinas = array;
        }
    }

    /* Retorna a posição de uma disciplina no repositório */
    public int procurarPosicao(NotasDisciplina nota) {
        int posicao = 0; // indice inicial no array.
        boolean achou = false; // flag para identificar sucesso.
        /* Percorre o repositório buscando a NotaDisciplina desejada */
        while ((!achou) && (posicao < this.proximo)) {
            /* Verifica se Turma e disciplina são as mesmas que o objeto passado como parâmetro */
            if (nota.getId().equals(notasDisciplinas[posicao].getId())
                    && (nota.getDisciplina().getNome().equals(this.notasDisciplinas[posicao].getDisciplina().getNome())) ){
                achou = true; // flag recebe 'true' se achou.
            } else {
                posicao++; // Caso contrário, avança o índice.
            }
        }
        return posicao; // retorna o índice da NotaDisciplina no repositório.
    }

    /* Retorna um boolean(true) se a nota passada existe no repositório */
    public boolean existe(NotasDisciplina nota) {
        boolean confirmacao = false;
        int i = procurarPosicao(nota);
        if (i != proximo) {
            confirmacao = true;
        }
        return confirmacao;
    }

    /* Método que remove disciplina do repositório - Delete */
    public void removerNotaDisciplina(NotasDisciplina nota) {

        if(nota  != null) {
            int i = procurarPosicao(nota);
            if(i != this.proximo) {
                this.notasDisciplinas[i] = this.notasDisciplinas[this.proximo - 1];
                this.notasDisciplinas[this.proximo - 1] = null;
                this.proximo--;
            } else {
                /* código para apresentar erro ao usuário */
                //possibilidade de inserção de exceptions
            }
        }
    }

    /* Método que retorna uma NotaDisciplina do repositório  - Read */
    public NotasDisciplina procurarNotasDisciplina(NotasDisciplina nota) {
        NotasDisciplina notinha = null;
        if(nota != null) {
            int i = procurarPosicao(nota);
            if(i != this.proximo) {
                notinha = this.notasDisciplinas[i];
            }
        }
        return notinha;
    }



}
