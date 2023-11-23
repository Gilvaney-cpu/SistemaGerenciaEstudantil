package Sistema_Gerencia_Estudantil.dados;


import Sistema_Gerencia_Estudantil.negocio.beans.Professor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioProfessor {

    private ArrayList<Professor> repositorioProfessor = new ArrayList<>();

    public RepositorioProfessor() {
        /* método construtor vazio*/
    }

    /* Adiciona o professor passado como parâmetro ao repositório - create */
    public void inserirProfessor(Professor professor) {
        if(professor != null && (!(repositorioProfessor.contains(professor))) ) {
            repositorioProfessor.add(professor); // adiciona o professor ao repositório
        }
    }
    /* Retorna uma lista de professores cadastrados no repositório  - recover */
    public ArrayList<Professor> listarProfessores() {
        ArrayList<Professor> lista = new ArrayList<>();
        if (!repositorioProfessor.isEmpty()) {
            //Collections.sort(repositorioProfessor); é necessário fazer o comparable na classe professor
            /* Percorre o repositório de professores */
            for(Professor p : repositorioProfessor) {
                lista.add(p);
            }
        }
        return lista;
    }

    /* Remove professor (passado como parâmetro) do repositorio - remove */
    public void removerProfessor(Professor professor) {
        if(professor != null && repositorioProfessor.contains(professor)) {
            repositorioProfessor.remove(professor);
        }

    }

    /* Atualiza um professor que já esteja no repositório */
    public ArrayList<Professor> atualizarProfessor(Professor professor) {
        ArrayList<Professor> lista = new ArrayList<>();
        if(professor != null && repositorioProfessor.contains(professor)) {
           for(int i = 0; i < repositorioProfessor.size(); i++) {
               if(repositorioProfessor.get(i).getCPF().equals(professor.getCPF())) {
                   repositorioProfessor.remove(repositorioProfessor.get(i)); // removeu o professor desejado

               }
           }
           this.inserirProfessor(professor); // reinseriu o professor
            lista = this.listarProfessores();
        }
        return lista; // devolve a lista com o professor atualizado
    }




}
