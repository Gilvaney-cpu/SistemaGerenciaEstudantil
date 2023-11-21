package Sistema_Gerencia_Estudantil.negocio.beans;

public class Usuario { //Atributos
    private String nome;
    private String CPF;
    private String senha;
    private String ID;

    public Usuario(String nome, String CPF, String senha, String ID){ //Instanciamento de atributos da classe {
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
        this.ID = ID;
    }
    // Método para apresentar o usuário
    public void apresentarUsuario() {
        System.out.println("Olá, eu sou o usuário " + getNome() + ".");
    }
//exemplo:
  //  Usuario usuario = new Usuario("João", "123456789", "senha123", "U1");
usuario.apresentarUsuario();

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
