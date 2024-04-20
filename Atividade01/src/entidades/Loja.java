package entidades;

public class Loja {
    private Conta conta;

    public Loja(Conta conta) {
        this.conta = conta;
    }

    public synchronized void pagarFuncionario(Funcionario funcionario) {
        double salario = funcionario.getSalario();
        if (conta.getSaldo() >= salario) {
            conta.debitar(salario);
            funcionario.receberSalario(salario);
            System.out.println("Pagamento de R$" + salario + " para " + funcionario.getNome() + " realizado");
        } else {
            System.out.println("Saldo insuficiente para pagar " + funcionario.getNome());
        }
    }
}
