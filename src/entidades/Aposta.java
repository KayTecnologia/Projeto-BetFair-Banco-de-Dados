package entidades;

public class Aposta {
    private String idAposta;
    private String idUsuario;
    private String idEvento;
    private double valor;
    private String resultadoEscolhido;

    public Aposta(String idAposta, String idUsuario, String idEvento, double valor, String resultadoEscolhido) {
        this.idAposta = idAposta;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.valor = valor;
        this.resultadoEscolhido = resultadoEscolhido;
    }

    public Aposta(String idAposta, String idUsuario, String idEvento, double valor) {
        this(idAposta, idUsuario, idEvento, valor, "Não definido");
    }

    public Aposta(String idAposta) {
        this.idAposta = idAposta;
        this.idUsuario = "0";
        this.idEvento = "0";
        this.valor = 0.0;
        this.resultadoEscolhido = "Não definido";
    }

    public String getIdAposta() {
        return idAposta;
    }

    public void setIdAposta(String idAposta) {
        this.idAposta = idAposta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getResultadoEscolhido() {
        return resultadoEscolhido;
    }

    public void setResultadoEscolhido(String resultadoEscolhido) {
        this.resultadoEscolhido = resultadoEscolhido;
    }

    public String detalhesAposta() {
        return "Aposta ID: " + idAposta + ", Valor: R$" + valor;
    }

    public String detalhesAposta(boolean incluirUsuario) {
        if (incluirUsuario) {
            return "Aposta ID: " + idAposta + ", Usuário ID: " + idUsuario + ", Valor: R$" + valor;
        }
        return detalhesAposta();
    }
}