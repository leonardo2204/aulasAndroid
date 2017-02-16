package leonardo2204.exc7.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by leonardo on 2/15/17.
 */

public class Pessoa extends RealmObject {
    String nome;
    int idade;
    RealmList<Cachorro> cachorros;

    public Pessoa() {
    }

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

    public RealmList<Cachorro> getCachorros() {
        return cachorros;
    }

    public void setCachorros(RealmList<Cachorro> cachorros) {
        this.cachorros = cachorros;
    }
}
