package Sistema_Gerencia_Estudantil;

public class Diretor extends Usuario { //Atributos
    private int id;
    private String cargo;
//instanciamento de atributos:
    public Diretor(int id, String cargo, String nome, String email, String senha) {
        super(nome, email, senha, "");
        this.id = id;
        this.cargo = cargo;
    }
     // Método para imprimir informações do diretor
    public void imprimirInformacoes() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + getNome());
        System.out.println("Cargo: " + cargo);
    }

    //exemplo:
    Diretor diretor = new Diretor(1, "João", "Diretor");
diretor.imprimirInformacoes();
    
//get e set
    public int getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }
}
