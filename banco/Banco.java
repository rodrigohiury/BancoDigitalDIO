package banco;


public class Banco{
    
    public static String nome;
    protected static Conta[] contas;
    protected static int i;

    public Banco(String nome) {
        this.nome = nome;
        contas = new Conta[100];
        i = 0;
    }

    public void adicionarConta(Conta conta){
        contas[i] = conta;
        i++;
    }

    public static String getNome() {
        return nome;
    }

    public static Conta buscarConta(int numero){
        for(int n = 0; n<=i;n++){
            if (contas[n].numero==numero) {
                return contas[n];
            }
        }
        return null;
    }
}
