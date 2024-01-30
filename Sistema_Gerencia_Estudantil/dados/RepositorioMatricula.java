package Sistema_Gerencia_Estudantil.dados;

import Sistema_Gerencia_Estudantil.negocio.beans.Matricula;

import java.util.ArrayList;

public class RepositorioMatricula {

    private ArrayList<Matricula> repositorioMatricula = new ArrayList<>();

    public RepositorioMatricula() {
        /* método construtor vazio */
    }

    /* Adiciona a matrícula passada como parâmetro ao repositório - Create */
    public void inserirMatricula(Matricula matricula) {
        if (matricula != null) {
            if (repositorioMatricula.isEmpty() || !repositorioMatricula.contains(matricula)) {
                repositorioMatricula.add(matricula);
            }
        }
    }

    /* Retorna uma lista de matrículas cadastradas no repositório - Retrieve */
    public ArrayList<Matricula> listarMatriculas() {
        ArrayList<Matricula> lista = new ArrayList<>();
        if (!repositorioMatricula.isEmpty()) {
            for (Matricula m : repositorioMatricula) {
                lista.add(m);
            }
        }
        return lista;
    }

    /* Remove a matrícula (passada como parâmetro) do repositório - Delete */
    public void removerMatricula(Matricula matricula) {
        if (matricula != null && repositorioMatricula.contains(matricula)) {
            repositorioMatricula.remove(matricula);
        }
    }

    /* Atualiza uma matrícula que já esteja no repositório - Update */
    public ArrayList<Matricula> atualizarMatricula(Matricula matricula) {
        ArrayList<Matricula> lista = new ArrayList<>();
        if (matricula != null && repositorioMatricula.contains(matricula)) {
            for (int i = 0; i < repositorioMatricula.size(); i++) {
                /*if (repositorioMatricula.get(i).getNumero() == matricula.getNumero()) {
                    repositorioMatricula.remove(repositorioMatricula.get(i)); // removeu a matrícula desejada
                }*/ if (repositorioMatricula.get(i).getIdMatricula().equals(matricula.getIdMatricula())) {
                    this.removerMatricula(matricula);
                }
            }
            this.inserirMatricula(matricula); // reinseriu a matrícula
            lista = this.listarMatriculas();
        }
        return lista; // devolve a lista com a matrícula atualizada
    }
}
