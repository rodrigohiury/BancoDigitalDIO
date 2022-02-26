package banco;

import banco.AccountException.NoAccountException;
/**
 * Classe Banco 
 * @author Rodrigo Hiury
 * @version 1.0.0
 */

public class Banco{
    
    public static String nome;
    protected static Conta[] contas;
    protected static int i;             //indice do vetor de contas.
                                        //Aponta para a primeira posição vaga no vetor de contas.
    
    /**
     * Construtor do Banco
     * @param nome Nome do Banco
     */

    public Banco(String nome) {
        this.nome = nome;
        contas = new Conta[100];
        i = 0;
    }

    /**
     * Adiciona uma conta ao Banco
     * @param conta Conta a ser adicionada ao Banco
     */
    public void adicionarConta(Conta conta){
        contas[i] = conta;
        i++;
    }

    /**
     * Retorna o nome do Banco
     * @return Nome do banco
     */

    public static String getNome() {
        return nome;
    }

    /**
     * Busca uma conta no vetor de contas a partir do número da conta
     * @param numero Número da conta a ser buscada
     * @return Conta buscada, nulo se não encontrada
     * @throws NoAccountException Quando uma conta não é encontrada
     */

    public static Conta buscarConta(int numero) throws NoAccountException, NullPointerException {
        for(int n = 0; n<=i;n++){
            if (contas[n].numero==numero) {
                return contas[n];
            }
        }
        throw new NoAccountException(1, numero);
    }
}
