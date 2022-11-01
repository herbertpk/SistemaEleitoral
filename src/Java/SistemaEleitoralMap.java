import java.util.*;

public class SistemaEleitoralMap implements SistemaEleitoralInterface{

    private Map<String, Eleitor> eleitores;
    private Map<String, Candidato> candidatos;
    private List<Voto> votos;

    public SistemaEleitoralMap() {
        this.eleitores = new HashMap<>();
        this.candidatos  = new HashMap<>();
        this.votos = new ArrayList<>();
    }

    @Override
    public Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException {
        Candidato candidato = this.candidatos.get(nome);
        if (candidato == null) {
            throw new CandidatoInexistenteException("Não existe candidato com o nome "+nome);
        } else {
            return candidato;
        }
    }
//…
