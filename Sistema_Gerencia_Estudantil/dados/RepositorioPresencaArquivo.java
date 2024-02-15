package Sistema_Gerencia_Estudantil.dados;


import Sistema_Gerencia_Estudantil.exceptions.PresencaNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.beans.Presenca;

import java.io.*;

public class RepositorioPresencaArquivo implements Serializable {

    @Serial
    private static final long serialVersionUID = -1611790846644741688L;
    private Presenca[] presencas;
    private int proximo;
    private static RepositorioPresencaArquivo instance;

    /* Método Construtor*/
    private RepositorioPresencaArquivo(int size) {
        presencas = new Presenca[size];
        proximo = 0;
    }

    /* Singleton Pattern */
    public static RepositorioPresencaArquivo getInstance() {
        if(instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    private static RepositorioPresencaArquivo lerDoArquivo() {
        RepositorioPresencaArquivo instanciaLocal = null;
        File entrada = new File("presencas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(entrada);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioPresencaArquivo) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioPresencaArquivo(100);
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                }catch(IOException e) {
                    // error swallowing
                }
            }
        }
        return instanciaLocal;
    }

    public void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File saida = new File("presencas.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(saida);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) { // "error hiding" }
                }
            }
        }
    }
    public void cadastrarPresenca(Presenca p) {
        if (p != null) {
            presencas[proximo] = p;
            proximo++;
            if (presencas.length == proximo) {
                duplicarArray();
            }
            this.salvarArquivo();
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

    public void removerPresenca(Presenca p) throws PresencaNaoExisteException {
        if(p != null) {
            int i = this.procurarPosicao(p);
            if( i != proximo) {
                presencas[i] = presencas[proximo - 1];
                presencas[proximo - 1] = null;
                proximo--;
                this.salvarArquivo();
            } else {
                throw new PresencaNaoExisteException(p.getIdAluno());
            }
        }
    }

    /* Método que retorna uma NotaDisciplina do repositório  - Read */
    public Presenca procurarPresenca(Presenca p) throws PresencaNaoExisteException {
        Presenca presenca = null;
        if(p != null) {
            int i = procurarPosicao(p);
            if( i != proximo) {
                presenca = presencas[i];
            } else {
                throw new PresencaNaoExisteException(p.getIdAluno());
            }
        }
        return presenca;
    }


}