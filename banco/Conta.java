package banco;


public class Conta implements IConta {

    protected int AGENCIA_PADRAO = 0001;
    protected static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected float saldo;
    protected Cliente titular;

    

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.titular = cliente;
    }

    public Conta(){

    }

    @Override
    public boolean sacar(double valor) {
        if(saldo==0){
            return true;
        }else if(valor<saldo){
            saldo -= valor;
            return false;
        }
        return true;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        
    }

    @Override
    public boolean transferir(double valor, int numero) {
        Conta contaDestino = new Conta();
        contaDestino = Banco.buscarConta(numero);
        if(contaDestino==null){
            return true;
        }
        boolean i = sacar(valor);
        if(i==false){
            contaDestino.depositar(valor);
            return false;
        }
        return true;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void imprimirInfosComuns() {
		System.out.println("Titular: " + titular.getNome() + " " + titular.getSobrenome());
        System.out.println("Data de Nascimento: " + titular.getDataNascimento());
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
	}
}
