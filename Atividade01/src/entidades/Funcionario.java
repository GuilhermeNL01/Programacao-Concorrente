package entidades;

public class Funcionario extends Thread {
    private final Conta contaSalario;
    private final Conta contaInvestimento;

    public Funcionario(Conta contaSalario, Conta contaInvestimento) {
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    @Override
    public void run() {
        // Lógica para receber o salário, investir e realizar outras operações
    }
}
