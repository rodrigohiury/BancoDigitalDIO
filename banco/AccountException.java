package banco;

public class AccountException {

    
    public static class NoAccountException extends Exception{

        int agencia;
        int numero;

        public NoAccountException(int agencia, int numero) {
            super("ERRO!!! Não foi possível encontrar uma conta com a agencia " + agencia + " e numero " + numero + "!");
            this.agencia = agencia;
            this.numero = numero;
        }

        
    }

    public static class LowFundException extends Exception {

        double saldo;

        public LowFundException(double saldo) {

            super(String.format("ERRO!!! Não há saldo suficiente! Saldo: R$ %.2f", saldo));
            this.saldo = saldo;
        }

        
    }
    
}
