package entidades;

public class Funcionario extends Thread {
    private String nome;
    private double salario;
    private Conta contaSalario;
    private Conta contaInvestimento;

    public Funcionario(String nome, double salario, Conta contaSalario, Conta contaInvestimento) {
        this.nome = nome;
        this.salario = salario;
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // Simula o tempo entre os salários
                double salarioLiquido = salario * 0.8; // Desconta 20% para o investimento
                synchronized (contaSalario) {
                    contaSalario.creditar(salarioLiquido);
                    contaInvestimento.creditar(salario * 0.2);
                    System.out.println("Salário de R$" + salarioLiquido + " recebido por " + nome);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void receberSalario(double valor) {
        synchronized (contaSalario) {
            contaSalario.creditar(valor);
        }
    }
}
