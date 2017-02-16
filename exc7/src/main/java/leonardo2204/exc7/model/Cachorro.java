package leonardo2204.exc7.model;

import io.realm.RealmObject;

/**
 * Created by leonardo on 2/15/17.
 */

public class Cachorro extends RealmObject {

    private String nome;
    private int idade;
    private float peso;

    public Cachorro() {
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
