package Sistema_Gerencia_Estudantil;

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
