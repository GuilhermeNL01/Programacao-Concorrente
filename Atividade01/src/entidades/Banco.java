package entidades;

public class Banco {
    public synchronized void transferencia(Conta origem, Conta destino, double valor) {
        if (origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
            System.out.println("Transferência de R$" + valor + " realizada de " + origem.getTitular() +
                    " para " + destino.getTitular());
        } else {
            System.out.println("Saldo insuficiente para transferência de " + origem.getTitular());
        }
    }
}
