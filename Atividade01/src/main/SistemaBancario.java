package main;

import entidades.*;

public class SistemaBancario {
    public static void main(String[] args) {
        Conta contaBanco = new Conta("Banco", Double.POSITIVE_INFINITY); // Conta ilimitada para o banco
        Conta contaLoja1 = new Conta("Loja 1", 0);
        Conta contaLoja2 = new Conta("Loja 2", 0);
        Conta[] contasFuncionario1 = {new Conta("Funcionário 1 da Loja 1", 0), new Conta("Investimento Funcionário 1 da Loja 1", 0)};
        Conta[] contasFuncionario2 = {new Conta("Funcionário 1 da Loja 2", 0), new Conta("Investimento Funcionário 1 da Loja 2", 0)};
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

        funcionario1.start();
        funcionario2.start();
        for (Cliente cliente : clientes) {
            cliente.start();
        }
    }
}
