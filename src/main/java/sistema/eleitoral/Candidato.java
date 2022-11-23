package sistema.eleitoral;


import java.io.Serializable;

public class Candidato implements Serializable {
    private String nome;
    private int numero;
    private Partido partido;

    public Candidato(String nome, int numero, Partido partido) {
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        return  "O candidato de nome: " + this.nome + "\n" +
                "tem o numero: " + numero +"\n"+
                "e é do partido: "+partido;

    }
}
