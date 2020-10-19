package DistribuidoraDeGas.negocio.excecoes;

public class PessoaInexistenteException extends Exception {
    private String cpf;

    public PessoaInexistenteException(String cpf){
        super("Produto já cadastrado com ID: " + cpf);
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }
}
