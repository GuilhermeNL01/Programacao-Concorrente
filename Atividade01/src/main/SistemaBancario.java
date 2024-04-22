package main;

import entidades.*;

public class SistemaBancario {
    public static void main(String[] args) {
        // Criando as contas para o banco, lojas, funcionários e clientes
        Conta contaBanco = new Conta("Banco", Double.POSITIVE_INFINITY); // Conta ilimitada para o banco
        Conta contaLoja1 = new Conta("Loja 1", 0);
        Conta contaLoja2 = new Conta("Loja 2", 0);
        Conta[] contasFuncionario1 = {new Conta("Funcionário 1 da Loja 1", 0), new Conta("Investimento Funcionário 1 da Loja 1", 0)};
        Conta[] contasFuncionario2 = {new Conta("Funcionário 1 da Loja 2", 0), new Conta("Investimento Funcionário 1 da Loja 2", 0)};
        // Criando as lojas, funcionários e clientes
        Loja loja1 = new Loja(contaLoja1);
        Loja loja2 = new Loja(contaLoja2);
        Funcionario funcionario1 = new Funcionario("Funcionário 1", 1400, contasFuncionario1[0], contasFuncionario1[1]);
        Funcionario funcionario2 = new Funcionario("Funcionário 2", 1400, contasFuncionario2[0], contasFuncionario2[1]);
        Cliente[] clientes = {
                new Cliente("Cliente 1", new Conta("Conta Cliente 1", 1000), new Loja[]{loja1, loja2}),
                new Cliente("Cliente 2", new Conta("Conta Cliente 2", 1000), new Loja[]{loja1, loja2}),
                new Cliente("Cliente 3", new Conta("Conta Cliente 3", 1000), new Loja[]{loja1, loja2}),
                new Cliente("Cliente 4", new Conta("Conta Cliente 4", 1000), new Loja[]{loja1, loja2}),
                new Cliente("Cliente 5", new Conta("Conta Cliente 5", 1000), new Loja[]{loja1, loja2})
        };
        // Iniciando as threads dos funcionários e clientes
        funcionario1.start();
        funcionario2.start();
        for (Cliente cliente : clientes) {
            cliente.start();
        }

        // Verifica se a soma dos saldos dos clientes é inferior à soma dos salários dos funcionários
        double somaSaldosClientes = 0;
        for (Cliente cliente : clientes) {
            somaSaldosClientes += cliente.getConta().getSaldo();
        }
        double somaSalariosFuncionarios = funcionario1.getSalario() + funcionario2.getSalario();
        if (somaSaldosClientes >= somaSalariosFuncionarios) {
            System.out.println("A soma dos saldos dos clientes é suficiente para pagar os salários dos funcionários.");
        } else {
            System.out.println("A soma dos saldos dos clientes é insuficiente para pagar os salários dos funcionários.");
        }

        // Verifica se alguma loja tem R$ 1400 em caixa e paga um funcionário que ainda não recebeu o salário
        if (contaLoja1.getSaldo() >= 1400) {
            if (!loja1.pagarFuncionario(funcionario1)) {
                loja1.pagarFuncionario(funcionario2);
            }
        } else if (contaLoja2.getSaldo() >= 1400) {
            if (!loja2.pagarFuncionario(funcionario1)) {
                loja2.pagarFuncionario(funcionario2);
            }
        }
    }
}
