import java.util.Scanner;

import banco.Conta;
import banco.ContaCorrente;
import banco.ContaPoupanca;
import banco.Banco;
import banco.Cliente;

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
                    System.out.println("Logar\nInsira sua agencia: ");
                    int agencia = scanner.nextInt();
                    System.out.println("Insira o número da sua conta: ");
                    int numero = scanner.nextInt();
                    Conta conta = new Conta();
                    conta = Banco.buscarConta(numero);
                    if(conta!=null){
                        System.out.println("Logado com Sucesso!!!");
                        System.out.println("Bem-Vindo " + conta.getTitular().getNome() + " " + conta.getTitular().getSobrenome());
                        int opcao1 = 0;
                        while (opcao1!=5) {
                            
                            System.out.println("Escolha uma opção:\n1 - Sacar\n2 - Depositar\n3 - Transferir\n4 - Saldo\n5 - Deslogar");
                            opcao1 = scanner.nextInt();
                            switch (opcao1) {
                                case 1:
                                    System.out.println("Informe quanto deseja sacar: ");
                                    float valor = scanner.nextFloat();
                                    boolean i = conta.sacar(valor);
                                    if(i==false){
                                        System.out.println(String.format("Valor sacado com sucesso!!! Saldo: R$ %.2f", conta.getSaldo()));
                                        break;
                                    }else{
                                        System.out.println(String.format("Saldo Insuficiente!!! Saldo: R$ %.2f", conta.getSaldo()));
                                        break;
                                    }
                                case 2:
                                    System.out.println("Informe quanto deseja depositar: ");
                                    float valor1 = scanner.nextFloat();
                                    conta.depositar(valor1);
                                    System.out.println(String.format("Valor depositado com sucesso!!! Saldo: R$ %.2f", conta.getSaldo()));
                                    break;
                                case 3:
                                    System.out.println("Informe a agencia da conta destino:");
                                    int ag1 = scanner.nextInt();
                                    System.out.println("Informe o numero da conta destino: ");
                                    int num = scanner.nextInt();
                                    System.out.println("Informe o valor a ser transferido: ");
                                    float valor2 = scanner.nextFloat();
                                    boolean j = conta.transferir(valor2, num);
                                    if(j==false){
                                        System.out.println(String.format("Valor transferido com sucesso!!! Saldo: R$ %.2f", conta.getSaldo()));
                                        System.out.println("Conta de Destino: ");
                                        Banco.buscarConta(num).imprimirInfosComuns();
                                    }else{
                                        System.out.println("ERRO! Não foi possível transferir!");
                                        if(conta.getSaldo()<valor2){
                                            System.out.println(String.format("Saldo Insuficiente!!! Saldo: R$ %.2f", conta.getSaldo()));
                                        }else{
                                            System.out.println("Conta não Encontrada! Verifique os dados e tente novamente!");
                                        }
                                    }
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
                    break;
                case 2:
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
                        System.out.println("Informe o tipo de conta que deseja abrir: \n1 - Conta Corrente\n2 - Conta Poupança");
                        int n = scanner.nextInt();
                        if (n==1) {
                            System.out.println("Abrindo Conta Corrente...");
                            Conta cc = new ContaCorrente(cliente);
                            banco.adicionarConta(cc);
                            System.out.println("Conta Aberta com Sucesso!!!");
                            cc.imprimirInfosComuns();
                            break;
                        } else if (n==2) {
                            System.out.println("Abrindo Conta Poupança...");
                            Conta poupanca = new ContaPoupanca(cliente);
                            banco.adicionarConta(poupanca);
                            System.out.println("Conta Aberta com Sucesso!!!");
                            poupanca.imprimirInfosComuns();
                            break;
                        }else {
                            System.out.println("Opção Inválida!!!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar nosso servicos.\n================== Saindo... ==================");
                    break;
                default:
                    break;
            }
        }while (opcao!=3);
        scanner.close();
    }
}
