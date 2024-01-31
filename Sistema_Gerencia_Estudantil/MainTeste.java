package Sistema_Gerencia_Estudantil;

import Sistema_Gerencia_Estudantil.dados.RepositorioProfArray;
import Sistema_Gerencia_Estudantil.dados.RepositorioProfessor;
import Sistema_Gerencia_Estudantil.exceptions.*;
import Sistema_Gerencia_Estudantil.negocio.*;
import Sistema_Gerencia_Estudantil.negocio.beans.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe para Teste das funcionalidades do sistema
 */
public class MainTeste {

    public static void main(String[] args) throws ProfessorJaExisteException, ProfessorNaoExisteException, DisciplinaJaExisteException, DisciplinaNaoExisteException, NotasDisciplinaJaExisteException, NotasDisciplinaNaoExisteException, PresencaJaExisteException, PresencaNaoExisteException {

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
        System.out.println("\n*** \t TESTE ProfARRAY \t ***");
        ControllerProfessorArray.getInstance().cadastrarProf(p1);
        ControllerProfessorArray.getInstance().cadastrarProf(p2);
        ControllerProfessorArray.getInstance().cadastrarProf(p3);
        ControllerProfessorArray.getInstance().cadastrarProf(p4);
        ControllerProfessorArray.getInstance().cadastrarProf(p5);
       // ControllerProfessorArray.getInstance().cadastrarProf(p6);
        System.out.println("P3.EQUALS(P6): " + p3.equals(p6)); // teste método equals classe Professor
        /* Teste Existe e Procurar */
        System.out.println(ControllerProfessorArray.getInstance().existe(p6));
        System.out.println(ControllerProfessorArray.getInstance().procurar(p6).getNome() + " " + ControllerProfessorArray.getInstance().procurar(p6).getCPF());
        /* Teste Delete */
        ControllerProfessorArray.getInstance().descadastrarProf(p4);
        System.out.println(ControllerProfessorArray.getInstance().existe(p4));
        System.out.println(ControllerProfessorArray.getInstance().existe(p6));
        System.out.println(ControllerProfessorArray.getInstance().procurar(p6));

        /* TESTE DISCIPLINAARRAY */
        System.out.println("\n***\tTeste Controller e repositorio classe Disciplina \t***\n");
        Disciplina d1 = new Disciplina("Português", p1, LocalTime.of(7,30),new Turma(124,"3 ANO C","Paula Tejano", "Manhã"));
        Disciplina d2 = new Disciplina("Biologia", p2, LocalTime.of(8,40),new Turma(124,"3 ANO C","Etê Bilú", "Manhã"));
        Disciplina d3 = new Disciplina("Filosofia", p5, LocalTime.of(9,50),new Turma(124,"3 ANO C","Nelson Rodrigues", "Manhã"));
        /* Teste Create */
        ControllerDisciplinaArray.getInstance().cadastrarDisciplina(d1);
        ControllerDisciplinaArray.getInstance().cadastrarDisciplina(d2);
        ControllerDisciplinaArray.getInstance().cadastrarDisciplina(d3);
        /* Teste Existe */
        System.out.println(ControllerDisciplinaArray.getInstance().existe(d1));
        System.out.println(ControllerDisciplinaArray.getInstance().existe(d2));
        System.out.println(ControllerDisciplinaArray.getInstance().existe(d3));
        /* Teste Procurar */
        System.out.println(ControllerDisciplinaArray.getInstance().procurar(d1).getNome() + " - Horário: " + ControllerDisciplinaArray.getInstance().procurar(d1).getHorario());
        System.out.println(ControllerDisciplinaArray.getInstance().procurar(d2).getNome() + " - Horário: " + ControllerDisciplinaArray.getInstance().procurar(d2).getHorario());
        System.out.println(ControllerDisciplinaArray.getInstance().procurar(d3).getNome() + " - Horário: " + ControllerDisciplinaArray.getInstance().procurar(d3).getHorario());
        /* Teste Delete */
        ControllerDisciplinaArray.getInstance().remover(d2);
        System.out.println(ControllerDisciplinaArray.getInstance().existe(d2));

        /* TESTE NotasDisciplinaArray CONTROLLER E REPOSITORIO */
        System.out.println("*** \t TESTE NotasDisciplinaArray CONTROLLER E REPOSITORIO \t ***");
       Turma t1 = new Turma(124,"3 ANO C","Paula Tejano", "Manhã");
        NotasDisciplina ntd1 = new NotasDisciplina(t1,d1);
        ControllerNotasDisciplinaArray.getInstance().inserir(ntd1);
        System.out.println(ControllerNotasDisciplinaArray.getInstance().procurar(ntd1));
        System.out.println("Usando método 'existe': " + ControllerNotasDisciplinaArray.getInstance().existe(ntd1));
        ControllerNotasDisciplinaArray.getInstance().remover(ntd1);
        System.out.println("Usando método 'existe' depois de remover: " + ControllerNotasDisciplinaArray.getInstance().existe(ntd1));

        /* TESTE PresencaArray CONTROLLER E REPOSITORIO */
        System.out.println();
        System.out.println("*** \t TESTE PresencaArray CONTROLLER E REPOSITORIO \t ***");
        Presenca presenca1 = new Presenca(LocalDate.of(2023,12,1),"3 ANO B","Rolando Lero");
        ControllerPresencaArray.getInstance().inserir(presenca1);
        System.out.println(ControllerPresencaArray.getInstance().procurar(presenca1));
        System.out.println("Usando o método 'existe': " + ControllerPresencaArray.getInstance().existe(presenca1));
        ControllerPresencaArray.getInstance().remover(presenca1);
        System.out.println("Usando o método 'existe' depois de remover: " + ControllerPresencaArray.getInstance().existe(presenca1));

        /* Teste métodos atribuirNota e atribuirPresenca */
        Matricula m1 = new Matricula("07653123","Português",2023,1);
       Aluno aluno1 = new Aluno("Kiessen MayKoch", "19199344798","password7","a249iq", LocalDate.of(2009,12,03), t1.getNome(),m1 );
       ControllerAluno.getInstance().inserir(aluno1);
       ControllerProfessorArray.getInstance().atribuirNota(p1,t1,d1,aluno1,8.7);
        ControllerProfessorArray.getInstance().atribuirPresenca(p1,t1,d1,aluno1);

        /* Trecho totalmente descartável */
        System.out.println("\n\nteste m1 e aluno1");
        System.out.println(ControllerProfessorArray.getInstance().procurar(p1));
        System.out.println(ControllerAluno.getInstance().listar().size());
        System.out.println(ControllerAluno.getInstance().listar());

        /* Teste FACHADA */
        System.out.println("\n\n****\tTeste Fachada\t****");
        System.out.println(Fachada.getInstance().procurarProfessor(p1));
        System.out.println(Fachada.getInstance().procurarProfessor(p6));
       Fachada.getInstance().cadastrarProfessor(p4);
        System.out.println(Fachada.getInstance().procurarProfessor(p4));
        Fachada.getInstance().descadastrarProfessor(p4);
        System.out.println(Fachada.getInstance().existeProfessor(p4));
        System.out.println(Fachada.getInstance().listarAlunos());



    }
}
