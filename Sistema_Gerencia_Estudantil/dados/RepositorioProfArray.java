package Sistema_Gerencia_Estudantil.dados;

import Sistema_Gerencia_Estudantil.negocio.beans.Professor;


public class RepositorioProfArray {

    private Professor[] professores;
    private int proxima;

    /* Método construtor */
    public RepositorioProfArray(int tamanho) {
        this.professores = new Professor[tamanho];
        this.proxima = 0;
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

   /* Método para verificar o índice do cpf que consta no repositório ProfArray (myVersion) */
   public int procurarIndiceR(String cpf) {
       boolean achou = false;
       int indice = 0;
       for(int i = 0; i < this.proxima; i++){
           if(cpf.equals(this.professores[i].getCPF())) {
               achou = true;
               indice = i;
           }
       }
       return indice;
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
   public void removerProf(String cpf) {
       int i = this.procurarPosicao(cpf);
       if (i != this.proxima) {
           this.professores[i] = this.professores[this.proxima - 1];
           this.professores[this.proxima - 1] = null;
           this.proxima--;
       } else {
           /* código para apresentar erro ao usuário*/
           //possibilidade de inserção de exceptions
       }
   }

   /* Método que retorna um professor no repositório  - Read */
   public Professor procurarProf(String cpf) {
       int i = this.procurarPosicao(cpf);
       Professor resultado = null;
       if(i != this.proxima) {
           resultado = this.professores[i];
       }
       return resultado;
   }




}
