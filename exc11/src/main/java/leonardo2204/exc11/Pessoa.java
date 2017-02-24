package leonardo2204.exc11;

/**
 * Created by leonardo on 2/24/17.
 */

public class Pessoa {

    private int id;
    private String nome;
    private String sobrenome;
    private boolean casado;
    private String emprego;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String sobrenome, boolean casado, String emprego) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.casado = casado;
        this.emprego = emprego;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public String getEmprego() {
        return emprego;
    }

    public void setEmprego(String emprego) {
        this.emprego = emprego;
    }
}
