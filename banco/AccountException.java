package banco;

/**
 * Exceptions Utilizadas em Banco e Conta
 * @author Rodrigo Hiury
 * @since 1.1.0
 */
public class AccountException {

    
    /**
     * É lançada quando não é encontrada uma conta em uma busca
     */

    public static class NoAccountException extends Exception{

        int agencia;
        int numero;

        /**
         * Construtor da Exception
         * @param agencia Agência da conta procurada
         * @param numero Número da conta procurada
         */
        
        public NoAccountException(int agencia, int numero) {
            super("ERRO!!! Não foi possível encontrar uma conta com a agencia " + agencia + " e numero " + numero + "!");
            this.agencia = agencia;
            this.numero = numero;
        }

        
    }

    /**
     * É lançada quando não há saldo insuficiente na conta para um saque ou transferência
     */

    public static class LowFundException extends Exception {

        double saldo;

        /**
         * Construtor da Exception
         * @param saldo Saldo atual da conta
         */

        public LowFundException(double saldo) {

            super(String.format("ERRO!!! Não há saldo suficiente! Saldo: R$ %.2f", saldo));
            this.saldo = saldo;
        }

        
    }
    
}
