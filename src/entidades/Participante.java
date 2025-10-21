package entidades;

public abstract class Participante {
    private String nome;
    private String id;

    public Participante(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public Participante(String id) {
        this.id = id;
        this.nome = "Desconhecido";
    }

    public Participante() {
        this.nome = "Sem Nome";
        this.id = "0";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String exibirInformacoes();

    public String registrarAcao() {
        return "Ação registrada por " + nome;
    }

    public String registrarAcao(String detalhes) {
        return "Ação registrada por " + nome + ": " + detalhes;
    }
}