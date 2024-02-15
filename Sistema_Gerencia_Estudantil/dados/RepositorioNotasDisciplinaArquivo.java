package Sistema_Gerencia_Estudantil.dados;


import Sistema_Gerencia_Estudantil.exceptions.NotasDisciplinaNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.beans.Disciplina;
import Sistema_Gerencia_Estudantil.negocio.beans.NotasDisciplina;

import java.io.*;

public class RepositorioNotasDisciplinaArquivo implements Serializable {

    @Serial
    private static final long serialVersionUID = -2082053928932491089L;
    private NotasDisciplina[] notasDisciplinas;
    private int proximo;
    private static RepositorioNotasDisciplinaArquivo instance;

    /* Método Construtor */
    private RepositorioNotasDisciplinaArquivo(int tamanho) {

        this.notasDisciplinas = new NotasDisciplina[tamanho];
        this.proximo = 0;

    }

    /* Implementação do Padrão Singleton */
    public static RepositorioNotasDisciplinaArquivo getInstance() {
        if(instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    private static RepositorioNotasDisciplinaArquivo lerDoArquivo(){
        RepositorioNotasDisciplinaArquivo instanciaLocal = null;

        File entrada = new File("notasDisciplinas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(entrada);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioNotasDisciplinaArquivo) o; // Cast necessário
        } catch (Exception e) {
        instanciaLocal = new RepositorioNotasDisciplinaArquivo(100); // Acionado pela primeira vez
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e){
                    // do nothing ("error swallowing")
                }
            }
        }
        return instanciaLocal;
    }

    public void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File saida = new File("notasDisciplinas.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(saida);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    //do nothing ("error swallowing")
                }
            }
        }
    }

    public void inserirNotasDisciplina(NotasDisciplina nota) {

        if(nota != null) {
            this.notasDisciplinas[proximo] = nota;
            this.proximo++;

            if(this.notasDisciplinas.length == this.proximo) {
                this.duplicarArray();
            }
            this.salvarArquivo();
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
    public void removerNotaDisciplina(NotasDisciplina nota) throws NotasDisciplinaNaoExisteException{

        if(nota  != null) {
            int i = procurarPosicao(nota);
            if(i != this.proximo) {
                this.notasDisciplinas[i] = this.notasDisciplinas[this.proximo - 1];
                this.notasDisciplinas[this.proximo - 1] = null;
                this.proximo--;
                this.salvarArquivo();
            } else {
                throw new NotasDisciplinaNaoExisteException(nota.getDisciplina().getNome());
            }
        }
    }

    /* Método que retorna uma NotaDisciplina do repositório  - Read */
    public NotasDisciplina procurarNotasDisciplina(NotasDisciplina nota) throws NotasDisciplinaNaoExisteException {

        NotasDisciplina notinha = null;
        if(nota != null) {
            int i = procurarPosicao(nota);
            if(i != this.proximo) {
                notinha = this.notasDisciplinas[i];
            } else {
                throw new NotasDisciplinaNaoExisteException(nota.getDisciplina().getNome());
            }
        }
        return notinha;
    }



}
