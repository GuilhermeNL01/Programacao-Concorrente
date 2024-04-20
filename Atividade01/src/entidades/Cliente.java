package entidades;

public class Cliente extends Thread {
    private final Conta conta;

    public Cliente(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void run() {
        while (conta.getSaldo() > 0) {
            double valor = Math.random() < 0.5 ? 100 : 200;
            Banco banco = new Banco();
            Conta lojaDestino = null;
            // Lógica para selecionar a loja de destino
            banco.transferir(conta, lojaDestino, valor);
            try {
                Thread.sleep(100); // Simulação de tempo entre transações
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
