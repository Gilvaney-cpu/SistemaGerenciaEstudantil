package Sistema_Gerencia_Estudantil.dados;


import Sistema_Gerencia_Estudantil.exceptions.DisciplinaNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.beans.Disciplina;

import java.io.*;

public class RepositorioDisciplinaArquivo implements Serializable {
    @Serial
    private static final long serialVersionUID = -3236304934842510866L;
    private Disciplina[] disciplinas;
    private int proxima;
    private static RepositorioDisciplinaArquivo instance;

    /* Método construtor */
    private RepositorioDisciplinaArquivo(int tamanho) {
        disciplinas = new Disciplina[tamanho];
        proxima = 0;
    }

    /* Implementação do Padrão Singleton */
    public static RepositorioDisciplinaArquivo getInstance() {
        if(instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    private static RepositorioDisciplinaArquivo lerDoArquivo() {
        RepositorioDisciplinaArquivo instanciaLocal = null;

        File entrada = new File("disciplinas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(entrada);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioDisciplinaArquivo) o; // cast necessário para instanciar o repositorio
        }catch (Exception e) {
            // Captura a condição de não existir o arquivo
            instanciaLocal = new RepositorioDisciplinaArquivo(100);
        } finally {
            //snippet que fecha o stream de dados
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e ){

                }
            }
        }
        return instanciaLocal;
    }

    public void salvarArquivo() {
        if(instance == null) {
            return;
        }
        File saida = new File("disciplinas.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(saida);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {

                }
            }
        }
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
            this.salvarArquivo();
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
    public void removerDisciplina(Disciplina d) throws DisciplinaNaoExisteException {

            int i = procurarPosicao(d);
            if (i != this.proxima) {
            this.disciplinas[i] = this.disciplinas[this.proxima - 1];
            this.disciplinas[this.proxima - 1] = null;
            this.proxima--;
            this.salvarArquivo();
            } else {
                /* código para apresentar "erro" ao usuário */
                throw new DisciplinaNaoExisteException(d.getNome());
            }

    }

    /* Método que retorna uma disciplina do repositório  - Read */
    public Disciplina  procurarDisciplina(Disciplina d) throws DisciplinaNaoExisteException {

        int i = this.procurarPosicao(d);
        Disciplina resultado = null;
            if(i != this.proxima) {
                resultado = this.disciplinas[i];
            } else {
                throw new DisciplinaNaoExisteException(d.getNome());
            }

        return resultado;
    }

}