package entidades;

public class Cliente extends Thread {
    private String nome;
    private Conta conta;
    private Loja[] lojas;

    public Cliente(String nome, Conta conta, Loja[] lojas) {
        this.nome = nome;
        this.conta = conta;
        this.lojas = lojas;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // Simula o tempo entre as compras
                double valorCompra = Math.random() < 0.5 ? 100 : 200;
                Loja loja = lojas[(int) (Math.random() * lojas.length)];
                synchronized (conta) {
                    if (conta.getSaldo() >= valorCompra) {
                        conta.debitar(valorCompra);
                        loja.pagarFuncionario(this);
                        System.out.println("Compra de R$" + valorCompra + " realizada por " + nome +
                                " na loja " + loja);
                    } else {
                        System.out.println("Saldo insuficiente para " + nome + " realizar compra");
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
