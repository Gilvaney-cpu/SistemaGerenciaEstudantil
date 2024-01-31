package Sistema_Gerencia_Estudantil.dados;

import Sistema_Gerencia_Estudantil.exceptions.ProfessorNaoExisteException;
import Sistema_Gerencia_Estudantil.negocio.beans.Professor;

import java.io.*;


public class RepositorioProfArray implements Serializable {

    @Serial
    private static final long serialVersionUID = 4701956056778571230L;
    private Professor[] professores;
    private int proxima;

    private static RepositorioProfArray instance;

    /* Método construtor */
    private RepositorioProfArray(int tamanho) {
        this.professores = new Professor[tamanho];
        this.proxima = 0;
    }

    /* Implementação do Padrão Singleton */
    public static RepositorioProfArray getInstance() {
        if(instance == null) {
            instance = lerDoArquivo();
        }
        return instance;
    }

    private static RepositorioProfArray lerDoArquivo() {
        RepositorioProfArray instanciaLocal = null;

        File entrada = new File("professores.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
        fis = new FileInputStream(entrada);
        ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        instanciaLocal = (RepositorioProfArray) o; // Cast necessário para instanciar o repositorio

        }catch(Exception e) {
            instanciaLocal = new RepositorioProfArray(100); // Para o caso de ser a 1ª vez
        }finally {
            if(ois != null) {
                try{
                    ois.close();
                }catch(IOException e) {
                    // do nothing ("error swallowing")
                }
            }
        }
        return instanciaLocal;
    }

    public void salvarArquivo() {
        if(instance == null) {
            return;
        }
        File saida = new File("professores.dat");
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
                } catch (IOException e) {
                    // do nothing ("error swallowing")
                }
            }
        }
    }

    /*Adiciona o professor passado como parâmetros ao Repositório - Create */
    public void inserirProf(Professor p) {

        this.professores[this.proxima] = p;
        this.proxima++;
        /* Dobra o tamanho do array para o caso dele estar totalmente ocupado */
        if(this.proxima == this.professores.length) {
            this.duplicaProfArray();
        }
    }

    /* Método que busca a posição do cpf de um professor que esteja no RepositorioProfArray */
   private int procurarPosicao(String cpf) {
        int i = 0; // indice inicial no array
        boolean achou = false; // flag para identificar se achou o cpf desejado
       /* Percorre o repositorio buscando o cpf (professor) desejado */
        while( (!achou) && (i < this.proxima) ) {
            if(cpf.equals(this.professores[i].getCPF())) {
                achou = true; // flag recebe 'true' se encontrou o cpf desejado
            } else {
                i++; //avança a posição
            }
        }

        return i; // retorna a posição do cpf
   }


   /* Verifica se o cpf passado como parâmetro existe nos objetos adicionados no repositório */
   public boolean existe(String cpf) {
       boolean existe = false; // flag
       int indice = this.procurarPosicao(cpf); //chamando o método p/ encontrar a posição
       if(indice != proxima){
           existe = true; // flag recebe 'true' se tiver encontrado antes do fim do array
       }
       return existe;
   }

   /* Método para duplicar o tamanho do RepositórioProfArray */
   private void duplicaProfArray() {
       if(this.professores != null && this.professores.length > 0) {
           Professor[] arrayDuplicado = new Professor[this.professores.length * 2];
           for(int i = 0; i < this.professores.length; i++) {
               arrayDuplicado[i] = this.professores[i];
           }
           this.professores = arrayDuplicado;
       }
   }

   /* Método que remove professor do repositório - Delete */
   public void removerProf(String cpf) throws ProfessorNaoExisteException {
       int i = this.procurarPosicao(cpf);
       if (i != this.proxima) {
           this.professores[i] = this.professores[this.proxima - 1];
           this.professores[this.proxima - 1] = null;
           this.proxima--;
       } else {
           /* código para apresentar erro ao usuário*/
           throw new ProfessorNaoExisteException(cpf);
       }
   }

   /* Método que retorna um professor no repositório  - Read */
   public Professor procurarProf(String cpf) throws ProfessorNaoExisteException {
       int i = this.procurarPosicao(cpf);
       Professor resultado = null;
       if(i != this.proxima) {
           resultado = this.professores[i];
       } else {
           throw new ProfessorNaoExisteException(cpf);
       }
       return resultado;
   }




}
