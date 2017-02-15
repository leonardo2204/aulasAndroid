package leonardo2204.exc6.model;

/**
 * Created by leonardo on 2/15/17.
 */

public class Contato {
    String telefone;
    String nomePessoa;

    public Contato(String telefone, String nomePessoa) {
        this.telefone = telefone;
        this.nomePessoa = nomePessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }
}
