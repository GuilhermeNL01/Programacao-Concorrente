package entidades;

public class Loja {
    private Conta conta;

    public Loja(Conta conta) {
        this.conta = conta;
    }

    public synchronized void pagarFuncionario(Funcionario funcionario) {
        if (conta.getSaldo() >= funcionario.getSalario()) {
            conta.debitar(funcionario.getSalario());
            funcionario.receberSalario();
            System.out.println("Funcionário " + funcionario.getNome() + " pago com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para pagar o funcionário " + funcionario.getNome());
        }
    }
}
