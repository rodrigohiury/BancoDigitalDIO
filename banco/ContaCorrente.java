package banco;

import banco.AccountException.LowFundException;
import banco.AccountException.NoAccountException;

/**
 * Classe Conta Corrente
 * @author Rodrigo Hiury
 */

public class ContaCorrente extends Conta{

    /**
     * Construtor da Conta Corrente
     * @param Cliente Titular da conta
     */

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    /**
     * Construtor da Conta Corrente
     */

    public ContaCorrente() {
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
        return true;
    }
}
