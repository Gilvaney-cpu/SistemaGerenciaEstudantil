package Sistema_Gerencia_Estudantil.negocio;


import Sistema_Gerencia_Estudantil.exceptions.*;
import Sistema_Gerencia_Estudantil.negocio.beans.*;

import java.util.List;

public class Fachada {
    private ControllerProfessorArray controllerProfessorArray;
    private ControllerDisciplinaArray controllerDisciplinaArray;
    private ControllerNotasDisciplinaArray controllerNotasDisciplinaArray;
    private ControllerPresencaArray controllerPresencaArray;
    private ControllerAluno controllerAluno; // Gilvaney
    private ControllerMatricula controllerMatricula; //Gilvaney

    private static Fachada instance;

    /* Método Construtor*/
    private Fachada() {
        controllerProfessorArray = ControllerProfessorArray.getInstance();
        controllerDisciplinaArray = ControllerDisciplinaArray.getInstance();
        controllerNotasDisciplinaArray = ControllerNotasDisciplinaArray.getInstance();
        controllerPresencaArray = ControllerPresencaArray.getInstance();
        controllerAluno = ControllerAluno.getInstance();
        controllerMatricula = ControllerMatricula.getInstance();

    }

    /* Implementação Singleton Pattern */
    public static Fachada getInstance() {
        if(instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    /* Controller Professor
    * revisar métodos ATRIBUIR NOTA E ATRIBUIR PRESENCA (EXCEPTIONS E teste)*/

    public void cadastrarProfessor (Professor p) throws ProfessorJaExisteException {
        controllerProfessorArray.cadastrarProf(p);
    }

    public Professor procurarProfessor(Professor p) throws ProfessorNaoExisteException {

        return controllerProfessorArray.procurar(p);
    }

    public boolean existeProfessor (Professor p) {
        return controllerProfessorArray.existe(p);
    }

    public void descadastrarProfessor (Professor professor) throws ProfessorNaoExisteException {
        controllerProfessorArray.descadastrarProf(professor);
    }

    public void atribuirNota(Professor professor, Turma turma, Disciplina disciplina, Aluno aluno, double nota) {
        controllerProfessorArray.atribuirNota(professor, turma, disciplina, aluno, nota);
    }

    public void atribuirPresencaProfessor(Professor professor, Turma turma, Disciplina disciplina, Aluno aluno) {
        controllerProfessorArray.atribuirPresenca(professor,turma,disciplina,aluno);
    }

    /* Métodos Disciplina */
    public void cadastrarDisciplina(Disciplina d) throws DisciplinaJaExisteException {
        controllerDisciplinaArray.cadastrarDisciplina(d);
    }

    public Disciplina procurarDisciplina(Disciplina d) throws DisciplinaNaoExisteException {
        return controllerDisciplinaArray.procurar(d);
    }

    public void removerDisciplina(Disciplina d) throws DisciplinaNaoExisteException {
        controllerDisciplinaArray.remover(d);
    }

    public boolean existeDisciplina(Disciplina d) {
        return controllerDisciplinaArray.existe(d);
    }

    /* Métodos NotasDisciplina */
    public void inserirNotasDisciplina(NotasDisciplina ntd) throws NotasDisciplinaJaExisteException {
        controllerNotasDisciplinaArray.inserir(ntd);
    }

    public boolean existeNotasDisciplina(NotasDisciplina ntd) {
        return controllerNotasDisciplinaArray.existe(ntd);
    }

    public NotasDisciplina procurarNotasDisciplina (NotasDisciplina ntd) throws NotasDisciplinaNaoExisteException {
        return controllerNotasDisciplinaArray.procurar(ntd);
    }

    public void removerNotasDisciplina (NotasDisciplina ntd) throws NotasDisciplinaNaoExisteException {
        controllerNotasDisciplinaArray.remover(ntd);
    }

    /* Métodos Presença */
    public void inserirPresenca (Presenca p) throws PresencaJaExisteException {
        controllerPresencaArray.inserir(p);
    }

    public boolean existePresenca(Presenca p) {
        return controllerPresencaArray.existe(p);
    }

    public Presenca procurarPresenca(Presenca p) throws PresencaNaoExisteException {
        return controllerPresencaArray.procurar(p);
    }

    public void removerPresenca (Presenca p) throws PresencaNaoExisteException {
        controllerPresencaArray.remover(p);
    }

    /* Métodos ControllerAluno */
    public void inserirAluno(Aluno a) {
        controllerAluno.inserir(a);
    }

    public List<Aluno> listarAlunos() {
        return controllerAluno.listar();
    }

    public void removerAluno(Aluno a) {
        controllerAluno.remover(a);
    }

    public void atualizarAluno(Aluno a) {
        controllerAluno.atualizar(a);
    }

    public void atribuirPresencaAluno(Aluno a, Turma t, Disciplina d) {
        controllerAluno.atribuirPresenca(a, t, d);
    }

    /* Métodos do Controller Matricula */
    public void inserirMatricula(Matricula m) {
        controllerMatricula.inserir(m);
    }

    public List<Matricula> listarMatriculas() {
        return controllerMatricula.listar();
    }

    public void removerMatricula(Matricula m) {
        controllerMatricula.remover(m);
    }

    public void atualizarMatricula(Matricula m) {
        controllerMatricula.atualizar(m);
    }


}
