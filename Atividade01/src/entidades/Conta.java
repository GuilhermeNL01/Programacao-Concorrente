package entidades;

public class Conta {
    private String titular;
    private double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public synchronized void creditar(double valor) {
        saldo += valor;
    }

    public synchronized void debitar(double valor) {
        saldo -= valor;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
