package entidades;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private final Lock lock = new ReentrantLock();

    public void transferir(Conta origem, Conta destino, double valor) {
        lock.lock();
        try {
            origem.debitar(valor);
            destino.creditar(valor);
            System.out.println("Transferência de " + valor + " de " + origem.getCliente() + " para " + destino.getCliente());
            System.out.println("Saldo final de " + origem.getCliente() + ": " + origem.getSaldo());
            System.out.println("Saldo final de " + destino.getCliente() + ": " + destino.getSaldo());
        } finally {
            lock.unlock();
        }
    }
}
