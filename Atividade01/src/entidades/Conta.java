package entidades;

public class Conta {
    private final String cliente;
    private double saldo;

    public Conta(String cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public synchronized void creditar(double valor) {
        saldo += valor;
    }

    public synchronized void debitar(double valor) {
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCliente() {
        return cliente;
    }
}
