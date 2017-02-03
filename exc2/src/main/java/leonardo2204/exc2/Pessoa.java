package leonardo2204.exc2;

/**
 * Created by leonardo on 2/2/17.
 */

public class Pessoa {

    String nome;
    int idade;
    float peso;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, float peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
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
