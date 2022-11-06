package sistemaEleitoral;
import java.util.Objects;

public class Eleitor {
    String nome;
    String titulo;


    public Eleitor(String nome, String titulo) {
        this.nome = nome;
        this.titulo = titulo;
    }

    public Eleitor(){this("","");}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Eleitor eleitor)) return false;
        return Objects.equals(getTitulo(), eleitor.getTitulo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo());
    }

}
