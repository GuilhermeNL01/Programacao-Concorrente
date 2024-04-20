package entidades;

public class Funcionario extends Thread {
    private String nome; // Nome do funcionário
    private double salario; // Salário do funcionário
    private Conta contaSalario; // Conta de salário do funcionário
    private Conta contaInvestimento; // Conta de investimento do funcionário
    private Conta[] contas; // Array de contas do funcionário (não utilizado no código fornecido)

    // Construtor da classe Funcionario
    public Funcionario(String nome, double salario, Conta contaSalario, Conta contaInvestimento) {
        this.nome = nome;
        this.salario = salario;
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
        this.contas = contas; // Array de contas não está sendo utilizado aqui
    }

    // Método para execução da thread
    public void run() {
        synchronized (contaSalario) {
            try {
                Thread.sleep(2000); // Simula o tempo de processamento de pagamento
                contaInvestimento.creditar(salario * 0.2); // Credita 20% do salário na conta de investimento
                System.out.println(nome + " investiu R$ " + (salario * 0.2) + " em sua conta de investimentos.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para obter a conta de salário do funcionário
    public Conta getContaSalario() {
        // Retorna a conta de salário
        return contaSalario;
    }

    // Método para obter o salário do funcionário
    public double getSalario() {
        return salario;
    }

    // Método para obter o nome do funcionário
    public String getNome() {
        return nome;
    }

    // Método para receber o salário na conta de salário do funcionário
    public void receberSalario() {
        contaSalario.creditar(salario);
    }
}
