package repositorios;

import entidades.Pessoa;
import excecoes.PessoaInexistenteException;

import java.util.ArrayList;

public class RepositorioGerente implements iRepositorioPessoa{
    private ArrayList<Pessoa> gerentes;

    public RepositorioGerente(){
        this.gerentes = new ArrayList<>();
    }

    @Override
    public void adicionarPessoa(Pessoa gerente) {
        this.gerentes.add(gerente);
    }

    @Override
    public void removerPessoa(String cpf) throws PessoaInexistenteException{
        try{
            Pessoa gerente = this.getPessoa(cpf);
            this.gerentes.remove(gerente);
        }catch (PessoaInexistenteException e){
            throw new PessoaInexistenteException(cpf);
        }
    }

    @Override
    public Pessoa getPessoa(String cpf) throws PessoaInexistenteException {
        int index;
        for(Pessoa g: this.gerentes){
            if(g.getCpf().equals(cpf)){
                index = this.gerentes.indexOf(g);
                return this.gerentes.get(index);
            }
        }
        throw new PessoaInexistenteException(cpf);
    }

    @Override
    public void atualizarPessoa(Pessoa gerente) {
        int index = this.gerentes.indexOf(gerente);
        this.gerentes.set(index, gerente);
    }

    @Override
    public boolean verificarPessoa(String cpf) {
        for(Pessoa g: this.gerentes){
            if(cpf.equals(g.getCpf())){
                return true;
            }
        }

        return false;
    }

    @Override
    public ArrayList<Pessoa> listarpessoa() {
        return this.gerentes;
    }
}
