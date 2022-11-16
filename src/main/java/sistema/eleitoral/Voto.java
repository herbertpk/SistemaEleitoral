package sistema.eleitoral;

import java.io.Serializable;

public class Voto implements Serializable {
    int numeroVotado;

    public Voto(int numeroVotado) {
        this.numeroVotado = numeroVotado;
    }

    public int getNumeroVotado() {
        return numeroVotado;
    }

    public void setNumeroVotado(int numeroVotado) {
        this.numeroVotado = numeroVotado;
    }
}

