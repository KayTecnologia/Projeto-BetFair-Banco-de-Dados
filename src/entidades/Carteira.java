package entidades;

public class Carteira {
    private String idUsuario;
    private double saldo;

    public Carteira(String idUsuario, double saldo) {
        this.idUsuario = idUsuario;
        this.saldo = saldo;
    }

    public Carteira(String idUsuario) {
        this.idUsuario = idUsuario;
        this.saldo = 0.0;
    }

    public Carteira() {
        this.idUsuario = "0";
        this.saldo = 0.0;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String adicionarFundos(double valor) {
        saldo += valor;
        return "Adicionado R$" + valor + ". Novo saldo: R$" + saldo;
    }

    public String adicionarFundos(double valor, String motivo) {
        saldo += valor;
        return "Adicionado R$" + valor + " (" + motivo + "). Novo saldo: R$" + saldo;
    }
}