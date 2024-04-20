package entidades;

import java.util.Random;

public class Cliente extends Thread {
    private static final double SALDO_INICIAL = 1000.0; // Saldo inicial do cliente
    private static final double[] VALORES_COMPRA = {100.0, 200.0}; // Valores possíveis para as compras
    private String nome; // Nome do cliente
    private Conta conta; // Conta do cliente
    private Loja[] lojas; // Array de lojas disponíveis para compras

    // Construtor da classe Cliente
    public Cliente(String nome, Conta conta, Loja[] lojas) {
        this.nome = nome;
        this.conta = conta;
        this.lojas = lojas;
    }

    // Método para execução da thread
    public void run() {
        Random random = new Random();
        // Loop enquanto o cliente tiver saldo na conta
        while (conta.getSaldo() > 0) {
            double valorCompra = VALORES_COMPRA[random.nextInt(VALORES_COMPRA.length)]; // Valor da compra aleatório
            Loja loja = lojas[random.nextInt(lojas.length)]; // Seleciona uma loja aleatória
            synchronized (loja) {
                // Verifica se há saldo suficiente na conta para a compra
                if (conta.getSaldo() >= valorCompra) {
                    conta.debitar(valorCompra); // Debita o valor da compra da conta
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
