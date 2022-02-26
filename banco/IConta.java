package banco;

import banco.AccountException.LowFundException;
import banco.AccountException.NoAccountException;

public interface IConta{

    void sacar(double valor) throws LowFundException;
    void depositar(double valor);
    void transferir(double valor, int numero) throws LowFundException, NoAccountException;

}
