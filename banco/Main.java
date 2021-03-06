import java.util.Scanner;

import banco.Banco;
import banco.Cliente;
import banco.Conta;
import banco.ContaCorrente;
import banco.ContaPoupanca;
import banco.AccountException.LowFundException;
import banco.AccountException.NoAccountException;

/**
 * Banco Digital
 * Este é a Interface do console do Banco Digital
 * @author Rodrigo Hiury
 * @version 1.1.0 Implementação das Exceptions e Mudança do armazenamento das contas no banco para ArrayList
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um nome para o banco: ");
        String name = scanner.nextLine();
        Banco banco = new Banco(name);
        int opcao;
        System.out.println("================== Banco Digital " + Banco.getNome() + " ==================");
        do {
            System.out.println("        Página Principal        ");
            System.out.println("Escolha uma opção:\n1 - Logar\n2 - Criar Conta\n3 - Sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    log(banco);
                    break;
                case 2:
                    criarUsuario(banco);
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar nosso servicos.");
                    System.out.println("================== Saindo... ==================");
                    break;
                default:
                    break;
            }
        } while (opcao != 3);
        scanner.close();
    }

    /**
     * Entra na interface de log do Banco
     * @param banco Banco atualmente utilizado
     */

    public static void log(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Logar\nInsira sua agencia: ");
        int agencia = scanner.nextInt();
        System.out.println("Insira o número da sua conta: ");
        int numero = scanner.nextInt();
        try {
            boolean c = Banco.buscarConta(numero).tipoConta();
            if (c) {
                Conta conta = new ContaCorrente();
                conta = Banco.buscarConta(numero);
                logConta(conta);
            } else if (!c) {
                Conta conta = new ContaPoupanca();
                conta = Banco.buscarConta(numero);
                logConta(conta);
            }
        } catch (NoAccountException e) {
            System.out.println(e.getMessage());
            System.out.println("Verifique os dados e tente novamente!");
        }
    }

    /**
     * Entra na interface com a conta já logada
     * @param conta Conta logada
     */

    public static void logConta(Conta conta) {
        Scanner scanner = new Scanner(System.in);
        if (conta != null) {
            System.out.println("Logado com Sucesso!!!");
            System.out.println("Bem-Vindo " + conta.getTitular().getNome() + " " + conta.getTitular().getSobrenome());
            int opcao1 = 0;
            while (opcao1 != 5) {
                System.out.println("Escolha uma opção:\n1 - Sacar\n2 - Depositar\n3 - Transferir\n4 - Saldo\n5 - Deslogar");
                opcao1 = scanner.nextInt();
                switch (opcao1) {
                    case 1:
                        saque(conta);
                        break;
                    case 2:
                        deposito(conta);
                        break;
                    case 3:
                        transferencia(conta);
                        break;
                    case 4:
                        System.out.println(String.format("Saldo: R$ %.2f", conta.getSaldo()));
                        break;
                    case 5:
                        System.out.println("Deslogando...");
                        break;
                    default:
                        System.out.println("Opção Inválida!!!");
                        break;
                }
            }
        }
    }

    /**
     * Entra na interface de saque
     * @param conta Conta a ser sacada
     */

    public static void saque(Conta conta) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe quanto deseja sacar: ");
        float valor = scanner.nextFloat();
        try {
            conta.sacar(valor);
            System.out.println(
                    String.format("Valor sacado com sucesso!!! Saldo: R$ %.2f", conta.getSaldo()));
        } catch (LowFundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Entra na interface de depósito
     * @param conta Conta a receber o depósito
     */

    public static void deposito(Conta conta) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe quanto deseja depositar: ");
        float valor1 = scanner.nextFloat();
        conta.depositar(valor1);
        System.out.println(String.format("Valor depositado com sucesso!!! Saldo: R$ %.2f", conta.getSaldo()));
    }

    /**
     * Entra na interface de transferência
     * @param conta Conta a realizar a transferência
     */

    public static void transferencia(Conta conta) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a agencia da conta destino:");
        int ag1 = scanner.nextInt();
        System.out.println("Informe o numero da conta destino: ");
        int num = scanner.nextInt();
        try {
            if(Banco.buscarConta(num)!=null){
                System.out.println("Informe o valor a ser transferido: ");
                float valor2 = scanner.nextFloat();
                conta.transferir(valor2, num);
                System.out.println(
                        String.format("Valor transferido com sucesso!!! Saldo: R$ %.2f", conta.getSaldo()));
                System.out.println("Conta de Destino: ");
                Banco.buscarConta(num).imprimirInfosPublicas();
            }
        } catch (LowFundException e) {
            System.out.println(e.getMessage());
        } catch (NoAccountException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Entra na interface de criação de usuário
     * @param banco Banco atualmente utilizado
     */

    public static void criarUsuario(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando Usuário!!!");
        System.out.println("Informe seu Nome:");
        String nome = scanner.next();
        System.out.println("Informe seu Sobrenome:");
        String sobrenome = scanner.next();
        System.out.println("Agora sua data de nascimento. Informe do dia:");
        int dia = scanner.nextInt();
        System.out.println("Agora informe o mês:");
        int mes = scanner.nextInt();
        System.out.println("Informe o Ano:");
        int ano = scanner.nextInt();
        System.out.println("Criando Usuário...");
        Cliente cliente = new Cliente(nome, sobrenome, dia, mes, ano);
        System.out.println("Usuário criado com sucesso!!!");
        while (true) {
            System.out.println(
                    "Informe o tipo de conta que deseja abrir: \n1 - Conta Corrente\n2 - Conta Poupança");
            int n = scanner.nextInt();
            if (n == 1) {
                System.out.println("Abrindo Conta Corrente...");
                Conta cc = new ContaCorrente(cliente);
                banco.adicionarConta(cc);
                System.out.println("Conta Aberta com Sucesso!!!");
                cc.imprimirInfosComuns();
                break;
            } else if (n == 2) {
                System.out.println("Abrindo Conta Poupança...");
                Conta poupanca = new ContaPoupanca(cliente);
                banco.adicionarConta(poupanca);
                System.out.println("Conta Aberta com Sucesso!!!");
                poupanca.imprimirInfosComuns();
                break;
            } else {
                System.out.println("Opção Inválida!!!");
            }
        }
    }
}
