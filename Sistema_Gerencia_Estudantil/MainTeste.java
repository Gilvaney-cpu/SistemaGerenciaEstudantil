package Sistema_Gerencia_Estudantil;

import Sistema_Gerencia_Estudantil.dados.RepositorioProfArray;
import Sistema_Gerencia_Estudantil.dados.RepositorioProfessor;
import Sistema_Gerencia_Estudantil.negocio.ControllerProfessor;
import Sistema_Gerencia_Estudantil.negocio.ControllerProfessorArray;
import Sistema_Gerencia_Estudantil.negocio.beans.Professor;

/**
 * Classe para Teste das funcionalidades do sistema
 */
public class MainTeste {

    public static void main(String[] args) {

        /* Teste de objetos Professor */
        Professor p1 = new Professor("Bárbara Lima", "07386499799", "password1","8555");
        Professor p2 = new Professor("Maria Tereza Buril", "06486578588", "password2","8556");
        Professor p3 = new Professor("Harvey M. Deitel", "85438657855", "password3","8557");
        Professor p4 = new Professor("Marcelo Carneiro Leao", "64027277090", "password4","8558");
        Professor p5 = new Professor("Paulo Freire", "38252243096", "password5","8559");
        Professor p6 = new Professor("Harvey M. Deitel", "85438657855", "password3","8557");

        System.out.println(p1.getCPF().length() + " - " + p1.getNome() );
        System.out.println(p2.getCPF().length() + " - " + p2.getNome() );
        System.out.println(p3.getCPF().length() + " - " + p3.getNome() );
        System.out.println(p4.getCPF().length() + " - " + p4.getNome() );
        System.out.println(p5.getCPF().length() + " - " + p5.getNome() );
        System.out.println(p3.equals(p6));

        /* Teste controllerProfessor */
        //ControllerProfessor.getInstance();  //Instanciando o controlador através do Sigleton Pattern

        /* Teste Método Create */
        ControllerProfessor.getInstance().inserir(p1); // Demonstração de sucesso acerca do Singleton Pattern
        ControllerProfessor.getInstance().inserir(p2);
        ControllerProfessor.getInstance().inserir(p3);
        ControllerProfessor.getInstance().inserir(p4);
        ControllerProfessor.getInstance().inserir(p5);
        ControllerProfessor.getInstance().inserir(p6);

        System.out.println();
       // ControllerProfessor.getInstance().listar();
        /* Teste método Retrieve */
       System.out.println(ControllerProfessor.getInstance().listar());
       /* Teste método Delete */
       ControllerProfessor.getInstance().remover(p6);
       ControllerProfessor.getInstance().remover(p4);
        System.out.println();
        System.out.println(ControllerProfessor.getInstance().listar());
        System.out.println();
        /* Método Update */
        ControllerProfessor.getInstance().atualizar(p1);
        System.out.println(ControllerProfessor.getInstance().listar());


        /* Seção de testes com Controller e Repositorio Baseados em Array */
        System.out.println("\n*** \t TESTE ARRAY \t ***");

        ControllerProfessorArray controllerProfessorArray = new ControllerProfessorArray();
        //controllerProfessorArray.cadastrarProf(p6);
        /* Teste Cadastro - método Create */
//        controllerProfessorArray.getRepositorioProfArray().inserirProf(p1);
//        controllerProfessorArray.getRepositorioProfArray().inserirProf(p2);
//        controllerProfessorArray.getRepositorioProfArray().inserirProf(p3);
//        controllerProfessorArray.getRepositorioProfArray().inserirProf(p4);
//        controllerProfessorArray.getRepositorioProfArray().inserirProf(p5);
//        controllerProfessorArray.getRepositorioProfArray().inserirProf(p6);
//        /* Teste método existe */
        controllerProfessorArray.cadastrarProf(p6);
        controllerProfessorArray.cadastrarProf(p4);
        System.out.println(controllerProfessorArray.existe(p6));
        System.out.println(p3.equals(p6)); // teste método equals classe Professor
        System.out.println(controllerProfessorArray.procurar(p6).getNome() + " " + controllerProfessorArray.procurar(p6).getCPF());
        /* Teste método remover - Método Delete */
        controllerProfessorArray.descadastrarProf(p4);
        //controllerProfessorArray.getRepositorioProfArray().removerProf(p4.getCPF());
        System.out.println(controllerProfessorArray.existe(p6));
        System.out.println(controllerProfessorArray.procurar(p4));

        System.out.println(controllerProfessorArray.procurar(p6));






    }
}