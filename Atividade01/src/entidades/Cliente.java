package entidades;

import java.util.Random;

public class Cliente extends Thread {
    private static final double SALDO_INICIAL = 1000.0;
    private static final double[] VALORES_COMPRA = {100.0, 200.0};
    private String nome;
    private Conta conta;
    private Loja[] lojas;

    public Cliente(String nome, Conta conta, Loja[] lojas) {
        this.nome = nome;
        this.conta = conta;
        this.lojas = lojas;
    }

    public void run() {
        Random random = new Random();
        while (conta.getSaldo() > 0) {
            double valorCompra = VALORES_COMPRA[random.nextInt(VALORES_COMPRA.length)];
            Loja loja = lojas[random.nextInt(lojas.length)];
            synchronized (loja) {
                if (conta.getSaldo() >= valorCompra) {
                    conta.debitar(valorCompra);
                    // Simula o tempo de compra
                    try {
                        Thread.sleep(500); // 0.5 segundo de atraso
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Cliente " + nome + " comprou na loja " + loja.hashCode() + " no valor de R$ " + valorCompra);
                } else {
                    System.out.println("Saldo insuficiente para cliente " + nome);
                    break;
                }
            }
        }
        // Simula o tempo de finalização das compras
        try {
            Thread.sleep(1000); // 1 segundo de atraso
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cliente " + nome + " finalizou suas compras.");
    }
}
