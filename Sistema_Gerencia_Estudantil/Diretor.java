ublic class Diretor extends Usuario { //Atributos
    private int id;
    private String cargo;
//instanciamento de atributos:
    public Diretor(int id, String cargo, String nome, String email, String senha) {
        super(nome, email, senha, "");
        this.id = id;
        this.cargo = cargo;
    }
//get e set
    public int getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }
}
