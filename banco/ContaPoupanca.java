package banco;

import banco.AccountException.LowFundException;
import banco.AccountException.NoAccountException;

/**
 * Classe Conta Poupança
 * @author Rodrigo Hiury
 */

public class ContaPoupanca extends Conta {

    /**
     * Construtor da Conta Poupança
     * @param cliente Cliente Titular da Conta 
     */
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    /**
     * Construtor da Conta Poupança
     */
    
    public ContaPoupanca() {
        
    }

    public void transferir(double valor, int numero) throws LowFundException, NoAccountException{
        Conta contaDestino;
        if(Banco.buscarConta(numero).tipoConta()){
            contaDestino = new ContaCorrente();
            contaDestino = Banco.buscarConta(numero);
            sacar(valor);
            contaDestino.depositar(valor);
        }else if(!Banco.buscarConta(numero).tipoConta()){
            contaDestino = new ContaPoupanca();
            contaDestino = Banco.buscarConta(numero);
            sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    public boolean tipoConta() {
        return false;
    }
}
