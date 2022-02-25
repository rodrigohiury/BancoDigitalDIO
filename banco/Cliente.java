package banco;

/**
 * Classe Cliente
 * @author Rodrigo Hiury
 * @version 1.0.0
 */
public class Cliente {
    
    String nome;
    String sobrenome;
    int diaNascimento;
    int mesNascimento;
    int anoNascimento;

    /**
     * Construtor do Cliente
     * @param nome Nome do Cliente
     * @param sobrenome Sobrenome do Cliente
     * @param diaNascimento Dia de Nascimento do Cliente
     * @param mesNascimento Mês de Nascimento do Cliente
     * @param anoNascimento Ano de Nascimento do Cliente
     */

    public Cliente(String nome, String sobrenome, int diaNascimento, int mesNascimento, int anoNascimento){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.diaNascimento = diaNascimento;
        this.mesNascimento = mesNascimento;
        this.anoNascimento = anoNascimento;
    }

    /**
     * Contrutor do Cliente
     */

    Cliente(){
        
    }
    
    /**
     * Retorna o Nome do Cliente
     * @return Nome do Cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Seta o Nome do Cliente
     * @param nome Nome do Cliente a ser setado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o Sobrenome do Cliente
     * @return Sobrenome do Cliente
     */

    public String getSobrenome() {
        return sobrenome;
    }
    
    /**
     * Seta o Sobrenome do cliente
     * @param sobrenome Sobrenome do cliente a ser setado
     */

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * Retorna o Dia de Nascimento do Cliente
     * @return Dia de Nascimento do Cliente
     */

    public int getDiaNascimento() {
        return diaNascimento;
    }

    /**
     * Seta o Dia de Nascimento do Cliente
     * @param diaNascimento Dia de Nascimento do Cliente
     */

    public void setDiaNascimento(int diaNascimento) {
        this.diaNascimento = diaNascimento;
    }

    /**
     * Retorna o Mês de Nascimento do Cliente
     * @return Mês de Nascimento do Cliente
     */

    public int getMesNascimento() {
        return mesNascimento;
    }

    /**
     * Seta o Mês de Nascimento do Cliente
     * @param mesNascimento Mês de Nascimento do Cliente
     */
    public void setMesNascimento(int mesNascimento) {
        this.mesNascimento = mesNascimento;
    }

    /**
     * Retorna o Ano de Nascimento do Cliente
     * @return Ano de Nascimento do Cliente
     */

    public int getAnoNascimento() {
        return anoNascimento;
    }

    /**
     * Seta o Ano de Nascimento do Cliente
     * @param anoNascimento Ano de Nascimento do Cliente
     */

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    /**
     * Retorna a Data de Nascimento do Cliente
     * @return Data de Nascimento do Cliente com barras
     */
    
    String getDataNascimento(){
        String data = getDiaNascimento()+"/"+getMesNascimento()+"/"+getAnoNascimento();
        return data;
    }

    
}
