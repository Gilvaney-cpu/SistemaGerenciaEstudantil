package Sistema_Gerencia_Estudantil.negocio.beans;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements Serializable {

    /* VERIFICAR O CODIGO NO FINAL DESTA CLASSE (psvm) para posterior exclusão */
    @Serial
    private static final long serialVersionUID = -8993350995089294146L;
    private ArrayList<Turma> turma;
    private boolean ativo;
    private ArrayList<Disciplina> disciplina;

    /* Método construtor */
    public Professor(String nome, String cpf, String senha, String id) {

        super(nome, cpf, senha, id); // herança da classe Usuario.
        turma = new ArrayList<Turma>();
        this.disciplina = new ArrayList<>();
        this.ativo = true;
    }

    public ArrayList<Turma> getTurma() {
        return turma;
    }

    public void setTurma(ArrayList<Turma> turma) {
        this.turma = turma;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public ArrayList<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(ArrayList<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

    public String toString(){
        /* Devolve o nome, id(super), nome da classe 'professor' do professor */
        return String.format("Nome: %-10s | \nId: %10s | \nCargo: %-10s |\n",this.getNome()
                ,super.getID()
                , this.getClass().getSimpleName().toUpperCase());
    }

    public boolean equals(Professor professor) {
        boolean b = false;
        if(professor != null) {
           if(this.getCPF().equals(professor.getCPF())) {
                b = true;
            }
        }
        return b;
    }

    public static void main(String[] args) {

        /* TESTE DE MANIPULAÇÃO DE ARQUIVOS*/
        File f = new File("meuArquivo.dat");

        try {
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);

            List<Professor> listaProf = (List<Professor>) ois.readObject();

            for (Professor p: listaProf) {
                System.out.println(p.getNome());
                System.out.println(p.getCPF());
                System.out.println(p.getID());
                System.out.println("**********");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
