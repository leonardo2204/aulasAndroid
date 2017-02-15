package leonardo2204.exc6.model;

import java.util.List;

/**
 * Created by leonardo on 2/15/17.
 */

public class Pessoa {
    String nome;
    int idade;
    List<Contato> telefones;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Contato> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Contato> telefones) {
        this.telefones = telefones;
    }
}
