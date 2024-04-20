package entidades;

public class Banco {

    // Método para transferir dinheiro entre contas
    public static void transferir(Conta origem, Conta destino, double valor) {
        // Sincroniza o acesso à conta de origem para evitar condições de corrida
        synchronized (origem) {
            // Sincroniza o acesso à conta de destino para evitar condições de corrida
            synchronized (destino) {
                // Verifica se há saldo suficiente na conta de origem para a transferência
                if (origem.getSaldo() >= valor) {
                    // Debita o valor da conta de origem
                    origem.debitar(valor);
                    // Credita o valor na conta de destino
                    destino.creditar(valor);
                    // Imprime mensagem de confirmação da transferência
                    System.out.println("Transferência de R$ " + valor + " de " + origem.getTitular() + " para " + destino.getTitular());
                } else {
                    // Imprime mensagem de saldo insuficiente se não houver saldo para a transferência
                    System.out.println("Saldo insuficiente para transferência de " + origem.getTitular() + " para " + destino.getTitular());
                }
            }
        }
    }
}
