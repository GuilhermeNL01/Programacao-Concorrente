package entidades;

public class Banco {
    public static void transferir(Conta origem, Conta destino, double valor) {
        synchronized (origem) {
            synchronized (destino) {
                if (origem.getSaldo() >= valor) {
                    origem.debitar(valor);
                    destino.creditar(valor);
                    System.out.println("Transferência de R$ " + valor + " de " + origem.getTitular() + " para " + destino.getTitular());
                } else {
                    System.out.println("Saldo insuficiente para transferência de " + origem.getTitular() + " para " + destino.getTitular());
                }
            }
        }
    }
}
