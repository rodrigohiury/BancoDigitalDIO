package banco;


/**
 * Classe Conta Corrente
 * @author Rodrigo Hiury
 * @version 1.0.0
 */

public class ContaCorrente extends Conta {

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

    public boolean transferir(double valor, int numero){
        boolean i;
        if(Banco.buscarConta(numero)!=null){
            if(Banco.buscarConta(numero).tipoConta()){
                Conta contaDestino = new ContaCorrente();
                contaDestino = Banco.buscarConta(numero);
                i = sacar(valor);
                if(i==false){
                    contaDestino.depositar(valor);
                    return false;
                }
            }else if(!Banco.buscarConta(numero).tipoConta()){
                Conta contaDestino = new ContaPoupanca();
                contaDestino = Banco.buscarConta(numero);
                i = sacar(valor);
                if(i==false){
                    contaDestino.depositar(valor);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean tipoConta() {
        return true;
    }
}
