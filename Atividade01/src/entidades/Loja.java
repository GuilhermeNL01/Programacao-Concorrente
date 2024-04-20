package entidades;

public class Loja {
    private Conta conta;

    public Loja(Conta conta) {
        this.conta = conta;
    }

    public boolean pagarFuncionario(Funcionario funcionario) {
        synchronized (conta) {
            double salario = funcionario.getSalario();
            if (conta.getSaldo() >= salario) {
                conta.debitar(salario);
                // Transferir fundos da conta da loja para a conta de salário do funcionário
                Banco.transferir(conta, funcionario.getContaSalario(), salario);
                funcionario.receberSalario();
                System.out.println("Funcionário " + funcionario.getNome() + " pago com sucesso.");
                return true; // Pagamento bem-sucedido
            } else {
                System.out.println("Saldo insuficiente para pagar o funcionário " + funcionario.getNome());
                return false; // Pagamento mal-sucedido
            }
        }
    }
}
