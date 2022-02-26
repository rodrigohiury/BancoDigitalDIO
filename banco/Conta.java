package banco;

import banco.AccountException.LowFundException;
import banco.AccountException.NoAccountException;;

/**
 * Conta abstrata
 * @author Rodrigo Hiury
 * @version 1.0.0
 */

public abstract class Conta implements IConta{

    protected int AGENCIA_PADRAO = 0001;
    protected static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected float saldo;
    protected Cliente titular;

    /**
     * Construtor da conta 
     * @param cliente Objeto cliente titular da conta
     */

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.titular = cliente;
    }

    /**
     * Construtor da conta
     */

    public Conta(){

    }

    /**
     * Saca o valor fornecido do saldo da conta
     * @param valor valor a ser sacado
     * @return Se houve erro, retorna true. Se não houve erro, false
     * @throws LowFundException
     */

    @Override
    public void sacar(double valor) throws LowFundException {
        if(saldo==0){
            throw new LowFundException(saldo);
        }else if(valor>saldo){
            throw new LowFundException(saldo);
        }
        saldo -= valor;
    }

    /**
     * Deposita o valor fornecido na conta
     * @param valor valor a ser depositado
     */

    @Override
    public void depositar(double valor) {
        saldo += valor;
        
    }

    /**
     * Transfere um valor de uma conta a outra
     * @param valor valor a ser transferido
     * @param numero numero da conta a receber a transferência
     * @return Se houve erro, retorna true. Se não houve erro, false
     * @throws NoAccountException
     */
    @Override
    public abstract void transferir(double valor, int numero) throws LowFundException, NoAccountException;

    /**
     * Retorna agencia da conta
     * @return número da agência da conta
     */

    public int getAgencia() {
        return agencia;
    }

    /**
     * Retorna o número da conta
     * @return número da conta
     */

    public int getNumero() {
        return numero;
    }

    /**
     * Retorna o saldo da conta
     * @return Saldo da conta
     */

    public float getSaldo() {
        return saldo;
    }

    /**
     * Retorna o titular da conta
     * @return Objeto cliente titular da conta
     */
    public Cliente getTitular() {
        return titular;
    }

    /**
     * Imprime os dados da conta no console
     */

    public void imprimirInfosComuns() {
		System.out.println("Titular: " + titular.getNome() + " " + titular.getSobrenome());
        System.out.println("Data de Nascimento: " + titular.getDataNascimento());
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
	}

    /**
     * Imprime os dados da conta no console, exceto o saldo
     */

    public void imprimirInfosPublicas() {
		System.out.println("Titular: " + titular.getNome() + " " + titular.getSobrenome());
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
	}
    /**
     * Retorna o tipo da conta
     * @return Se Conta Corrente, true. Se Conta Poupança, false
     */

    public abstract boolean tipoConta();

    @Override
    public String toString() {
        return "[agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + ", titular=" + titular + "]";
    }

    
}
