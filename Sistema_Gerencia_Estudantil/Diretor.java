import java.util.Date;

public class Diretor extends Usuario {
    private int ID;
    private String cargo;

    public Diretor(String nome, String email, String senha, String cpf) {
        super(nome, email, senha, cpf); // ta chamando os construct da superclasse usuário, cujo diretor é uma extensão e contém herança
    }
}