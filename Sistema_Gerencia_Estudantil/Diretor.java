ublic class Diretor extends Usuario {
    private int id;
    private String cargo;

    public Diretor(int id, String cargo, String nome, String email, String senha) {
        super(nome, email, senha, "");
        this.id = id;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }
}
