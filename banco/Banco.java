package banco;

import java.util.ArrayList;
import java.util.List;

import banco.AccountException.NoAccountException;
/**
 * Classe Banco 
 * @author Rodrigo Hiury
 * @version 1.0.0
 */

public class Banco{
    
    public static String nome;
    protected static List<Conta> contas;

    /**
     * Construtor do Banco
     * @param nome Nome do Banco
     */

    public Banco(String nome) {
        this.nome = nome;
        contas = new ArrayList<Conta>();
    }

    /**
     * Adiciona uma conta ao Banco
     * @param conta Conta a ser adicionada ao Banco
     */
    public void adicionarConta(Conta conta){
        contas.add(conta);
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

    public static Conta buscarConta(int numero) throws NoAccountException{
        for (Conta conta : contas) {
            if (conta.getNumero()==numero) {
                return conta;
            }
        }
        throw new NoAccountException(1, numero);
    }
}
