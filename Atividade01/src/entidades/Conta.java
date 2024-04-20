package entidades;

public class Conta {
    private String titular; // Titular da conta
    private double saldo; // Saldo da conta

    // Construtor da classe Conta
    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    // Método para obter o saldo da conta
    public double getSaldo() {
        return saldo;
    }

    // Método para creditar um valor à conta
    public void creditar(double valor) {
        saldo += valor;
    }

    // Método para debitar um valor da conta
    public void debitar(double valor) {
        saldo -= valor;
    }

    // Método para obter o titular da conta
    public String getTitular() {
        return titular;
    }
}
