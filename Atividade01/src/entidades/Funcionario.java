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
        synchronized (contaSalario) {
            try {
                Thread.sleep(2000); // Simula o tempo de processamento de pagamento
                contaInvestimento.creditar(salario * 0.2);
                System.out.println(nome + " investiu R$ " + (salario * 0.2) + " em sua conta de investimentos.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public double getSalario() {
        return salario;
    }

    public String getNome() {
        return nome;
    }

    public void receberSalario() {
        contaSalario.creditar(salario);
    }
}
