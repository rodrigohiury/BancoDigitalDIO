package banco;

/**
 * Classe Conta Poupança
 * @author Rodrigo Hiury
 * @version 1.0.0
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
        return false;
    }
}
