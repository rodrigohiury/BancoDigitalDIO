package banco;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

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
